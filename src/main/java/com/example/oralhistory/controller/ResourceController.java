package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.mapper.ResourceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
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
     *
     * @return 返回全部资源
     */
    @GetMapping("/get")
    public ResponseEntity getAll(@RequestParam int pageNum,
                                 @RequestParam int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Resource> resources = resourceMapper.selectList(new QueryWrapper<Resource>().eq("status", 1));
            return RespondResult.success(new PageInfo<>(resources));
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 400);
        }
    }

    /**
     * 按关键字检索标题
     *
     * @return 响应
     */
    @GetMapping("/query")
    public ResponseEntity query(@RequestParam String title,
                                @RequestParam Integer type,
                                @RequestParam String province,
                                @RequestParam String theme,
                                @RequestParam int pageNum,
                                @RequestParam int pageSize) {
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
            queryWrapper.eq("status", 1);

            PageHelper.startPage(pageNum, pageSize);
            List<Resource> resources = resourceMapper.selectList(queryWrapper);
            return RespondResult.success(new PageInfo<>(resources));
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }

    }

    /**
     * 用于获取分类项
     * 如省份有哪些，主题有哪些
     *
     * @param target 指定分类名，province或theme
     * @return 返回字符串列表
     */
    @GetMapping("/getClassification/{target}")
    public ResponseEntity getClassification(@PathVariable String target) {
        try {
            if (!"province".equals(target) && !"theme".equals(target)) {
                return RespondResult.error("指定分类名错误", 400);
            }
            List<Resource> resources = resourceMapper.selectList(new QueryWrapper<Resource>().select("Distinct " + target));
            List<String> targets = new ArrayList<>();
            for (Resource resource : resources) {
                targets.add("province".equals(target)?resource.getProvince():resource.getTheme());
            }
            return RespondResult.success(target);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }
}
