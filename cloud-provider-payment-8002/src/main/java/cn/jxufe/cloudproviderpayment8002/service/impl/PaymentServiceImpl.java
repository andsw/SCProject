package cn.jxufe.cloudproviderpayment8002.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.cloudproviderpayment8002.dao.PaymentDao;
import cn.jxufe.cloudproviderpayment8002.service.PaymentService;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/21 11:38
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
