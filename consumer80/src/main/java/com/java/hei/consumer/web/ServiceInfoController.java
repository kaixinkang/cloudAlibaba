package com.java.hei.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceInfoController {
    @Value("${server.port}")
    private String prot;
    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("hei/consumer/serviceinfo")
    public String getServiceInfo() {
        return appName + ":" + prot;
    }

    @GetMapping("hei/consumer/discoverlist")
    public String discoverlist() {
        return discoveryClient.getServices().toString();
    }

    @GetMapping("hei/consumer/serverInstances")
    public Object serverInstances() {
        List<ServiceInstance> instances = discoveryClient.getInstances(appName);
        ServiceInstance serviceInstance = instances.get(0);
        return serviceInstance.getMetadata();
    }
}
