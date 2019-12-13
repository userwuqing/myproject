package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月13日 12:48
 **/
@SpringBootApplication
@EnableTurbine //启用集群监控
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
