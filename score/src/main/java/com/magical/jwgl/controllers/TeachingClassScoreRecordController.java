package com.magical.jwgl.controllers;

import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateTeachingClassScoreCommand;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingClassScoreRecordID;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/10/27
 */
@RestController
public class TeachingClassScoreRecordController {

    private static final Logger LOGGER = getLogger(TeachingClassScoreRecordController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    /**
     * 创建成绩登记卡
     * @param input
     */
    @RequestMapping(value = "score/addScore")
    public void createTeachingClassScore(@RequestBody()JSONObject input){
        LOGGER.info(input.toJSONString());

        try {
            if (input.containsKey("teachingClassID")&& input.containsKey("standardID")){

                TeachingClassScoreRecordID teachingClassScoreID = new TeachingClassScoreRecordID();

                TeachingClassID teachingClassID = new TeachingClassID(input.getString("teachingClassID"));

                String termID = input.getString("termID");

                String courseID = input.getString("courseID");
                //创建命令
                CreateTeachingClassScoreCommand command = new CreateTeachingClassScoreCommand(teachingClassScoreID,teachingClassID,termID,courseID);

                this.commandGateway.sendAndWait(command);

                response.setStatus(HttpServletResponse.SC_CREATED);

            }
        }catch (CommandExecutionException e){

            LOGGER.warn("Add Command FAILED with Message: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }


    }

}
