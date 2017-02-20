package com.xsoft.sys.sys.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.sys.sys.biz.SysMenuBiz;
import com.xsoft.sys.sys.entity.SysMenu;

/**
 * 系统菜单action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysMenu")
public class SysMenuAction extends BaseAction {

	@Autowired
	private SysMenuBiz sysMenuBiz;

	@RequestMapping(value = "")
	public String index() {
		return "sys/sys/sys_menu";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/saveSysMenu")
	@ResponseBody
	public Object saveSysMenu(SysMenu sysMenu) {
		sysMenuBiz.save(sysMenu);
		return sendOk();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateSysMenu")
	@ResponseBody
	public Object updateSysMenu(SysMenu sysMenu) {
		sysMenuBiz.update(sysMenu);
		return sendOk();
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 *            id字符串多个使用,分隔
	 */
	@RequestMapping(value = "/deleteSysMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteSysMenu(String ids) {
		sysMenuBiz.delete(ids.split(","));
		return sendOk();
	}

	/**
	 * 分页查询
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return 返回查询结果json
	 */
	@RequestMapping(value = "/findSysMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysMenu(int page, int rows, Map<String, Object> params) {
		return sysMenuBiz.queryPage(page, rows, params);
	}

	/**
	 * 查询菜单树
	 * @return 返回查询结果json
	 */
	@RequestMapping(value = "/findAllMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object findAllMenu(HttpServletRequest request) {
		return sysMenuBiz.findAllMenu();
	}

}