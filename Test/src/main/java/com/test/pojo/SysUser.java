package com.test.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser {
	
//	   @TableId(type = IdType.AUTO)
//	    private Long id;
//	   
	@TableId(type=IdType.UUID)
	 private String id;  
	  
	
	private String name;
	
	private String firstName;
	
	private String email;
	
	private String password;
	
	private Date createDate;
	
	
	

}
