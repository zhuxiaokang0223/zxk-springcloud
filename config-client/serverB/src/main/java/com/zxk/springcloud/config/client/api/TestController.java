package com.zxk.springcloud.config.client.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/8/26 17:55
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Value("${server.name}")
    private String serverName;

    @GetMapping("/h2")
    public String h2() {
        return serverName;
    }

}
