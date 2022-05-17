package com.example.oralhistory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oralhistory.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {
}
