package com.magical.jwgl.web.clients.clientProxys;

import com.alibaba.fastjson.JSONObject;
import com.magical.jwgl.web.clients.TeacherService;
import com.magical.jwgl.web.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxp on 2017/10/25
 */
@Component
public class TeacherProxy {

    @Autowired
    private TeacherService teacherService;

   public EmployeeDTO getTeacherDTOByID(String teacherID){

       JSONObject teacherJson = this.teacherService.getTeacherDTOByID(teacherID);

       return JSONObject.toJavaObject(teacherJson,EmployeeDTO.class);
   }
}
