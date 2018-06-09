<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>币种表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_currency/list',
				method: 'POST',
				title : '',
				iconCls : '',
				fit : true,
				fitColumns : true,
				pagination : true,
				rownumbers:true,
				pageSize : 20,
				pageList : [ 10,20,30 ],
				nowarp : false,
				border : false,
				idField : 'currency_id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'currency_id',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '顺序号',
						field : 'currency_sn',
						width : 150,
						align : 'center'
					},
					{
						title : '币种符号',
						field : 'currency_symbol',
						width : 150,
						align : 'center'
					},
					{
						title : '币种描述',
						field : 'currency_desc',
						width : 150,
						align : 'center'
					},
					{
						title : '币种图标',
						field : 'icon_id',
						width : 150,
						align : 'center'
					},
					{
						title : '中文名',
						field : 'name_cn',
						width : 150,
						align : 'center'
					},
					{
						title : '英文名',
						field : 'name_en',
						width : 150,
						align : 'center'
					},
					{
						title : '启用日期',
						field : 'enable_time',
						width : 150,
						align : 'center'
					},
					{
						title : '是否是媒介币',
						field : 'is_token',
						width : 150,
						align : 'center',
						formatter : function(value, row, index)
						 {
							if(value=="0")
							{
								return "<font>不是</font>";
							}if(value=="1")
							{
								return "<font>是</font>";
							}
							return value;
						}
					},
					{
						title : '操作者编号',
						field : 'operator_uid',
						width : 150,
						align : 'center'
					},
					{
						title : '操作者',
						field : 'operator_name',
						width : 150,
						align : 'center'
					},
					{
						title : '提现配置编号',
						field : 'currency_config_id',
						width : 150,
						align : 'center'
					},
					{
						title : '充值/提现',
						field : 'is_open',
						width : 150,
						align : 'center',
						formatter : function(value, row, index)
						 {
							if(value=="12")
							{
								return "<font>充值</font>";
							}if(value=="21")
							{
								return "<font>提现</font>";
							}
							return value;
						}
					},
					{
						title : '启用/冻结',
						field : 'is_enable',
						width : 150,
						align : 'center',
						formatter : function(value, row, index)
						 {
							if(value=="1")
							{
								return "<font>启用</font>";
							}if(value=="2")
							{
								return "<font>冻结</font>";
							}
							return value;
						}
					},
					{
						title : '发行量',
						field : 'supply',
						width : 150,
						align : 'center'
					},
					{
						title : '流通总量',
						field : 'circulation',
						width : 150,
						align : 'center'
					},
					{
						title : '创建时间',
						field : 'create_time',
						width : 150,
						align : 'center'
					},
					{
						title : '更新时间',
						field : 'updated_time',
						width : 150,
						align : 'center'
					},
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
                        var a = '';var b = '';var c = '';
                        var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
						<shiro:hasPermission name="bus:g_currency:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_currency/info?id='+row.currency_id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_currency:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_currency/toUpdate?id='+row.currency_id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_currency:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.currency_id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
						</shiro:hasPermission>
                        div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a><ul class="u-menu">' + a + b + c + '</ul></div>';
            			return div;
					}
				}
				] ],
				onClickRow : function(rowIndex, rowData) {
				}
			}).datagrid('getPager').pagination({
				showPageList : true,
				showRefresh : true
			});
	  	});
	  	function reloadTable(){
	  		try{	
				$('#dataGrid').datagrid('reload');	
			}catch(ex){
			}
	  	}
  		function deleterow(id){
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_currency/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
	  		timeCompare();
  		
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_currency/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_currency/toAdd','dataGrid',800,500);
		}
		function timeCompare(){
			var bg = $("#bg_create_date").val();
			var ed = $("#end_create_date").val();
			var start = new Date(bg.replace("-", "/").replace("-", "/"));  
			var end = new Date(ed.replace("-", "/").replace("-", "/"));  
			if(bg!=null && ed!=null){
				if(end<start){    
					alert("开始时间不能小于结束时间!");
    				return false;    
				}  
			}
		}
		
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>币种表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_currency:view">
		   			<span>币种符号:</span><input type="text" name="g_currency_vo.currency_symbol" >
		   			<span>是否是媒介币:</span>
		   			<select name="g_currency_vo.is_token">
			   				<option value="">--请选择--</option>
			   				<option value="1">是</option>
			   				<option value="0">不是</option>
			   		</select>
			   		<span>充值/提现:</span>
			   		<select name="g_currency_vo.is_open">
			   				<option value="">--请选择--</option>
			   				<option value="0102">充值</option>
			   				<option value="0201">提现</option>
			   		</select>
			   		<span>启用/冻结:</span>
			   		<select name="g_currency_vo.is_enable">
			   				<option value="">--请选择--</option>
			   				<option value="1">启用</option>
			   				<option value="2">冻结</option>
			   		</select>
		   			<span>启用开始结束时间</span><input id="bg_create_date" name="bg_create_date" class="Wdate"    onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
		   			-<input name="end_create_date" id="end_create_date" class="Wdate"   onblur="timeCompare()"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_currency:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
