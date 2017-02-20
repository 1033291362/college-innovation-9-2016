package com.xsoft.sys.sys.action;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.base.utils.DigestUtil;
import com.xsoft.base.utils.ShiroUtil;
import com.xsoft.sys.sys.biz.SysUserBiz;
import com.xsoft.sys.sys.entity.SysUser;

/**
 * 系统菜单action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}")
public class SysAction extends BaseAction {

	@Autowired
	public SysUserBiz sysUserBiz;

	@RequestMapping(value = "/index")
	public String index() {
		return "sys/sys/index";
	}
	@RequestMapping(value = "/unauth")
	public String unauth() {
		return "base/unauth";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
        logger.info("GET请求登录");
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/admin/index";
        }
		return "sys/sys/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object logining(String username, String password) {
        logger.info("POST请求登录");

        if (StringUtils.isBlank(username)) {
            return sendError("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return sendError("密码不能为空");
        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtil.md5Hex(password).toCharArray());
        token.setRememberMe(true);
        try {
            user.login(token);
            updateUserLastTime();
        } catch (UnknownAccountException e) {
            logger.error("账号不存在：{}", e.getMessage());
            return sendError(2,"账号不存在");
        } catch (DisabledAccountException e) {
            logger.error("账号已禁用：{}", e.getMessage());
            return sendError(2,"账号已禁用");
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误：{}", e.getMessage());
            return sendError(2,"密码错误");
        } catch (RuntimeException e) {
            logger.error("未知错误,请联系管理员：{}", e.getMessage());
            return sendError("未知错误,请联系管理员");
        }
        return sendOk();
	}


    /**
     * 退出登录
     * @return {Result}
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Object logout() {
        logger.info("退出登录");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return sendOk();
    }
    
	/**
	 * 跟新用户登录时间
	 */
	private void updateUserLastTime() {
		SysUser user = new SysUser();
		user.setId(ShiroUtil.getSysUserId());
		user.setLastTime(new Date());
		sysUserBiz.update(user);
	}
}