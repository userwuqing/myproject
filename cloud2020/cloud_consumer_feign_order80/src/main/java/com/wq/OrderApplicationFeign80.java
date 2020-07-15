package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 19:11
 */
@SpringBootApplication
@EnableFeignClients //激活feign
@EnableHystrix //客户端使用这个注解，服务端@EnableCircuitBreaker
public class OrderApplicationFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationFeign80.class, args);
    }
}
