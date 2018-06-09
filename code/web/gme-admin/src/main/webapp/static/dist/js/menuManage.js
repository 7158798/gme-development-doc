(function(){
	"use strict";
	var menuManage = {
		fireEvents:function(){
			var top = 10;
			$("#menuNav").on("mouseenter","a",function(){
				top = $(this).position().top; 
				$("#editMenuGroup").show().css("top",top+"px");
			});

			$("#menuNav").hover(function(){
				$("#editMenuGroup").show();
			},function(){
				$("#editMenuGroup").hide();
			});
		},
		editMenu:function(){

		},
		addMenu:function(url,param){
			//${ctx}/sys/sys_menu/add
			$.post(url, param, function(data) {
				if (data.success) {
					console.log(JSON.stringify(data));
				}else{
					showDialog("添加菜单",data.msg,300);
				}
			},"json");
		},
		deleteMenu:function(){
			
		},
		setData:function(){},
		getData:function(){},
		getList:function(url,meunList){
			$.post(url, {}, function(data) {
				console.log(JSON.stringify(data));
				var list = data.rows;
				if (list.length > 0) {
					for (var i = 0,j = list.length; i < j; i++) {
						var menuFatherId = list[i].menuFatherId;
					}
				}
			},"json");
		}
	};
	function open(closeEle,oEle){
		if(oEle.is(":hidden")){
			closeEle.addClass("menuhide").slideUp("fast");
			oEle.slideDown("fast");
		}
	}

	function stopPropagation(a){
		if (a && a.stopPropagation) a.stopPropagation();
        else if (window.event) window.event.cancelBubble = true;
	}

	if (!window.menuManage) {
		window.menuManage = menuManage;
	}
})();