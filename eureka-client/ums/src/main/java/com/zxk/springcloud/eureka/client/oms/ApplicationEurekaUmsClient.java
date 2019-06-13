package com.zxk.springcloud.eureka.client.oms;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @Description:
 *      @EnableEurekaClient 使用eureka时，使用此注解
 *      @EnableDiscoveryClient  所有spring cloud支持的服务发现都可以使用此注解
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 11:40
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationEurekaUmsClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaUmsClient.class, args);
    }

}
