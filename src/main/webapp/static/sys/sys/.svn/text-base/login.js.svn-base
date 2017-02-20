$(function() {
	login.init();
});
var login = {
	form: null,
	init: function() {
		login.loadFrom();
	},
	loadFrom: function() {
		login.form = $('#login_from').xform({
			url: adminPath + '/login',
			xbtn: '#submit',
			xcheck: [
			    {label: '账号',name: 'username',xcheck: 'null,length:1:20'}, 
			    {label: '密码',name: 'password',xcheck: 'null,length:1:20'}
			],
			submitp: function() {
				$('#login_from').find('.error').remove();
			},
			success: function(data) {
				if (data.code == 1) {
					window.location.href = adminPath + '/index';
				} else if(data.code == 2) {
					$('<label class="error">账户或登录密码不正确。</lable>').appendTo('#login_from');
				} else {
					$('<label class="error">登录异常。</lable>').appendTo('#login_from');
				}
			}
		});
	}
}