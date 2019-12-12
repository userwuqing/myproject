package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:13
 **/
@SpringBootApplication
@EnableEurekaClient
//下面两个注解用于feign
@EnableFeignClients(basePackages = {"com.api"})
@ComponentScan("com.api")
public class Application {
    //feign代理的是目标的地址，且必须给每个方法或者类加上ResponseBody注解
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
