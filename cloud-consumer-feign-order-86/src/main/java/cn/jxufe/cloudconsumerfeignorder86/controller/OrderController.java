package cn.jxufe.cloudconsumerfeignorder86.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudconsumerfeignorder86.service.FeignPaymentService;
import cn.jxufe.dto.NormalResult;

/**
 * @author hsw
 * @date 2020/4/26 10:39
 */
@RestController
public class OrderController {

    private final FeignPaymentService paymentService;

    @Autowired
    public OrderController(FeignPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/feign/order/{id}")
    public NormalResult<?> feignGetOrder(@PathVariable(value = "id") Integer id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String getTimeout() {
        return paymentService.getTimeout();
    }

}
