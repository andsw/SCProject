package cn.jxufe.cloudnacosorder9002.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hsw
 * @date 2020/8/15 11:30
 */
@FeignClient(value = "nacos-payment-provider")
@Component
public interface OrderService {
    @GetMapping(value = "/payment/nacos/{id}")
    String getPayment(@PathVariable Integer id);
}
