# myproject
新增服务发现
**Spring-cloud-Eureka**
eureka集群
    eureka配置其他注册中心地址，服务提供者则配置所有集群的eureka地址逗号隔开

eureka与zookeeper区别
    C:consistency（强一致性）
    A:availability(可用性)
    P:partition tolerance（分区容错性）
区别：eureka遵守AP zookeeper遵守CP
   
若eureka与服务超过15分钟没有心跳（可能网络故障或其他）
1、eureka不会在注册表中移除故障的服务
2、在接受新服务注册时暂时不会同步到其他注册中心（eureka）
3、网络稳定后，新注册服务会及时同步到其他注册中心（eureka）


新增eureka注册中心（集群）
1、server.port配置无效：原因可能是classes下并未编译配置文件（yml/properties）

**Spring-cloud-openFeign**
feign代理的目标微服务必要条件
1、feign接口必须responesDody注解
2、feign启动类必须加componentScan注解指定扫描feign公共api目录
3、启用enableFeignClients注解指定扫描feign路径

**Spring-cloud-netflix-ribbon**
可以自定义，启用EnableRibbonClient时，自定义负载类需要目录高于启动类，否则会所有Ribbon共享一个规则。


**Spring-cloud-netflix-hystrix**
1、服务熔断：就是处理异常（缺点-方法膨胀/高耦合。在服务端）
2、服务降级：整体资源不够，先关闭某个微服务，待问题回归正常后，服务重回（在客户端）

