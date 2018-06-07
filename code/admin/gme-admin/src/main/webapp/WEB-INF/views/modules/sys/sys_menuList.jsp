<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
  <head>
    <title>菜单列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<style type="text/css">
		.datagrid-htable tbody tr{ height: 39px; }
		.datagrid-header-row, .datagrid-row {height: 39px;}
		.datagrid-header td,.datagrid-body td{ padding: 0px 0px; background-color: #fefefe;}
	</style>
	<script type="text/javascript">
		var tin = 0;
	  	$(function() {
	  		$('#dataGrid').treegrid({
				url : '${ctx}/sys/sys_menu/list',
				method: 'POST',
				fit:true,
				title:'菜单列表',
				treeField:'menuname',
				idField:'id',
				fitColumns:true,
				border : true,
				toolbar:'#toolDiv',
				rownumbers:true,
				columns : [ [ 
				{
					title : '菜单名',
					field : 'menuname',
					align : 'left',
					width : 150
				},	
				{
					title : '菜单地址',
					field : 'menuurl',
					align : 'left',
					width : 250
				},	
				{
					title : '菜单排序',
					field : 'menusortno',
					align : 'left',
					width : 100
				},
				{
					title : '菜单样式',
					field : 'ico',
					align : 'left',
					width : 150
				},
				{
					title : '是否显示',
					field : 'isshow',
					align : 'left',
					formatter:function (value, row, index){
						return value=="1"?"是":"否";
					}
				},
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
						var a = '';var b = '';var c = '';
						var div = '<div class="dropdown-table" data-row="'+tin+'">'+ '<a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i>&nbsp;&nbsp;</a>';
						tin++;
						<shiro:hasPermission name="sys:sys_menu:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/sys/sys_menu/info?id='+row.id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sys_menu:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/sys/sys_menu/toUpdate?id='+row.id+'\',\'dataGrid\',null,null)"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sys_menu:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
						</shiro:hasPermission>
						div = div + '<ul class="u-menu">' + a + b + c +'</ul></div>';
                        return div;
					}
				}
				] ]
			});
	  	});
        function deleterow(id){
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/sys/sys_menu/delete?id='+id,'dataGrid');
        }
	  	function reloadTable(){
	  		tin = 0;
	  		try{	
				$('#dataGrid').treegrid('reload');	
			}catch(ex){
			}
	  	}
	</script>
  </head>
<body class="psflow-panpel-body psflow-menu-body">
		<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>菜单列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
					<shiro:hasPermission name="sys:sys_menu:add">
						<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="add('新增','${ctx}/sys/sys_menu/toAdd','dataGrid',null,null);"><i class="fa fa-fw fa-plus"></i>添加</a>
					</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
