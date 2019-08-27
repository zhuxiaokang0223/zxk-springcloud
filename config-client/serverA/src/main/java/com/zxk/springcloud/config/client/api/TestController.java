package com.zxk.springcloud.config.client.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/8/26 17:55
 * @Version: 1.0
 */
@RestController
/* 要实现刷新配置，需要配置@RefreshScope注释 */
@RefreshScope
public class TestController {

    @Value("${server.name}")
    private String serverName;

    @GetMapping("/h1")
    public String h1() {
        return serverName;
    }


}
