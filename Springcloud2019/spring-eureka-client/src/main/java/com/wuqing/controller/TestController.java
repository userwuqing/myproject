package com.wuqing.controller;

import com.api.po.UserPO;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:16
 **/
@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Value("${spring.datasource.userName}")
    private String userName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务发现
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("test.do")
    public String test(HttpServletRequest request, HttpServletResponse response){

        String comeBackValue = restTemplate.getForObject("http://EUREKA-SERVER/test/test.do", String.class);
        logger.info("测试================="+comeBackValue);
        return comeBackValue;
    }

    @GetMapping("discoveryServer.do")
    public Object discoveryServer() {
        logger.info("测试=================");
        UserPO comeBackValue = restTemplate.getForObject("http://EUREKA-SERVER/test/selectDiscoveryServer.do", UserPO.class);
        return comeBackValue;
    }

    @GetMapping("getConfig.do")
    public String getConfig() {
        logger.info("测试=================");
        return userName;
    }
}
