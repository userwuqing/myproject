package com.wq;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Description：支付模块
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:41
 */
@SpringBootApplication
//@EnableEurekaClient //入住注册中心
@EnableDiscoveryClient //非常重要，就是提供服务信息（字面-发现服务信息）zookeeper与nacos使用
//@EnableHystrix //启动熔断机制客户端
//@EnableCircuitBreaker //服务端降级注解
public class PaymentApplication {
    public static void main(String[] args) {
        //约定》配置》编码
        //有前端交互的需要web依赖
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    //被hystrix监控得服务必须配置此servlet
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
