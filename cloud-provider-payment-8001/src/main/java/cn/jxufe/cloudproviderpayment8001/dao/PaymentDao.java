package cn.jxufe.cloudproviderpayment8001.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/21 11:32
 */
public interface PaymentDao {
    Integer insertPayment(Payment payment);
    Payment selectPaymentById(Integer id);
}
