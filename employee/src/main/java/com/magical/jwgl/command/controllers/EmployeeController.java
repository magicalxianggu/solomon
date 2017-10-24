package com.magical.jwgl.command.controllers;

import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateEmployeeCommand;
import com.magical.cloud.commands.CreateStudentCommand;
import com.magical.jwgl.command.aggregates.Employee;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/10/24
 */
@RestController
//@RequestMapping(value = "/employee")
public class EmployeeController {

    private static final Logger LOGGER = getLogger(EmployeeController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private Repository<Employee> repository;

    @PostMapping(value = "/employee/addEmployee")
    public void addEmployee(@RequestBody(required = true) JSONObject input){

        LOGGER.info(input.toJSONString());

        try{
            if(input.containsKey("employeeName") && input.containsKey("employeeeNO")){
                String employeeName = input.getString("employeeName");
                String employeeeNO = input.getString("employeeeNO");
                CreateEmployeeCommand command = new CreateEmployeeCommand(employeeName,employeeeNO);
                commandGateway.sendAndWait(command);
                response.setStatus(HttpServletResponse.SC_CREATED);
            }

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "teacher/{id}")
    public JSONObject getTeacherDTOByID(@PathVariable("id") String teacherID){

      Aggregate<Employee> employeeAggregate = repository.load(teacherID);

      JSONObject o = new JSONObject();
      o.put("teacherID",teacherID);
      o.put("teacherName",employeeAggregate.invoke(employee -> employee.getEmployeeName()));
      o.put("teacherNO",employeeAggregate.invoke(employee -> employee.getEmployeeNO()));
      return o;
    }
}
