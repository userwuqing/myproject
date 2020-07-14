package com.wq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 16:41
 */
@SpringBootApplication
@EnableDiscoveryClient //用于发现zookeeper的服务
public class PaymentApplication8004 {
    public static void main(String[] args) {
        //zookeeper是临时节点还是持久节点
        //zookeeper没有eureka的自我保护机制，服务故障zookeeper就移除当前服务节点
        //因此服务节点是临时的
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
