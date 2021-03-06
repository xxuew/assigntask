package com.nju.assigntask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理

public class   AssigntaskApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(AssigntaskApplication.class, args);
    }
}
