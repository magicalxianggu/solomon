package com.magical.jwgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhouxp on 2017/10/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScoreApplication {
    public static void main(String args[]){
        SpringApplication.run(ScoreApplication.class,args);}
}
