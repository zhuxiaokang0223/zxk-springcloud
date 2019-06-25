package com.zxk.springcloud.eureka.client.oms.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 14:06
 * @Version: 1.0
 */
 @RestController
 @RequestMapping("/user/")
public class UserController {

     private static final Logger log = LoggerFactory.getLogger(UserController.class);

     @Resource
     private RestTemplate restTemplate;

     @GetMapping("getUserNameByMobile")
     public String getUserNameByMobile(String mobile) {
        System.err.println("mobile="+mobile);
        log.info("ums mobile {}", mobile);
        String userName = "张三";
        return userName;
     }


     @GetMapping("getUserOrders")
     public String getUserOrders(String mobile) {
         System.err.println("oms getUserOrders mobile="+mobile);
         return restTemplate.getForObject("http://oms/order/getOrderList", String.class ,mobile);
     }

}
