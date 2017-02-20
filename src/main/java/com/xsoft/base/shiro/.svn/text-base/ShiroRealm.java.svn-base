package com.xsoft.base.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xsoft.sys.sys.biz.SysMenuBiz;
import com.xsoft.sys.sys.biz.SysUserBiz;
import com.xsoft.sys.sys.entity.SysMenu;
import com.xsoft.sys.sys.entity.SysUser;

/**
 * 权限认证
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-5-22
 * @version: V1.0.0
 */
public class ShiroRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

	@Autowired
	private SysUserBiz sysUserBiz;
	@Autowired
	private SysMenuBiz sysMenuBiz;

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		logger.debug("开始登录认证");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser user = sysUserBiz.getByParams("username", token.getUsername());
		// 账号不存在
		if (user == null) {
			return null;
		}
		// 账号已禁用
		if (user.getStatus() == 0) {
			return null;
		}
		ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getName(), user.getRoleId());
		// 认证缓存信息
		return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), getName());

	}

	/**
	 * 授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("开始授权认证");
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		String roleId = shiroUser.getRoleId();

		List<SysMenu> roleMenuList = sysMenuBiz.findMenuByRoleId(roleId);
		Set<String> urlSet = new HashSet<String>();
		for (SysMenu menu : roleMenuList) {
			if (StringUtils.isNoneBlank(menu.getUrl())) {
				urlSet.add(menu.getUrl());
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(urlSet);
		return info;
	}
}
