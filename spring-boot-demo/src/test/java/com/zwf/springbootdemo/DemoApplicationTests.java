package com.zwf.springbootdemo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	private SysUserService sysUserService;
	
	@Test
	public void contextLoads() {
	}
	
	

	@Test
	public void insert() {
		SysUserEntity user = new SysUserEntity();
		user.setUsername("zzz");
		user.setPassword("zzz");
		sysUserService.save(user);
		
	}
	
	
	@Test
	public void update() {
		SysUserEntity user = new SysUserEntity();
		user.setUserId(1136254582992023556L);
		user.setUsername("zzz");
		user.setPassword("zzz");
		sysUserService.updateById(user);
		
	}
	

	@Test
	public void select() {
		List<SysUserEntity> list = sysUserService.selectList(null);
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void delete() {
		SysUserEntity user = new SysUserEntity();
		user.setUserId(1136254582992023556L);
		sysUserService.deleteById(user.getUserId());
		
	}
	

	

}
