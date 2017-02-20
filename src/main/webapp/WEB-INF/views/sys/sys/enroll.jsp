<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE>
<html>
<head>
	<title>登录</title>
		<link rel="stylesheet" type="text/css" href="${staticPath}/libs/xui/xui.css" />
	<script type="text/javascript" src="${staticPath}/sys/sys/enroll.js"></script>
</head>
<body>
	
		<form class="xform login_panel" id="enroll_from" method="post" action="">
			<div class="xgroup">
				<label class="g1 stu_id">账号<i>*</i></label>
				<div class="g2">
					<input type="text" name="stu_id" autocomplete="off" >
				</div>
			</div>
			<div class="xgroup">
				<label class="g1 stu_name">名字<i>*</i></label>
				<div class="g2">
					<input type="text" name="stu_name" autocomplete="off" >
				</div>
			</div>
			<div class="xgroup">
				<label class="g1 stu_num">班级<i>*</i></label>
				<div class="g2">
					<input type="text" name="stu_num" autocomplete="off" >
				</div>
			</div>
			<div class="xgroup">
				<label class="g1 web_chat_id">微信<i>*</i></label>
				<div class="g2">
					<input type="text" name="web_chat_id" autocomplete="off" >
				</div>
			</div>
        <input type="submit" name="Submit" value="提 交">
		</form>
</body>
</html>