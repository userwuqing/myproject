package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 16:07
 */
@SpringBootApplication
/*@EnableEurekaClient //注册eureka使用的注解，其他注册中心使用下面这个
@EnableDiscoveryClient*/
public class StreamApplication8801 {
    //目前启动报错，原因未知
    public static void main(String[] args) {
        SpringApplication.run(StreamApplication8801.class, args);
    }
}
