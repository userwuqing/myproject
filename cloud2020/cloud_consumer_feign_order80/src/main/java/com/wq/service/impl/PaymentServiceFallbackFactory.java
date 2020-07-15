package com.wq.service.impl;

import com.wq.service.IPaymentService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 11:45
 */
/*@Component //必须加这个，要不然spring不认识
//这里有一个坑，实现IPaymentService接口时同时把@RequestMapping("test")也继承过来
//因此会报错com.wq.service.IPaymentService#insert(String)
//to {GET /test/insert.do}: There is already 'paymentServiceFallbackImpl' bean method

public class PaymentServiceFallbackImpl implements IPaymentService {
    @Override
    public String insert(String id) {
        return "insert(T_T)";
    }

    @Override
    public String select(String id) {
        return "select(T_T)";
    }

    @Override
    public String testTimeOut() {
        return "testTimeOut(T_T)";
    }
}*/
@Component //必须加这个，要不然spring不认识
public class PaymentServiceFallbackFactory implements FallbackFactory<IPaymentService> {
    @Override
    public IPaymentService create(Throwable throwable) {
        return new IPaymentService(){
            @Override
            public String insert(String id) {
                return "insert (T_T)";
            }

            @Override
            public String select(String id) {
                return  "select (T_T)";
            }
            @Override
            public String testTimeOut() {
                return  "testTimeOut (T_T)";
            }
        };
    }
}
