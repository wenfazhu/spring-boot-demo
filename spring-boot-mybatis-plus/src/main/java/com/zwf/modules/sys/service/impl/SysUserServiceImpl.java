
 package com.zwf.modules.sys.service.impl;
 

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwf.modules.sys.dao.SysUserDao;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
