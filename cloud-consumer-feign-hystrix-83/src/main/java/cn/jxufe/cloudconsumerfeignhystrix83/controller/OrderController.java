package cn.jxufe.cloudconsumerfeignhystrix83.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudconsumerfeignhystrix83.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;

/**
 * DefaultProperties使用的方法必须无参！
 * @author hsw
 * @date 2020/7/26 21:43
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallbackHandler")
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

    @GetMapping(value = "/hystrix/exception/{id}")
    public String getOrderException(@PathVariable Integer id) {
        final String result = hystrixPaymentService.paymentWithException(id);
        log.info("port : " + port + " result : " + result + " payment throws exception!");
        return result;
    }


    /**
     * 客户端请求超时降级示例方法，超过一秒即调用本地方法获取结果！
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/client/timeout/{id}")
    @HystrixCommand(fallbackMethod = "clientMethodTimeoutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String getOrderClientTimeout(@PathVariable Integer id) {
        final String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info("port : " + port + " result : " + result + " payment timeout! in client method!");
        return result;
    }

    /**
     * 为了不写多余代码，也用这个方法作为默认fallback函数！
     * @param id
     * @return
     */
    public String clientMethodTimeoutHandler(Integer id) {
        return "timeout in client method ! with id = " + id;
    }

    /**
     * 定义出来作为使用default fallback method 的示例接口！
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/default/fallback/timeout/{id}")
    @HystrixCommand
    public String getOrderClientTimeoutWithDefaultHandler(@PathVariable Integer id) {
        final String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info("result of method used default fallback method : " + result);
        return "";
    }

    /**
     * 作为默认fallback方法，必须无参！！！
     * @return
     */
    public String defaultFallbackHandler() {
        return "【defaultFallbackHandler】feign获取信息发生错误";
    }

}
