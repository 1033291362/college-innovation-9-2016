<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath()+"/";%>
<div class="xwindow" id="sys_menu_win">
	<div class="cover"></div>
	<div class="xbox">
		<div class="title">系统菜单表单</div>
		<form class="xform" id="sys_menu_form" method="post">			
			<input type="hidden" id="sys_menu_add" value="true"/>
			<div class="xgroup">
				<label class="g1">id<i>*</i></label>
				<div class="g2"><input type="text" name="id"/></div>
			</div>
			<div class="xgroup">
				<label class="g1">父id<i>*</i></label>
				<div class="g2"><input type="text" name="pid"/></div>
			</div>
			<div class="xgroup">
				<label class="g1">菜单名称<i>*</i></label>
				<div class="g2"><input type="text" name="name"/></div>
			</div>
			<div class="xgroup">
				<label class="g1">链接地址</label>
				<div class="g2"><input type="text" name="url"/></div>
			</div>
			<div class="xgroup">
				<label class="g1">图片</label>
				<div class="g2"><input type="text" name="img"/></div>
			</div>
			<div class="xgroup">
				<label class="g1">排序<i>*</i></label>
				<div class="g2"><input type="text" name="sort"/></div>
			</div>
		</form>
		<div class="bottombar">
			<span class="xbtn btn_submit">保存</span><span class="xbtn xclose">取消</span>
		</div>
	</div>
</div>