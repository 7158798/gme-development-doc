<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>GME后台管理管理平台</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
    <script type="text/javascript" charset="utf-8" src="${ctxStatic}/jschart/jscharts.js"></script>
    <script type="text/javascript">
	  	$(function() {
	  		
	  	});
	</script>
  </head>
<body style="overflow:hidden;">
  	<div class="easyui-panel" data-options="fit:true">
  		<div class="psflow-panpel-maintitle" style="border:1px solid #dcdcdc">
			<h2 class="psflow-panpel-title"><span>平台数据总汇</span></h2>
		</div>
		
		<div id="graph" align= "center">交易量月度报表</div>

		<script type="text/javascript">
			var myData = new Array(['2017年1月', 69.5], ['2017年2月', 2.8], ['2017年3月', 5.6], ['2017年4月', 2.8], ['2017年5月', 14.6], ['2017年6月', 20.7], ['2017年7月', 19], ['2017年8月', 1.9], ['2017年9月', 9], ['2017年10月', 15], ['2017年11月', 50], ['2017年12月', 1.9]);
			var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55'];
			var myChart = new JSChart('graph', 'bar');
			myChart.setDataArray(myData);
			myChart.colorizeBars(colors);
			myChart.setTitle('网站月度交易量统计表');
			myChart.setTitleColor('#8E8E8E');
			myChart.setAxisNameX('单位：万元');
			myChart.setAxisNameY('%');
			myChart.setAxisColor('#c6c6c6');
			myChart.setAxisWidth(1);
			myChart.setAxisNameColor('#9a9a9a');
			myChart.setAxisValuesColor('#939393');
			myChart.setAxisPaddingTop(60);
			myChart.setAxisPaddingLeft(50);
			myChart.setAxisPaddingBottom(60);
			myChart.setTextPaddingBottom(20);
			myChart.setTextPaddingLeft(15);
			myChart.setTitleFontSize(11);
			myChart.setBarBorderWidth(0);
			myChart.setBarSpacingRatio(50);
			myChart.setBarValuesColor('#737373');
			myChart.setGrid(true);
			myChart.setSize(1024, 524);
			myChart.setBackgroundImage('chart_bg.jpg');
			myChart.draw();
		</script>
  	</div>
  </body>
</html>
