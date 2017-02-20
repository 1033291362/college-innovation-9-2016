<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath()+"/";%>
<div class="xwindow" id="user_win">
	<div class="cover"></div>
	<div class="xbox">
		<div class="title">用户表单</div>
		<form class="xform" id="user_form" method="post">
			<input type="hidden" name="id" id="user_id"/>
			<div class="xgroup">
				<label class="g1">登录账号<i>*</i></label>
				<div class="g2">
					<input type="text" name="username"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">登录密码<i class="pass_required">*</i></label>
				<div class="g2">
					<input type="password" name="password" id="password"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">确认密码<i class="pass_required">*</i></label>
				<div class="g2">
					<input type="password" name="password2" id="password2"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">姓名<i>*</i></label>
				<div class="g2">
					<input type="text" name="name"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">电话<i>*</i></label>
				<div class="g2">
					<input type="text" name="phone"/>
				</div>
			</div>
			<div class="xgroup">
				<label class="g1">用户角色<i>*</i></label>
				<div class="g2">
					<div class="xcombo" data-name="roleId" id="user_role">
				  		<ul class="xtemplate">
					   		<li data-xv="{id}">{name}</li>
					   	</ul>
				  	</div>
				  	<div class="error f_role_error"></div>
				</div>
			</div>
		</form>
		<div class="bottombar">
			<span class="xbtn btn_submit">保存</span><span class="xbtn xclose">取消</span>
		</div>
	</div>
</div>