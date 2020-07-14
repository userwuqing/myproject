package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 17:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplicationZK80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationZK80.class, args);
    }
}
