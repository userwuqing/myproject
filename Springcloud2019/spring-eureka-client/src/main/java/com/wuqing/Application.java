package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:13
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
