package com.xsoft.sys.sys.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.sys.sys.biz.SysRoleMenuBiz;

/**
 * 角色菜单action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysRoleMenu")
public class SysRoleMenuAction extends BaseAction {

	@Autowired
	private SysRoleMenuBiz sysRoleMenuBiz;

	/**
	 * 角色菜单设置
	 */
	@RequestMapping(value = "/updateRoleMenu", method = RequestMethod.POST)
	public @ResponseBody Object updateRoleMenu(@RequestParam int roleId, @RequestParam String menus){
		sysRoleMenuBiz.updateRoleMenu(roleId, menus);
		return super.sendOk();
	}

}