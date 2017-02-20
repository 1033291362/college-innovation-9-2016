$(function(){
	user.init();
	userWin.init();
})
var app = {table:null,win:null,form:null,roleCombo:null,pass_required:true};
var user = {
	init:function(){
		user.loadData();
	},
	loadData:function(){
		app.table = $('#user_xtable').xtable({
			url:adminPath + '/sysStudent/findSysStudent',
			deleteUrl:adminPath + '/sysUser/deleteSysUser',
			paging:'.user_paging',
			format:function(row){
				row.btns = '<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;'+
					'<a class="xdelete" data-xv="'+row.id+'">删除</a>';
			},
			update:function(row,b){
				userWin.optionalPass();
				app.form.setData(row);;
				app.win.open();
			},
			deleteSuccess:function(d){
				if (d.code==1){
					app.table.reload();
            		$.ok('删除成功');
                } else {
                	$.xalert({msg:'删除失败！'});
                }
			}
		});
	}
};
var userWin = {
	init:function(){
		userWin.loadWin();
		userWin.loadForm();
		userWin.bindOpen();
	},
	loadWin:function(){
		app.win = $('#user_win').xwindow({width:500,height:400,open:false});
	},
	loadForm:function(){
		app.form = $('#user_form').xform({
			save : adminPath + '/sysUser/saveSysUser',
			update : adminPath + '/sysUser/updateSysUser',
			updateId : '#user_id',
			xbtn:'.btn_submit',
			xcheck:[
				{label:'登录账号', name:'username', xcheck:'null,length:2:16'},
				{label:'登陆密码', name:'password', xcheck:'length:5:16',
					msgCheck:'不能为空',
					check:function(){
						if(app.pass_required){
							return $('#password').val() != '';
						}
						return true;
					}
				},
				{label:'确认密码', name:'password2', xcheck:'equals,length:5:16',equals:'password',
					msgCheck:'不能为空',
					check:function(){
						if(app.pass_required){
							return $('#password2').val() != '';
						}
						return true;
					}
				},
				{label:'姓名', name:'name', xcheck:'null,length:2:16'},
				{label:'电话', name:'phone', xcheck:'null,phone'},
				{label:'用户角色', name:'roleId', xcheck:'null', msgBox:'.f_role_error'}
			],
			xcombo:[{id:'#user_role',url:adminPath+'/sysRole/findCombo'}],
			success:function(e){
				if(e.code==1){
					app.table.reload();
					app.win.close();
					$.ok('操作成功');
				}else{
					$.xalert({msg:'操作失败！'});	
				}
			},
			error:function(){$.xalert({msg:'请求失败！'});}
		});
	},
	bindOpen:function(){
		$('#btn_add').click(function(){
			app.pass_required = true;
			$('.pass_required').css('visibility','visible');
			app.form.clear();
			app.win.open();
		});
	},
	optionalPass:function(){
		app.pass_required = false;
		$('.pass_required').css('visibility','hidden');
	}
};