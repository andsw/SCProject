package cn.jxufe.cloudproviderpayment8004.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/3/24 14:52
 */
@RestController
@Slf4j
public class ZkController {

    @Value(value = "${server.port}")
    private String port;

    @GetMapping("/payment/zk/info")
    public String paymentZk() {
        return "payment info : " + UUID.randomUUID().toString() + ", port" + port;
    }

}
