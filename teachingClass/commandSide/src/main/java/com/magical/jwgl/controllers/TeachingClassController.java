package com.magical.jwgl.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateTeachingClassCommand;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(value = "/command")
public class TeachingClassController {

    private static final Logger LOGGER = getLogger(TeachingClassController.class);

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping(value = "/addTeachingClass")
    public void addTeachingClass( @RequestBody(required = true) JSONObject input){

        try{
            String studingInterval = input.getString("studingInterval");

            JSONObject courseJson = input.getJSONObject("courseInfo");

            JSONArray teacherArray = input.getJSONArray("teachers");
            JSONArray studentIDArray = input.getJSONArray("studentIDs");

             Map courseInfo = courseJson;

             Map<String,String> teachers = new HashMap<>();

             ArrayList<String> studentIDs = new ArrayList<>();
            //构建命令
            CreateTeachingClassCommand command = new CreateTeachingClassCommand(courseInfo,studingInterval,teachers,studentIDs);

            for(Object each:teacherArray) {
                JSONObject o = (JSONObject)each;
                teachers.put(o.getString("teacherID"),o.getString("teacherType"));
            }

            for(Object each:studentIDArray) {
                JSONObject o = (JSONObject)each;
                studentIDs.add(o.getString("studentID"));
            }

            //发送命令
            commandGateway.sendAndWait(command);

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
    }

    }
}
