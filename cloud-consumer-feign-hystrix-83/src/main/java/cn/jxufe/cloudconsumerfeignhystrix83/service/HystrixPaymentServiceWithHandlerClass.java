package cn.jxufe.cloudconsumerfeignhystrix83.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 实现接口进行fallback示例！
 * @author hsw
 * @date 2020/7/27 22:20
 * 千万别忘了配置：
 * feign.hystrix.enabled=true
 * 以实现实现类方法作为默认降级服务方法！
 * 还有将 下面这些属性改成这个值，实现从客户端就开始超时，而不是调用到服务端的fallback方法！（我改回之前的值了，要调试这个就改！）
 * feign:
 *   client:
 *     config:
 *       default:
 *         connectTimeout: 2000
 *         readTimeout: 2000
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = HystrixPaymentServiceHandler.class)
public interface HystrixPaymentServiceWithHandlerClass {
    /**
     * 测试实现接口来定义fallback方法
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable Integer id);
}
