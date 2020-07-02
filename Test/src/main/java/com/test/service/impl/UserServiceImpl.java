package com.test.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.dao.SysUserMapper;
import com.test.pojo.SysUser;
import com.test.service.UserService;

@Service
public class UserServiceImpl  extends ServiceImpl<SysUserMapper, SysUser> implements UserService{

	@Override
	public SysUser get(String id) {
		
		
		return baseMapper.get(id);
	}
	
	
	
	
}