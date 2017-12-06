package com.magical.jwgl.web.clients;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zhouxp on 2017/10/23
 */
@FeignClient(value = "student-service",fallback = StudentClient.StudentClientFallback.class)
public interface StudentClient {

    @GetMapping(value = "/student/{id}")
    JSONObject getStudentDTOByID(@PathVariable("id") String studentID);

    @Component
    class StudentClientFallback implements StudentClient{

        @Override
        public JSONObject getStudentDTOByID(String studentID) {
            return new JSONObject();
        }
    }
}
