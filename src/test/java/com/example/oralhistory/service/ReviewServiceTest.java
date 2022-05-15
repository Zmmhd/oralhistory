package com.example.oralhistory.service;

import com.example.oralhistory.entity.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created with IntelliJ IDEA.
 * @Author: 朱明名
 * @Date: 2022/5/15
 * @Description:
 */
@SpringBootTest
class ReviewServiceTest {

    @Autowired
    ReviewService reviewService;

    @Test
    void testAddReview(){
        Resource resource = new Resource();

        resource.setType(1);
        resource.setStatus(0);
        resource.setUrl("-----sda-");
        resource.setTitle("test");
        resource.setSynopsis("test");
        resource.setProvince("anhui");
        resource.setArchives("test");
        resource.setTheme("test");
        resource.setUptime(LocalDate.now());
        resource.setUpercity("an");
        resource.setUpername("super");
        resource.setUpernumber("123123");

        ResponseEntity addreview = reviewService.addreview(resource);
        System.out.println(addreview.toString());

    }
}