package com.example.oralhistory.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootTest
class ResourceControllerTest {

    @Autowired
    private ResourceController resourceController;

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    void testQuery(){
        ResponseEntity query = resourceController.query("", 1, "", "", 1, 10);
        Object queryBody = query.getBody();
        String s = queryBody.toString();
        System.out.println(s);


    }

    @Test
    void testSelectObjs(){

    }

}