package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description：注册中心，无需引用spring-boot的web（不注册服务）
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:13
 **/
@SpringBootApplication
//启用eureka服务注解
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
