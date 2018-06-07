<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
  <head>
    <title>菜单详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<style type="text/css">
		.panel-header{
			display: none;
		}
		.panel-header, .panel-body{
			border-width: 0px;
		}
	</style>
  </head>
  <body style="margin-top: 10px;">
     <div class="easyui-layout psflow-base-ui" fit="true">
			<div region="north"  split="true" style="height: 140px;" >
			  	<table style="width: 100%" cellpadding="0" cellspacing="1" class="formtable" >
					<tbody>
						<tr>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									菜单名：
								</label>
							</td>
							<td class="value" width="35%">
								${item.menuname}
							</td>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									菜单地址：
								</label>
							</td>
							<td class="value" width="35%">
								${item.menuurl}
							</td>
						</tr>
						<tr>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									菜单排序：
								</label>
							</td>
							<td class="value" width="35%">
								${item.menusortno}
							</td>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									父类菜单：
								</label>
							</td>
							<td class="value" width="35%">
								<c:if test="${item.menufatherid eq 0}">一级菜单</c:if>
								<c:if test="${not empty result}">
									<c:forEach items="${result}" var="tem">
										<c:if test="${item.menufatherid eq tem.id}">${tem.menuname}</c:if>
									</c:forEach>
								</c:if>
							</td>
						</tr>
						<tr>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									是否显示：
								</label>
							</td>
							<td class="value" width="35%">
								<c:if test="${item.isshow eq 1}">是</c:if>
								<c:if test="${item.isshow eq 0}">否</c:if>
							</td>
							<td align="right" height="40" width="15%">
								<label class="Validform_label">
									ICO图标：
								</label>
							</td>
							<td class="value" width="35%">
								${item.ico}
							</td>
					</tbody>
				</table>
		</div>
		<div region="center" title="权限列表">
			<table id="dataGrid1"></table>
		</div>
	</div>
	<script type="text/javascript">
	  $(function(){
			$("#dataGrid1").datagrid({
		        fit : true,
		        collapsible: true,
		        singleSelect: true,
		        fitColumns : true,
		        url:'${ctx}/sys/sys_persion/list?sys_persion_vo.mid=${item.id}',
		        columns: [[
		        	{ field: 'id', title: '',hidden : true},
		            { field: 'persion', title: '权限', width: 200},
		            { field: 'persiondec', title: '权限描述', width: 200}
		        ]],
		        onClickRow:function(rowIndex,rowData){
		        }
		    });
		    
		});
	</script>
  </body>
</html>
