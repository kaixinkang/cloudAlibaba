package com.java.hei.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80Application.class,args);
    }
}
