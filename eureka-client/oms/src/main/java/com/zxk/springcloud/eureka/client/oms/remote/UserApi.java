package com.zxk.springcloud.eureka.client.oms.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 *     @FeignClient("ums") : FeignClient接口，  其中"ums"表示注册到eureka server的服务名
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/12 17:47
 * @Version: 1.0
 */
@FeignClient("ums")
@RequestMapping("/user/")
public interface UserApi {

    @GetMapping("getUserNameByMobile")
    public String getUserNameByMobile(@RequestParam("mobile") String mobile);
}
