package cn.jxufe.cloudsentinelservice8401.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hsw
 * @date 2020/8/15 21:40
 */
@RestController
public class FlowLimitController {
    @GetMapping(value = "/test/A")
    public String testA() {
        return "test A";
    }

    @GetMapping(value = "/test/B")
    public String testB() {
        return "test B";
    }
}
