package com.wq.service.impl;

import com.wq.dao.PaymentDao;
import com.wq.entries.Payment;
import com.wq.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:59
 */
@Service
@Slf4j
//全局服务降级，若方法配置有
// @HystrixCommand(fallbackMethod = "selectPaymentException", commandProperties = {
//            //设定超时3s
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
//则使用其服务降级策略,这个全局方式需要返回类型与参数类型一致，否则异常，可以想个方法统一一下
//这里业务混合一起了，耦合度高，混乱，需要解耦。
public class PaymentServiceImpl implements IPaymentService {


//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public void add(Payment payment) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int insert = paymentDao.insert(payment);
        if (insert < 0) {
            log.error("插入失败");
        }
    }

    @Override
    public Payment selectPayment(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentDao.selectPayment(id);
        if (payment == null) {
            log.info("DB 未找到该数据id={}",id);
        }
        return payment;
    }

    @Override
    public Payment selectPaymentException(Long id) {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSerial("系统繁忙哦！");
        return payment;
    }

    private String globalFunction() {

        return "系统错误";
    }

    //==============服务熔断
    @Override
    public String paymentCircuitBreaker(Long id) {

        if (id < 0) {
            throw new RuntimeException("id 不能为符数");
        }
        return null;
    }

    public String paymentCircuitBreakerFallback(Long id) {

        return "请稍后再试/（ToT）/~~";
    }
}
