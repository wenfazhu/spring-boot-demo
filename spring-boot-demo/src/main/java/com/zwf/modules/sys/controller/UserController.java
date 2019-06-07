package com.zwf.modules.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;
import com.zwf.modules.sys.utils.R;


@RestController
@RequestMapping("/sys/user")
public class UserController{

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

		sysUserService.deleteById(user.getUserId());

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
	 * 查询用户
	 */
	@RequestMapping("/selectList")
	public R selectList(@RequestBody SysUserEntity user){

		List<SysUserEntity> list = sysUserService.selectList(user);

		return R.ok().put("result",list);
	}
}