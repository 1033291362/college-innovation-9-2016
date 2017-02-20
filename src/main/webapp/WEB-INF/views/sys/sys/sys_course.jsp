<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>课程管理</title>
	<%@ include file="/WEB-INF/views/base/sys_head.jsp"%>
	<script type="text/javascript" src="${staticPath}/sys/sys/sys_course.js"></script>
</head>
<body>
	<div class="main_body">
		<div class="main_title main_title_border">
			<h5>课程管理</h5>
			<div class="box_right">
				<button type="button" class="xbtn" id="btn_add">添加</button>
			</div>
		</div>
		<div class="xtable" id="course_xtable">
			<table class="xhead">
				<tr>
					<th class="ck"><input type="checkbox" class="xcheckbox"/></th>
					<th width="140px">课程名</th>
					<th width="100px">教师id</th>
					<th width="140px">班级姓名</th>
					<th>课程时间id</th>
					<th>上课时间</th>
					<th>下课时间</th>
					<th width="80px">操作</th>
				</tr>
			</table>
			<div class="xbody">
				<table>
					<tbody class="xtemplate">
						<tr>
							<td class="ck"><input type="checkbox" data-xv="{id}"/></td>
							<td>{courseName}</td>
							<td>{teacherId}</td>
							<td>{className}</td>
							<td>{courseTimeId}</td>
							<td class="tc">{startTime}</td>
							<td class="tc">{endTime}</td>
							<td class="tc">{btns}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="bottom_btns"><span class="xbtn xdeletes">批量删除</span></div>
		</div>
		<jsp:include page="../../base/paging.jsp"><jsp:param value="course_paging" name="cls"/></jsp:include>
	</div>
	<jsp:include page="sys_course_add.jsp"></jsp:include>
</body>
</html>