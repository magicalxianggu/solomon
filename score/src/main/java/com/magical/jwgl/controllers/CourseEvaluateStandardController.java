package com.magical.jwgl.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.magical.cloud.commands.CreateCourseEvaluateStandardCommand;
import com.magical.cloud.domain.CheckTypeEnum;
import com.magical.cloud.domain.ScoreTypeEnum;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/10/27
 */
@RestController
public class CourseEvaluateStandardController {

    private static final Logger LOGGER = getLogger(CourseEvaluateStandardController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    /**
     * 添加课程考核标准
     */
    @PostMapping(value = "/score/courseStandard/addStandard")
    public void createCourseEvaluateStandard(@RequestBody() JSONObject input){
        LOGGER.info(input.toJSONString());

        try{
            if(input.containsKey("classID") && input.containsKey("checkType")){

                //创建命令
                String classID = input.getString("classID");
                String version = input.getString("version");
                String checkType = input.getString("checkType");
                CheckTypeEnum checkTypeEnum = CheckTypeEnum.valueOf(checkType);

                JSONArray requireMarkTypes = input.getJSONArray("requireMarkTypes");

                HashMap<ScoreTypeEnum,Float> everyMarkWeighting = new HashMap();
                requireMarkTypes.forEach((each) ->{
                    JSONObject o = (JSONObject)each;
                    everyMarkWeighting.put(ScoreTypeEnum.valueOf(o.getString("scoreType")),o.getFloat("markWeighting"));
                        }
                );

                CreateCourseEvaluateStandardCommand command =
                        new CreateCourseEvaluateStandardCommand(classID,version,checkTypeEnum,everyMarkWeighting);

                //发送命令
                commandGateway.sendAndWait(command);
                response.setStatus(HttpServletResponse.SC_CREATED);
            }

        }catch (CommandExecutionException cex){
            LOGGER.warn("Add Command FAILED with Message: {}", cex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改课程考核标准
     */
}
