package com.zxk.springcloud.geteway;

import com.zxk.springcloud.geteway.filter.CustomerZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 网关
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/21 11:11
 * @Version: 1.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApplicationZuul {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuul.class, args);
    }

}
