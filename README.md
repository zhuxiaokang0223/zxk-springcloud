# zxk-springcloud
Spring Cloud 学习

> 20190611

## 模块说明

### eureka-server  
Eureka Server集群

启动方式：
- ide： Edit Configurations中Active Profiles设置待启用配置的名称。如 eserver2
- jar包启动
    ```
    java -jar xxx.jar --spring.profiles.active=eserver2
    ```

### eureka-client
Eureka Client 客户端

##### ums
使用ribbon

##### oms
使用Feign