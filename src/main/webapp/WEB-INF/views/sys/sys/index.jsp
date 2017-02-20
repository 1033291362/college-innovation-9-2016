<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE>
<html>
<head>
	<title>系统管理</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript"> var sys_menus = ${xsoft:getSysMenus()};</script>
	<script type="text/javascript" src="${staticPath}/sys/sys/index.js"></script>
</head>
<body>
	<div class="jx_body">
		<%@ include file="index_top.jsp" %>
		<%@ include file="index_menu.jsp" %>
		
		<div class="jx_center">
			<iframe class="main_iframe" name="main_iframe"></iframe>
		</div>
	</div>
</body>
</html>