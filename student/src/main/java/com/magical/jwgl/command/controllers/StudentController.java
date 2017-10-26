package com.magical.jwgl.command.controllers;

import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateStudentCommand;
import com.magical.jwgl.command.aggregates.Student;
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
 * Created by zhouxp on 2017/10/20
 */
@RestController
//@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger LOGGER = getLogger(StudentController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    @Autowired
   private Repository<Student> repository;



    @PostMapping(value = "/student/addStudent")
    public void addStudent(@RequestBody(required = true) JSONObject input){

        LOGGER.info(input.toJSONString());

        try{
            if(input.containsKey("studentName") && input.containsKey("classID")){
                String studentName = input.getString("studentName");
                String classID = input.getString("classID");
                CreateStudentCommand command = new CreateStudentCommand(studentName,classID);
                    commandGateway.sendAndWait(command);
                    response.setStatus(HttpServletResponse.SC_CREATED);
                }

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/students/{id}")
    public JSONObject getStudentDTOByID(@PathVariable("id") String studentID){

        Aggregate<Student> student = repository.load(studentID);

        JSONObject o = new JSONObject();
        o.put("studentID",student.identifier().toString());
        o.put("studentName",student.invoke(studentAggregate -> studentAggregate.getStudentName()));
        o.put("classID",student.invoke(studentAggregate -> studentAggregate.getClassID()));

        return o;
    }

}

