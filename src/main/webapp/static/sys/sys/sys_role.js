$(function(){
	role.init();
	roleWin.init();
	roleMenuWin.init();
})
/**
 * 用户角色管理
 */
var app = {table:null,win:null,form:null,menuWin:null,roleId:null};
var role = {
	init:function(){
		role.loadData();
	},
	loadData:function(){
		app.table = $('#role_xtable').xtable({
			url:adminPath + '/sysRole/findSysRole',
			deleteUrl:adminPath + '/sysRole/deleteSysRole',
			paging:'.role_paging',
			format:function(row){
				row.btns = '<a class="btn_role_menu" data-xv="'+row.index+'">权限设置</a>&nbsp;'+
					'<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;'+
					'<a class="xdelete" data-xv="'+row.id+'">删除</a>';
			},
			update:function(row,b){
				app.form.setData(row);
				app.win.open();
			},
			deleteSuccess:function(d){
				if (d.code==1){
					app.table.reload();
            		$.ok('删除成功');
                } else {
                	$.xalert({msg:'删除失败！'});
                }
			},
			bind:function(data){
				role.bind();
			}
		});
	},
	bind:function(){
		$('.btn_role_menu').xbtn(function(ops){
			var row = app.table.getRow(ops.xv);
			app.roleId = row.id;
			var menus = ','+row.menus+',';
			$('input[name="roleMenu"]').prop('checked',false);
			$('input[name="roleMenu"]').each(function(index,item){
				if(menus.indexOf(','+item.value+',')!=-1){item.checked=true;}
			})
			app.menuWin.open();
		});
	}
};
/**
 * 角色表单
 */
var roleWin = {
	init:function(){
		roleWin.loadWin();
		roleWin.loadForm();
		roleWin.bindOpen();
	},
	loadWin:function(){
		app.win = $('#role_win').xwindow({width:500,height:350,open:false});
	},
	loadForm:function(){
		app.form = $('#role_form').xform({
			save : adminPath + '/sysRole/saveSysRole',
			update : adminPath + '/sysRole/updateSysRole',
			updateId : '#role_id',
			xbtn:'.btn_submit',
			xcheck:[
				{label:'用户名', name:'name', xcheck:'null,max:20'},
				{label:'备注', name:'remark', xcheck:'max:10'}
			],
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
			app.form.clear();
			app.win.open();
		});
	}
};
/**
 * 角色权限设置
 */
var roleMenuWin = {
	init:function(){
		roleMenuWin.loadWin();
		roleMenuWin.loadMenus();
		roleMenuWin.bind();
	},
	loadWin:function(){
		app.menuWin = $('#role_menu_win').xwindow({width:700,height:530,open:false});
	},
	loadMenus:function(){
		$.ajax({
			url: adminPath + '/sysMenu/findAllMenu',
			type:'post',
			dataType:'json',
			success:function(data){
				var menulist = '';
		        $.each(data, function(i, n) {
		        	menulist +='<div class="menu_box"><div class="menu_root"><input type="checkbox" name="roleMenu" value="'+n.id+'"/>'+n.name+'&nbsp;</div>';
		            if(n.son){
		            	$.each(n.son, function(ni, o) {
		            		menulist +='<div class="menu_row">';
		            		menulist +='<div class="menu_left"><input type="checkbox" name="roleMenu" value="'+o.id+'"/>'+o.name+'&nbsp;</div>';
		            		if(o.son){
					        	menulist +='<div class="menu_right">';
		            			$.each(o.son, function(oi, s) {
		            				menulist +='<div class="menu-item"><input type="checkbox" name="roleMenu" value="'+s.id+'"/>'+s.name+'&nbsp;</div>';
		            			});
				            	menulist +='</div>';
		            		}
		            		menulist +='</div>';
		            	});
		            }
	            	menulist +='</div>';
		        });
				$('#role_menu_tree').html(menulist);
			},
			error:function(){}
		});
	},
	bind:function(){
		$('#menu_all').click(function(){
			$('input[name="roleMenu"]').each(function(index,item){
				item.checked=true;
			})
		})
		$('#menu_no').click(function(){
			$('input[name="roleMenu"]').each(function(index,item){
				if(item.checked)item.checked=false;
				else item.checked=true;
			})
		})
		$('#btn_menu_submit').xbtn(function(ops){
			ops.close();
			var menus = '';
			$('input[name="roleMenu"]').each(function(index,item){
				if(item.checked){menus += item.value+',';}
			})
			if(menus){menus=menus.substring(0,menus.length-1)}
			$.ajax({
				url:adminPath+'/sysRoleMenu/updateRoleMenu',
				type:'post',
				dataType:'json',
				data:{
					roleId:app.roleId,
					menus:menus
				},
				success:function(e){
					ops.open();
					if (e.code==1){
						$.ok('保存成功！');
						app.menuWin.close();
						app.table.reload();
	                } else {
						$.error('保存失败！');
	                }
				},
				error:function(){
					ops.open();
					$.xalert({msg:'请求失败！'});
				}
			});
		})
	}
}