package com.magical.score.controllers;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;

/**
 * Created by zhouxp on 2017/12/21
 */
@RestController
public class JsoupParseController {

    @GetMapping(value = "/html/parse")
    public String htmlParse() throws Exception {


        URL resource = this.getClass().getResource("/");

        String path1 = resource.getPath();

        String path = "D:/gdsCms";
        //得到模板文件
        File templateHtml = new File(path+ "/templates/index.ftl");

        //得到模板配置属性文件转化为json对象
        JSONObject templateAtrributeJson = getTemplateAttributeJsonObject(path);

        //得到装饰器文件
        File decorHtml = new File(path+ "/offline/elements/decorator/decorator-view.html");


        //得到模块文件
        File moduleHtml = new File(path+ "/offline/elements/module/listModule.ftl");

        String templateString = parseTemplateFile(path,templateHtml, templateAtrributeJson, decorHtml, moduleHtml);

        //将templateString写入freemarker文件
        writerFileToFtl(path, templateString);

        return templateString;
    }



    private void writerFileToFtl(String path, String templateString) throws IOException {
        File file = new File(path+"/web/index.ftl");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(templateString);
        bw.close();
    }

    private String parseTemplateFile(String path,File templateHtml, JSONObject templateAtrributeJson, File decorHtml, File moduleHtml) throws IOException {
        Document templateDocument = Jsoup.parse(templateHtml,"UTF-8");

        Document decorDocument = Jsoup.parse(decorHtml,"UTF-8");

        Document moduleDocument = Jsoup.parse(moduleHtml,"UTF-8");

        //得到所有装饰器
        Element content = templateDocument.body();
        Elements gdsdecors = content.getElementsByTag("gds:decor");

        //循环装饰器模板中替换装饰器与模块代码
        for(Element gdsdecor : gdsdecors){

            String decorID = gdsdecor.attr("decorID");
            String decorNO = templateAtrributeJson.getJSONObject("decors").getJSONObject(decorID).getString("decorNO");;

            Element module = gdsdecor.children().first();
            String moduleID =module.attr("moduleID");

            moduleDocument.select("div").first().attr("id",moduleID);

            decorDocument.select("div").first().attr("id",decorID).addClass(decorNO);

            decorDocument.select("div.decor-body").first().html(Entities.unescape(moduleDocument.html()));
            //得到装饰器的父div标签
            Element gdsdecorPrent = gdsdecor.parent();
            gdsdecorPrent.html(decorDocument.html());

        }

        //获取模板结构
        File templateStructureHtml = new File(path+ "/templates/templateStructure.html");

        Document templateStructureDocument = Jsoup.parse(templateStructureHtml,"UTF-8");

        //将解析后的模板放入模板结构中
        templateStructureDocument.select("body").first().html(templateDocument.body().html());

         String templateString = Entities.unescape(templateStructureDocument.html());
        return  templateString;
    }

    /**
     * 得到模板配置属性文件转化为json对象
     * @param path
     * @return
     * @throws Exception
     */
    private JSONObject getTemplateAttributeJsonObject(String path) throws Exception {
        File templateAttributeFile = new File(path+"/templateAttribute/index.json");

        String  templateAttribute = this.fileRead(templateAttributeFile);

        return JSONObject.parseObject(templateAttribute);
    }


    /**
     * 读取file文件内容到String
     * @param file
     * @return
     * @throws Exception
     */
    public static String fileRead(File file) throws Exception {
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
        return str;
    }
}















