package com.wq.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description：
 * 这里就是开启全局过滤器
 * @author v_qqinwu
 * @date 2020年07月15日 15:22
 */
@Component
@Slf4j
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String id = exchange.getRequest().getQueryParams().getFirst("id");
        if (null == id) {
            log.error("********非法用户参数********（T_T）");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
