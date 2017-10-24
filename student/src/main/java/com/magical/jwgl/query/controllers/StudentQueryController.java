package com.magical.jwgl.query.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.magical.jwgl.query.entries.StudentEntry;
import com.magical.jwgl.query.repository.StudentQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouxp on 2017/10/24
 */
@RestController
public class StudentQueryController {

    @Autowired
    private StudentQueryRepository repository;

    @GetMapping(value = "student/{id}")
    public JSONObject findStudentByID(@PathVariable("id") String studentID){

        StudentEntry studentEntry= repository.findOne(studentID);
        if(studentEntry == null){
            return (JSONObject)JSONObject.toJSON(new StudentEntry("ceshi","ceshi","ceshi"));
        }else{

            return (JSONObject)JSONObject.toJSON(studentEntry);

        }
    }

}
