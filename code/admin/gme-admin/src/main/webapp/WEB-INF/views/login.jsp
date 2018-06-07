<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.manage.sys.security.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%> 
<html>
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登陆</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/font-awesome-4.6.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/main.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/base.css">
	<script src="<%=basePath%>/static/dist/js/jquery-1.12.3.min.js" charset="utf-8"></script>
	<script src="<%=basePath%>/static/layer/layer.js" charset="utf-8"></script>
	
	<script type="text/javascript">
		// 如果在框架中，则跳转刷新上级页面
        if(self.frameElement && self.frameElement.tagName=="IFRAME"){
        	$.dialog.confirm("会话超时重新登录！", function(){
				parent.location.reload();
			}, function(){
			}).zindex();
        }
	</script>
	
	<script type="text/javascript">
		document.onkeydown = function(e){
		    var event = e || window.event;  
		    var code = event.keyCode || event.which || event.charCode;
		    if (code == 13) {
		        login();
		    }
		}
		
		$(function(){
		    $("input[name='login']").focus();
		    $('#randCodeImage').click(function(){
				var date = new Date();
				var img = document.getElementById("randCodeImage");
				img.src='<%=basePath%>/commonServlet?a=' + date.getTime();
			});
		});
		
		function cleardata(){
		    $('#loginForm').form('clear');
		}
		
		function login(){
			$("#showMsg").html("");  
		    if($("input[name='username']").val().trim()==""){
		         layer.alert("账号不能为空");
		         $("input[name='username']").focus();
		         return;
		    }
		    if($("input[name='password']").val().trim()==""){
		         layer.alert("用户密码不能为空");
		         $("input[name='password']").focus();
		         return;
		    }
		    if($("input[name='validateCode']").val().trim()=="" ){
		         layer.alert("验证码不能为空");
		         $("input[name='validateCode']").focus();
		         return;
		    }
		    $("#loginForm").submit();
		}
   </script>
   
  </head>
  
  <body class="hold-transition login-page">
  
  	<div class="login-wrap">
        <div class="login-box">
            <div class="login-box-body">
                <p class="login-box-msg">欢迎使用管理平台</p>
                <form id="loginForm" action="${ctx}/login" method="post">
                    <div class="form-group has-feedback">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        <input name="username" class="form-control" placeholder="用户名" type="text">
                        
                    </div>
                    <div class="form-group has-feedback">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <input name="password" class="form-control" placeholder="密码" type="password">
                        
                    </div>
                    <div class="form-group has-feedback">
                        <span class="glyphicon glyphicon-question-sign form-control-feedback"></span>
                        <input name="validateCode" autocomplete="off" class="form-control" placeholder="验证码" type="text">
                        <span style="position:absolute; display:block; width:82px; height:27px; right:4px; top:5px;"> 
                        <img src="<%=basePath%>/commonServlet" id="validateCode" style="width: 82px;"></span>
                    </div>
                    <div class="form-group has-feedback">
                    	<p class="redword">
                    		<span id="showMsg"></span>
                    	</p>
                        <p class="redword">
                        	<% String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);%>
        					<%=error==null?"":"com.manage.sys.security.CaptchaException".equals(error)?"验证码错误, 请重试.":"输入密码错误, 请重试." %>
                        </p>
                    </div>
                    <div class="form-group has-feedback">
                       <!--  <button type="submit" class="btn btn-primary btn-block btn-flat">登&nbsp;录</button> -->
                        <button type="button" class="btn btn-primary btn-block btn-flat" onclick="login();">登&nbsp;录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
  </body>
</html>
