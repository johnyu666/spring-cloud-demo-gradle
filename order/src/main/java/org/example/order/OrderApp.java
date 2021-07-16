package org.example.order;

import com.example.commons.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class,args);
    }
    @Resource
    private RestTemplate restTemplate;
    @Bean
    @LoadBalanced
    public RestTemplate createResetTemplate(){
        System.out.println("create rest template");
        return new RestTemplate();
    }
    @RequestMapping("/payemnts")
    public Payment loadPayemnt(){
        String url="http://PAYMENT/test1";
        Payment payment = restTemplate.getForObject(url, Payment.class);
        return payment;
    }
}
