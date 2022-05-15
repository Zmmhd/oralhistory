package com.example.oralhistory.controller;

import com.example.oralhistory.entity.Resource;
import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.entity.Review;
import com.example.oralhistory.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

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
     * 通过状态查询审核
     *
     * @param status   状态
     * @param pageNum  第几页
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
     *
     * @param upernumber 手机号
     * @param pageNum    第几页
     * @param pageSize   页面大小
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
     *
     * @param id     审核的id
     * @param status 审核建议 1为通过；-1为不通过
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestParam int status,
                                 HttpServletRequest request) {
        if (status == 1) {
            return reviewService.passReview(id);
        } else if (status == -1) {
            return reviewService.failReview(id, request);
        }
        return RespondResult.error("失败", 400);

    }

    /**
     * 新建一个审核和资源
     * 注意传过来的两个实体要满足下列条件
     *
     * @param resource 不需要字段id、status、uptime
     * @return
     */
    @RequestMapping("/addreview")
    public ResponseEntity addreview(@RequestBody Resource resource) {
        resource.setStatus(0);
        resource.setUptime(LocalDate.now());
        return reviewService.addreview(resource);
    }
}
