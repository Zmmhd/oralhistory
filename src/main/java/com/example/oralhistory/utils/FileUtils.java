package com.example.oralhistory.utils;

import com.example.oralhistory.entity.RespondResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * 帮助处理文件
 * 以及文件路径
 *
 * @Author: 朱明名
 * @Date: 2022/05/05/16:01
 * @Description:
 */
public class FileUtils {

    /**
     * 保存文件
     * @param path 保存文件的路径
     * @param file 文件
     * @return 返回新的文件名
     * @throws Exception 保存文件时产生的异常
     */
    public static String saveFile(String path, MultipartFile file) throws Exception {
        File folder = new File(path);

        //重命名上传的文件,为避免重复,我们使用UUID对文件分别进行命名,getOriginalFilename()获取文件名带后缀
        String oldname = file.getOriginalFilename();

        //UUID去掉中间的"-",并将原文件后缀名加入新文件
        String newname = UUID.randomUUID().toString().replace("-", "")
                + oldname.substring(oldname.lastIndexOf("."));

        //文件保存

        file.transferTo(new File(folder, newname));

        return newname;
    }

    public static void deleteFile(String filename, String filepath)throws Exception{
        File file = new File(filepath);
        if(file.exists()){
            file.delete();
        }
    }

    public static String getType(int i){
        switch (i) {
            case 1:
                return  "article";
            case 2:
                return  "video";
            case 3:
                return  "vocal";
            default:
                return null;
        }
    }

}
