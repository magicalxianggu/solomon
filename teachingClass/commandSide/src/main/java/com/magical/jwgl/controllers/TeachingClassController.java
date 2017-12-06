package com.magical.jwgl.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateTeachingClassCommand;
import com.magical.jwgl.web.clients.clientProxys.StudentProxy;
import com.magical.jwgl.web.dto.StudentDTO;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
//@RequestMapping(value = "/command")
public class TeachingClassController {

    private static final Logger LOGGER = getLogger(TeachingClassController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private StudentProxy studentService;

    @PostMapping(value = "/command/addTeachingClass")
    public void addTeachingClass( @RequestBody(required = true) JSONObject input){

        try{
            String studingInterval = input.getString("studingInterval");

            JSONObject courseJson = input.getJSONObject("courseInfo");

            JSONArray teacherArray = input.getJSONArray("teachers");
            JSONArray studentIDArray = input.getJSONArray("studentIDs");

             Map courseInfo = courseJson;

             HashMap<String,String> teachers = new HashMap<>();

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
            this.commandGateway.sendAndWait(command);

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
        }

    }

    @GetMapping(value = "/command/students/{id}")
    public StudentDTO findStudentByID(@PathVariable("id") String studentID){

      return this.studentService.getStudentDTOByID(studentID);
    }
}
