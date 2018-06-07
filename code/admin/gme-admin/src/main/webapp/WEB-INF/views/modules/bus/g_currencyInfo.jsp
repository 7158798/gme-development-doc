<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种表（g_currency）
功能描述：存储币种信息。详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">顺序号，递增：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_sn}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种符号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_symbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_desc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种图标：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.icon_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">中文名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.name_cn}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">英文名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.name_en}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">启用日期：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.enable_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币0-不是;1-是;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.is_token}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作者编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.operator_uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作者：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.operator_name}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提现配置编号；存储币种提现配置表（g_withdrawal_config）的config_id：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_config_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.is_open}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">1-启用(默认);2-冻结;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.is_enable}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">发行量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.supply}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">流通总量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.circulation}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">备注：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.remark}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.version}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.create_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updated_time}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
