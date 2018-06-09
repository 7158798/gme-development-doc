<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${tableComment}详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  	<#if fields ?exists >
  		<#list fields as tem>
  		<#if priField !=tem[1] >
  		<div class="control-group">
        	<label class="control-label Validform_label">${tem[2]}：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${dollar}{item.${tem[1]}}" class="inputxt" type="text">
	        </div>
      	</div>
		</#if>
  		</#list>
  	</#if>
  	</div>
  </body>
</html>
