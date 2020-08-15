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

# 网关
#### gateway
> Zuul因为1过时，2还处于半成品，所以这里直接学习Gateway了！
- 9527 gateway

# 配置中心
#### spring-cloud-config
略

# 消息总线
#### bus
略

# 流
#### stream
是什么？
答：作为一种项目和中间件的一种解耦工具，将项目代码和消息队列解耦，不用关注使用的是哪一种消息队列。
实操：（这里我用的是RabbitMQ）
- 8801 消息队列的生产者
- 8802 消息队列消费者1号
- 8803 消息队列消费者2号
> 默认情况下，监听rabbitmq消息队列的同一exchange的两个消费者属于两个不同的group，所以会出现重复消费问题，只要将8002和8003所在group设置成同一个即可！

# alibaba
## nacos
- 9001 服务注册 生产者1
- 9011 服务注册 生产者2，作为9001的复制版本(第一次使用这种方式，直接赋值9001然后该端口号即可，不必新创建模块)
- 9002 服务注册 消费者
- 9002 配置中心

##笔记：
> 总结需要重启才能生效的改动
> 
> - 添加注解，或修改注解属性的值
> - 修改application.yaml文件中的值
> - 添加类，因为新添加的类没有被监控

