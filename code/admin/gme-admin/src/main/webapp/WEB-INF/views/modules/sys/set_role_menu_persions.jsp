<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.manage.sys.vo.SysMenuPersions"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>设置权限</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<style>
	table tr td{ padding: 2px 5px; }
	table tr td button{ border: 0px; display: inline-block; padding: 3px 5px; background-color: #F2F7FE; color: #353535; cursor: pointer; outline: none; }
	table tr td button.active{ background-color: #64a9d8; color: #fff; }
	</style>
  </head>
  <body>
		<div style="width: 100%" class="formtable" id="formtable">
			<div class="persion-wrap">
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="tem">
					<div class="persion-one">
						<button id="${tem.id}" <c:if test="${tem.isCheck eq 1}">class="active"</c:if>>
							${tem.menuName}
						</button>
					</div>
					<c:if test="${not empty tem.childrens}">
						<c:forEach items="${tem.childrens}" var="tem1">
						
							<c:if test="${tem1.id eq 2 and rid eq 1}">
								<div class="persion-two">
									<div class="blank-icn"></div>
									<div class="persion-thcon">
										<button id="${tem.id}_${tem1.id}" <c:if test="${tem1.isCheck eq 1}">class="active"</c:if>>
											${tem1.menuName}
										</button>
									</div>
								</div>
								<c:if test="${not empty tem1.childrens}">
									<div class="persion-th">
										<div class="blank-icn blank-icn-two"></div>
										<div class="persion-thcon">
			    							<c:forEach items="${tem1.childrens}" var="tem2">
		                                   		<button id="${tem.id}_${tem1.id}_${tem2.id}" <c:if test="${tem2.isCheck eq 1}">class="active"</c:if>>
			                                   		${tem2.menuName}
		                                   		</button>
			                                </c:forEach>
										</div>
									</div>
								</c:if>
							</c:if>
							
							<c:if test="${tem1.id ne 2}">
								<div class="persion-two">
									<div class="blank-icn"></div>
									<div class="persion-thcon">
										<button id="${tem.id}_${tem1.id}" <c:if test="${tem1.isCheck eq 1}">class="active"</c:if>>
											${tem1.menuName}
										</button>
									</div>
								</div>
								<c:if test="${not empty tem1.childrens}">
									<div class="persion-th">
										<div class="blank-icn blank-icn-two"></div>
										<div class="persion-thcon">
			    							<c:forEach items="${tem1.childrens}" var="tem2">
		                                   		<button id="${tem.id}_${tem1.id}_${tem2.id}" <c:if test="${tem2.isCheck eq 1}">class="active"</c:if>>
			                                   		${tem2.menuName}
		                                   		</button>
			                                </c:forEach>
										</div>
									</div>
								</c:if>
							</c:if>
							
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:if>
			</div>
		</div>
		<form id="formobj" action="${ctx}/sys/sys_role/addRoleMenu" name="formobj" method="post">
	 		<input type="hidden" id="btn_sub" class="btn_sub">
			<input type="hidden" name="sys_role_vo.id" value="${rid}"/>
			<div id="otherP"></div>
		</form>
		<script type="text/javascript">
		$(function(){
			$("#formobj").Validform({
				tiptype:4,
				btnSubmit:"#btn_sub",
				btnReset:"#btn_reset",
				ajaxPost:true,
				beforeSubmit:function(){
				  	var j=0;var val="";
				  	$("#formtable button").each(function(i){
		  				var tid=$(this).attr("id");
		  				var tids=tid.split("_");
		  				if(tids.length==1 && $("#"+tid).hasClass('active')){
		  					var t="1_0_"+tid+",";
		  					val+=t;
		  					j++;
		  				}if(tids.length==2 && $("#"+tid).hasClass('active')){
		  					var t="1_"+tids[0]+"_"+tids[1]+",";
		  					val+=t;
		  					j++;
		  				}if(tids.length==3 && $("#"+tid).hasClass('active')){
		  					var t="2_"+tids[1]+"_"+tids[2]+",";
		  					val+=t;
		  					j++;
		  				}
		  			});
		  			$("#otherP").append("<input type='hidden' name='sys_role_vo.menuIds' value='"+val+"'/>");
		  			return true;
				},
				callback:function(data){
				   	var win = frameElement.api.opener;
				   	if(data.success==true){
					  	frameElement.api.close();
					  	win.tip(data.msg);
				   	}else{
				   	 	$.messager.alert('错误', data.msg);
					 	return false;
				    }
				   win.reloadTable();
				}
			});
			$("#formtable button").on('click', function() {
				checkbtn(this);
			});
		});

	  	function inputChecked(input,ids,tids_i,ids_i,dd){
			for (var i = 0,j = input.size(); i < j; i++) {
				var tid=$(input[i]).attr("id");
				var tids=tid.split("_");
				if(tids[tids_i]==ids[ids_i]){
					if (dd) {
						$(input[i]).removeClass("active");
					} else {
						$(input[i]).addClass('active'); 
					}
				}
			}
	  	}

	  	function checkbtn(obj){
	  		var id = $(obj).attr("id");
	  		var ids = id.split("_");
	  		var input = $("button");
	  		if(ids.length==1){
	  			if(!$(obj).hasClass("active")){
	  				inputChecked(input,ids,0,0);
	  			}else{
	  				inputChecked(input,ids,0,0,true);
	  			}
	  		} else if(ids.length==2){
	  			if(!$(obj).hasClass("active")){
	  				inputChecked(input,ids,1,1);
		  			$("#"+ids[0]).addClass('active'); 
	  			}else{
	  				inputChecked(input,ids,1,1,true);
		  			var t1=false;
		  			for (var ii = 0,jj = input.size(); ii < jj; ii++) {
		  				var tid = $(input[ii]).attr("id");
		  				var tids = tid.split("_");
		  				if(tids.length == 2){
			  				if(tids[0]==ids[0] && $("#"+tid).hasClass('active')){
			  					t1 = true;
			  					break;
			  				}
			  			}
		  			}
		  			if(!t1){
		  				$("#"+ids[0]).removeClass('active'); 
		  			} 
	  			}
	  		} else if(ids.length==3){
	  			if (!$(obj).hasClass('active')) {
	  				$(obj).addClass('active');
		  			$("#"+ids[0]+"_"+ids[1]).addClass('active');
		  			$("#"+ids[0]).addClass('active');
	  			} else {
	  				$(obj).removeClass('active');
	  				var t1 = false;
	  				var t2 = false;
	  				for (var ii = 0,jj = input.size(); ii < jj; ii++) {
		  				var tid = $(input[ii]).attr("id");
		  				var tids = tid.split("_");
		  				if(tids.length == 3){
			  				if(tids[1]==ids[1] && $("#"+tid).hasClass("active")){
			  					t1 = true;
			  					break;
			  				}
			  			}
		  			}			
		  			if(!t1){
		  				$("#"+ids[0]+"_"+ids[1]).removeClass('active'); 
		  				for (var iii = 0,jjj = input.size(); iii < jjj; iii++) {
			  				var tid = $(input[iii]).attr("id");
			  				var tids = tid.split("_");
			  				if(tids.length == 2){
				  				if(tids[0]==ids[0] && $("#"+tid).hasClass("active")){
				  					t2 = true;
				  					break;
				  				}
				  			}
			  			}
			  			if(!t2){
			  				$("#"+ids[0]).removeClass('active'); 
			  			} 
		  			}
	  			}
	  		}
	  	}
	</script>
  </body>
</html>
