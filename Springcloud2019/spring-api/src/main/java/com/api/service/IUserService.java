package com.api.service;

import com.api.po.UserPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月12日 13:51
 **/
@FeignClient("eureka-server")
@RequestMapping("test")
@ResponseBody
public interface IUserService {
        @GetMapping("test.do")
        String test();

        @GetMapping("selectDiscoveryServer.do")
        UserPO selectDiscoveryServer();
    }