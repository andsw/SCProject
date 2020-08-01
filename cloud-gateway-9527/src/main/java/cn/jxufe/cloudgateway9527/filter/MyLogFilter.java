package cn.jxufe.cloudgateway9527.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author hsw
 * @date 2020/8/1 22:12
 */
@Component
@Order(0)
@Slf4j
public class MyLogFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("===request comes into GlobalFilter===");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null || "".equals(username)) {
            log.info("===username is invalid, please log in!===");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}

