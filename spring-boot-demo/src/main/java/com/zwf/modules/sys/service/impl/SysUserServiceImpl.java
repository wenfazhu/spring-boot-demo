
 package com.zwf.modules.sys.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwf.modules.sys.dao.SysUserDao;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;

@Service("sysUserService")
 public class SysUserServiceImpl implements SysUserService {

	 
	 @Resource
	 private SysUserDao sysUserDao;
	 
	 
	@Override
	public void save(SysUserEntity user) {
		// TODO Auto-generated method stub
		sysUserDao.save(user);		
	}

	@Override
	public void deleteById(Long userId) {
		// TODO Auto-generated method stub
		sysUserDao.deleteById(userId);
		
	}

	@Override
	public void updateById(SysUserEntity user) {
		// TODO Auto-generated method stub
		sysUserDao.updateById(user);
		
	}

	@Override
	public List<SysUserEntity> selectList(SysUserEntity user) {
		// TODO Auto-generated method stub
		List<SysUserEntity> list = sysUserDao.selectList(user);
		return list;
	}


		
 }
