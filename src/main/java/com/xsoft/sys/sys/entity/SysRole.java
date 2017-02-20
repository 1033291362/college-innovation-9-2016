package com.xsoft.sys.sys.entity;

import java.util.Date;

import com.xsoft.base.annotation.Key;

/**
 * 角色实体
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-22
 * @version: V1.0.0
 */
public class SysRole {

	// 角色id
	@Key
	private String id;
	// 角色名称
	private String name;
	// 角色默认主页
	private String home;
	// 备注
	private String remark;
	// 录入时间
	private Date createTime;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return this.home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}