package cn.jxufe.cloudproviderpayment8004.service;

import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/24 14:14
 */
public interface PaymentService {
    Payment InsertPayment(Payment payment);

    Payment selectPaymentById(Integer id);
}
