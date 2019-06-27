package com.zxk.springcloud.eureka.client.oms;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 *     @EnableFeignClients  使用Feign调用其他服务
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 14:49
 * @Version: 1.0
 */
//@SpringCloudApplication  此注解，包含 @SpringBootApplication @EnableDiscoveryClient @EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class ApplicationEurekaOmsClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaOmsClient.class, args);
    }

}
