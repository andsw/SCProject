# 按端口分
# 注册中心与服务调用
## eureka
- 7001 eureka-server
- 7002 eureka-server

- 8001 eureka-client provider
- 8002 eureka-client provider
- 81   eureka-client consumer
- 86   eureka-client consumer

## zookeeper
- 8004 zookeeper-client provider
- 84 zookeeper-client consumer

## consul
- 85 consul-client consumer
- 8005 consul-client provider

# 负载均衡
- 81 ribbon修改自定义规则

# open feign
- 86 openfeign consumer(超时设置，日志级别)
