package cn.jxufe.cloudnacospayment9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hsw
 * @date 2020/8/15 11:09
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable(name = "id") Integer id) {
        return "nacos registry, serverPort = " + serverPort + " id = " + id;
    }
}
