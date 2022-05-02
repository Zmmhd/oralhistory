package com.example.oralhistory.mapper;

import com.example.oralhistory.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zmm
 * @since 2022-05-02
 */
@Mapper
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {
}
