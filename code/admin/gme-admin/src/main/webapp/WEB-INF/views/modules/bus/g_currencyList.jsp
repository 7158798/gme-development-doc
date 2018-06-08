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
						title : '顺序号，递增',
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
						title : '是否是媒介币0-不是;1-是;',
						field : 'is_token',
						width : 150,
						align : 'center'
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
						title : '提现配置编号；存储币种提现配置表（g_withdrawal_config）的config_id',
						field : 'currency_config_id',
						width : 150,
						align : 'center'
					},
					{
						title : '充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;',
						field : 'is_open',
						width : 150,
						align : 'center'
					},
					{
						title : '1-启用(默认);2-冻结;',
						field : 'is_enable',
						width : 150,
						align : 'center'
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
						title : '备注',
						field : 'remark',
						width : 150,
						align : 'center'
					},
					{
						title : '数据表版本,默认1',
						field : 'version',
						width : 150,
						align : 'center'
					},
					{
						title : '创建时间格式:yyyy-MM-dd HH:ss:mm',
						field : 'create_time',
						width : 150,
						align : 'center'
					},
					{
						title : '更新时间格式:yyyy-MM-dd HH:ss:mm',
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
