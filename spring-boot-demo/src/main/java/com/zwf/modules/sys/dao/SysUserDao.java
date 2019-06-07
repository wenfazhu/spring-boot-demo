package com.zwf.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zwf.modules.sys.entity.SysUserEntity;

@Mapper
public interface SysUserDao  {

	public void save(SysUserEntity user);

	public void deleteById(Long userId);

	public void updateById(SysUserEntity user);

	public List<SysUserEntity> selectList(SysUserEntity user);

}
