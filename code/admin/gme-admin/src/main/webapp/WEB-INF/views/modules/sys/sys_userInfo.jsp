<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户列表</title> 
	<%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  		<div class="form-horizontal">
  			<div class="control-group">
	        	<label class="control-label Validform_label">角色：</label>
		        <div class="controls">
		          	<input type="text" class="inputxt" value='<c:if test="${not empty roles}"><c:forEach items="${roles}" var="tem"><c:if test="${tem.id eq item.roleid}">${tem.rolename}</c:if></c:forEach></c:if>' disabled="disabled">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">姓名：</label>
		        <div class="controls">
		        	<input disabled="disabled" value="${item.truename}" class="inputxt" datatype="*1-200" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">登录名：</label>
		        <div class="controls">
		        	<input disabled="disabled" value="${item.username}" class="inputxt" datatype="*1-100" type="text">
		        </div>
	      	</div>   
			<div class="control-group"> 
				<label class="control-label Validform_label">
					手机号：
				</label>
				<div class="controls">
					<input disabled="disabled" value="${item.phone}" class="inputxt" datatype="empty|m" type="text">
				</div>
			</div>  
			<div class="control-group"> 
				<label class="control-label Validform_label">
					联系QQ：
				</label>
				<div class="controls">
					<input disabled="disabled" value="${item.qq}" class="inputxt" datatype="empty|n" type="text">
				</div>
			</div>	
			<div class="control-group"> 
				<label class="control-label Validform_label">
					邮箱：
				</label>
				<div class="controls">
					<input disabled="disabled" value="${item.email}" class="inputxt" datatype="empty|e" type="text">
				</div>  
			</div>
  		</div>
  </body>
</html>
