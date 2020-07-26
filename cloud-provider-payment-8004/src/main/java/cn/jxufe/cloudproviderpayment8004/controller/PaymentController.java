package cn.jxufe.cloudproviderpayment8004.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jxufe.cloudproviderpayment8004.service.PaymentService;
import cn.jxufe.dto.NormalResult;
import cn.jxufe.dto.myenum.HttpCodeEnum;
import cn.jxufe.entity.Payment;

/**
 * @author hsw
 * @date 2020/3/24 14:09
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Value(value = "${server.port}")
    private Integer port;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public NormalResult<?> getPayment(@PathVariable("id") Integer id) {
        return new NormalResult<Payment>(HttpCodeEnum.OK_CODE.getCode(), String.valueOf(port), paymentService.selectPaymentById(id));
    }

    @PostMapping
    public NormalResult<?> createPayment(@RequestBody Payment payment) {
        paymentService.InsertPayment(payment);
        return new NormalResult<Payment>(HttpCodeEnum.OK_CODE.getCode(), String.valueOf(port), payment);
    }
}
