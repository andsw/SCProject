package cn.jxufe.cloudconsumerorder84.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.jxufe.dto.NormalResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/3/24 15:17
 */
@RestController
@Slf4j
public class OrderController {
    private static final String REQUEST_URL = "http://cloud-provider-payment";

    private final RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String res = restTemplate.getForObject(REQUEST_URL + "/payment/zk/info", String.class);
        return res;
    }
}
