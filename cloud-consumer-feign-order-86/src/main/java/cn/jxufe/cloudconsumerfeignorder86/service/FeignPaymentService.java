package cn.jxufe.cloudconsumerfeignorder86.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.jxufe.dto.NormalResult;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/4/26 10:35
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-PAYMENT")
public interface FeignPaymentService {
    @GetMapping(value = "/payment/{id}")
    NormalResult<Payment> getPaymentById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/feign/timeout")
    String getTimeout();
}
