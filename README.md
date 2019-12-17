# myproject

SpringCloud版本（Finchley.SR4） 
SpringBoot版本（2.0.X.RELEASE）
JDK版本（1.8）
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

注意：
服务注册中心需依赖spring-cloud-starter-netflix-eureka-server
服务提供者把服务注册到服务注册中心必须依赖spring-cloud-starter-netflix-eureka-client而非spring-cloud-netflix-eureka-client

**Spring-cloud-openFeign**

feign代理的目标微服务必要条件
1、feign接口必须responesDody注解
2、feign启动类必须加componentScan注解指定扫描feign公共api目录
3、启用enableFeignClients注解指定扫描feign路径
4、FeignClient指定的微服务名称为小写

**Spring-cloud-starter-netflix-ribbon**

可以自定义，启用EnableRibbonClient时，自定义负载类需要目录高于启动类，否则会所有Ribbon共享一个规则。


**Spring-cloud-starter-netflix-hystrix**

1、服务熔断：就是处理异常，避免服务超时（缺点-方法膨胀/高耦合。在服务端）
2、服务降级：整体资源不够，先关闭某个微服务，待问题回归正常后，服务重回（在客户端）

总结：服务熔断：微服务不能停止，若停止则会发生404，不发生，但该方法容易方法膨胀
      服务降级：微服务可停止，用户会收到友好提示


**Spring-cloud-netflix-hystrix-dashboard**
被hystrixDishbord监控的服务必须有如下配置，且不能在启动类之下的路径。否则无法监控某个微服务
@Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
 
集群监控依赖turbine不能与turbine.stream依赖共存
    
**spring-cloud-netflix-turbine**
turbine集群监控服务，需要注意yml/properties配置文件cluster-name-expression: "'default'"，且
fetch-registry: true以表示可在注册中心发现服务，必须如此配置。否则该turbine会一直loading状态

zuul
统一服务入口，类似

**spring-cloud-starter-gateway**
端口配置7000以下会出现服务迁移错误（原因未知）


**spring-cloud-starter-bus**
配置总线通知时需要management.endpoints.web.exposure.include=bus-refresh,否则无法刷新所有节点（post请求）
