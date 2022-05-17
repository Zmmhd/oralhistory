package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Admin;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/17/20:35
 * @Description:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String name,
                                @RequestParam String password){
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("name", name));
        if (admin == null){
            return RespondResult.error("没有该管理员",400);
        }
        if (!password.equals(admin.getPassword())){
            return  RespondResult.error("密码错误",400);
        }
        return RespondResult.success("登录成功");
    }

}
