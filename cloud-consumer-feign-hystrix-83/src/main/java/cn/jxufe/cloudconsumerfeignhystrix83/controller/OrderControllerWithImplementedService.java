package cn.jxufe.cloudconsumerfeignhystrix83.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudconsumerfeignhystrix83.service.HystrixPaymentServiceWithHandlerClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/7/27 22:27
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderControllerWithImplementedService {
    private final HystrixPaymentServiceWithHandlerClass hystrixPaymentServiceWithHandlerClass;

    @Autowired
    public OrderControllerWithImplementedService(HystrixPaymentServiceWithHandlerClass hystrixPaymentServiceWithHandlerClass) {
        this.hystrixPaymentServiceWithHandlerClass = hystrixPaymentServiceWithHandlerClass;
    }

    @GetMapping(value = "/hystrix/timeout/implement/fallback/{id}")
    public String getOrder(@PathVariable Integer id) {
        final String result = hystrixPaymentServiceWithHandlerClass.paymentInfoTimeout(id);
        log.info("【controller use implemented payment service】 result : " + result + " id = " + id);
        return result;
    }
}
