package com.zwf.springbootmybatisplus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwf.modules.sys.dao.SysUserDao;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.utils.R;

/**
 * 这里边是MP的dao层的一些常用方法测试方法
 * @author zwf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

	@Resource
	private SysUserDao sysUserDao;

	@Test
	public void contextLoads() {
	}


	@Test
	public void insert() {
		SysUserEntity user = new SysUserEntity();
		user.setUsername("zzz");
		user.setPassword("zzz");
		int count = sysUserDao.insert(user);
		System.out.println("受影响的个数"+count);
		System.out.println("主键：" + user.getUserId());
	}

	@Test
	public void updatById() {
		SysUserEntity user = new SysUserEntity();
		user.setUserId(1105502516699090946L);
		user.setUsername("zwf111");
		int count = sysUserDao.updateById(user);
		System.out.println("受影响的个数"+count);
	}
	@Test
	public void userList() {
		List<SysUserEntity> list = sysUserDao.selectList(null);
		list.forEach(System.out::println);
	}
	/**
	 * 分页查询
	 */
	@Test
	public void selectPage() {
		Page<SysUserEntity> page = new Page<>(1, 2);

		IPage<SysUserEntity> userIPage = sysUserDao.selectPage(page, new QueryWrapper<SysUserEntity>());
		userIPage.getRecords().forEach(System.out::println);
	}



	@Test
	public void deleteById() {
		//删除不存在的mp的逻辑是删除成功，测试时此处的id换成你表里的id
		int count =  sysUserDao.deleteById(1105502516699090946L);
		System.out.println("受影响的个数"+count);
	}

	/**
	 * deleteByMap 物理删除。。。
	 * @param map
	 * key为表字段，value为表中的值
	 */
	@Test
	public void deleteByMap() {
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("username", "zzz");
		columnMap.put("password", "zzz");

		int rows = sysUserDao.deleteByMap(columnMap);
		System.out.println("删除条数：" + rows);
	}

	/**
	 * 批量删除
	 * @param list
	 */
	@Test
	public void deleteBatchByIds() {
		int rows = sysUserDao.deleteBatchIds(Arrays.asList(1136254114299551746L, 1136254300186931201L));
		System.out.println("删除条数：" + rows);
	}




}
