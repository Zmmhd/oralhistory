package com.example.oralhistory.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;



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