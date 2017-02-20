package com.xsoft.sys.sys.entity;

import java.util.Date;

import com.xsoft.base.annotation.Key;

public class UserPicPath {

	@Key
	private String pic_id;
	
	private String pic_ip;
	
	private String pic_path;
	
	private String course_id;
	
	private Date add_time;
	
	public String getPic_id() {
		return pic_id;
	}
	public String getPic_ip() {
		return  pic_ip;
	}
	public String getPic_path() {
		return  pic_path;
	}
	public String getCourse_id() {
		return  course_id;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setPic_id(String pic_id) {
		this.pic_id = pic_id;
	}
	public void setPic_ip(String pic_ip) {
		this.pic_ip =pic_ip;
	}
	public void setPic_path(String pic_path) {
		this.pic_path =pic_path;
	}
	public void setCourse_id(String course_id) {
		this.course_id =course_id;
	}
	
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

}
