package com.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.pojo.SysUser;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	public SysUser get(@Param("id")String id);

}
