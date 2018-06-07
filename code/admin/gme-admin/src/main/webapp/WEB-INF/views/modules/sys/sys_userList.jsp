<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
	    <title>用户列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<%@ include file="/WEB-INF/views/include/head.jsp"%>
		<script type="text/javascript">
		  	$(function() {
		  		var roles=new Array();
			  	<c:if test="${not empty roles}">
			     	var object=new Object();
					<c:forEach items="${roles}" var="tem">
						object=new Object();object.id="${tem.id}";object.roleName="${tem.rolename}";roles[roles.length]=object;
					</c:forEach>
		    	</c:if> 
		    	
		  		$('#dataGrid').datagrid({
					url : '${ctx}/sys/sys_user/list',
					method: 'POST',
					title : '',
					iconCls : '',
					fit : true,
					fitColumns : true,
					pagination : true,
					rownumbers:true,
					pageSize : 20,
					pageList : [10,20,30,50],
					nowarp : false,
					border : true,
					idField : 'id',
					sortName : '',
					sortOrder : '',
					remotesort: true,
					singleSelect:true,
					toolbar:'#toolDiv',
					frozenColumns : [ [ 
							{
								title : '编号',
								field : 'id',
								hidden : true
							}
					 ]],
					columns : [ [ 
							{
								title : '登录名',
								field : 'username',
								align : 'left',
								width : 150
							},
							{
								title : '姓名',
								field : 'truename',
								align : 'left',
								width : 150
							},	
							{
								title : '手机号',
								field : 'phone',
								align : 'left',
								width : 100
							},	
							{
								title : '联系QQ',
								field : 'qq',
								align : 'left',
								width : 100
							},	
							{
								title : '邮箱',
								field : 'email',
								align : 'left',
								width : 150 
							},
							{
								title : '角色',
								field : 'roleid',
								align : 'left',
								width : 150,
								formatter:function (value, row, index){
									for(var i=0;i<roles.length;i++){
										if(roles[i].id==value){
											return roles[i].roleName; 
										}
									}
									return value;
								}
							},
							{
								title : '操作',
								field : '_opt',
								align : 'center',
								width : 100,
								formatter:function (value, row, index){
			                        var a = '';var b = '';var c = '';var d = '';
			                        var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
									<shiro:hasPermission name="sys:sys_user:view">
										a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/sys/sys_user/info?id='+row.id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
									</shiro:hasPermission>
									<shiro:hasPermission name="sys:sys_user:update">
										b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/sys/sys_user/toUpdate?id='+row.id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
									</shiro:hasPermission>
									<shiro:hasPermission name="sys:sys_user:delete">
										c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
									</shiro:hasPermission>
									<shiro:hasPermission name="sys:sys_user:update">
										d = "<li><a href='javaScript:void(0);' onclick='rsetPass(\""+row.id+"\",\""+row.username+"\");'><i class='fa fa-refresh'></i>重置密码</a></li>";
									</shiro:hasPermission>
			                        if(row.id!=1){
			                        	div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a><ul class="u-menu">' + a + b + c + d + '</ul></div>';
                        				return div;
			                        }
								}
							}
					] ]	,
					onClickRow: function (row) {
					}
				}).datagrid('getPager').pagination({
					showPageList : true,
					showRefresh : true
				});
		  	});
		  	function deleterow(id){
	            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/sys/sys_user/delete?id='+id,'dataGrid');
	        }
		  	function reloadTable(){
		  		try{	
					$('#dataGrid').datagrid('reload');	
				}catch(ex){
				}
		  	}
			function rsetPass(id,us){ 
				var paramsData="sys_user.id="+id+"&sys_user.username="+us;
				$.ajax({
					async : false,
					cache : false,
					type : 'POST',
					data : paramsData,
					url : '${ctx}/sys/sys_user/rsetPass',
					error : function() {
					},
					success : function(data) {
						var msg = data.msg;
						tip(msg);
					}
				});
			}
			function bustripsearch(){
				var queryParams=$('#dataGrid').datagrid('options').queryParams;
				$('#toolDivNew').find('*').each(function(){
					console.info($(this).val());
					queryParams[$(this).attr('name')]=$(this).val();
				});
				$('#dataGrid').datagrid({url:'${ctx}/sys/sys_user/list',pageNumber:1});
			}
			function searchReset(){ 
				$("#toolDivNew").find(":input").val("");bustripsearch();
			}
			function toAdd(){
				add('新增','${ctx}/sys/sys_user/toAdd','dataGrid',800,500);
			}
		</script>
	</head>
	<body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>后台用户管理</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
					<span>姓名:</span><input type="text" name="sys_user_vo.truename"/>
		   			<span>登录名:</span><input type="text" name="sys_user_vo.userName"/>
		   			<span>手机号码:</span><input type="text" name="sys_user_vo.phone"/>
		   			<shiro:hasPermission name="sys:sys_user:view">
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="sys:sys_user:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
