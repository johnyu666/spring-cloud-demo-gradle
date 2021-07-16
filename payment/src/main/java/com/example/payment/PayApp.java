package com.example.payment;

import com.example.commons.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class PayApp {
    public static void main(String[] args) {
        SpringApplication.run(PayApp.class,args);
    }
//    @LoadBalanced
//    public RestTemplate createRestTemplate(){
//        return new RestTemplate();
//    }
    @RequestMapping(value = "/test1")
    public Payment test1(){
        Payment payment=new Payment();
        payment.setId(100);
        payment.setSn("snabc");
        return payment;
    }
}
