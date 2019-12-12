package com.wuqing.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:17
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced //表示使用spring.application.name作为服务地址，也启用ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
