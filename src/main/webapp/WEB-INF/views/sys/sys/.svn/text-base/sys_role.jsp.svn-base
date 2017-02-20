<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>员工角色</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript" src="${staticPath}/sys/sys/sys_role.js"></script>
	<style type="text/css">
	#role_menu_tree{
		overflow-y: scroll;
		height: 445px;
	}
	.menu_box{
		width:100%;
	}
	.menu_root{
		height:30px;
		line-height:30px;
		background: #ddd;
	}
	.menu_row{
		border-bottom:1px solid #ddd;
	}
	.menu_row:after{
		clear:both;display:block;visibility:hidden;height:0;content:"";
	}
	.menu_left{
		width:110px;
		float:left;
		padding-left:20px;
	}
	.menu_right{
		width:500px;
		float:left;
		border-left:1px solid #ddd;
	}
	.menu-item{
		width:120px;
		float:left;
		padding-bottom:5px;
	}
	</style>
</head>
<body>
	<div class="main_body">
		<div class="main_title main_title_border">
			<h5>员工角色</h5>
			<div class="box_right">
				<button type="button" class="xbtn" id="btn_add">添加</button>
			</div>
		</div>
		<div class="xtable" id="role_xtable">
			<table class="xhead">
				<tr>
					<th class="ck"><input type="checkbox" class="xcheckbox"/></th>
					<th width="140px">角色</th>
					<th>备注</th>
					<th width="140px">创建时间</th>
					<th width="180px">操作</th>
				</tr>
			</table>
			<div class="xbody">
				<table>
					<tbody class="xtemplate">
						<tr>
							<td class="ck"><input type="checkbox" data-xv="{id}"/></td>
							<td>{name}</td>
							<td>{remark}</td>
							<td class="tc">{createTime}</td>
							<td class="tc">{btns}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="bottom_btns"><span class="xbtn xdeletes">批量删除</span></div>
		</div>
		<jsp:include page="../../base/paging.jsp"><jsp:param value="role_paging" name="cls"/></jsp:include>
	</div>
	<jsp:include page="sys_role_add.jsp"></jsp:include>
	<jsp:include page="sys_role_menu.jsp"></jsp:include>
</body>
</html>