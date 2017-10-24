package com.magical.jwgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhouxp on 2017/10/24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApplication {
    public static void main(String args[]){
        SpringApplication.run(EmployeeApplication.class,args);}
}
