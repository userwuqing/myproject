package com.wq.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 19:53
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLogger() {

        //开启feign全日志级别
        return Logger.Level.FULL;
    }
}
