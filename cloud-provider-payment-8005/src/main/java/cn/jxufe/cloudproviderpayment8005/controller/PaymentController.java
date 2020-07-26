package cn.jxufe.cloudproviderpayment8005.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author hsw
 * @date 2020/3/24 15:52
 */
@RestController
public class PaymentController {
    @Value(value = "${server.port}")
    private String port;

    @GetMapping("/payment/consul/info")
    public String paymentConsul() {
        return "payment info : " + UUID.randomUUID().toString() + ", port" + port;
    }
}
