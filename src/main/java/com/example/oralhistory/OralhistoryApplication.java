package com.example.oralhistory;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(value = "com.example.oralhistory.mapper")
public class OralhistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OralhistoryApplication.class, args);
    }

}
