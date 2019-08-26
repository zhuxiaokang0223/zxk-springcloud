package com.zxk.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/8/26 16:28
 * @Version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication{

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
