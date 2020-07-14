package com.wq.service;

import com.wq.entries.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:59
 */
@FeignClient("CLOUD-PYMENT-SERVICE") //找对应微服务的service，避免不同服务有一样的service
@RequestMapping("test")//这里对应调用服务的controller的对应路径
@ResponseBody //这里必须加，因为CLOUD-PYMENT-SERVICE使用了
public interface IXXxxxx {

    //这里的service不一定需要与目标服务的service一致，但为了可读性，需要与目标服务的service接口一致
    //这里的方法直接写目标服务的controller类中的方法，因为目标服务的controller本身就是调用其service
    //这里对应的是8001、8002微服务，详情查看其controller
    @GetMapping("insert.do")
    String insert(@RequestParam("id") String id);

    //这里的service不一定需要与目标服务的service一致，但为了可读性，需要与目标服务的service接口一致
    //这里的方法直接写目标服务的controller类中的方法，因为目标服务的controller本身就是调用其service
    //这里对应的是8001、8002微服务，详情查看其controller
    @GetMapping("select.do")
    String select(@RequestParam("id") String id);
}
