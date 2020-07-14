package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description：支付模块
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:41
 */
@SpringBootApplication
@EnableEurekaClient //入住注册中心
public class PaymentApplication {
    public static void main(String[] args) {
        //约定》配置》编码
        //有前端交互的需要web依赖
        SpringApplication.run(PaymentApplication.class, args);
    }
}
