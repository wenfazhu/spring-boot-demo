package com.zwf.modules.sys.entity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@TableName("sys_user")
public class SysUserEntity {


	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;	

	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	@TableField
	private String password;

	/**
	 * 盐值
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;


	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 类型  1：系统用户   2：其他用户
	 */
	private Integer type;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;

	/**
	 * 创建者ID
	 */
	private Long createUser;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	private Date createTime;

	/**
	 * 更新者ID
	 */
	private Long updateUser;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	private Date updateTime;

	/**
	 * 部门ID
	 */
	private String deptId;



}
