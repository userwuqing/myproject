package com.wq.service;

import com.wq.entries.Payment;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:59
 */
public interface IPaymentService {

    void add(Payment payment);



    Payment selectPayment(Long id);

    Payment selectPaymentException(Long id);

    String paymentCircuitBreaker(Long id);
}
