package com.wq.service.impl;

import com.wq.dao.PaymentDao;
import com.wq.entries.Payment;
import com.wq.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:59
 */
@Service

public class PaymentServiceImpl implements IPaymentService {


//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public void add(Payment payment) {
        paymentDao.insert(payment);
    }

    @Override
    public Payment selectPayment(Long id) {
        return paymentDao.selectPayment(id);
    }
}
