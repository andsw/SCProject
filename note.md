# 注册中心与服务调用
#### Eureka
- 7001 eureka-server
- 7002 eureka-server

- 8001 eureka-client provider
- 8002 eureka-client provider
- 8003 eureka-client provider
- 81   eureka-client consumer
- 86   eureka-client consumer

#### Zookeeper
- 8004 zookeeper-client provider
- 84 zookeeper-client consumer

#### Consul
- 85 consul-client consumer
- 8005 consul-client provider

# 负载均衡
#### Ribbon
- 81 ribbon修改自定义规则

# 接口调用
#### Open feign
- 86 openfeign consumer(超时设置，日志级别)
> 使用7001、7002作为注册服务，8001、8002作为
> 接口提供方可以测试feign，另外两个模块还有提
> 供超时接口以测试feign的超时功能。

# 服务熔断和降级
#### Hystrix
- 8003 hystrix provider 注册7001的eureka
- 83 hystrix openfeign consumer 注册7001的eureka hystrix服务降级示例
超时降级、发生异常降级 服务端降级、客户端降级
> ####关于熔断
> 1. Assuming the volume across a circuit meets a certain threshold
>    (HystrixCommandProperties.circuitBreakerRequestVolumeThreshold)
> 2. And assuming that the error percentage exceeds the threshold error percentage
>    (HystrixCommandProperties.circuitBreakerErrorThresholdPercentage)
> 3. Then the circuit-breaker transitions ``CLOSED`` to ``OPEN``.
> 4. While it is open, it short-circuits all requests made against that circuit-break.
> 5. After some amount of time
>    (HystrixCommandProperties.circuitBreakerSleepWindowInMilliseconds()), the next single
>    request is let through(this is the ``HALF-OPEN`` state). If the request fails, the
>    circuit-breaker returns to the ```OPEN``` state for the duration of the sleep window.
>    if the request succeeds, the circuit-breaker transitions to ```CLOSED``` and the logic
>    in 1. takes over again.

##笔记：
> 总结需要重启才能生效的改动
> 
> - 添加注解，或修改注解属性的值
> - 修改application.yaml文件中的值
> - 添加类，因为新添加的类没有被监控

