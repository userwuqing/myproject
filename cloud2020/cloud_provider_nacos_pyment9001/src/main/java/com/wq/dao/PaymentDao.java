package com.wq.dao;

import com.wq.entries.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月13日 19:50
 */
@Mapper
public interface PaymentDao {

    int insert(Payment payment);

    Payment selectPayment(Long id);
}
