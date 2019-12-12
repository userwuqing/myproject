# myproject
新增服务发现

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