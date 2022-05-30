package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.Notice;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.mapper.NoticeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity addNotice(@RequestParam Notice notice) {
        try {
            notice.setUptime(LocalDate.now());
            int insert = noticeMapper.insert(notice);
            if (insert == 0) {
                return RespondResult.error("失败", 400);
            }
            return RespondResult.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNotice(@PathVariable("id") Integer id) {
        try {
            int delete = noticeMapper.deleteById(id);
            if (delete == 0) {
                return RespondResult.error("失败", 400);
            }
            return RespondResult.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    @GetMapping("/getbytype/{type}")
    public ResponseEntity getBytype(@PathVariable("type") Integer type,
                                    @RequestParam int pageNum,
                                    @RequestParam int pageSize) {
        try {
            if (type == 1 || type == 2 || type == 3) {
                PageHelper.startPage(pageNum, pageSize);
                List<Notice> notices = noticeMapper.selectList(new QueryWrapper<Notice>().eq("type", type));
                return RespondResult.success(new PageInfo<>(notices));
            }
            return RespondResult.error("参数错误", 400);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

}
