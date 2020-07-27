package cn.jxufe.cloudconsumerfeignhystrix83.service;

import org.springframework.stereotype.Component;

/**
 * @author hsw
 * @date 2020/7/27 22:16
 */
@Component
public class HystrixPaymentServiceHandler implements HystrixPaymentServiceWithHandlerClass {

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "【fallback method in child class】id =  " + id;
    }
}
