package com.api.service.impl;

import com.api.po.UserPO;
import com.api.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * description：
 *
 * @author v_qqinwu
 * @date 2019年12月12日 19:54
 **/
@Component //必要
public class UserServiceFallbackFactory implements FallbackFactory<IUserService> {

    @Override
    public IUserService create(Throwable throwable) {
        return new IUserService() {
            @Override
            public String test() {
                return "系统繁忙";
            }

            @Override
            public UserPO selectDiscoveryServer() {
                UserPO userPO = new UserPO();
                userPO.setUserName("未知。。。");
                return userPO;
            }
        };
    }
}
