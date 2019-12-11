package com.wuqing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:16
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务发现
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("test.do")
    public String test(HttpServletRequest request, HttpServletResponse response){

        String comeBackValue = restTemplate.getForObject("http://eureka-server/test/test.do", String.class);
        return comeBackValue;
    }

    @GetMapping("discoveryServer.do")
    public Object discoveryServer() {
        List<String> services = discoveryClient.getServices();
        System.out.println("所有启用服务暴露的微服务"+services);
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-CLIENT");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println(serviceInstance.getServiceId()+"\\s" +serviceInstance.getHost()+"\\s"+serviceInstance.getPort());
        }
        return this.discoveryClient;
    }
}
