package com.xsoft.sys.sys.bizImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsoft.base.biz.bizImpl.BaseBizImpl;
import com.xsoft.base.utils.StringUtil;
import com.xsoft.sys.sys.biz.SysRoleMenuBiz;
import com.xsoft.sys.sys.dao.SysRoleMenuDao;
import com.xsoft.sys.sys.entity.SysRoleMenu;

/**
 * 角色菜单biz实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Service
public class SysRoleMenuBizImpl extends BaseBizImpl<SysRoleMenu> implements SysRoleMenuBiz {

	@Autowired
	public SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public void updateRoleMenu(int roleId, String menus) {
		//获取当前角色菜单
		List<String> roleMenus = sysRoleMenuDao.findRoleMenuById(roleId);
		//新菜单
		List<String> newMenus =  new ArrayList<String>();
		if(StringUtil.isNotBlank(menus)){
			//新菜单
			String[] menuId = menus.split(",");
			//需要添加的菜单
			List<SysRoleMenu> saveList  = new ArrayList<SysRoleMenu>();
			for (String mid : menuId) {
				newMenus.add(mid);
				if(!roleMenus.contains(mid)){
					saveList.add(new SysRoleMenu(roleId, mid));
				}
			}
			sysRoleMenuDao.saveRoleMenuList(saveList);
		}
		//需要删除的菜单
		List<SysRoleMenu> delList = new ArrayList<SysRoleMenu>();
		for (String mid : roleMenus) {
			if(!newMenus.contains(mid)){
				delList.add(new SysRoleMenu(roleId, mid));
			}
		}
		sysRoleMenuDao.delRoleMenuList(delList);
	}
}
