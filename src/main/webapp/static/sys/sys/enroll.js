$(function() {
	enroll.init();
});
var enroll = {
	form: null,
	init: function() {
		enroll.loadFrom();
	},
	enrollFrom: function() {
		enroll.form = $('#enroll_from').xform({
			url: '/static/enroll',
			xbtn: '#submit',
			submitp: function() {
				$('#enroll_from').find('.error').remove();
			},
			success: function(data) {
				if (data.code == 1) {
					app.win.close();
					$.ok('操作成功');
				}else{
					$.xalert({msg:'操作失败！'});	
				}
			}
		});
	}
}