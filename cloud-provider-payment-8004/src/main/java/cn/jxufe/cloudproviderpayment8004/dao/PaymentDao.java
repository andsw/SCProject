package cn.jxufe.cloudproviderpayment8004.dao;

import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/24 14:10
 */
public interface PaymentDao {
    Integer insertPayment(Payment payment);
    Payment selectPaymentById(Integer id);
}
