package com.zxk.springcloud.eureka.client.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 *     @EnableFeignClients  使用Feign调用其他服务
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 14:49
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationEurekaOmsClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaOmsClient.class, args);
    }

}
