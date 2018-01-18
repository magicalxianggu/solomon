package com.magical.score.controllers;

import com.magical.score.entries.PagingResult;
import org.bouncycastle.util.StringList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouxp on 2018/1/15
 */
@RestController
public class ListFtlController {


    @RequestMapping(value = "/listView/{page}")
    public ModelAndView  ListView( @PathVariable Integer page, Model model,
                                  HttpServletRequest request){


        List<String> stringList = new ArrayList();
        stringList.add("12134243");
        stringList.add("55555");
        PagingResult<String> pagingResult = new PagingResult<String>(1,1000,20,stringList);



        model.addAttribute("pagingDealList", pagingResult);

        ModelAndView mv = new ModelAndView("list");
        return mv;
    }
}
