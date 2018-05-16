package com.beifeng.hadoop.spring.cloud.consumer.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRibbonController {

private static Logger logger=LoggerFactory.getLogger(ConsumerRibbonApp.class);
    
    /*@Autowired
    private RestTemplate restTemplate;*/
    
    @Autowired
    private HiService hiService;
    
    
    @RequestMapping("hi")
    public String hiConsumer() {
        //使用restTemplate调用消费服务提供者的SERVICE-HI的info服务
        //String response=restTemplate.getForObject("http://SERVICE-HI/info", String.class);
        String response=hiService.sayHi()+" ribbon";
        logger.info(response);
        return response;
    }
    
    @RequestMapping("hello")
    public String helloConsumer() {
        //使用restTemplate调用消费服务提供者的SERVICE-HI的info服务
        //String response=restTemplate.getForObject("http://cloud-consumer-feign/hi", String.class);
        String response=hiService.sayHello()+" ribbon";
        logger.info(response);
        return response;
    }
}
