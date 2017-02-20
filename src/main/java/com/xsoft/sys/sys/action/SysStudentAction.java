package com.xsoft.sys.sys.action;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.base.utils.DigestUtil;
import com.xsoft.base.utils.StringUtil;
import com.xsoft.base.utils.ToolsUtil;
import com.xsoft.sys.sys.biz.SysUserBiz;
import com.xsoft.sys.sys.daoImpl.SysStudentDaoImpl;
import com.xsoft.sys.sys.entity.SysUser;

/**
 * 系统用户表action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysStudent")
public class SysStudentAction extends BaseAction {

	@Autowired
	private SysStudentDaoImpl sysUserBiz;

	
	@RequestMapping(value = "")
	public String index() {
		return "sys/sys/sys_Student";
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
	@RequestMapping(value = "/findSysStudent", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysStudent(int page, int rows, Map<String, Object> params) {
		return sysUserBiz.queryPage(page, rows, params);
	}
}