package cn.jxufe.cloudproviderhystrix8003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudproviderhystrix8003.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/7/26 19:32
 */
@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id) {
        String result = paymentService.paymentOk(id);
        log.info("collect result : " + result);
        return result;
    }

    @GetMapping(value = "/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id) {
        String result = paymentService.paymentTimeout(id);
        log.info("result in service time delay method : " + result);
        return result;
    }

    @GetMapping(value = "/hystrix/exception/{id}")
    public String paymentInfoException(@PathVariable Integer id) {
        String result = paymentService.paymentWithException(id);
        log.info("result in service exception method : " + result);
        return result;
    }
}

