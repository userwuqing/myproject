package com.wuqing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private RestTemplate restTemplate;

    @GetMapping("test.do")
    public String test(HttpServletRequest request, HttpServletResponse response){

        String comeBackValue = restTemplate.getForObject("http://eureka-server/test/test.do", String.class);
        return comeBackValue;
    }
}
