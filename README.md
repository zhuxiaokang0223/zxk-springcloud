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

### zuul
zuul网关

### gateway
spring-cloud-gateway网关

### security 
访问权限控制。

已实现功能点：
- access_token保存到redis
- OAuth2 客户端模式、密码模式
- 参与校验的用户信息可从数据库获取

##### security-db
使用数据库保存权限

### zuul-auth
zuul网关整合OAuth2

已实现功能点：
- access_token保存到redis
- OAuth2 客户端模式、密码模式
- 参与校验的用户信息可从数据库获取