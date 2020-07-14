package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月14日 18:08
 */
@Configuration
public class RuleTest {

    @Bean
    public IRule rule() {
        //随机策略,ThreadLocalRandom.current().nextInt(serverCount);
        //通过安全的随机整数取服务lb.getReachableServers();中的下标
//        RandomRule randomRule = new RandomRule();

        //轮询策略，使用atomic的integer来统计请求次数，请求次数与锁请求的服务总数求余
        //
        RoundRobinRule randomRule = new RoundRobinRule();
        return randomRule;
    }
    //负载均衡原理

}
