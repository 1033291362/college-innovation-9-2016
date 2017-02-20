<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>crud测试</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript" src="${staticPath}/sys/demo/sys_demo.js"></script>
</head>
<body>
	<div class="main_body">
		<div class="main_title main_title_border">
			<h5>crud测试</h5>
			<div class="box_right">
				<button type="button" class="xbtn" id="btn_add">添加</button>
			</div>
		</div>
		<div class="xtable" id="sys_demo_xtable">
			<table class="xhead">
				<tr>
					<th class="ck"><input type="checkbox" class="xcheckbox"/></th>			
					<th>名称</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>生日</th>
					<th width="80px">操作</th>
				</tr>
			</table>
			<div class="xbody">
				<table>
					<tbody class="xtemplate">
						<tr>
							<td class="ck"><input type="checkbox" data-xv="{id}"/></td>
							<td>{name}</td>
							<td>{phone}</td>
							<td>{email}</td>
							<td>{birthday}</td>
							<td class="tc">{btns}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="bottom_btns"><span class="xbtn xdeletes">批量删除</span></div>
		</div>
		<jsp:include page="../../base/paging.jsp"><jsp:param value="sysDemo_paging" name="cls"/></jsp:include>
	</div>
	<jsp:include page="sys_demo_add.jsp"></jsp:include>
</body>
</html>