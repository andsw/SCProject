package cn.jxufe.cloudconsumerfeignhystrix83.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hsw
 * @date 2020/7/26 21:43
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface HystrixPaymentService {

    /**
     * 正常工作
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable Integer id);

    /**
     * 有延时接口
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable Integer id);

    /**
     * 测试服务端报错的服务降级
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/exception/{id}")
    String paymentWithException(@PathVariable Integer id);

    /**
     * 测试服务端断路器短路服务方法！
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/circuit/breaker/exception/{id}")
    String paymentExceptionBreaker(@PathVariable Integer id);
}
