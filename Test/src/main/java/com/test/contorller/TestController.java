package com.test.contorller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.pojo.SysUser;
import com.test.service.UserService;

import io.swagger.annotations.Info;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 根据id 查询
	 * @param id
	 * @return
	 */
	@GetMapping("/getById/{id}")
	public Object test(@PathVariable("id")String id) {
		
		SysUser user=	userService.getById(id);
		
		if(user==null) {
			return "找不到";
		}
		log.info("查找得到的用户："+user);
		
		return user;
	}
	
	/**
	 * 查询list 没有条件
	 * @return
	 */
	@GetMapping("/list")
	public List<SysUser> getList(){
		
		return userService.list();
	}
	
	@GetMapping("/listPage")
	public IPage<SysUser> getListByPage(){
		
		IPage<SysUser> page=new Page<>();
		page.setCurrent(2);//当前第几页
		page.setSize(2);//每页条数
		page=userService.page(page);
		
		return page;
	}
	
	/**
	 * 普通查询
	 * @return
	 */
	@GetMapping("/getListMap")
	public Collection<SysUser> getListMap(){
		
		Map<String, Object> map=new HashMap<>();
		map.put("email", "123456@qq.com");
//		map.put("email", "12345");
		//key  是字段名， value  是值
		return	userService.listByMap(map);
		
	}
	
	
	@GetMapping("/saveInfo")
	public Object saveInfo() {
		
		SysUser u=new SysUser();
		
		u.setFirstName("wanger");
		u.setName("sss");
		u.setEmail("XX12");
//		u.setPassword("CC222");
		u.setId("5c89cb0399ba9a0c84752e5526ff9ebe");
//		userService.save(u);//只保存
//		userService.saveOrUpdate(u);//不指定主键时 插入
		//根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
		userService.updateById(u);//更新不为空的字段
		
		return "";
	}
	
	//删除
	@GetMapping("/delete")
	public Object delete() {
		
		userService.removeById("5c89cb0399ba9a0c84752e5526ff9ebe");
		
		return "ok";
		
	}
	
	//复杂查询
	@GetMapping("/getInfoListPlus")
	public Object getInfoListPage() {
		
		Map<String, Object> result=new HashMap<>();
		
		QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
		
		queryWrapper.lambda().eq(SysUser::getEmail, "123456@qq.com")
		.or()
		.like(SysUser::getEmail, "12345");
		;
		
	List<SysUser> list1=	userService.list(queryWrapper);
		
	result.put("list1", list1);
		return result;
	}
	
	
	@GetMapping("/selSql")
	public Object selSql() {
	
		log.info("查到的数据："+userService.get("1"));
		return "ok";
		
	}
	
	
	
	
	

}
