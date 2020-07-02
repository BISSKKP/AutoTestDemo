package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.pojo.SysUser;


public interface UserService  extends IService<SysUser>{

	public SysUser get(String id);
}
