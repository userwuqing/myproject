package com.wq.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description：类似于xml，配置类
 *
 * @author v_qqinwu
 * @date 2020年07月14日 10:38
 */
@Configuration
public class ApplicationContextConfig {

    @Bean //注入容器中
    @LoadBalanced //新增负载均衡 默认轮询, 未加ribbon
    public RestTemplate getRestTemplate() {

        //客户端模板请求
        return new RestTemplate();
    }


}
