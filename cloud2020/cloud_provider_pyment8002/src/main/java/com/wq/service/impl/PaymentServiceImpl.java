package com.wq.service.impl;

import com.wq.dao.PaymentDao;
import com.wq.entries.Payment;
import com.wq.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:59
 */
@Service
@Slf4j
public class PaymentServiceImpl implements IPaymentService {


//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public void add(Payment payment) {
        int insert = paymentDao.insert(payment);
        if (insert < 0) {
            log.error("插入失败");
        }
    }

    @Override
    public Payment selectPayment(Long id) {
        Payment payment = paymentDao.selectPayment(id);
        if (payment == null) {
            log.info("DB 未找到该数据id={}",id);
        }
        return payment;
    }
}
