package cn.jxufe.cloudproviderpayment8001.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cn.jxufe.cloudproviderpayment8001.service.PaymentService;
import cn.jxufe.dto.NormalResult;
import cn.jxufe.dto.myenum.HttpCodeEnum;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/21 11:45
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    Logger log = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;
    private final DiscoveryClient discoveryClient;

    @Value(value = "${server.port}")
    private Integer port;

    @Autowired
    public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/{id}")
    public NormalResult<?> getPayment(@PathVariable("id") Integer id) {
        return new NormalResult<>(HttpCodeEnum.OK_CODE.getCode(), String.valueOf(port), paymentService.selectPaymentById(id));
    }

    @PostMapping
    public NormalResult<?> createPayment(@RequestBody Payment payment) {
        paymentService.InsertPayment(payment);
        return new NormalResult<>(HttpCodeEnum.OK_CODE.getCode(), String.valueOf(port), payment);
    }

    /**
     * 获取注册中心已经注册的实例。
     * @return 名为discoveryClients的数组。
     */
    @GetMapping(value = "/discovery")
    public DiscoveryClient paymentInfo() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***element : " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 模拟超时
     * @return 返回端口号
     */
    @GetMapping(value = "/feign/timeout")
    public String getTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(port);
    }

}
