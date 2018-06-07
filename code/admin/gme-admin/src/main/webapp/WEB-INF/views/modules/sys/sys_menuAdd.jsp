<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
  <head>
    <title>菜单新增</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/sys/sys_menu/add" name="formobj" method="post" class="form-horizontal">
  		<input type="hidden" id="btn_sub" class="btn_sub">
      	<div class="control-group">
        	<label class="control-label Validform_label">菜单名<font color="red">*</font>：</label>
	        <div class="controls">
	          	<input name="sys_menu.menuname" value="" datatype="*1-200" class="inputxt" type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">菜单地址：</label>
	        <div class="controls">
	          	<input name="sys_menu.menuurl" value="" datatype="*0-200" class="inputxt" type="text">
	        </div>
      	</div>
      	<div class="control-group">
      		<label class="control-label Validform_label">
	            菜单排序<font color="red">*</font>：
	        </label>
	        <div class="controls">
	          	<input name="sys_menu.menusortno" value="" datatype="n" class="inputxt" type="text">
	        </div>
      	</div>
 		<div class="control-group">
      		<label class="control-label Validform_label">
	            上级菜单<font color="red">*</font>：
	        </label>
	        <div class="controls">
	          	<select name="sys_menu.menufatherid"  class="select">
					<option value="0" selected="selected">顶级菜单</option>
					<c:if test="${not empty result}">
						<c:forEach items="${result}" var="item">
							<option value="${item.id}">${item.menuname}</option>
						</c:forEach>
					</c:if>
				</select>
	        </div>
      	</div>
      	<div class="control-group">
      		<label class="control-label Validform_label">
	            是否显示<font color="red">*</font>：
	        </label>
	        <div class="controls">
	          	<select name="sys_menu.isshow" class="select">
					<option value="1" selected="selected">是</option>
					<option value="0">否</option>
				</select>
	        </div>
      	</div>
      	<div class="control-group">
      		<label class="control-label Validform_label">
	            菜单样式：
	        </label>
	        <div class="controls">
	          	<input name="sys_menu.ico" readonly="readonly" value="" class="inputxt fonttype" datatype="*0-100" type="text" id="fontTypetype">
	        </div>
      	</div>
	</form>
	<div id="fontTypeBox">
		<div class="font-type-box">
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-calendar-check-o">
					<i class="fa fa-calendar-check-o"></i>
					<span>fa-calendar-check-o</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-commenting">
					<i class="fa fa-commenting"></i>
					<span>fa-commenting</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa  fa-get-pocket">
					<i class="fa  fa-get-pocket"></i>
					<span>fa-get-pocket</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-hourglass-end">
					<i class="fa fa-hourglass-end"></i>
					<span>fa-hourglass-end</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-industry">
					<i class="fa fa-industry"></i>
					<span>fa-industry</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-fonticons">
					<i class="fa fa-fonticons"></i>
					<span>fa-fonticons</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-television">
					<i class="fa fa-television"></i>
					<span>fa-television</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-yc">
					<i class="fa fa-yc"></i>
					<span>fa-yc</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-adjust">
					<i class="fa fa-adjust"></i>
					<span>fa-adjust</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-archive">
					<i class="fa fa-archive"></i>
					<span>fa-archive</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-area-chart">
					<i class="fa fa-area-chart"></i>
					<span>fa-area-chart</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-asterisk">
					<i class="fa fa-asterisk"></i>
					<span>fa-asterisk</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-automobile">
					<i class="fa fa-automobile"></i>
					<span>fa-automobile</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-ban">
					<i class="fa fa-ban"></i>
					<span>fa-ban</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-balance-scale">
					<i class="fa fa-balance-scale"></i>
					<span>fa-balance-scale</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bank">
					<i class="fa fa-bank"></i>
					<span>fa-bank</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bars">
					<i class="fa fa-bars"></i>
					<span>fa-bars</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bar-chart">
					<i class="fa fa-bar-chart"></i>
					<span>fa-bar-chart</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bar-chart-o">
					<i class="fa fa-bar-chart-o"></i>
					<span>fa-bar-chart-o</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bell">
					<i class="fa fa-bell"></i>
					<span>fa-bell</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bell-slash">
					<i class="fa fa-bell-slash"></i>
					<span>fa-bell-slash</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-building">
					<i class="fa fa-building"></i>
					<span>fa-building</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-bookmark">
					<i class="fa fa-bookmark"></i>
					<span>fa-bookmark</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-calculator">
					<i class="fa fa-calculator"></i>
					<span>fa-calculator</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-calendar">
					<i class="fa fa-calendar"></i>
					<span>fa-calendar</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-calendar-check-o">
					<i class="fa fa-calendar-check-o"></i>
					<span>fa-calendar-check-o</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-camera">
					<i class="fa fa-camera"></i>
					<span>fa-camera</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cloud">
					<i class="fa fa-cloud"></i>
					<span>fa-cloud</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cloud-download">
					<i class="fa fa-cloud-download"></i>
					<span>fa-cloud-download</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cloud-upload">
					<i class="fa fa-cloud-upload"></i>
					<span>fa-cloud-upload</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cog">
					<i class="fa fa-cog"></i>
					<span>fa-cog</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cogs">
					<i class="fa fa-cogs"></i>
					<span>fa-cogs</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-comments">
					<i class="fa fa-comments"></i>
					<span>fa-comments</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-compass">
					<i class="fa fa-compass"></i>
					<span>fa-compass</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cube">
					<i class="fa fa-cube"></i>
					<span>fa-cube</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-cubes">
					<i class="fa fa-cubes"></i>
					<span>fa-cubes</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-dashboard">
					<i class="fa fa-dashboard"></i>
					<span>fa-dashboard</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-database">
					<i class="fa fa-database"></i>
					<span>fa-database</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-dot-circle-o">
					<i class="fa fa-dot-circle-o"></i>
					<span>fa-dot-circle-o</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-edit">
					<i class="fa fa-edit"></i>
					<span>fa-edit</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-envelope">
					<i class="fa fa-envelope"></i>
					<span>fa-envelope</span>
				</a>
			</div>
			<div class="fatype">
				<a href="javascript:;" data-fatype="fa fa-external-link">
					<i class="fa fa-external-link"></i>
					<span>fa-external-link</span>
				</a>
			</div>
		</div>
	</div>
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
		   		win.tip(data.msg);
		   	 //$.messager.alert('错误', data.msg);
			 return false;
		   }
		   win.reloadTable();
		 }
		});
		$(document).on('click', function(e) {
            var event = e || window.event,
                el = event.target || event.srcElement,
                cl = el.className.toLowerCase(),
                clid = el.id.toLowerCase();
            if (cl != "inputxt fonttype") {
                $("#fontTypeBox").hide();
            }
        });
        $("#fontTypetype").on('click', function() {
            $("#fontTypeBox").show();
        });
        $(".fatype a").on('click', function() {
        	$(".fatype a").removeClass('active');
        	$(this).addClass('active');
        	$("#fontTypetype").val($(this).attr('data-fatype'));
        	$("#fontTypeBox").hide();
        });
	});
	</script>
  </body>
</html>
