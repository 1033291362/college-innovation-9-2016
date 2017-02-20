package com.xsoft.sys.sys.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsoft.base.biz.bizImpl.BaseBizImpl;
import com.xsoft.sys.sys.biz.SysMenuBiz;
import com.xsoft.sys.sys.dao.SysMenuDao;
import com.xsoft.sys.sys.entity.SysMenu;
import com.xsoft.sys.sys.vo.SysMenuVo;

/**
 * 系统菜单biz实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Service
public class SysMenuBizImpl extends BaseBizImpl<SysMenu> implements SysMenuBiz {
	
	@Autowired
	public SysMenuDao sysMenuDao;

	public List<SysMenu> findMenuByRoleId(String roleId){
		return sysMenuDao.findMenuByRoleId(roleId);
	}

	@Override
	public List<Map<String, Object>> findAllMenu() {
		List<Map<String, Object>> menus = sysMenuDao.findAllMenu();
		return getMenusMap(menus, "0");
	}

	@Override
	public List<SysMenuVo> findMenusByRoleId(String roleId) {
		// 查询角色菜单
		List<SysMenu> menus = sysMenuDao.findMenuByRoleId(roleId);
		return getMenusVo(menus, "0");
	}

	// 获取权限TreeListMap
	private List<Map<String, Object>> getMenusMap(List<Map<String, Object>> menus, String id) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> row : menus) {
			String rowid = row.get("id").toString();
			String rowpid = row.get("pid").toString();
			if (id.equals(rowpid)) {
				List<Map<String, Object>> list = getMenusMap(menus, rowid);
				if (list.size() > 0) {
					row.put("son", list);
				}
				result.add(row);
			}
		}
		return result;
	}

	//获取权限TreeListVo
	private List<SysMenuVo> getMenusVo(List<SysMenu> menus, String id) {
		List<SysMenuVo> result = new ArrayList<SysMenuVo>();
		for (SysMenu row : menus) {
			String rowid = row.getId();
			String rowpid = row.getPid();
			if (id.equals(rowpid)) {
				SysMenuVo vo = row.toVo();
				List<SysMenuVo> list = getMenusVo(menus, rowid);
				if (list.size() > 0) {
					vo.setSon(list);
				}
				result.add(vo);
			}
		}
		return result;
	}
}
