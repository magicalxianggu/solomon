package com.magical.jwgl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouxp on 2018/1/17
 */
@Controller
public class TemplateController {

    /**
     * 返回html模板.
     */

    @RequestMapping("/homeHtml")
    public String helloHtml(Model model){

        Map home = new HashMap();
        home.put("welcome","hello ni hao!!!");
        model.addAttribute("home","8945648945648545848");
//        ModelAndView mv = new ModelAndView("home");
        return "home";
    }
}
