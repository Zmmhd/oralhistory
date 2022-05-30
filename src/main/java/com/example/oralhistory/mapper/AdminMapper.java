package com.example.oralhistory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oralhistory.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
