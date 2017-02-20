$(function(){
	sysMenu.init();
	sysMenuWin.init();
})
/**
 * 系统菜单
 */
var app = {table:null,win:null,form:null};
var sysMenu = {
	init:function(){
		sysMenu.loadData();
	},
	loadData:function(){
		app.table = $('#sys_menu_xtable').xtable({
			url:adminPath + '/sysMenu/findSysMenu',
			deleteUrl:adminPath + '/sysMenu/deleteSysMenu',
			paging:'.sysMenu_paging',
			format:function(row){
				row.btns = '<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;'+
					'<a class="xdelete" data-xv="'+row.id+'">删除</a>';
			},
			update:function(row,b){
				app.form.setData(row);
				$("#sys_menu_add").val(true);
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
/**
 * 系统菜单表单
 */
var sysMenuWin = {
	init:function(){
		sysMenuWin.loadWin();
		sysMenuWin.loadForm();
		sysMenuWin.bindOpen();
	},
	loadWin:function(){
		app.win = $('#sys_menu_win').xwindow({width:500,height:400,open:false});
	},
	loadForm:function(){
		app.form = $('#sys_menu_form').xform({
			save : adminPath + '/sysMenu/saveSysMenu',
			update : adminPath + '/sysMenu/updateSysMenu',
			updateId : '#sys_menu_add',
			xbtn:'.btn_submit',
			xcheck:[
				{label:'父id', name:'pid', xcheck:'null'},
				{label:'菜单名称', name:'name', xcheck:'null'},
				{label:'图片', name:'img', xcheck:''},
				{label:'排序', name:'sort', xcheck:'null'}
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
			$('#sys_menu_add').val('');
			app.win.open();
		});
	}
};