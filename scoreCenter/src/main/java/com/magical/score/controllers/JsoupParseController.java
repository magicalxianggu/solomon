package com.magical.score.controllers;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by zhouxp on 2017/12/21
 */
@RestController
public class JsoupParseController {

    @GetMapping(value = "/html/parse")
    public JSONObject htmlParse() throws IOException {



        URL resource = JsoupParseController.class.getResource("/");

        String path = resource.getPath();

        File templateHtml = new File(path+"templates/index.ftl");



        Document document = Jsoup.parse(templateHtml,"UTF-8");


        String contentString = document.body().html();
        String aaa=Entities.unescape(contentString);

        Element content = document.body();
        Elements gdsdecors = content.getElementsByTag("gds:decor");

        JSONObject jsonObject = new JSONObject();
        for(Element gdsdecor : gdsdecors){
            String decorID = gdsdecor.attr("decorID");
            Element modle = gdsdecor.children().first();
            String modleID =modle.attr("moduleID");

            jsonObject.put(decorID,modleID);
        }


        Elements assign = content.getElementsByTag("#assign");

        Element aa = content.tagName("#assign");
        for (Element s:assign) {
            String item = s.attr("item");
            jsonObject.put(item,"a");
        }

        return jsonObject;
    }
}















