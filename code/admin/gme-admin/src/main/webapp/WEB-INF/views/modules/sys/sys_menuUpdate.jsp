<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
  <head>
    <title>菜单修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
  </head>
  <body>
  		<div class="easyui-tabs" data-options="tabWidth:112" style="width:100%;height:100%">
			<div title="编辑菜单" style="padding:10px">
				<div class="tabs-menu-box">
					<form id="formobj" action="${ctx}/sys/sys_menu/update" name="formobj" method="post" class="form-horizontal">
				 		<input type="hidden" id="btn_sub" class="btn_sub">
				 		<div class="control-group">
				        	<label class="control-label Validform_label">菜单名<font color="red">*</font>：</label>
					        <div class="controls">
					          	<input name="sys_menu.menuname" value="${item.menuname}" datatype="*1-200" class="inputxt" type="text">
					        </div>
				      	</div>
				      	<div class="control-group">
				        	<label class="control-label Validform_label">菜单地址：</label>
					        <div class="controls">
					          	<input name="sys_menu.menuurl" value="${item.menuurl}" datatype="*0-200" class="inputxt" type="text">
					        </div>
				      	</div>
				      	<div class="control-group">
				      		<label class="control-label Validform_label">
					            菜单排序<font color="red">*</font>：
					        </label>
					        <div class="controls">
					          	<input name="sys_menu.menusortno" value="${item.menusortno}" datatype="n" class="inputxt" type="text">
					        </div>
				      	</div>
				 		<div class="control-group">
				      		<label class="control-label Validform_label">
					            上级菜单<font color="red">*</font>：
					        </label>
					        <div class="controls">
					          	<select name="sys_menu.menufatherid"  class="select">
									<option value="0"> <c:if test="${item.menufatherid eq 0}">selected="selected"</c:if>>一级菜单</option>
									<c:if test="${not empty result}">
										<c:forEach items="${result}" var="tem">
											<option value="${tem.id}"> <c:if test="${item.menufatherid eq tem.id}">selected="selected"</c:if>>${tem.menuname}</option>
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
									<option value="1"> <c:if test="${item.isshow eq 1}">selected="selected"</c:if>>是</option>
									<option value="0"><c:if test="${item.isshow eq 0}">selected="selected"</c:if>>否</option>
								</select>
					        </div>
				      	</div>
				      	<div class="control-group">
				      		<label class="control-label Validform_label">
					            菜单样式：
					        </label>
					        <div class="controls">
					          	<input name="sys_menu.ico" readonly="readonly" class="inputxt fonttype" value="${item.ico}" datatype="*0-100" class="inputxt" id="fontTypetype">
					        </div>
				      	</div>
						<input type="hidden" name="sys_menu.id" value="${item.id}" />
					</form>
				</div>
			</div>
			<div title="权限列表" style="padding:10px">
				<div class="easyui-layout psflow-base-ui tabs-menu-persion" fit="true">
					<div region="center" title="权限列表">
						<div id="toolDiv" style="padding:2px 5px;">
							<div class="form-horizontal">
								<div class="control-group">
						        	<label class="control-label Validform_label">权限<font color='red'>*</font>：</label>
							        <div class="controls">
							          	<input name="sys_persion.persion" value="" id="persion" datatype="*1-200" class="inputxt" type="text">
							        </div>
						      	</div>
						      	<div class="control-group">
						        	<label class="control-label Validform_label">权限描述<font color='red'>*</font>：</label>
							        <div class="controls">
							          	<input name="sys_persion.persiondec" id="persiondec" value="" datatype="*1-200" class="inputxt" type="text">
							        </div>
						      	</div>
						      	<div class="control-group">
						      		<label class="control-label Validform_label">
							            &nbsp;&nbsp;&nbsp;
							        </label>
							        <div class="controls">
							          	<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn">
							          	<!-- <i class="fa fa-fw fa-plus"></i> -->
							          	添加</a>
							        </div>
						      	</div>
							</div>
					    </div>
						<table id="dataGrid1"></table>
					</div>
				</div>
			</div>
		</div>
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
	  $(function(){
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
	  	 $("#toolDiv").Validform({
			  tiptype:4,
			  btnSubmit:"#addBtn",
			  ajaxPost:true,
			  beforeSubmit:function(curform){
			  	var postData="sys_persion.mid=${item.id}&sys_persion.persion="+$("#persion").val()+"&sys_persion.persiondec="+$("#persiondec").val();
			  	$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data:postData,
					url : '${ctx}/sys/sys_persion/add',
					error : function() {
					},
					success : function(data) {
						tip(data.msg);
						if (data.success) {
							$("#persion").val("");$("#persiondec").val("");
							$('#dataGrid1').datagrid('reload');	
						}
					}
				});
				return false;
			  },
			 callback:function(data){
			 }
		 });
		 
		  $("#formobj").Validform({
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
			});
			
			$("#dataGrid1").datagrid({
		        fit : true,
		        collapsible: true,
		        singleSelect: true,
		        fitColumns : true,
		        toolbar:'#toolDiv',
		        url:'${ctx}/sys/sys_persion/list?sys_persion_vo.mid=${item.id}',
		        columns: [[
		        	{ field: 'id', title: '',hidden : true},
		            { field: 'persion', title: '权限', width: 200},
		            { field: 'persiondec', title: '权限描述', width: 200},
		            { field: '_opt', title: '操作', width: 200,
			            formatter:function (value, row, index){	
			            	return '<a href="javaScript:void(0);" onclick="createDeleteDialog( \'${ctx}/sys/sys_persion/delete?id='+row.id+'\');">[删除]</a>';
			            }
		            }
		        ]],
		        onClickRow:function(rowIndex,rowData){
		        }
		    });
		    
		});
		function reloadTable(){
	  		try{	
				$('#dataGrid1').datagrid('reload');	
			}catch(ex){
			}
	  	}
	  	function createDeleteDialog(url) {
	  		$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : url,
				error : function() {
				},
				success : function(data) {
					if (data.success) {
						var msg = data.msg;
						$.dialog.setting.zIndex = 4980;
						tip(data.msg);
						$('#dataGrid1').datagrid('reload');	
					}else{
						tip(data.msg);
						var msg = data.msg;
						$.dialog.setting.zIndex = 4980;
					}
				}
			});
		}
	</script>
  </body>
</html>
