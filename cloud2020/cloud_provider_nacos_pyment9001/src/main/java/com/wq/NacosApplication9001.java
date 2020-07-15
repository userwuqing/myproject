package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 17:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication9001.class, args);
    }
}
