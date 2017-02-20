package com.xsoft.sys.sys.biz;

import java.util.List;
import java.util.Map;

import com.xsoft.base.biz.BaseBiz;
import com.xsoft.sys.sys.entity.SysMenu;
import com.xsoft.sys.sys.vo.SysMenuVo;

/**
 * 系统菜单biz
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
public interface SysMenuBiz extends BaseBiz<SysMenu> {

	/**
	 * 通过用户角色获取权限菜单
	 * 
	 * @param roleId
	 *            角色id
	 * @return 权限菜单集合
	 */
	public List<SysMenu> findMenuByRoleId(String roleId);

	/**
	 * 查询菜单树
	 */
	List<Map<String, Object>> findAllMenu();

	/**
	 * 获取角色菜单树
	 * 
	 * @param roleId
	 *            角色id
	 * @return
	 */
	List<SysMenuVo> findMenusByRoleId(String roleId);

}
