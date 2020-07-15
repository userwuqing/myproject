package com.wq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private final static String URL_BASE = "http://CLOUD-PYMENT-SERVICE";

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("insert.do")
    public String insert() {

        return null;
    }

    @GetMapping("select.do")
    public String select(@RequestParam("id") String id, HttpServletRequest request) {
        //目标微服务使用@RequestParam这个注解时，需要在请求时拼接参数，或者
        System.out.println(request.getQueryString());
//        ResponseEntity<String> entity = restTemplate.getForEntity(URL_BASE + "/test/select.do?id="+id, String.class);
        ResponseEntity<String> entity = restTemplate.getForEntity(serverUrl +"/test/select.do?id="+id, String.class);
        return entity.toString();
    }
}
