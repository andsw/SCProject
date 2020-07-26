package cn.jxufe.cloudproviderpayment8002.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hsw
 * @date 2020/3/21 12:16
 */
@SpringBootTest
public class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;
    @Test
    public void testGetPayment() {
        System.out.println(paymentService.selectPaymentById(1));
    }
}
