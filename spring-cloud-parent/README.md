#### sring-cloud微服务

1、在idea中新建一个空的maven父工程，相应的配置pom文件可参考如下：
```
<groupId>com.example</groupId>
<artifactId>spring-cloud-parent</artifactId>
<packaging>pom</packaging>
<version>1.0-SNAPSHOT</version>
<modules>
    <module>eureka-server</module>
    <module>eureka-client</module>
</modules>
```
2、在父工程上新建两个springboot子工程，一个eureka的注册中心(eureka-server)，一个eureka客户端(eureka-client)，在父工程的pom文件引入相应的子项目，见上方的pom文件; 子工程新建的时候，分别选择erueka的服务端和客户端jar包，即：

eureka-server:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
eureka-clicent:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

3、将eureka-server工程的application.properties修改为application.yml，并且添加注册中心的相关配置：
```
server:
  port: 7865
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
4、在eureka-server工程的启动类，加上@EnableEurekaServer注解，声明这是eureka的注册中心；

5、将eureka-client工程的application.properties修改为application.yml，并且添加客户端微服务的相关配置：
```
server:
  port: 9090
spring:
  application:
    name: eureka-client
eureka:
  client:
    service-url:
      defaultZone: http://localhost:7865/eureka/
  instance:
    prefer-ip-address: true 
```
6、在eureka-client工程的启动类，加上@EnableEurekaClient注解，声明这是erueka的客户端（也就是将此微服务要注册到注册中心）；

7、首先启动eureka-server注册中心，启动之后，再浏览器输入locathsot:port即可看到eureka的注册中心界面，然后再启动eureka-client这个微服务，此时即可看到注册中心里已经有微服务注册进来了。
