package com.xsoft.sys.sys.biz;

import com.xsoft.base.biz.BaseBiz;
import com.xsoft.sys.sys.entity.SysRoleMenu;

/**
 * 角色菜单biz
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
public interface SysRoleMenuBiz extends BaseBiz<SysRoleMenu> {

	/**
	 * 角色菜单设置
	 */
	void updateRoleMenu(int roleId, String menus);

}
