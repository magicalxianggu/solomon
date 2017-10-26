package com.magical.jwgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableAutoConfiguration
public class TeachingClassQueryApplication {

    public static void main(String args[]){
        SpringApplication.run(TeachingClassQueryApplication.class,args);
    }
}
