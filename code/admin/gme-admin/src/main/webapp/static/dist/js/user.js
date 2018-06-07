(function(){
	var modify = {
		showTip:function(target,tipWords){
			//console.info("val:::"+target.val()+"width:::"+target.width());
			var tooltip = new fui.Tooltip(target, {
		    	trigger	: "none",
		    	position: "right",
		    	content : tipWords,
		    	space   : 2
		    });
		    tooltip.init(target);
		    return tooltip;
		},
		
		validate:function(){
			var t1 = t2 = t3 = null;
			$("#oldPassword").on("change",function(){
				var target = $(this),
					val = $(this).val(),
					tipWords = "请输入正确的密码!";
				if ((val.length < 6) || (val.length > 16)) {
					t1 = modify.showTip(target,tipWords);
				} else if(t1) {
					t1.close();
					t1 = null;
				}
			});
			$("#newPassword").on("change",function(){
				var target = $(this),
					val = $(this).val(),
					tipWords = "请输入正确的密码!";
				if (!isPassword(val)) {
					t2 = modify.showTip(target,tipWords);
				} else if(t2) {
					t2.close();
					t2 = null;
				}
			});
			$("#newPassword2").on("change",function(){
				var target = $(this),
					val = $(this).val(),
					tipWords = "两次输入的密码不一致!";
				if (val != $("#newPassword").val()) {
					t3 = modify.showTip(target,tipWords);
				} else if(t3) {
					t3.close();
					t3 = null;
				}
			});
		},
		msave:function(oval,nval1,nval2,url){
			var t4 = t5 = t6 = null;
			var dialog = top.dialog.get(window);	
			if ((oval.length < 6) || (oval.length > 16)) {
				t4 = modify.showTip($("#oldPassword"),"请输入原来的密码!");
				return false;
			}	
			if (!isPassword(nval1)) {
				t5 = modify.showTip($("#newPassword"),"请输入正确的密码!");
			    return false;
			}
			if (nval1 != nval2) {
				t6 = modify.showTip($("#newPassword2"),"两次输入的密码不一致!!");
			    return false;
			}
			//var url = '${ctx}/sys/sys_user/curUpdatePass';
			$.ajax({
				url: url,
				type: 'POST',
				dataType: 'json',
				data: {userOldPass:oval,userNewPass:nval1},
				success:function(data){
					if (data.success) {
						showDialog('修改密码',data.msg,300,function(){
							window.location.replace(window.location.href);
						});
					} else {
						showDialog('修改密码',data.msg,300);
					}
				},
				error:function() {
					console.log("error");
				}
			});
		},
		updateUserInfo:function(updateUserurl,checkUserUrl,id,userName,trueName,phone,qq,email,yName){
			if ($.trim(userName) == "") {
                modify.showTip($("#userName"),"请输入登录名!");
                return false;
            }
            if ($.trim(trueName) == "") {
                modify.showTip($("#trueName"),"请输入真实姓名!");
                return false;
            }
            if ($.trim(phone) != "" && !isCellphone(phone)) {
                modify.showTip($("#phone"),"您输入的手机号不正确!");
                return false;
            }
            if ($.trim(qq) != "" && !isQQ(qq)) {
                modify.showTip($("#qq"),"您输入的QQ号不正确!");
                return false;
            }
            if ($.trim(email) != "" && !isEmail(email)) {
                modify.showTip($("#email"),"您输入的邮箱格式不正确!");
                return false;
            }
			if(modify.checkUser(checkUserUrl,userName,yName)){
				$.post(updateUserurl, 
					{
						"sys_user.id":id,
						"sys_user.userName": userName,
						"sys_user.truename":trueName,
						"sys_user.phone": phone,
						"sys_user.qq":qq,
						"sys_user.email":email
					}, 
					function(data) {
						if (data.success) {
							showDialog('修改信息',data.msg,300,function(){
								window.location.replace(window.location.href);
							});
						}else{
							showDialog('修改信息',data.msg,300);
						}
				},"json");
			}
		},
		checkUser:function(url,newName,yName){
			//查找用户，检测用户名是否存在
			var flag = false;
			if (newName != yName) {
				$.post(url, {userName:newName}, function(data) {
					if (data.success) {
						flag = true;
					}else{
						showDialog('提示',data.msg,300);
						flag = false;
					}
				},"json");
			}else{
				flag = true;
			}
			
			return flag;
		}
	};
	
	if (!window.modify) {
		window.modify = modify;
	}
})()