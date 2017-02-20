package com.xsoft.sys.sys.dao;

import java.util.List;

import com.xsoft.base.dao.BaseDao;
import com.xsoft.sys.sys.entity.SysRoleMenu;

/**
 * 角色菜单dao
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {

	/**
	 * 获取指定角色菜单id
	 * 
	 * @param roleId
	 *            角色id
	 * @return
	 */
	List<String> findRoleMenuById(int roleId);

	/**
	 * 批量添加角色菜单
	 * 
	 * @param saveList
	 *            角色菜单集合
	 */
	void saveRoleMenuList(List<SysRoleMenu> saveList);

	/**
	 * 批量删除角色菜单
	 * 
	 * @param delList
	 *            角色菜单集合
	 */
	void delRoleMenuList(List<SysRoleMenu> delList);

}
