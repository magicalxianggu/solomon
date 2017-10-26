package com.magical.jwgl.query.controllers;

import com.alibaba.fastjson.JSONObject;
import com.magical.jwgl.query.entries.EmployeeEntry;
import com.magical.jwgl.query.repository.EmployeeQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouxp on 2017/10/25
 */
@RestController
public class EmployeeClientController {

    @Autowired
    private EmployeeQueryRepository repository;

    @GetMapping(value = "/teacher/{id}")
    public JSONObject getTeacherDTOByID(@PathVariable("id") String teacherID){

        EmployeeEntry employeeEntry = this.repository.findOne(teacherID);

        if (employeeEntry == null){

          return  (JSONObject) JSONObject.toJSON(new EmployeeEntry("zxp123456","zhangshan12","9527123"));
        }else{

            return (JSONObject) JSONObject.toJSON(employeeEntry);
        }

    }
}
