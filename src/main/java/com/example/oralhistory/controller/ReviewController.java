package com.example.oralhistory.controller;

import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.entity.Review;
import com.example.oralhistory.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zmm
 * @since 2022-05-02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * 增加一条审核,要同时增加一条resource记录
     * （后面可能还要添加一个文件流）
     * @param review 审核对象
     * @param resource 一条resource记录
     * @return 响应
     */
    @PostMapping("/add")
    public ResponseEntity addReview(@RequestParam Review review,
                                    @RequestParam Resource resource) {
        return reviewService.addReview(review,resource);
    }

    /**
     * 通过状态查询审核
     * @param status 状态
     * @param pageNum 第几页
     * @param pageSize 页面大小
     * @return 响应
     */
    @GetMapping("/getbystatus/{status}")
    public ResponseEntity getByStatus(@PathVariable Integer status,
                                      @RequestParam int pageNum,
                                      @RequestParam int pageSize) {
        return reviewService.getByStatus(status, pageNum, pageSize);
    }

    /**
     * 根据标题模糊查询
     *
     * @param title    标题
     * @param pageNum  第几页
     * @param pageSize 页面大小
     * @return 响应
     */
    @GetMapping("/titlelike/{title}")
    public ResponseEntity likeTitle(@PathVariable String title,
                                    @RequestParam int pageNum,
                                    @RequestParam int pageSize) {
        return reviewService.likeTitle(title, pageNum, pageSize);
    }

    /**
     * 根据手机号进行审核查询
     * @param upernumber 手机号
     * @param pageNum 第几页
     * @param pageSize 页面大小
     * @return 响应
     */
    @GetMapping("/upernumberlike/{upernumber}")
    public ResponseEntity likeUpnumber(@PathVariable String upernumber,
                                       @RequestParam int pageNum,
                                       @RequestParam int pageSize) {
        return reviewService.likeUpnumber(upernumber, pageNum, pageSize);
    }

    /**
     * 修改审核，即选择通过或者不通过,
     * 修改实体review的status.1为通过；-1为不通过
     * @param id 审核id
     * @param status 审核建议 1为通过；-1为不通过
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestParam int status) {
        return reviewService.update(id, status);
    }


}
