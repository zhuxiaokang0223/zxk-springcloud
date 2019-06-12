package com.zxk.springcloud.eureka.client.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


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
