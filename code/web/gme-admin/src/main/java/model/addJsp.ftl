<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${tableComment}新增</title>
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
  	<form id="formobj" action="${dollar}{ctx}/${module}/${tableName}/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<#if fields ?exists >
 		<#list fields as tem>
 		<#if priField !=tem[1] >
 		<div class="control-group">
        	<label class="control-label Validform_label">${tem[2]}${tem[3]}：</label>
	        <div class="controls">
	        	<input name="${tableName}.${tem[1]}" value="" class="inputxt"<#if tem[3] !="" > datatype="*1-${tem[4]}" </#if> type="text">
	        </div>
      	</div>
      	</#if>
		</#list>
		</#if>
	</form>
  </body>
</html>
