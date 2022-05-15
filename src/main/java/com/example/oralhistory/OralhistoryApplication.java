package com.example.oralhistory;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * @Author: 朱明名
 * @Date: 2022/5/10
 * @Description: 启动类
 */
@SpringBootApplication
@MapperScan(value = "com.example.oralhistory.mapper")
public class OralhistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OralhistoryApplication.class, args);
    }

}
