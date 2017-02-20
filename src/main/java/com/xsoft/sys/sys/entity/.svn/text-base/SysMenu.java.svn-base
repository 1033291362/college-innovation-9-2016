package com.xsoft.sys.sys.entity;

import com.xsoft.base.annotation.Key;
import com.xsoft.sys.sys.vo.SysMenuVo;

/**
 * 菜单实体
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-22
 * @version: V1.0.0
 */
public class SysMenu {

	// 角色id
	@Key
	private String	id;
	// 父id
	private String pid;
	// 菜单名称
	private String name;
	// 链接地址
	private String url;
	// 图片
	private String img;
	// 排序
	private Integer sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public SysMenuVo toVo() {
		SysMenuVo vo = new SysMenuVo();
		vo.setId(id);
		vo.setPid(pid);
		vo.setName(name);
		vo.setUrl(url);
		vo.setImg(img);
		vo.setSort(sort);
		return vo;
	}

}