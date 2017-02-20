package com.xsoft.sys.sys.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xsoft.base.annotation.Key;

/**
 * 系统用户
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-22
 * @version: V1.0.0
 */
public class SysUser {

	// 用户id
	@Key
	private String id;
	// 角色id
	private String roleId;
	// 登陆账号
	private String username;
	// 登陆密码
	@JsonIgnore
	private String password;
	// 姓名
	private String name;
	// 手机号
	private String phone;
	// 电子邮件
	private String email;
	// 创建时间
	private Date createTime;
	// 最后登录时间
	private Date lastTime;
	// 状态 (0禁用、1启用)
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}