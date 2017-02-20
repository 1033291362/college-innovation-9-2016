<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>员工管理</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript" src="${staticPath}/sys/sys/sys_user.js"></script>
</head>
<body>
	<div class="main_body">
		<div class="main_title main_title_border">
			<h5>员工管理</h5>
			<div class="box_right">
				<button type="button" class="xbtn" id="btn_add">添加</button>
			</div>
		</div>
		<div class="xtable" id="user_xtable">
			<table class="xhead">
				<tr>
					<th class="ck"><input type="checkbox" class="xcheckbox"/></th>
					<th width="140px">登录账号</th>
					<th width="100px">姓名</th>
					<th width="140px">电话</th>
					<th>注册时间</th>
					<th>最近登录时间</th>
					<th width="80px">操作</th>
				</tr>
			</table>
			<div class="xbody">
				<table>
					<tbody class="xtemplate">
						<tr>
							<td class="ck"><input type="checkbox" data-xv="{id}"/></td>
							<td>{username}</td>
							<td>{name}</td>
							<td>{phone}</td>
							<td class="tc">{createTime}</td>
							<td class="tc">{lastTime}</td>
							<td class="tc">{btns}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="bottom_btns"><span class="xbtn xdeletes">批量删除</span></div>
		</div>
		<jsp:include page="../../base/paging.jsp"><jsp:param value="user_paging" name="cls"/></jsp:include>
	</div>
	<jsp:include page="sys_user_add.jsp"></jsp:include>
</body>
</html>