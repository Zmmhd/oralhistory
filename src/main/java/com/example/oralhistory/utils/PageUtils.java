package com.example.oralhistory.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/03/20:23
 * @Description:
 */
public class PageUtils<T> {
    public static <T> PageInfo<T> pageInfo(List<T> list,int pageNum,int pageSize){
        PageInfo<T> tPageInfo = new PageInfo<>(list);
        tPageInfo.setPageNum(pageNum);
        tPageInfo.setPageSize(pageSize);
        return tPageInfo;
    }

}
