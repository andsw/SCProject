package cn.jxufe.cloudconsumerfeignhystrix83.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudconsumerfeignhystrix83.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/7/26 21:43
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {
    private final HystrixPaymentService hystrixPaymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    public OrderController(HystrixPaymentService hystrixPaymentService) {

        this.hystrixPaymentService = hystrixPaymentService;
    }

    @GetMapping(value = "/hystrix/ok/{id}")
    public String getOrder(@PathVariable Integer id) {
        final String result = hystrixPaymentService.paymentInfoOk(id);
        log.info("port : " + port + " result : " + result + " payment ok!");
        return result;
    }

    @GetMapping(value = "/hystrix/timeout/{id}")
    public String getOrderTimeout(@PathVariable Integer id) {
        final String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info("port : " + port + " result : " + result + " payment timeout!");
        return result;
    }
}
