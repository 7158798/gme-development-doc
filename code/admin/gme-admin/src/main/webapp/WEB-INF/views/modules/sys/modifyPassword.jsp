<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
   	<title>修改密码</title>
   	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	       $(function(){  

				  var ro=$("#formobj").Validform({ 
						  tiptype:4,
						  btnSubmit:"#btn_sub",
						  btnReset:"#btn_reset",
						  ajaxPost:true,
						  callback:function(data){  
						   if(data.success==true){
							  tip(data.msg);
							  $("#oldPassword").val("");
							  $("#newPassword").val("");
							  $("#rePassword").val("");
						   }else{
						   	 tip(data.msg); 
						   	 $("#oldPassword").val("");
							 return false;
						   } 
						}
					});
					
			    ro.addRule([
				{
		            ele: "#oldPassword",
		            nullmsg: "请填写旧密码！",
		            ajaxurl: "${ctx}/sys/sys_user/checkUserPass",
		            errormsg: "请填写正确的密码！"
		        }
		        ]);
	      });
	</script>
  </head>
  <body style="overflow:hidden;">
  	<div class="easyui-panel" data-options="fit:true">
	    <div class="psflow-panpel-maintitle" style="border:1px solid #dcdcdc">
			<h2 class="psflow-panpel-title"><span>修改密码</span></h2>
		</div>
		<form id="formobj" action="${ctx}/sys/sys_user/curUpdatePass" name="formobj" method="post" class="form-horizontal">
 			<input type="hidden" id="btn_sub" class="btn_sub">
 			<div class="control-group">
	        	<label class="control-label Validform_label">旧密码<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input name="oldPassword" id="oldPassword" value="" datatype="*6-16" type="password" nullmsg="请填写旧密码" errormsg="密码应为6—16位的英文字母或数字组合" class="inputxt">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">新密码<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input name="newPassword" id="newPassword" datatype="*6-16" type="password" errormsg="密码应为6—16位的英文字母或数字组合" nullmsg="请填写新密码" class="inputxt">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">确认新密码<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input recheck="newPassword" id="rePassword" value="" datatype="*6-16" type="password" nullmsg="请确认新密码"  errormsg="两次输入的密码不一致" class="inputxt">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">&nbsp;</label>
		        <div class="controls">
		        	<input type="submit" value="确定" id="btn_sub" class="btn_sub u-btn u-btn-cg" style="width:85px; margin-right:12px; color:#fff;">
					<input type="reset" value="重置" id="btn_reset" class="btn_sub u-btn u-btn-cgray" style="width:85px;">
		        </div>
	      	</div>
 		</form>
	</div>
  </body>
</html>
