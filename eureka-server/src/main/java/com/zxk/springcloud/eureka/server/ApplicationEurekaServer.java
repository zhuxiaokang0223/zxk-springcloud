package com.zxk.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: Eureka Server注册中心
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/11 17:23
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEurekaServer {

    public static void main(String[] args) {
       SpringApplication.run(ApplicationEurekaServer.class, args);
    }

}
