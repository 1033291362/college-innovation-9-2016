package com.xsoft.sys.sys.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.sys.sys.dao.SysRoleMenuDao;
import com.xsoft.sys.sys.entity.SysRoleMenu;

/**
 * 角色菜单dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class SysRoleMenuDaoImpl extends BaseDaoImpl<SysRoleMenu> implements SysRoleMenuDao {

	@Override
	public List<String> findRoleMenuById(int roleId) {
		String sql = "select menuId from sys_role_menu where roleId=?";
		return jdbcTemplate.queryForList(sql, String.class, roleId);
	}

	@Override
	public void saveRoleMenuList(List<SysRoleMenu> saveList) {
		if(saveList.size()<1)return;
		final List<SysRoleMenu> itemList = saveList;
		String sql = "INSERT INTO sys_role_menu(roleid,menuid) VALUES(?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, itemList.get(i).getRoleId());
				ps.setString(2, itemList.get(i).getMenuId());
			}

			public int getBatchSize() {
				return itemList.size();
			}
		});
	}

	@Override
	public void delRoleMenuList(List<SysRoleMenu> delList) {
		if(delList.size()<1)return;
		final List<SysRoleMenu> itemList = delList;
		String sql = "DELETE FROM sys_role_menu WHERE roleId=? AND menuId=?";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, itemList.get(i).getRoleId());
				ps.setString(2, itemList.get(i).getMenuId());
			}

			public int getBatchSize() {
				return itemList.size();
			}
		});
	}
}
