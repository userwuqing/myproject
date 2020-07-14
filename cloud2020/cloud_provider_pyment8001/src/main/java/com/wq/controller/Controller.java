package com.wq.controller;

import com.wq.entries.Payment;
import com.wq.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        return paymentService.selectPayment(Long.valueOf(id)).toString();
    }
}
