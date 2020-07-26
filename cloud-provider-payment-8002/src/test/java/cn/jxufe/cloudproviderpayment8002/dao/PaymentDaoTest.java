package cn.jxufe.cloudproviderpayment8002.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hsw
 * @date 2020/3/21 12:19
 */
@SpringBootTest
public class PaymentDaoTest {
    @Autowired
    private PaymentDao paymentDao;
    @Test
    public void testSelect() {
        System.out.println(paymentDao.selectPaymentById(1));
    }
}
