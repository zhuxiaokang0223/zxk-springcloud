package com.zxk.springcloud.security.oauth2.db.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/18 9:13
 * @Version: 1.0
 */
@RestController
public class UserController {

    @GetMapping("/product")
    public String getProduct(String id){
        return "product id = "+ id;
    }

    @GetMapping("/order1")
    public String getOrder(String id){
        return "order id = "+id;
    }


    @GetMapping("/home")
    public String home(){
        return "首页";
    }
}
