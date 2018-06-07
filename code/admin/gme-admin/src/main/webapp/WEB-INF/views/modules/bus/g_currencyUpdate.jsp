<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种表（g_currency）
功能描述：存储币种信息。修改</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>  
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
		   	  tip(data.msg);
			  return false;
		   }
		   win.reloadTable();
		 }
		});});
	</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/bus/g_currency/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">顺序号，递增<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_sn" value="${item.currency_sn}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_symbol" value="${item.currency_symbol}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_desc" value="${item.currency_desc}" class="inputxt"  datatype="*1-500"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种图标<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.icon_id" value="${item.icon_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">中文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.name_cn" value="${item.name_cn}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">英文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.name_en" value="${item.name_en}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">启用日期<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.enable_time" value="${item.enable_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币0-不是;1-是;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.is_token" value="${item.is_token}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">操作者编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.operator_uid" value="${item.operator_uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">操作者<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.operator_name" value="${item.operator_name}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">提现配置编号；存储币种提现配置表（g_withdrawal_config）的config_id<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_config_id" value="${item.currency_config_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.is_open" value="${item.is_open}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">1-启用(默认);2-冻结;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.is_enable" value="${item.is_enable}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">发行量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.supply" value="${item.supply}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">流通总量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.circulation" value="${item.circulation}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.version" value="${item.version}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.create_time" value="${item.create_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.updated_time" value="${item.updated_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_currency.currency_id" value="${item.currency_id}"/>
	</form>
  </body>
</html>
