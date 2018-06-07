<%@ page language="java"  pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@page import="com.manage.base.util.UserUtil"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%> 
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/font-awesome-4.6.1/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/main.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/skins/skin-blue.min.css">
    <link href="${ctxStatic}/lhgDialog/skins/default.css" rel="stylesheet" id="lhgdialoglink">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/base.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini" id="indexBody">
    <!--[if lt IE 9]>
        <div class="lttip">
            <div class="lttipcontent">
                <h2>你的浏览器版本太低，本系统不支持IE9以下浏览器，请点击下面的链接，下载安装新版本后再试试吧！</h2>
                <p><a href="http://dldir1.qq.com/invc/tt/QQBrowser_Setup_9.4.8113.400.exe">点击此处，升级你的浏览器</a></p>
            </div>
        </div>
    <![endif]-->
    <!--[if lt IE 10]>
        <div class="lttip" id="lttip">
            <div class="lttipcontent">
                <h2>你的浏览器版本太低，体验最佳效果，请点击下面的链接，下载安装新版本后再试试吧！</h2>
                <p><a href="http://dldir1.qq.com/invc/tt/QQBrowser_Setup_9.4.8113.400.exe">点击此处，升级你的浏览器</a></p>
                <p><a href="###" onclick="document.getElementById('lttip').style.display='none';">关闭提示</a></p>
            </div>
        </div>
    <![endif]-->
    <div class="wrapper">
        <header class="main-header" id="mainHeader">
            <!-- Logo -->
            <a  class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini">后台</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg">管理后台</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">下拉切换</span>
                </a>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                    	 <li class="dropdown tasks-menu">
                            <a href="${ctx}/main" target="main" class="dropdown-toggles">
                                <i class="fa fa-home"></i>
                               	首页
                            </a>
                        </li>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggles">
                                <!-- <img src="<%=basePath%>/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> -->
                                <i class="fa fa-user"></i>
                                <span class="hidden-xs"><%=UserUtil.getCurUser().getTruename()%><small>（<%=UserUtil.getCurUserRol().getRolename()%>）</small></span>
                            </a>
                        </li>
                        <li class="dropdown tasks-menu">
                            <a href="${ctx}/sys/sys_user/toCurUpdatePass" target="main" class="dropdown-toggles">
                                <i class="fa fa-compass"></i> 修改密码
                            </a>
                        </li>
                        <li class="dropdown tasks-menu">
                            <a href="${ctx}/sys/sys_user/curInfo" target="main" class="dropdown-toggles">
                                <i class="fa fa-info-circle"></i>修改资料
                            </a>
                        </li>
                        <li class="dropdown tasks-menu">
                            <a href="###" class="dropdown-toggles" id="logout">
                                <i class="fa fa-power-off"></i>
                                <span class="hidden-xs">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu" id="psflowMenu">
                	<c:forEach items="${fns:getUserFirstMenus()}" var="tem" varStatus="st">
                		<li class="treeview">
	                        <a href="#">
	                            <i <c:if test="${not empty tem.ico}">class="${tem.ico}"</c:if><c:if test="${empty tem.ico}">class="fa fa-folder-o"</c:if>></i><span>${tem.menuname}</span> <i class="fa fa-angle-left pull-right"></i>
	                        </a>
	                        <ul class="treeview-menu">
	                        	<c:forEach items="${fns:getUserSecondMenus()[tem.id]}" var="tem1">
	                        		<li><a href="${ctx}/${tem1.menuurl}" target="main"><i <c:if test="${not empty tem1.ico}">class="${tem1.ico}"</c:if><c:if test="${empty tem1.ico}"> class="fa fa-folder-open-o"</c:if>></i>${tem1.menuname}</a></li>
	                        	</c:forEach>
	                        </ul>
	                    </li>
                	</c:forEach>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" id="contnetWrap">
            <iframe frameborder="0" scrolling="auto" name="main" id="main" width="100%" src="${ctx}/main">
                
            </iframe>
        </div>
        <!-- /.content-wrapper -->
        <!-- <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b>1.0.0
            </div>
            <strong>Copyright &copy; 2015-2016 <a href="http://www.montnets.com">xx</a>.</strong> All rights reserved.
        </footer> -->
    </div>
    <!-- ./wrapper -->
    <!-- jQuery 2.1.4 -->
    <script src="<%=basePath%>/static/dist/js/jquery-1.12.3.min.js" charset="utf-8"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=basePath%>/static/bootstrap/js/bootstrap.min.js" charset="utf-8"></script>
    <script src="<%=basePath%>/static/plugins/slimScroll/jquery.slimscroll.min.js" charset="utf-8"></script>
    <script src="<%=basePath%>/static/dist/js/app.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStatic}/lhgDialog/lhgdialog.min.js"></script>
    <script src="<%=basePath%>/static/dist/js/formva.js" charset="utf-8"></script>
    <script>
        (function(){
            var index = {
                menuControl:function(){
                    var treeview = $("#psflowMenu > .treeview"),
                        treeviewMenu = $("#psflowMenu > .treeview > .treeview-menu"),
                        trena = treeviewMenu.find("a");
                    trena.on('click', function() {
                        var pul = $(this).parent("li").parent("ul"),
                            pulp = pul.parent("li");
                        $("#psflowMenu").find('li').removeClass('active');
                        $(this).parent("li").addClass('active');
                        pulp.addClass('active');
                    });    
                },
                logout:function(){
                    $.dialog.confirm("您确定要退出系统吗？", function() {
                        window.location = "${ctx}/logout";
                    }, function() {}).zindex();
                }
            };
            
            $(function(){
                $("#main").height($(window).height() - 62);
                $(window).on("resize",function(){
                    $("#main").height($(window).height() - $("#mainHeader").height());
                });
                /*$("input").formValidate();*/
                $("#logout").on('click', function(event) {
                    event.preventDefault();
                    index.logout();
                });
                index.menuControl();
            });
        })();
    </script>
</body>

</html>
