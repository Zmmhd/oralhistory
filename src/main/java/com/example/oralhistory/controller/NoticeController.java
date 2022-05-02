package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Notice;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zmm
 * @since 2022-05-02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeMapper noticeMapper;

    @PostMapping("/add")
    public ResponseEntity addNotice(@RequestBody Notice notice){
        int insert = noticeMapper.insert(notice);
        if(insert == 0){
            return RespondResult.error("失败",400);
        }
        return  RespondResult.success("成功");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNotice(@PathVariable("id") Integer id) {
        int delete = noticeMapper.deleteById(id);
        if(delete == 0){
            return RespondResult.error("失败",400);
        }
        return RespondResult.success("成功");
    }

    @GetMapping("/getbytype/{type}")
    public ResponseEntity getBytype(@PathVariable("type") Integer type){
        if(type == 1 || type == 2|| type == 3) {
            List<Notice> notices = noticeMapper.selectList(new QueryWrapper<Notice>().eq("type",type));
            return RespondResult.success(notices);
        }
        return RespondResult.error("失败",400);
    }

}
