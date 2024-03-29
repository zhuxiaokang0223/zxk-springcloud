package com.zxk.springcloud.eureka.client.oms.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zxk.springcloud.eureka.client.oms.remote.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private UserApi userApi;



    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("getOrder")
    public String getOrder(String mobile) {
        System.err.println("order mobile="+mobile);
        log.info("oms mobile {}", mobile);
        String name = userApi.getUserNameByMobile(mobile);
        System.err.println("name="+name);
        return mobile;
    }

    @GetMapping("getOrderList")
    public String getOrderList(String mobile) {
        return "[1,2,3,4]";
    }

    /**
     * 降级
     * @param mobile
     * @return
     */
    public String fallback(String mobile){
        return "哦豁！被熔断了";
    }
}
