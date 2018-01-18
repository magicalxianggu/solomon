package com.magical.score.controllers;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouxp on 2018/1/3
 */
@RestController
public class ViewFtlController {


    @GetMapping(value = "/viewStudentInfo")
    public ModelAndView viewStudentInfo(Model model){

//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setDefaultEncoding("UTF-8");

        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        model.addAttribute("friends", friends);

        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}


