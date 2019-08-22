package com.zxk.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/8/22 9:16
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationGateway {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationGateway.class, args);
    }
}
