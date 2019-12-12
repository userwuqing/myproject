package com.wuqing.controller;

import com.api.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月11日 15:16
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("test.do")
    public String test() {
        return "这里是9002微服务";
    }

    @GetMapping("selectDiscoveryServer.do")
    public UserPO selectDiscoveryServer() {
        List<String> services = discoveryClient.getServices();
        UserPO userPO = new UserPO();
        userPO.setUserName("eureka-server");
        userPO.setAddress("eureka-server：9001");
        return userPO;
    }
}
