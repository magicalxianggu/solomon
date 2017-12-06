package com.magical.jwgl.web.clients.clientProxys;

import com.alibaba.fastjson.JSONObject;
import com.magical.jwgl.web.clients.StudentClient;
import com.magical.jwgl.web.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxp on 2017/10/25
 */
@Component
public class StudentProxy {

    @Autowired
    private StudentClient studentClient;

    public StudentDTO getStudentDTOByID(String studentID){

        JSONObject studentJson = this.studentClient.getStudentDTOByID(studentID);


        return JSONObject.toJavaObject(studentJson,StudentDTO.class);
    }
}
