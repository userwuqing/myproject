package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * description：微服务监控平台
 *
 * @author v_qqinwu
 * @date 2019年12月13日 9:55
 **/
@SpringBootApplication
@EnableHystrixDashboard //开启服务图形化监控注解
@EnableHystrix
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
