package com.example.oralhistory.mapper;

import com.example.oralhistory.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
public interface ReviewMapper extends BaseMapper<Review> {
}
