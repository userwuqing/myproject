package com.wq.controller;

import com.wq.entries.Payment;
import com.wq.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:43
 */
@RestController
@RequestMapping("test")
public class Controller {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("insert.do")
    public String insert(@RequestParam("id") String id) {
        Payment payment = new Payment();
        payment.setSerial(id);
        paymentService.add(payment);
        return "success";
    }

    @GetMapping("select.do")
    public String select(@RequestParam("id") String id) {

        return paymentService.selectPayment(Long.valueOf(id)).toString()+"8001";
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("discovery.do")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("+++++++++++++"+service);
        }

        //同一个服务名，可能有多个服务,
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient.toString();
    }


    @GetMapping("testTimeOut.do")
    public String testTimeOut() {
        //测试 feign超时控制
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "8001";
    }

    @GetMapping("paymentCircuitBreaker.do")
    public String paymentCircuitBreaker(@RequestParam("id") String id) {
        //测试 服务熔断方法
        String s = paymentService.paymentCircuitBreaker(Long.valueOf(id));
        return s+"8001";
    }
}
