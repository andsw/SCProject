package cn.jxufe.cloudnacosorder9002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudnacosorder9002.service.OrderService;

/**
 * @author hsw
 * @date 2020/8/15 11:18
 */
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/nacos/{id}")
    private String getOrder(@PathVariable Integer id) {
        return orderService.getPayment(id);
    }
}
