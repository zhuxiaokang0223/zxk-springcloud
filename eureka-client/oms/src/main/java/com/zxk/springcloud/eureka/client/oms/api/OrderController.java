package com.zxk.springcloud.eureka.client.oms.api;

import com.zxk.springcloud.eureka.client.oms.remote.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 14:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order/")
public class OrderController {

    @Resource
    private UserApi userApi;

    @GetMapping("getOrder")
    public String getOrder(String mobile) {
        System.err.println("order mobile="+mobile);
        String name = userApi.getUserNameByMobile(mobile);
        System.err.println("name="+name);
        return mobile;
    }

}
