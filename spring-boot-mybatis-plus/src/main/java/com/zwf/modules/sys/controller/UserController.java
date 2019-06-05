package com.zwf.modules.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwf.modules.sys.dao.SysUserDao;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;
import com.zwf.modules.sys.utils.R;


@RestController
@RequestMapping("/sys/user")
public class UserController{

	@Autowired
	private SysUserDao sysUserDao; 

	@Autowired
	private SysUserService sysUserService;


	/**
	 * 保存用户
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SysUserEntity user){

		sysUserService.save(user);

		return R.ok();
	}

	/**
	 * 使用id删除用户
	 */
	@RequestMapping("/deleteById")
	public R deleteById(@RequestBody SysUserEntity user){

		sysUserService.removeById(user.getUserId());

		return R.ok();
	}

	/**
	 * 使用id更新用户
	 */
	@RequestMapping("/updateById")
	public R updateById(@RequestBody SysUserEntity user){

		sysUserService.updateById(user);

		return R.ok();
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/selectList")
	public R selectList(@RequestBody SysUserEntity user){
		Page<SysUserEntity> page = new Page<>(1, 2);

		IPage<SysUserEntity> userIPage = sysUserDao.selectPage(page, new QueryWrapper<SysUserEntity>());

		return R.ok().put("result",userIPage.getRecords());
	}
}