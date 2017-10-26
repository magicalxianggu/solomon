package com.magical.jwgl.controllers;

import com.magical.jwgl.entries.TeachingClassEntry;
import com.magical.jwgl.repository.TeachingClassRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouxp on 2017/10/25
 */
@RestController
@RequestMapping(value = "/query")
public class TeachingClassController {

    private TeachingClassRepository repository;

    @GetMapping(value = "teachingClass/{id}")
    public TeachingClassEntry findTeachingClassByID(@PathVariable("id") String teachingClassID){

        return this.repository.findOne(teachingClassID);
    }
}
