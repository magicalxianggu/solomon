package com.magical.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zhouxp on 2017/10/16
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {
    public static void main(String args[]){
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

}
