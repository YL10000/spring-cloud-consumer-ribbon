package com.beifeng.hadoop.spring.cloud.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;
    
    //需要熔断的方法
    @HystrixCommand(fallbackMethod="hiError")//熔断后执行的方法
    public String sayHi() {
        return restTemplate.getForObject("http://SERVICE-HI/info", String.class);
    }
    
    public String sayHello() {
        return restTemplate.getForObject("http://cloud-consumer-feign/hi", String.class);
    }
    
    //熔断后执行的方法
    public String hiError() {
        return "sorry hi error";
    }
}
