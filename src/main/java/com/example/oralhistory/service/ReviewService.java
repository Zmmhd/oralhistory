package com.example.oralhistory.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.entity.Review;
import com.example.oralhistory.mapper.ResourceMapper;
import com.example.oralhistory.mapper.ReviewMapper;
import com.example.oralhistory.utils.FileUtils;
import com.example.oralhistory.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 通过审核，修改为审核通过状态
     * @param id 审核id号
     * @return 响应
     */
    @Transactional
    public ResponseEntity passReview(Integer id) {
        Review review = reviewMapper.selectById(id);
        if (review == null) {
            return RespondResult.error("没有这条记录", 400);
        }
        // 修改review表中status
        reviewMapper.update(new Review(), new UpdateWrapper<Review>().eq("id", id).set("status", 1));
        // 修改resource表中数据
        resourceMapper.update(new Resource(), new UpdateWrapper<Resource>().eq("id", review.getResourceid()).set("status", 1));
        return RespondResult.success("成功");
    }

    /**
     * 没通过的审核
     *
     * @param id 审核id
     * @return 响应
     */
    @Transactional
    public ResponseEntity failReview(Integer id, HttpServletRequest request) {
        Review review = reviewMapper.selectById(id);
        if (review == null) {
            return RespondResult.error("没有这条记录", 400);
        }
        // 修改review表中status
        reviewMapper.update(new Review(), new UpdateWrapper<Review>().eq("id", id).set("status", -1));

        // 删除url对应的文件
        Resource resource = resourceMapper.selectById(review.getResourceid());
        try {
            String path = request.getSession().getServletContext().getRealPath("/uploadFile/") + FileUtils.getType(resource.getType());
            FileUtils.deleteFile(resource.getUrl(), path);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("删除文件失败", 400);
        }
        // 删除当前resource
        resourceMapper.deleteById(review.getResourceid());

        return RespondResult.success("成功");
    }

    /**
     * @param file
     * @param review
     * @param resource
     * @return
     */
    @Transactional
    public ResponseEntity uploadFile(MultipartFile file, Review review,
                                     Resource resource,
                                     HttpServletRequest request) {

        //设置文件上传保存文件路径：保存在项目运行目录下的uploadFile文件夹
        String savepath = request.getSession().getServletContext().getRealPath("/uploadFile/") + FileUtils.getType(resource.getType());
        String newname = null;
        try {
            newname = FileUtils.saveFile(savepath, file);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 400);
        }

        // 修改resource的url并且插入数据库中
        resource.setUrl(newname);
        resourceMapper.insert(resource);

        // 获得resource的id
        review.setResourceid(resourceMapper.selectOne(new QueryWrapper<Resource>().eq("url", resource.getUrl())).getId());

        //插入review
        reviewMapper.insert(review);
        return RespondResult.success("成功");
    }

}