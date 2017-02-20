package com.xsoft.sys.sys.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.sys.sys.dao.SysMenuDao;
import com.xsoft.sys.sys.entity.SysMenu;

/**
 * 系统菜单dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class SysMenuDaoImpl extends BaseDaoImpl<SysMenu> implements SysMenuDao {

	@Override
	public List<SysMenu> findMenuByRoleId(String roleId) {
		String sql = "select a.* from sys_menu a left join sys_role_menu b on(a.id=b.menuid) where b.roleid=?";
		return this.queryForList(sql, SysMenu.class, roleId);
	}

	@Override
	public List<Map<String, Object>> findAllMenu() {
		String sql = "select id,pid,name,sort from sys_menu order by pid,sort";
		return jdbcTemplate.queryForList(sql);
	}

}
