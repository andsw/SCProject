package cn.jxufe.cloudproviderpayment8004.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.cloudproviderpayment8004.dao.PaymentDao;
import cn.jxufe.cloudproviderpayment8004.service.PaymentService;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/24 14:14
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment InsertPayment(Payment payment) {
        paymentDao.insertPayment(payment);
        return payment;
    }

    @Override
    public Payment selectPaymentById(Integer id) {
        return paymentDao.selectPaymentById(id);
    }
}
