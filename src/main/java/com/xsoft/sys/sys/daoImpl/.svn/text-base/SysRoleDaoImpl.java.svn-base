package com.xsoft.sys.sys.daoImpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.base.vo.PageVo;
import com.xsoft.sys.sys.dao.SysRoleDao;
import com.xsoft.sys.sys.entity.SysRole;

/**
 * 系统角色dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao {
	
	@Override
	public PageVo queryPage(int page, int rows, Map<String, Object> params) {
		String sql = "select r.*,rm.menus from sys_role r LEFT JOIN (SELECT roleId, group_concat(menuId) as menus from sys_role_menu GROUP BY roleId) rm on(rm.roleId=r.id)";
		return queryForPage(sql, page, rows);
	}

}
