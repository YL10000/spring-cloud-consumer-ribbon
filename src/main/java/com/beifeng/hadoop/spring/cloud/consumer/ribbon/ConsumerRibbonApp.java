package com.beifeng.hadoop.spring.cloud.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient//向服务中心注册
@EnableHystrix//启用熔断机制
@EnableHystrixDashboard //启用熔断器监控页面
public class ConsumerRibbonApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApp.class, args);
    }
    
    @Bean
    @LoadBalanced//使用这个restTemplate开启负载均衡
    RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
    
    //100%的来采集日志，和在配置文件中配置spring.sleuth.sampler.percentage=1是一样的
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
    
}
