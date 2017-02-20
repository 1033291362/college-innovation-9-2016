$(function(){
	course.init();
	courseWin.init();
})
var app = {table:null,win:null,form:null,roleCombo:null,pass_required:true};
var course = {
	init:function(){
		course.loadData();
	},
	loadData:function(){
		app.table = $('#course_xtable').xtable({
			url:adminPath + '/sysCourse/findSysCourse',
			deleteUrl:adminPath + '/sysCourse/deleteSysCourse',
			paging:'.course_paging',
			format:function(row){
				row.btns = '<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;'+
					'<a class="xdelete" data-xv="'+row.id+'">删除</a>';
			},
			update:function(row,b){
				courseWin.optionalPass();
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
var courseWin = {
	init:function(){
		courseWin.loadWin();
		courseWin.loadForm();
		courseWin.bindOpen();
	},
	loadWin:function(){
		app.win = $('#course_win').xwindow({width:500,height:400,open:false});
	},
	loadForm:function(){
		app.form = $('#course_form').xform({
			save : adminPath + '/sysCourse/saveSysCourse',
			update : adminPath + '/sysCourse/updateSysCourse',
			updateId : '#id',
			xbtn:'.btn_submit',
			xcheck:[
				{label:'课程名', name:'courseName', xcheck:'null,length:1:30'},
				{label:'教师id', name:'teacherId', xcheck:'null,length:1:30'},
				{label:'班级姓名', name:'className', xcheck:'null,length:1:30'},
				{label:'课程时间id', name:'courseTimeId', xcheck:'max:1000000'},
				{label:'上课时间', name:'startTime', xcheck:'null,length:1:30'},
				{label:'上课时间', name:'endTime', xcheck:'null,length:1:30'}
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