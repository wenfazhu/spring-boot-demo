package com.zwf.springbootmybatisplus;



import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zwf.modules.sys.dao.SysUserDao;
import com.zwf.modules.sys.entity.SysUserEntity;

/**
 * 这里边是MP一些复杂点方法的测试方法
 * @author zwf
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexTests {


	@Resource
	private SysUserDao sysUserDao;


	@Test
	public void contextLoads() {
	}


	/**
	 * 使用UpdateWrapper更新，操作的wrapper对象中的key为表中字段，value为该条数据的值，而不是实体类的属性
	 * UPDATE sys_user SET username='first_update', password='222222_update',email = '123@gmail.com' WHERE username = 'first' AND password = '222222'
	 */
	@Test
	public void updateByWrapper1() {

		//set
		SysUserEntity user = new SysUserEntity();
		user.setUsername("first_update");
		user.setPassword("222222_update");
		user.setEmail("123@gmail.com");

		//where
		UpdateWrapper<SysUserEntity> userWrapper = Wrappers.update();
		userWrapper.eq("username", "first").eq("password", 222222);

		/**
		 * update时需要传入两个参数
		 * @param entity        实体对象 (也就是set 条件值,可以为 null)
		 * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
		 *  */
		int rows = sysUserDao.update(user, userWrapper);
		System.out.println("影响记录数：" + rows);
	}


	/**
	 *   构造器参数和实体对象参数都出现时拼接where条件
	 * UPDATE sys_user SET password='1111'
	 * WHERE username='first_second' AND password = '22222' AND email = '123@gmail.com'
	 */
	@Test
	public void updateByWrapper2() {

		//set
		SysUserEntity user = new SysUserEntity();
		user.setPassword("1111");
		//where
		SysUserEntity userWhere = new SysUserEntity();
		userWhere.setUsername("first_second");
		//and
		UpdateWrapper<SysUserEntity> userWrapper = Wrappers.update(userWhere);
		userWrapper.eq("password", "222222_update").eq("email", "123@gmail.com");

		int rows = sysUserDao.update(user, userWrapper);
		System.out.println("影响记录数：" + rows);
	}

	/**
	 * 来一个一气呵成的lambda
	 * UPDATE sys_user SET password='222222_update_222' WHERE username = 'first_update' AND password = '222222_update'
	 */
	@Test
	public void updateByWrapperLambda() {
		LambdaUpdateWrapper<SysUserEntity> lambdaUpdate = Wrappers.lambdaUpdate();
		lambdaUpdate.eq(SysUserEntity::getUsername, "first_update").eq(SysUserEntity::getPassword, "222222_update").set(SysUserEntity::getPassword, "222222_update_222");

		int rows = sysUserDao.update(null, lambdaUpdate);
		System.out.println("影响记录数：" + rows);
	}
	
	/**
	 * where 条件 or 的使用
	 * DELETE FROM sys_user WHERE username = 'zzz' OR password > 'zzz'
	 */
	@Test
	public void deleteByWrapper() {
		LambdaQueryWrapper<SysUserEntity> lambdaQuery = Wrappers.lambdaQuery();
		lambdaQuery.eq(SysUserEntity::getUsername, "zzz").or().gt(SysUserEntity::getPassword, "zzz");
		int rows = sysUserDao.delete(lambdaQuery);
		System.out.println("删除条数：" + rows);
	}
	
    /**
     * order by 排序 升序(orderByAsc),降序(orderByDesc)
     * likeRight 通配符在后边 eg:'zz%'
     */
    @Test
    public void selectByWarpper() {
        // 条件构造器
        QueryWrapper<SysUserEntity> userQuery = Wrappers.query();
        userQuery.likeRight("username", "zz").or().ge("password", "zz").orderByDesc("id");

        List<SysUserEntity> userList = sysUserDao.selectList(userQuery);
        userList.forEach(System.out::println);
    }




}
