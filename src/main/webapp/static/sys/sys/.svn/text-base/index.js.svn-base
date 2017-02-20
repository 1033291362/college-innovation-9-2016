$(function(){
	index.init();
	bind.init();
});
var app = {menu:null,sonMenu:null,loadUri:true}
var index = {
	init:function(){
		index.loadMenu();
		index.loadUrl();
	},
	loadMenu:function(){
		app.menu = $('#jx_menu').xaccordion({
			xdata:sys_menus,
			sonClick:function(btn){
				index.loadSonMenu(btn);
			}
		});
	},
	loadUrl:function(){
		var parent = $.cookie('XSOFT_MENU_PARENT');
		if(parent!=null&&parent!='null'){
			parent = eval('('+parent+')');
			index.showParentMenu(parent.id);
		}else{
			index.showUrl(adminPath+'/sysUser');
		}
	},
	loadSonMenu:function(data){
		var sonMenu = index.getSonMenuData(data.id);
		if(sonMenu.son){
			index.createSonMenu(sonMenu);
		}else{
			index.showUrl(data.url);
			index.clearSonMenu();
		}
		var parentData = '{id:"'+data.id+'",url:"'+data.url+'",index:"'+data.index+'"}';
		$.cookie("XSOFT_MENU_PARENT", parentData);
	},
	createSonMenu:function(data){
		$('.jx_body').addClass('max_body');
		$('.son_menu_title').html(data.name);
		if(app.sonMenu==null){
			app.sonMenu = $('#jx_son_menu').xaccordion({
				xdata:data.son,
				parentClick:function(btn){
					index.showUrl(btn.url);
					var uriData = '{id:"'+btn.id+'",url:"'+btn.url+'",index:"'+btn.index+'"}';
					$.cookie('XSOFT_MENU_URI', uriData);
				}
			});
		}else{
			app.sonMenu.setData(data.son);
		}
		index.showSonMenu();
	},
	clearSonMenu:function(){
		$('.jx_body').removeClass('max_body');
		if(app.sonMenu!=null)app.sonMenu.clear();
		$.cookie('XSOFT_MENU_URI', null);
	},
	getSonMenuData:function(id){
		var sonMenu = [];
		$.each(sys_menus,function(index, row){
			$.each(row.son,function(index, son){
				if(son.id==id){
					sonMenu = son;
					return false;
				}
			});				
		});
		return sonMenu;
	},
	showParentMenu:function(v){
		$('#jx_menu .xson').children().each(function(index,row){
			var value = $(row).data('id');
			if(v == value){
				$(row).parent().show();
				$(row).trigger('click');
			}
		});
	},
	showSonMenu:function(){
		var uri = $.cookie('XSOFT_MENU_URI');
		if(app.loadUri==true&&uri!=null&&uri!='null'){
			uri = eval('('+uri+')');
			$('#jx_son_menu .xparent').each(function(index,row){
				var value = $(row).data('id');
				if(uri.id == value){
					$(row).parent().show();
					$(row).trigger('click');
				}
			});
			app.loadUri=false;
		}else{
			app.sonMenu.select(0);
		}
	},
	showUrl:function(url){
		document.main_iframe.location.href = url;
	}
}
var bind = {
	init:function(){
		bind.logout();
	},
	logout:function(){
		$(".xsoft_logout").xbtn(function(btn){
			$.xget({
				url:adminPath+'/logout',
				success:function(data){
					if(data.code==1){
						window.location.href = adminPath + '/login';
					}else{
						$.xalert({msg:'操作失败！'});
					}
				}
			})
		});
	}
}