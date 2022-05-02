package com.example.oralhistory.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.entity.Review;
import com.example.oralhistory.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/review")
public class ReviewController {

    private final ReviewMapper reviewMapper;

    @PostMapping("/add")
    public ResponseEntity addReview(@RequestBody Review review) {
        try {
            int insert = reviewMapper.insert(review);
            if (insert == 0) {
                return RespondResult.error("修改失败",400);
            }
            return RespondResult.success("成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespondResult.error("失败",500);
        }
    }

    @GetMapping("/getbystatus/{status}")
    public ResponseEntity getByStatus(@PathVariable Integer status) {
        try {
            if (status == -1 || status == 0 || status == 1) {
                List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().eq("status", status));
                return RespondResult.success(reviews);
            }
            return RespondResult.error("状态位错误",400);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败",500);
        }
    }

    @GetMapping("/titlelike/{title}")
    public ResponseEntity likeTitle(@PathVariable String title) {
        try {
            List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().like("title", title));
            return RespondResult.success(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    @GetMapping("/upernumberlike/{upernumber}")
    public ResponseEntity likeUpnumber(@PathVariable String upernumber) {
        try {
            List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().like("upernumber", upernumber));
            return RespondResult.success(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Review review) {

        try {
            Review review1 = reviewMapper.selectById(id);
            if (review1 == null) {
                return RespondResult.error("没有这条公告", 400);
            }
            reviewMapper.updateById(review);
            return RespondResult.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }

    }


}
