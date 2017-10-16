package com.magical.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zhouxp on 2017/10/16
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProxyServiceApplication {
    public static void main(String args[]){
        SpringApplication.run(ProxyServiceApplication.class, args);
    }

}
