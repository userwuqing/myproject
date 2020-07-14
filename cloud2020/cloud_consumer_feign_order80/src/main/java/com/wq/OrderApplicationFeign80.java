package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 19:11
 */
@SpringBootApplication
@EnableFeignClients //激活feign
public class OrderApplicationFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationFeign80.class, args);
    }
}
