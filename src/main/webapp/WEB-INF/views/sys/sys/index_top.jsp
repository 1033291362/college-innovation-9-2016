<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="xsoft" uri="/WEB-INF/tlds/xsoft.tld"%>
<div class="jx_top">
	<div class="btn_left">
		<div class="logo"></div>
		<span>后台管理</span>
	</div>
	<div class="btn_right">
		<span>欢迎 ${xsoft:getSysUserName()}</span>
		<span class="xsoft_logout">退出登录</span>
	</div>
</div>