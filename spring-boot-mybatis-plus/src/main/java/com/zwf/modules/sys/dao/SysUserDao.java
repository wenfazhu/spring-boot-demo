package com.zwf.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwf.modules.sys.entity.SysUserEntity;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	

	
}
