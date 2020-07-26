package cn.jxufe.cloudproviderhystrix8003.service;

import org.springframework.stereotype.Component;

/**
 * @author hsw
 * @date 2020/7/26 19:27
 */
@Component
public class PaymentService {
    public String paymentOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "payment ok, id is" + id;
    }

    public String paymentTimeout(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "payment ok, id is" + id;
    }

    public String paymentWithException(Integer id) throws ArithmeticException {
        int a = 0;
        System.out.println(4 / a);
        return "线程池：" + Thread.currentThread().getName() + "payment time out, id is" + id;
    }
}
