package com.wuqing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("test.do")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("来访的人"+request.getServletPath());
        return "这里是9002微服务";
    }
}
