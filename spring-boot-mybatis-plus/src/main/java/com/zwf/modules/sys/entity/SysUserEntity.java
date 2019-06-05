package com.zwf.modules.sys.entity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;



	/**
	 * 创建者ID
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createUser;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 更新者ID
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Long updateUser;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;




}
