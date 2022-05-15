package com.example.oralhistory.controller;

import com.example.oralhistory.entity.RespondResult;
import com.example.oralhistory.utils.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/15/11:01
 * @Description:
 */
@RestController
public class FileController {
    @RequestMapping("/uploadfile/{isarticle}")
    public ResponseEntity uploadfile(@RequestParam MultipartFile file,
                                     HttpServletRequest request) {

        //设置文件上传保存文件路径：保存在项目运行目录下的uploadFile文件夹
        String savepath = request.getSession().getServletContext().getRealPath("/uploadFile/");


        String url = null;
        try {
            url = FileUtils.saveFile(savepath, file);
        } catch (Exception e) {
            e.printStackTrace();
            return RespondResult.error("失败", 400);
        }

        return RespondResult.success(url);
    }

}
