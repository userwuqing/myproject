package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 14:02
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication5757 {
    public static void main(String[] args) {
        //异步非阻塞模型
        SpringApplication.run(GatewayApplication5757.class, args);
    }
}
