package com.zwf.springbootmybatisplus;



import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;
/**
 * 这里边是MP的Service层的一些常用方法测试方法
 * @author zwf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Resource
	private SysUserService sysUserService;


	@Test
	public void contextLoads() {
	}

	/**
	 * 添加单个
	 */
	@Test
	public void insert() {
		SysUserEntity user = new SysUserEntity();
		user.setUsername("zzz");
		user.setPassword("zzz");
		boolean bool = sysUserService.save(user);
		System.out.println("是否成功"+bool);
	}

	/**
	 * 添加多条
	 */
	@Test
	public void insertBatch() {
		SysUserEntity user1 = new SysUserEntity();
		user1.setUsername("first");
		user1.setPassword("11111");

		SysUserEntity user2 = new SysUserEntity();
		user2.setUsername("second");
		user2.setPassword("22222");

		List<SysUserEntity> userList = Arrays.asList(user1, user2);
		boolean bool = sysUserService.saveBatch(userList);
		System.out.println("是否成功：" + bool);
	}

	/**
	 * 判断是新增还是修改，如果表中不存在新增，如果存在则更改
	 */
	@Test
	public void insertOrUpdateBatch() {
		SysUserEntity user1 = new SysUserEntity();
		user1.setUsername("first");
		user1.setPassword("11111");

		SysUserEntity user2 = new SysUserEntity();
		user2.setUserId(1136243196035510273L);
		user2.setUsername("second");
		user2.setPassword("22222");

		List<SysUserEntity> userList = Arrays.asList(user1, user2);
		boolean bool = sysUserService.saveOrUpdateBatch(userList);
		System.out.println("是否成功：" + bool);
	}
	/**
	 * 链式操作
	 * lambdaQuery操作list
	 * lambdaUpdate操作更新(update),删除(remove)
	 * 查询用户名中有z并且密码为22222的
	 *  where username LIKE "%z%" AND password = '22222'  
	 */
	@Test
	public void selectChain() {
		List<SysUserEntity> userList = sysUserService.lambdaQuery().like(SysUserEntity::getUsername, "z").eq(SysUserEntity::getPassword, 22222).list();

		userList.forEach(System.out::println);

	}


	/**
	 * UPDATE sys_user SET password='222222' WHERE username = 'first'
	 */
	@Test
	public void updateChain() {
		boolean bool = sysUserService.lambdaUpdate().eq(SysUserEntity::getUsername, "first").set(SysUserEntity::getPassword, 222222).update();
		System.out.println("是否成功：" + bool);
	}

	/**
	 * DELETE FROM sys_user WHERE username = 'first'
	 */
	@Test
	public void removeChain() {
		boolean bool = sysUserService.lambdaUpdate().eq(SysUserEntity::getUsername, "first").remove();
		System.out.println("是否成功：" + bool);
	}




}
