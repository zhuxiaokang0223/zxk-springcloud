package com.zxk.springcloud.eureka.client.oms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 14:06
 * @Version: 1.0
 */
 @RestController
 @RequestMapping("/user/")
public class UserController {

  @GetMapping("getUserNameByMobile")
  public String getUserNameByMobile(String mobile) {
     System.err.println("mobile="+mobile);
     String userName = "张三";
     return userName;
  }
}
