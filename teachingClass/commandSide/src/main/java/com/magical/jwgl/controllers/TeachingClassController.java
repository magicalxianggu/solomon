package com.magical.jwgl.controllers;


import com.magical.cloud.commands.CreateTeachingClassCommand;
import com.magical.cloud.domain.TeacherPositionEnum;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void addTeachingClass(Model model, @RequestParam HashMap<String, String> paramsMap){

        try{

            HashMap<String,String> courseInfo = new HashMap<>();
            String studingInterval = paramsMap.get("studingInterval");
            Map<String,TeacherPositionEnum> teachers = new HashMap<>();
            ArrayList<String> studentIDs = new ArrayList<>();

            //封装命名数据

            CreateTeachingClassCommand command = new CreateTeachingClassCommand(courseInfo,studingInterval,teachers,studentIDs);

            //发送命令
            commandGateway.sendAndWait(command);

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
    }

    }
}
