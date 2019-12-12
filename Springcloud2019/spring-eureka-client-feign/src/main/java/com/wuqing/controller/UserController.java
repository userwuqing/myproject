package com.wuqing.controller;

import com.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("test.do")
    public String test(HttpServletRequest request, HttpServletResponse response){
        String test = userService.test();
        return test;
    }

    @GetMapping("selectDiscoveryServer.do")
    public Object discoveryServer() {

        Object o = userService.selectDiscoveryServer();
        return o;
    }
}
