package com.example.oralhistory.controller;

import com.example.oralhistory.entity.Resource;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ResourceControllerTest {

    @Autowired
    private ResourceController resourceController;

    @Test
    void testQuery(){
        ResponseEntity query = resourceController.query("", 1, "", "", 1, 10);
        Object queryBody = query.getBody();
        String s = queryBody.toString();
        System.out.println(s);


    }



}