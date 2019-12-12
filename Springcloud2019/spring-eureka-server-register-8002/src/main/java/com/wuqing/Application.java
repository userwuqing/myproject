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
@EnableEurekaServer //启用eureka服务注册中心
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * eureka自我保护机制：不会盲目注销不活跃的微服务（好死不如赖活着），保证高可用
     */
}
