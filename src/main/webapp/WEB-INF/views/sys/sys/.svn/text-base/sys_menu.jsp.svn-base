<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>系统菜单</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript" src="${staticPath}/sys/sys/sys_menu.js"></script>
</head>
<body>
	<div class="main_body">
		<div class="main_title main_title_border">
			<h5>系统菜单</h5>
			<div class="box_right">
				<button type="button" class="xbtn" id="btn_add">添加</button>
			</div>
		</div>
		<div class="xtable" id="sys_menu_xtable">
			<table class="xhead">
				<tr>
					<th class="ck"><input type="checkbox" class="xcheckbox"/></th>			
					<th>id</th>
					<th>父id</th>
					<th>菜单名称</th>
					<th>链接地址</th>
					<th>图片</th>
					<th>排序</th>
					<th width="80px">操作</th>
				</tr>
			</table>
			<div class="xbody">
				<table>
					<tbody class="xtemplate">
						<tr>
							<td class="ck"><input type="checkbox" data-xv="{id}"/></td>
							<td>{id}</td>
							<td>{pid}</td>
							<td>{name}</td>
							<td>{url}</td>
							<td>{img}</td>
							<td>{sort}</td>
							<td class="tc">{btns}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="bottom_btns"><span class="xbtn xdeletes">批量删除</span></div>
		</div>
		<jsp:include page="../../base/paging.jsp"><jsp:param value="sysMenu_paging" name="cls"/></jsp:include>
	</div>
	<jsp:include page="sys_menu_add.jsp"></jsp:include>
</body>
</html>