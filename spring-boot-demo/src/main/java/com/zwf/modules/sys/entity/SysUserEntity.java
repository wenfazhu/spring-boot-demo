package com.zwf.modules.sys.entity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SysUserEntity {


	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;	

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
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




}
