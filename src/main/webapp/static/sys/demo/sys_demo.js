$(function(){
	sysDemo.init();
	sysDemoWin.init();
})
/**
 * crud测试
 */
var app = {table:null,win:null,form:null};
var sysDemo = {
	init:function(){
		sysDemo.loadData();
	},
	loadData:function(){
		app.table = $('#sys_demo_xtable').xtable({
			url: adminPath + '/sysDemo/findSysDemo',
			deleteUrl: adminPath + '/sysDemo/deleteSysDemo',
			paging: '.sysDemo_paging',
			format:function(row){
				row.btns = '<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;'+
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
			}
		});
	}
};
/**
 * crud测试表单
 */
var sysDemoWin = {
	init:function(){
		$('#birthday').xdate();
		sysDemoWin.loadWin();
		sysDemoWin.loadForm();
		sysDemoWin.bindOpen();
	},
	loadWin:function(){
		app.win = $('#sys_demo_win').xwindow({width:500,height:350,open:false});
	},
	loadForm:function(){
		app.form = $('#sys_demo_form').xform({
			save : adminPath + '/sysDemo/saveSysDemo',
			update : adminPath + '/sysDemo/updateSysDemo',
			updateId : '#sys_demo_id',
			xbtn:'.btn_submit',
			xcheck:[
				{label:'名称', name:'name', xcheck:'null,length:2:10'},
				{label:'电话', name:'phone', xcheck:'null,phone'},
				{label:'邮箱', name:'email', xcheck:'null,email'},
				{label:'生日', name:'birthday', xcheck:'null'}
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