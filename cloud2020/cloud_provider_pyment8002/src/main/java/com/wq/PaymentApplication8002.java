package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Description：支付模块
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:41
 */
@SpringBootApplication
@EnableEurekaClient //入住注册中心
@EnableDiscoveryClient //服务发现，可提供各种信息，非常重要
@EnableHystrix //启动熔断机制
public class PaymentApplication8002 {
    public static void main(String[] args) {
        //约定》配置》编码
        //有前端交互的需要web依赖
        SpringApplication.run(PaymentApplication8002.class, args);
    }
}
