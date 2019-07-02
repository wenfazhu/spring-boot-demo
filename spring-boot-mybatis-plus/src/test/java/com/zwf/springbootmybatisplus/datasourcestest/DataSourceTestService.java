

package com.zwf.springbootmybatisplus.datasourcestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwf.datasources.DataSourceNames;
import com.zwf.datasources.annotation.DataSource;
import com.zwf.modules.sys.entity.SysUserEntity;
import com.zwf.modules.sys.service.SysUserService;

/**
 * 测试多数据源
 */
@Service
public class DataSourceTestService {
    @Autowired
    private SysUserService sysUserService;

    
    public SysUserEntity queryUser(Long userId){
        return sysUserService.getById(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public SysUserEntity queryUser2(Long userId){
        return sysUserService.getById(userId);
    }
}
