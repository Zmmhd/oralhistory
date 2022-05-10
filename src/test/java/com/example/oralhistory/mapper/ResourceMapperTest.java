package com.example.oralhistory.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceMapperTest {

    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 测试queryWrapper的eq输入空串会出现什么情况
     */
    @Test
    void testqueryWrapper(){
        List<Resource> province = resourceMapper.selectList(new QueryWrapper<Resource>().eq("province", "安徽"));
        System.out.println(province);
    }

    @Test
    void testDistinct(){
        List<Resource> resources = resourceMapper.selectList(new QueryWrapper<Resource>().select("Distinct theme"));
        List<String> province = new ArrayList<>();
        for (Resource resource : resources) {
            province.add(resource.getProvince());
        }
        province.forEach(System.out::println);
    }
}