package com.magical.jwgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

/**
 * Created by zhouxp on 2017/10/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
public class TeachingClassCommandApplication {
    public static void main(String args[]){
        SpringApplication.run(TeachingClassCommandApplication.class,args);}
}
