package com.example.oralhistory.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.entity.Review;
import com.example.oralhistory.mapper.ResourceMapper;
import com.example.oralhistory.mapper.ReviewMapper;
import com.example.oralhistory.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/04/11:25
 * @Description:
 */
@Service
public class ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 增加一个审核
     *
     * @param review
     * @return
     */
    @Transactional
    public ResponseEntity addReview(Review review, Resource resource) {
        review.setStatus(0);
        resource.setStatus(0);
        reviewMapper.insert(review);
        resourceMapper.insert(resource);
        return RespondResult.success("成功");
    }

    public ResponseEntity getByStatus(Integer status, int pageNum, int pageSize) {
        try {
            if (status == -1 || status == 0 || status == 1) {
                List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().eq("status", status));
                return RespondResult.success(PageUtils.pageInfo(reviews, pageNum, pageSize));
            }
            return RespondResult.error("状态位错误", 400);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    public ResponseEntity likeTitle(String title, int pageNum, int pageSize) {
        try {
            List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().like("title", title));

            return RespondResult.success(PageUtils.pageInfo(reviews, pageNum, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    public ResponseEntity likeUpnumber(String upernumber, int pageNum, int pageSize) {
        try {
            List<Review> reviews = reviewMapper.selectList(new QueryWrapper<Review>().like("upernumber", upernumber));
            return RespondResult.success(PageUtils.pageInfo(reviews, pageNum, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 500);
        }
    }

    @Transactional
    public ResponseEntity update(Integer id, int status) {
        Review review1 = reviewMapper.selectById(id);
        if (review1 == null) {
            return RespondResult.error("没有这条记录", 400);
        }
        // 修改review表中status
        reviewMapper.update(new Review(), new UpdateWrapper<Review>().eq("id", id).set("status", status));
        Review review = reviewMapper.selectById(id);
        // 修改resource表中数据
        resourceMapper.update(new Resource(), new UpdateWrapper<Resource>().eq("id", review.getResourceid()).set("status", status));
        return RespondResult.success("成功");
    }

}
