package cn.jxufe.cloudconsumerorder81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import cn.jxufe.cloudconsumerorder81.lb.LoaderBalance;
import cn.jxufe.dto.NormalResult;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/22 16:38
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final RestTemplate restTemplate;

    private final LoaderBalance loaderBalance;

    private final DiscoveryClient discoveryClient;

//    private static final String url = "http://localhost:8001/payment/";
    private static final String url = "http://CLOUD-PROVIDER-PAYMENT/payment/";

    @Autowired
    public OrderController(RestTemplate restTemplate, LoaderBalance loaderBalance, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.loaderBalance = loaderBalance;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/{id}")
    public NormalResult<?> getOrder(@PathVariable Integer id) {
        return restTemplate.getForObject(url + id, NormalResult.class);
    }

    @PostMapping
    public NormalResult<?> addOrder(@RequestBody Payment payment) {
        return restTemplate.postForEntity(url, payment, NormalResult.class).getBody();
    }

    /**
     * 使用自定义的loaderBalance
     * @author hsw
     * @date 22:26 2020/7/11
     * @param
     * @return cn.jxufe.dto.NormalResult<?>
     **/
    @GetMapping("/mylb/{id}")
    public NormalResult<?> getOrderByDiyLoaderBalance(@PathVariable Integer id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() == 0) {
            return NormalResult.failureWithMessage("no payment server");
        }

        ServiceInstance instance = loaderBalance.instance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/" + id, NormalResult.class);
    }
}
