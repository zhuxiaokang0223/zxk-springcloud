package com.zxk.springcloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/8/26 17:53
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientServerApplication.class, args);
    }
}
