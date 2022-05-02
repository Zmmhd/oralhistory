package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Zmm
 * @since 2022-05-02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceMapper resourceMapper;

    /**
     * 获得全部资源列表
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity getAll(){
        try {
            List<Resource> resources = resourceMapper.selectList(new QueryWrapper<Resource>().eq("status",1));
            return RespondResult.success(resources);
        }catch (Exception e){
            e.printStackTrace();
            return RespondResult.error("失败",400);
        }
    }

    /**
     * 按关键字检索标题
     * @return
     */
    @GetMapping("/query")
    public  ResponseEntity query(@RequestParam String title,
                                 @RequestParam Integer type,
                                 @RequestParam String province,
                                 @RequestParam String theme){
        try {
            QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
            if (type == 1 || type == 2 || type == 3) {
                queryWrapper.eq("type", type);
            }
            if (!province.isEmpty()) {
                queryWrapper.eq("province", province);
            }
            if (!theme.isEmpty()) {
                queryWrapper.eq("theme", theme);
            }
            if (!title.isEmpty()) {
                queryWrapper.like("title", title);
            }
            queryWrapper.eq("status",1);
            List<Resource> resources = resourceMapper.selectList(queryWrapper);
            return RespondResult.success(resources);
        }catch (Exception e){
            e.printStackTrace();
            return RespondResult.error("失败",500);
        }

    }
}
