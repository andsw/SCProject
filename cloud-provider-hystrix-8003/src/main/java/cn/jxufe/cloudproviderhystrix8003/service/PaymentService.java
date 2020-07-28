package cn.jxufe.cloudproviderhystrix8003.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * @author hsw
 * @date 2020/7/26 19:27
 */
@Component
public class PaymentService {
    public String paymentOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "payment ok, id is" + id;
    }

    /**
     * 83请求处配置的open feign超时时间是4秒，这里设置5秒会超时，所以设置降级
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
        // 设置自身超时峰值，即如果调用接口超过3秒，就调用上面的paymentTimeoutHandler方法
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String paymentTimeout(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " payment timeout, id is" + id;
    }

    /**
     * 为上面方法提供的服务降级方法
     * @param id
     * @return
     */
    public String paymentTimeoutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " with id = " + id + "\n'timout'!!!";
    }

    /**
     * 这里示例当服务报错时的服务降级。
     */
    @HystrixCommand(fallbackMethod = "paymentExceptionHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String paymentWithException(Integer id) throws ArithmeticException {
        int a = 0;
        System.out.println(4 / a);
        return "线程池：" + Thread.currentThread().getName() + "payment time out, id is" + id;
    }

    public String paymentExceptionHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "with id = " + id + "\n throws 'ArithmeticException'!!!";
    }

    /**
     * HystrixProperty从上到下作用：
     *      开启断路器
     *      请求量的阈值
     *      失败率达到多少百分比熔断：表示当请求量到达上面的阈值，失败率达到多少时断路器断开
     *      熔断器断开窗口时间：表示短路器断开后多少时间才会变成半开放的状态！
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "circuitBreakerOpenOrExceptionHandler", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new InvalidParameterException();
        }
        String uid = UUID.randomUUID().toString();
        return "thread name : " + Thread.currentThread().getName() + " uid : " + uid + " id : " + id;
    }

    public String circuitBreakerOpenOrExceptionHandler(Integer id) {
        return "😔出错误了！！！ thread name：" + Thread.currentThread().getName() + " id : " + id;
    }
}
