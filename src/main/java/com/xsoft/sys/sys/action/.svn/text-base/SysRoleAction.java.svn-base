package com.xsoft.sys.sys.action;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.base.utils.ToolsUtil;
import com.xsoft.sys.sys.biz.SysRoleBiz;
import com.xsoft.sys.sys.entity.SysRole;

/**
 * 系统角色action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysRole")
public class SysRoleAction extends BaseAction {

	@Autowired
	private SysRoleBiz sysRoleBiz;

	@RequestMapping
	public String index() {
		return "sys/sys/sys_role";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/saveSysRole")
	@ResponseBody
	public Object saveSysRole(SysRole sysRole) {
		sysRole.setId(ToolsUtil.getUUID());
		sysRole.setCreateTime(new Date());
		sysRoleBiz.save(sysRole);
		return sendOk();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateSysRole")
	@ResponseBody
	public Object updateSysRole(SysRole sysRole) {
		sysRoleBiz.update(sysRole);
		return sendOk();
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 *            id字符串多个使用,分隔
	 */
	@RequestMapping(value = "/deleteSysRole", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteSysRole(String ids) {
		sysRoleBiz.delete(ids.split(","));
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
	@RequestMapping(value = "/findSysRole", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysRole(int page, int rows, Map<String, Object> params) {
		return sysRoleBiz.queryPage(page, rows, params);
	}

	/**
	 * 查询角色下拉框数据
	 * @return 返回查询结果json
	 */
	@RequestMapping(value = "/findCombo", method = RequestMethod.POST)
	@ResponseBody
	public Object findCombo(Map<String, Object> params) {
		return sysRoleBiz.queryAll();
	}

}