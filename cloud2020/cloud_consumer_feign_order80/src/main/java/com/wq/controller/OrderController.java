package com.wq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wq.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 10:35
 */
@RestController
@RequestMapping("order")
public class OrderController {

    //单机的可以这样写死
//    private final static String URL_BASE = "http://127.0.0.1:8001";
//    private final static String URL_BASE = "http://CLOUD-PYMENT-SERVICE";

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("insert.do")
    public String insert(@RequestParam("id") String id) {
        String insert = paymentService.insert(id);
        return insert;
    }

    @GetMapping("select.do")
  /*  @HystrixCommand(fallbackMethod = "selectException", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    public String select(@RequestParam("id") String id, HttpServletRequest request) {
        //目标微服务使用@RequestParam这个注解时，需要在请求时拼接参数，或者
        System.out.println(request.getQueryString());
//        ResponseEntity<String> entity = restTemplate.getForEntity(URL_BASE + "/test/select.do?id="+id, String.class);
//        ResponseEntity<String> entity = restTemplate.getForEntity(URL_BASE +"/test/select.do?id="+id, String.class);
        //使用feign
        String select = paymentService.select(id);
        return select;
    }

    private String selectException(@RequestParam("id") String id, HttpServletRequest request) {
       //客户端兜底函数
        return "客户端兜底函数";
    }

    @GetMapping("testTimeOut.do")
    public String testTimeOut() {
        //默认1s
        //使用feign,目标服务8001、8002已经设置3s沉睡，因此这里报错 java.net.SocketTimeoutException: Read timed out
        String select = paymentService.testTimeOut();
        return select;
    }
}
