(function(){
	"use strict";
	var rule = {
		editRule:function(title,content,width,type,data){
			//type :1编辑 || 2添加 || 3删除
			var dialog = top.dialog.get(window);
			//var contents = $('#rulesNav').html();
			//$("#ruleContentss").html(createRuleNavDom());
			var showDialog = top.dialog({
				//url: '<%=basePath%>/papp/management/rules.jsp',
				content: content,//$('#ruleContent').html(),
				title: title,//'编辑角色',
				width: width,
				id: 'relusDemo',
				/*onclose: function () {
					this.returnValue && $('#input').val(this.returnValue);
					dialog.focus();
				},*/
				cancelValue:"取&nbsp;消",
				okValue:"确&nbsp;定",
				oniframeload: function () {
					console.log("frfgerths");
				},
				ok: function () {
					/*alert("html:::::"+rule.getDataInDialog());
					alert($("#ruleContentss").html());*/
					//alert("$::"+$("#nroleName",window.parent.document).val());
					switch(type){
						case 1:
							rule.editRoles(data);
							break;
						case 2:
							rule.addRoles(data);
							break;
						case 3:
							rule.deleteRoles(data);
							break;
						default:
							break;		
					}
					//rule.ruleEditSave();
					rule.ctipRemove();
					//return false;  //阻止弹窗关闭
				},
			    cancel: function () {
			        console.log('取消');
			        rule.ctipRemove();
			    }
			});
			showDialog.showModal();
		},
		//编辑角色
		editRoles:function(data){
			var roleName = $("#nroleName",window.parent.document).val(),
				roleInfo = $("#nroleInfo",window.parent.document).val(),
				ele = $("#rulesNav .rules").eq((data-1)),
				elea = ele.find("a");
			elea.text(roleName);
			//alert("mingch::"+roleName+"|||||nshuom::"+roleInfo+"LLLdtata:::"+ele.html());

		},
		//添加角色
		addRoles:function(data){
			var roleName = $("#nroleName",window.parent.document).val(),
				roleInfo = $("#nroleInfo",window.parent.document).val();
			$("#rulesNav").append('<div class="rules"><div class="rulesT"><a href="###">'+roleName+'</a></div></div>');
			//alert("mingch::"+roleName+"||||||shuom::"+roleInfo+"LLLdtata:::"+data);
		},
		//删除角色
		deleteRoles:function(data){
			var ele = $("#rulesNav .rules").eq((data-1));
			ele.remove();
		},
		rulesqxSelectAll:function(obj){
			var pa = $(obj).attr('data-parentid'),
				a = $("#"+pa).find('a'),
				ase = $("#"+pa).find('.ruleactive');
			if (a.length == ase.length) {
				$(obj).addClass('btn-danger');
			} else {
				$(obj).removeClass('btn-danger');
			}
		},
		rulesqxDontSelect:function(obj){
			var pa = $(obj).attr('data-parentid'),
				a = $("#"+pa).find('a'),
				sa = $("#"+pa).find('.selected-all');
			if ($(obj).hasClass('btn-danger')) {
				$(obj).removeClass('btn-danger');
				a.removeClass('ruleactive');
				sa.removeClass('btn-danger');
			} else {
				$(obj).addClass('btn-danger');
				a.addClass('ruleactive');
				sa.addClass('btn-danger');
			}
		},
		ruleqxHover:function(obj){
			if ($(obj).hasClass('ruleactive')) {
				$(obj).removeClass('ruleactive');
			} else {
				$(obj).addClass('ruleactive');
			}
			var objs = $(obj).parent("dd").parent("dl"),
				obj = objs.siblings(".select-all").find(".selected-all");
			rule.rulesqxSelectAll(obj);
		},
		ruleqxSave:function(){
			var menuObj = $("#rulesManageBox"),
				selectRules = menuObj.find('.ruleactive'),
				pid = [],
				ppid = [],
				selectTexts = [];
			for (var i = 0; i < selectRules.length; i++) {
				pid.push($(selectRules[i]).attr("data-pid")),
				ppid.push($(selectRules[i]).attr("data-ppid"));
				selectTexts.push($(selectRules[i]).attr("data-text"));
			}
			//pid = unique(pid);
			//ppid = unique(ppid);
			console.log(pid);
			console.log(ppid);
			console.log(selectTexts);
		},
		eventFire:function(){
			_fireEventer("click","#ruleqxSave", function() {
				rule.ruleqxSave();
			});
			
			$(".selected-all").on('click', function() {
				rule.rulesqxDontSelect(this);
			});
			$(".ruleqx").on('click', function() {
				rule.ruleqxHover(this)
			});
			$(".editRole").on('click', function(event) {
				event.preventDefault();
				var id = $(this).attr("id"),
					title = null,
					content = null,
					width = 500,
					type = 1,
					data = $("#editRuleGroup").data("index"),
					roleName = $("#editRuleGroup").data("rolename");
				switch(this.id){
					case "editRule":
						title = "编辑角色";
						content = '<div class="form-horizontal" id="roleEditBox"><div class="form-group"><label class="col-sm-2 control-label">角色名称:</label><div class="col-sm-6"><input type="text" class="form-control" id="nroleName" value='+roleName+' placeholder="角色名称" data-maxlength="12" requied="requied" data-vtype="string"></div><div class="col-sm-2"><div class="input-tip"><span class="redword">*</span></div></div></div><div class="form-group"><label for="input2" class="col-sm-2 control-label">说明:</label><div class="col-sm-6"><input type="text" id="nroleInfo" class="form-control" placeholder="说明"></div><div class="col-sm-2"><div class="input-tip"></div></div></div></div>';
						type = 1;
						break;
					case "addRule":
						title = "添加角色";
						content = '<div class="form-horizontal" id="roleEditBox"><div class="form-group"><label class="col-sm-2 control-label">角色名称:</label><div class="col-sm-6"><input type="text" class="form-control" id="nroleName" placeholder="角色名称" data-maxlength="12" requied="requied" data-vtype="string"></div><div class="col-sm-2"><div class="input-tip"><span class="redword">*</span></div></div></div><div class="form-group"><label for="input2" class="col-sm-2 control-label">说明:</label><div class="col-sm-6"><input type="text" id="nroleInfo" class="form-control" placeholder="说明"></div><div class="col-sm-2"><div class="input-tip"></div></div></div></div>';
						type = 2;
						break;
					case "deleteRule":
						title = "删除角色";
						content = '<p>你确定要删除该角色吗？</p>';
						width = 280,
						type = 3;
						break;
				};
				rule.editRule(title,content,width,type,data);
				formValidateInDialog("roleEditBox");
			});
		},
		ctipRemove:function(){
			var ctip = $("body",window.parent.document).find(".cui-tooltip");
			ctip.remove();
		},
		ruleEditSave:function(){
			//编辑好角色后，保存数据，更新dom
			var valArr = rule.getDataInDialog(),
				demo = '';
			for (var i = 0; i < valArr.length; i++) {
				demo += '<div class="rules"><div class="rulesT"><a href="###" class="">'+valArr[i]+'</a></div></div>';
			}
			$("#rulesNav").html(demo);
		},
		getDataInDialog:function(){
			var dialogWin = $("body",window.parent.document),
				ruleContentss = dialogWin.find("#ruleContentss"),
				input = ruleContentss.find("input[data-input='rule']"),
				values = [],
				valObj = {};
			for (var i = 0; i < input.length; i++) {
				var val = $(input[i]).val();
				/*if ($.trim(val) == "") {
					$(input[i]).tooltip({
						trigger	: "none",
				    	position: "right",
				    	content : "该项是必填项",
				    	space   : 5
					});
					return false;
				}*/
				values.push(val);
			}	
			return values;
		},
		fireRuleEGEvents:function(){
			var top = 10;
			$("#rulesNav").on("mouseenter",".rules",function(){
				top = $(this).position().top;
				var index = $(this).index(),
					roleName = $(this).find("a").text();
				$("#editRuleGroup").show().css("top",top+"px").data("index",index).data("rolename",roleName);
			})
			.on('click', 'a', function(event) {
				event.preventDefault();
				$("#rulesNav").find("a").removeClass('active');
				$(this).addClass('active');
			});

			$("#rulesNav").hover(function(){
				$("#editRuleGroup").show();
			},function(){
				$("#editRuleGroup").hide();
			});
		}
	};
	/*function getRulesNav(){
		var rulesn = $("#rulesNav").find("a"),
			rulesns = [];
		for (var i = 0; i < rulesn.length; i++) {
			rulesns.push($(rulesn[i]).text());
		}
		return rulesns;
	}
	function createRuleNavDom(){
		var rulesns = getRulesNav(),
			html = '<div class="form-group" id="ruleContentsss"><div class="col-sm-12" id="erhtml">';
		for (var i = 0; i < rulesns.length; i++) {
			html += '<div class="srelusinput"><input type="text" data-input="rule" disabled="disabled" class="form-control col-sm-8 relusedit-input" value='+rulesns[i]+' requied="requied" data-vtype="string"><a href="javascript:;" class="btn btn-default deleteminus" title="删除"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></a></div>';
		}
		html += '</div></div>';
		return html;
	}

	function addHtml(){
		var html = '<div class="srelusinput"><input type="text" data-input="rule" class="form-control col-sm-8 relusedit-input" value="新建角色" requied="requied" data-vtype="string"><a href="javascript:;" class="btn btn-default deleteminus" style="display:inline-block" title="删除"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></a></div>';
		var dialogWin = $("body",window.parent.document),
			erhtml = dialogWin.find("#erhtml");
		erhtml.append(html);
	}

	function editRules(){
		var ruleContentss = $("body",window.parent.document).find("#ruleContentss"),
			input = ruleContentss.find('input');
		input.removeAttr('disabled');
	}

	function fireEventsInDialog(){
		
		$("body",window.parent.document).on('click', '.deleteminus', function(event) {
			$(this).parent(".srelusinput").remove();
			formValidateInDialog();
			event.preventDefault();
			
		});
		$("body",window.parent.document).on('click','#deleteRule', function(event) {
			var ruleContentss = $("body",window.parent.document).find("#ruleContentss");
			ruleContentss.find(".deleteminus").css("display","inline-block");
			formValidateInDialog();
			event.preventDefault();
		});
		$("body",window.parent.document).on('click','#addRule', function(event) {
			addHtml();
			formValidateInDialog();
			event.preventDefault();
		});
		$("body",window.parent.document).on('click','#editRules', function(event) {
			editRules();
			formValidateInDialog();
			event.preventDefault();
		});

	}*/

	function formValidateInDialog(id){
		var pform = $("body",window.parent.document).find("#"+id),
			input = pform.find("input");
		console.log("input::"+input.size());
		input.formValidate({
			"e":"input",
			"parentwindow":pform
		});
	}
	
	$(function(){
		rule.eventFire();
		rule.fireRuleEGEvents();
		//fireEventsInDialog();
	})
})();