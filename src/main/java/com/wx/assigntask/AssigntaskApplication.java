package com.wx.assigntask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
//@MapperScan("com.wx.assigntask.dao")//与dao层的@Mapper二选一写上即可（主要作用是扫包）
public class AssigntaskApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(AssigntaskApplication.class);
    }


    public static void main(String[] args) {

        SpringApplication.run(AssigntaskApplication.class, args);
    }
}
