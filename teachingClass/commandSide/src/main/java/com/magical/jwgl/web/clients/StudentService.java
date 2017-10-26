package com.magical.jwgl.web.clients;

import com.alibaba.fastjson.JSONObject;
import com.magical.jwgl.web.dto.StudentDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zhouxp on 2017/10/23
 */
@FeignClient(value = "student-service")
public interface StudentService {

    @GetMapping(value = "/student/{id}")
    JSONObject getStudentDTOByID(@PathVariable("id") String studentID);
}
