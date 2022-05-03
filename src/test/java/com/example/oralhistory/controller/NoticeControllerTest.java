package com.example.oralhistory.controller;

import com.example.oralhistory.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeControllerTest {


    @Autowired
    ResourceMapper resourceMapper;

    @Test
    void testAutowired(){
        System.out.println(resourceMapper);
    }
}