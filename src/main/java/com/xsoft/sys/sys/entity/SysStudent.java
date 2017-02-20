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
public class SysStudent {

	
	//a.stu_name,c.course_name,c.class_name
	
	
	// 用户id
	@Key
	private String stu_name;
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	// 角色id
	private String course_name;
	// 登陆账号
	private String class_name;
	
}