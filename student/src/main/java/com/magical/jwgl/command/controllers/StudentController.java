package com.magical.jwgl.command.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateStudentCommand;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/10/20
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger LOGGER = getLogger(StudentController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    @PostMapping(value = "/addStudent")
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


}

