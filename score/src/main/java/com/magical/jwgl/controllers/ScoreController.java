package com.magical.jwgl.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateScoreCommand;
import com.magical.cloud.commands.RecordScoreCommand;
import com.magical.cloud.domain.*;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/11/9
 */
@RestController
public class ScoreController {

    private static final Logger LOGGER = getLogger(ScoreController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;
    /**
     * 登记成绩(对成绩为空的可在前台过滤或者在此处过滤)
     */
    @RequestMapping(value = "score/recordScore")
    public void recordScore(@RequestBody()JSONObject input) {

        LOGGER.info(input.toJSONString());

        try {
            if (input.containsKey("teachingClassScoreRecordID")) {

                TeachingClassScoreRecordID teachingClassScoreRecordID = new TeachingClassScoreRecordID(input.getString("teachingClassScoreRecordID"));

                CourseID courseID = new CourseID(input.getString("courseID"));

                String termID = input.getString("termID");

                JSONArray studentScore = input.getJSONArray("studentScore");

                studentScore.forEach(p -> {

                    JSONObject o = (JSONObject) p;

                    StudentID studentID = new StudentID(o.getString("studentID"));

                    //获取成绩
                    HashMap<ScoreTypeEnum, String> scores = new HashMap<>();

                    JSONArray scoreArray = o.getJSONArray("score");

                    scoreArray.forEach(s -> {
                        JSONObject v = (JSONObject) s;
                        scores.put(ScoreTypeEnum.valueOf(v.getString("scoreType")), v.getString("scoreValue"));

                    });
                    String scoreID = o.getString("scoreID");

                    if (scoreID == null || scoreID.isEmpty()) {
                        ScoreID scoreIdentifier = new ScoreID();
                        //创建成绩
                        CreateScoreCommand command =new CreateScoreCommand(scoreIdentifier, teachingClassScoreRecordID, studentID, courseID,termID, scores);
                        this.commandGateway.sendAndWait(command);
                    } else {
                        ScoreID scoreIdentifier = new ScoreID(scoreID);
                        //登记成绩
                        RecordScoreCommand command = new RecordScoreCommand(scoreIdentifier, scores);

                        this.commandGateway.sendAndWait(command);

                    }
                });

            }

            response.setStatus(HttpServletResponse.SC_CREATED);

        } catch (CommandExecutionException e) {

            LOGGER.warn("Add Command FAILED with Message: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

