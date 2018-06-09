<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>角色列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%> 
	<script type="text/javascript">
	  $(function(){$("#formobj").Validform({
		  tiptype:4,
		  btnSubmit:"#btn_sub",
		  btnReset:"#btn_reset",
		  ajaxPost:true,
		  callback:function(data){
		   var win = frameElement.api.opener;
		   if(data.success==true){
			  frameElement.api.close();win.tip(data.msg);
		   }else{
		   		tip(data.msg); 
			 return false;
		   }
		   win.reloadTable();
		 }
		});});
	</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/sys/sys_role/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">角色名称<font color="red">*</font>：</label>
	        <div class="controls">
	          	<input name="sys_role.rolename" value="" class="inputxt" datatype="*1-200" class="inputxt" type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">说明<font color="red">*</font>：</label>
	        <div class="controls">
	        	<textarea rows="5" class="textarea" datatype="*1-200" name="sys_role.remark"></textarea>
	        </div>
      	</div>
	</form>
  </body>
</html>
