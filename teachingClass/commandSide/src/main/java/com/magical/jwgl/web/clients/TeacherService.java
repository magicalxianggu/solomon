package com.magical.jwgl.web.clients;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zhouxp on 2017/10/24
 */
@FeignClient(value = "employee-service")
public interface TeacherService {//可编写发生错误时的回掉方法

    @GetMapping(value = "/teacher/{id}")
    JSONObject getTeacherDTOByID(@PathVariable("id") String teacherID);
}
