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

        Map tableData = new HashMap();
        tableData.put("date","2017-11-16");
        tableData.put("name","lixiaoran");
        tableData.put("address","beijing momo junqu");
        model.addAttribute("tableData",tableData);
//        ModelAndView mv = new ModelAndView("home");
        return "home";
    }
}
