package cn.jxufe.cloudproviderpayment8001.service;

import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/21 11:38
 */
public interface PaymentService {
    Payment InsertPayment(Payment payment);

    Payment selectPaymentById(Integer id);
}
