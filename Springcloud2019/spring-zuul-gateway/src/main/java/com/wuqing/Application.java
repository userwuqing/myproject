package com.wuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月13日 13:51
 **/
@SpringBootApplication
//@EnableZuulProxy //启用网关代理
//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableZuulServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
