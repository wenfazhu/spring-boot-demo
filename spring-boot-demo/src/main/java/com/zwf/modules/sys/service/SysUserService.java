
 package com.zwf.modules.sys.service;

import java.util.List;

import com.zwf.modules.sys.entity.SysUserEntity;

public interface SysUserService {

		
	 public void save(SysUserEntity user);
	 
	 public void deleteById(Long userId);
	 
	 public void updateById(SysUserEntity user);
	 
	 public List<SysUserEntity> selectList(SysUserEntity user);
	 
	 
	 
	 
 }
