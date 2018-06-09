<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>角色列表</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">角色名称：</label>
	        <div class="controls">
	          	<input type="text" value="${item.rolename}" disabled="disabled" class="inputxt">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">说明：</label>
	        <div class="controls">
	        	<textarea rows="5" class="textarea" datatype="*1-200" name="sys_role.remark" disabled="disabled">${item.remark}</textarea>
	        </div>
      	</div>
  	</div>
  </body>
</html>
