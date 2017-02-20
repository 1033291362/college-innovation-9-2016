<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath()+"/";%>
<div class="xwindow" id="course_win">
	<div class="cover"></div>
	<div class="xbox">
		<div class="title">课程表单</div>
		<form class="xform" id="course_form" method="post">
			<input type="hidden" name="id" id="id"/>
			<input type="hidden" name="courseTimeId" id="courseTimeId"/>
			<div class="xgroup">
				<label class="g1">课程名<i>*</i></label>
				<div class="g2">
					<input type="text" name="courseName"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">教师id<i>*</i></label>
				<div class="g2">
					<input type="text" name="teacherId" id="teacherId"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">班级姓名<i>*</i></label>
				<div class="g2">
					<input type="text" name="className"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">上课时间<i>*</i></label>
				<div class="g2">
					<input type="text" name="startTime"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">下课时间<i>*</i></label>
				<div class="g2">
					<input type="text" name="endTime"/>
				</div>
			</div>
		</form>
		<div class="bottombar">
			<span class="xbtn btn_submit">保存</span><span class="xbtn xclose">取消</span>
		</div>
	</div>
</div>