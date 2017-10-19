package com.magical.jwgl.controllers;

import com.magical.cloud.commands.CreateTeachingClassCommand;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(value = "/command")
public class TeachingClassController {

    private static final Logger LOGGER = getLogger(TeachingClassController.class);

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping(value = "/addTeachingClass")
    public void addTeachingClass( CreateTeachingClassCommand command){

        try{

               //发送命令
            commandGateway.sendAndWait(command);

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
    }

    }
}
