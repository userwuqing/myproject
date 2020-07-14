package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description：客户端基本就只有controller
 *
 * @author v_qqinwu
 * @date 2020年07月14日 10:31
 */
@SpringBootApplication
@EnableEurekaClient
//配置某个微服务使用某种策略的负载均衡，这里是支付服务模块
//@RibbonClient(name = "CLOUD-PYMENT-SERVICE", configuration = RuleTest.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
