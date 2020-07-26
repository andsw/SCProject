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
- 8003 hystrix consumer 注册7001的eureka
- 83 hystrix openfeign consumer 注册7001的eureka

