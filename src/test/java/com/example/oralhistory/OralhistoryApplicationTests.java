package com.example.oralhistory;

import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OralhistoryApplicationTests {
    @Autowired
    ResourceMapper resourceMapper;

    @Test
    void contextLoads() {
        System.out.println(resourceMapper);
    }

}
