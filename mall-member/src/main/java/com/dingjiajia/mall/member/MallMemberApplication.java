package com.dingjiajia.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1.想要远程调用别的服务
 *   1.1.引入 open-feign
 *   1.2.编写一个接口，告诉Springcloud这个接口需要调用远程服务
 *       声明接口的每一个方法都是调用那个远程服务的那个请求
 *   1.3.开启远程调用功能
 */

@EnableFeignClients(basePackages = "com.dingjiajia.mall.member.feign")        // 开启远程调用服务
@EnableDiscoveryClient     // 开启服务的注册和发现   nacos
@SpringBootApplication
public class MallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }

}
