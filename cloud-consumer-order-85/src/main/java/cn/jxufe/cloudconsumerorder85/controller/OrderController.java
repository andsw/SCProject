package cn.jxufe.cloudconsumerorder85.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hsw
 * @date 2020/3/24 15:58
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REQUEST_URL = "http://cloud-provider-payment";

    @GetMapping("/order/consul/info")
    public String paymentInfo() {
        return restTemplate.getForObject(REQUEST_URL + "/payment/consul/info", String.class);
    }

}
