package com.lgl.practice.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 15911
 * @Date 2023/4/17 21:23
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.lgl.practice.payment.dao")
public class PaymentServiceMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceMain6001.class);
    }
}
