function is_old_ie() {
	return !0
}

function request_page(t) {
	window.location = t
}

function reload_page() {
	location.reload()
}

function show_message(t) {
	alert(t)
}

function show_hide_obj(t) {
	"visible" == t.style.visibility ? t.style.visibility = "hidden" : t.style.visibility = "visible"
}

function check_miner_name(t) {
	return !(t.length > 15) && (reg = new RegExp("^[a-zA-Z0-9__]+$"), !!reg.test(t))
}

function is_email(t) {
	return /^(?:[a-z\d]+[_\-\+\.]?)*[a-z\d]+@(?:([a-z\d]+\-?)*[a-z\d]+\.)+([a-z]{2,})+$/i.test(t)
}

function check_username(t) {
	return !!/^[a-zA-Z0-9\_@.]+$/.test(t)
}

function GetBrowserType() {
	return navigator.userAgent.indexOf("MSIE") > 0 ? "MSIE" : (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) ? "Firefox" : (isSafari = navigator.userAgent.indexOf("Safari") > 0) ? "Safari" : (isCamino = navigator.userAgent.indexOf("Camino") > 0) ? "Camino" : (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) ? "Gecko" : "Unknow"
}

function get_element(t, n) {
	return null == n && (n = 0), obj = document.getElementById(t), obj || (obj = document.getElementsByName(t), obj ? obj[n] : null)
}

function search_child(t, n) {
	if(!t || !t.hasChildNodes()) return !1;
	if(n)
		for(var e = 0; e < t.childNodes.length; e++) {
			if(t.childNodes[e].id == n || t.childNodes[e].name == n) return t.childNodes[e];
			if(result = search_child(t.childNodes[e], n), result) return result
		}
	return !1
}

function check_number(t) {
	var n = t.keyCode;
	return !(!t.ctrlKey && !t.altKey) || (n >= 48 && n <= 57 || n >= 96 && n <= 105 || 8 == n || 46 == n || 27 == n || 37 == n || 39 == n || 16 == n || 9 == n || 33 == n || 34 == n || 190 == n || n >= 91 && n <= 93 || n >= 110 && n < 124)
}

function get_max(t, n) {
	return t > n ? t : n
}

function get_min(t, n) {
	return t < n ? t : n
}

function cut_float_zero(t) {
	var n = t.indexOf(".");
	if(n < 0) return t;
	for(var e = t.length, i = t.length - 1; i >= n && ("0" == t[i] || "." == t[i]); i--) e = i;
	return t.substr(0, e)
}

function num_need_fix(t, n) {
	var e = (t = t.toString()).indexOf(".");
	return !(e < 0) && (t.length - e - 1 > n && (n > 0 ? t.substr(0, e + n + 1) : t.substr(0, e)))
}

function num_fix(t, n) {
	if("" == (t = t.toString())) return 0;
	var e = num_need_fix(t, n);
	return e || t
}

function num_multi(t, n) {
	var e = 0;
	t.toString(), n.toString();
	try {
		e += t.toString().split(".")[1].length
	} catch(t) {}
	try {
		e += n.toString().split(".")[1].length
	} catch(t) {}
	return Number(t.toString().replace(".", "")) * Number(n.toString().replace(".", "")) / Math.pow(10, e)
}

function rand(t, n) {
	return Math.floor(Math.random() * n + t)
}

function page_rand() {
	return "&c=" + rand(0, 1e6)
}

function get_view_symbol(t, n) {
	var e;
	return null == n || "l" == n ? (e = t.indexOf("_")) >= 0 ? t.substr(0, e).toUpperCase() : t.substr(0, 3).toUpperCase() : (e = t.indexOf("_")) >= 0 ? t.substr(e + 1, t.length - e - 1).toUpperCase() : t.substr(4).toUpperCase()
}

function get_symbols(t) {
	var n = t.indexOf("_");
	return n >= 0 ? [t.substr(0, n).toUpperCase(), t.substr(n + 1, t.length - n - 1).toUpperCase()] : [""]
}

function trim(t) {
	for(var n = 0; n < t.length && " " == t.charAt(n); n++);
	for(var e = t.length; e > 0 && " " == t.charAt(e - 1); e--);
	return n > e ? "" : t.substring(n, e)
}

function fireEvent(t, n) {
	if(document.createEventObject) {
		var e = document.createEventObject();
		return t.fireEvent("on" + n, e)
	}
	return(e = document.createEvent("HTMLEvents")).initEvent(n, !0, !0), !t.dispatchEvent(e)
}

function get_query_string(t) {
	if(-1 == location.href.indexOf("?") || -1 == location.href.indexOf(t + "=")) return "";
	for(var n, e, i, a = location.href.substring(location.href.indexOf("?") + 1).split("<!@!>"), l = 0; l < a.length; l++)
		if(-1 != (n = a[l].indexOf("=")) && (e = a[l].substring(0, n), i = a[l].substring(n + 1), e == t)) return unescape(i.replace(/\+/g, " "));
	return ""
}

function sell_all() {
	var t, n, e = "undefined" != typeof global_precision_vol ? global_precision_vol : 6,
		i = "undefined" != typeof global_precision_total ? global_precision_total : 6;
	(n = parseFloat(get_element("balance_bid_able").innerHTML)) > 0 && (t = parseFloat(get_element("bid_rate").value)) > 0 && (get_element("bid_vol").value = num_fix(n, e), get_element("bid_amount").value = num_fix(t * n, i))
}

function buy_all() {
	"undefined" != typeof global_precision_vol && global_precision_vol;
	var t, n, e = "undefined" != typeof global_precision_total ? global_precision_total : 6;
	(n = parseFloat(get_element("balance_ask_able").innerHTML)) > 0 && (t = parseFloat(get_element("ask_rate").value)) > 0 && (get_element("ask_amount").value = num_fix(n, e), get_element("ask_vol").value = num_fix(n / t, e))
}

function gate_success_noty(t) {
	noty({
		text: t,
		type: "sucess",
		layout: "bottomCenter",
		closeWith: ["button", "click"],
		theme: "gateioNotyTheme",
		animation: {
			open: {
				height: "toggle"
			},
			close: {
				height: "toggle"
			},
			easing: "swing",
			speed: 50
		},
		timeout: 5e3,
		callback: {
			afterClose: function() {
				$(".noty_modal").remove()
			}
		}
	})
}

function gate_warning_noty(t, n) {
	var e = {
		open: {
			height: "toggle"
		},
		close: {
			height: "toggle"
		},
		easing: "swing",
		speed: 50
	};
	1 == n ? $(".noty_container").noty({
		text: t,
		type: "warning",
		layout: "center",
		theme: "gateioNotyTheme",
		animation: e,
		callback: {
			afterShow: function() {
				var t = $(".noty_container").find("ul"),
					n = document.body.clientHeight;
				t.css("top", (n - t.height()) / 2)
			},
			afterClose: function() {
				$(".noty_modal").remove()
			}
		}
	}) : noty({
		text: t,
		type: "warning",
		layout: "center",
		closeWith: ["button", "click"],
		theme: "gateioNotyTheme",
		animation: e,
		timeout: 15e3,
		callback: {
			afterClose: function() {
				$(".noty_modal").remove()
			}
		}
	})
}

function gate_error_noty(t, n) {
	var e = {
		open: {
			height: "toggle"
		},
		close: {
			height: "toggle"
		},
		easing: "swing",
		speed: 50
	};
	1 == n ? $(".noty_container").noty({
		text: t,
		type: "error",
		layout: "center",
		theme: "gateioNotyTheme",
		animation: e,
		callback: {
			afterShow: function() {
				var t = $(".noty_container").find("ul"),
					n = document.body.clientHeight;
				t.css("top", (n - t.height()) / 2)
			},
			afterClose: function() {
				$(".noty_modal").remove()
			}
		}
	}) : noty({
		text: t,
		type: "error",
		layout: "center",
		closeWith: ["button", "click"],
		theme: "gateioNotyTheme",
		animation: e,
		timeout: 1e4,
		callback: {
			afterClose: function() {
				$(".noty_modal").remove()
			}
		}
	})
}

function get_paytype_desc(t) {
	var n = "";
	return t.indexOf("pay_ali") >= 0 && (n = n + " " + lang_string("支付宝") + " "), t.indexOf("pay_wechat") >= 0 && (n = n + " " + lang_string("微信") + " "), t.indexOf("pay_bank") >= 0 && (n = n + " " + lang_string("银行转账") + " "), n
}

function valid_paytype(t) {
	return "pay_all" == t || "pay_ali" == t || "pay_wechat" == t || "pay_bank" == t || "pay_paypal" == t
}

function on_input_biz_rate_offset(t, n) {
	if("-" != n.value) {
		var e = "" == n.value ? 0 : num_fix(n.value, 2);
		if(isNaN(e) && (e = 0), e < -20 && (e = -20), e > 20 && (e = 20), n.value = e, "sell" == t) {
			e = n.value;
			var i = parseFloat($('input:radio[name="sell_rate_ref_id"]:checked').attr("rate"));
			$("#sell_ref_rate").html(num_fix(i + i * (.01 * e), 2))
		} else {
			e = n.value;
			i = parseFloat($('input:radio[name="buy_rate_ref_id"]:checked').attr("rate"));
			$("#buy_ref_rate").html(num_fix(i + i * (.01 * e), 2))
		}
	}
}

function on_input_buy_amount(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("buy_amount");
		get_element("buy_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_input_buy_vol(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("buy_amount"),
			e = get_element("buy_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_sell_amount(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("sell_amount");
		get_element("sell_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_input_sell_vol(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("sell_amount"),
			e = get_element("sell_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_quick_input_buy_amount(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("quick_buy_amount");
		get_element("quick_buy_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_quick_input_buy_vol(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("quick_buy_amount"),
			e = get_element("quick_buy_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_quick_input_sell_amount(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("quick_sell_amount");
		get_element("quick_sell_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_quick_input_sell_vol(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("quick_sell_amount"),
			e = get_element("quick_sell_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_biz_buy_rate(t) {
	if("" != (t = get_element("biz_buy_rate").value) && $.isNumeric(t) && !(t <= 0)) {
		t = "" == t ? 0 : num_fix(t, 2);
		get_element("biz_buy_rate").value = t;
		var n = get_element("biz_buy_amount"),
			e = get_element("biz_buy_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_biz_buy_total(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("biz_buy_amount");
		get_element("biz_buy_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_input_biz_buy_vol(t) {
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("biz_buy_amount"),
			e = get_element("biz_buy_vol"),
			i = get_element("buy_vol_max"),
			a = num_fix(e.value, global_precision_total);
		i.value = a > 3e4 ? 3e4 : a, n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_biz_buy_min_vol() {
	var t = get_element("buy_vol_min").value;
	"" != t && (t = num_fix(t, 2), get_element("buy_vol_min").value = t)
}

function on_input_biz_sell_rate() {
	var t = get_element("biz_sell_rate").value;
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		t = "" == t ? 0 : num_fix(t, 2), get_element("biz_sell_rate").value = t;
		var n = get_element("biz_sell_amount"),
			e = get_element("biz_sell_vol");
		n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_biz_sell_total() {
	var t = get_element("biz_sell_rate").value;
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("biz_sell_amount");
		get_element("biz_sell_vol").value = num_fix(n.value / t, global_precision_vol)
	}
}

function on_input_biz_sell_vol() {
	var t = get_element("biz_sell_rate").value;
	if("" != t && $.isNumeric(t) && !(t <= 0)) {
		var n = get_element("biz_sell_amount"),
			e = get_element("biz_sell_vol"),
			i = get_element("sell_vol_max"),
			a = num_fix(e.value, global_precision_total);
		i.value = a > 3e4 ? 3e4 : a, n.value = num_fix(num_multi(e.value, t), global_precision_total)
	}
}

function on_input_biz_sell_min_vol() {
	var t = get_element("sell_vol_min").value;
	"" != t && (t = num_fix(t, 2), get_element("sell_vol_min").value = t)
}

function set_vol(t) {
	get_element("buy_vol").value = t, on_input_buy_vol(get_element("buy_rate").value), get_element("sell_vol").value = t, on_input_sell_vol(get_element("sell_rate").value)
}

function bizSellSubmit(t, n) {
	var e = 0,
		i = parseFloat($("#biz_sell_amount").val()),
		a = $('input:radio[name="sell_rate_fixed"]:checked').val();
	if(1 == a) {
		if(e = parseFloat($("#biz_sell_rate").val()), isNaN(e) || e < 0) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效价格，请重新输入") + "</span>"), $("#biz_sell_rate").focus(), !1;
		if(isNaN(i) || i > 1e9) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效兑换额，请重新输入") + "</span>"), $("#biz_sell_amount").focus(), !1
	} else if(e = parseFloat($('input:radio[name="sell_rate_ref_id"]:checked').attr("rate")), isNaN(e) || e < 0) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效参考价格，请重新输入") + "</span>"), !1;
	var l = parseFloat($("#biz_sell_vol").val());
	if(isNaN(l) || l < .01 || l > 1e6) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效卖出数量，请重新输入") + "</span>"), $("#biz_sell_vol").focus(), !1;
	var s = parseFloat($("#sell_vol_min").val());
	if(isNaN(s) || s < .01 || s > l || s > 1e6) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效最小交易量，请重新输入") + "</span>"), $("#sell_vol_min").focus(), !1;
	var r = parseFloat($("#sell_vol_max").val());
	if(isNaN(r) || r < s || r > l || r > 1e6) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效最大交易量，请重新输入") + "</span>"), $("#sell_vol_max").focus(), !1;
	var o = $('input:radio[name="sell_rate_ref_id"]:checked').val(),
		_ = num_fix($("#sell_rate_offset").val(), 2);
	if(0 == a) {
		if(o < 0) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效参考市场") + "</span>"), !1;
		if(_ < -20 || _ > 20) return $("#biz_sell_tips").html("<span style=color:#ff5d5d>" + lang_string("无效浮动价格") + "</span>"), !1
	} else o = -1;
	_page.obj.on_request_biz_push("sell", t, n, e, l, s, r, a, o, _), _page.run();
	return busi_sell_hide("formSub"), !0
}

function bizBuySubmit(t, n) {
	var e = 0,
		i = $('input:radio[name="buy_rate_fixed"]:checked').val(),
		a = parseFloat($("#biz_buy_amount").val());
	if(1 == i) {
		if(e = parseFloat($("#biz_buy_rate").val()), isNaN(e) || e < 0) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效价格，请重新输入") + "</span>"), $("#biz_buy_rate").focus(), !1;
		if(isNaN(a) || a > 1e9) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效兑换额，请重新输入") + "</span>"), $("#biz_buy_amount").focus(), !1
	} else if(e = parseFloat($('input:radio[name="buy_rate_ref_id"]:checked').attr("rate")), isNaN(e) || e < 0) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效参考价格，请重新输入") + "</span>"), !1;
	var l = parseFloat($("#biz_buy_vol").val());
	if(isNaN(l) || l < .01 || l > 1e6) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效买入数量请重新输入") + "</span>"), $("#biz_buy_vol").focus(), !1;
	var s = parseFloat($("#buy_vol_min").val());
	if(isNaN(s) || s < .01 || s > l || s > 1e6) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效最小交易量，请重新输入") + "</span>"), $("#buy_vol_min").focus(), !1;
	var r = parseFloat($("#buy_vol_max").val());
	if(isNaN(r) || r < s || r > l || r > 1e6) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效最大交易量，请重新输入") + "</span>"), $("#buy_vol_max").focus(), !1;
	var o = $('input:radio[name="buy_rate_ref_id"]:checked').val(),
		_ = num_fix($("#buy_rate_offset").val(), 2);
	if(0 == i) {
		if(o < 0) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效参考市场") + "</span>"), !1;
		if(_ < -20 || _ > 20) return $("#biz_buy_tips").html("<span style=color:#ff5d5d>" + lang_string("无效浮动价格") + "</span>"), !1
	} else o = -1;
	_page.obj.on_request_biz_push("buy", t, n, e, l, s, r, i, o, _);
	return busi_buy_hide("formSub"), !0
}

function rate_change(t, n) {
	var e = 0;
	e = 0 == n ? 0 : num_fix((t - n) / n * 100, 2);
	var i = "green";
	return void 0 !== $.cookie("lang") && "" != $.cookie("lang") && "cn" != $.cookie("lang") && ("green", i = "red"), e < 0 ? "<font class='" + i + "'>" + e + "%</font><i class=icon-arrow-down>↓</i>" : "<font  class='" + i + "'>+" + e + "%</font><i class=icon-arrow-up>↑</i>"
}

function trade_operator(n, e, a, l, s, r, o, _, g) {
	l = void 0 !== l ? l : 0, fee_percentage_buy = void 0 !== l ? l : 0, s = void 0 !== s ? s : 6, r = void 0 !== r ? r : 6, o = void 0 !== o ? o : 6;
	var u = {
			appraised_buy_rate: 0,
			appraised_sell_rate: 0,
			reload_main_rates: function() {
				var t = {
					type: "push_main_rates",
					symbol: e
				};
				p.my_orders_num = 0, $.ajax({
					type: "get",
					//url: "/json_svr/query_push/?u=13" + page_rand(),
					url: "/json_svr/u13.json",
					data: t,
					xhrFields: {
						withCredentials: !0
					},
					success: function(t, n) {
						var e = t;
						e && e.result && e.appraised_rates && (e.appraised_rates.buy_rate && (get_element("buy_rate").value = e.appraised_rates.buy_rate, u.appraised_buy_rate = parseFloat(e.appraised_rates.buy_rate)), e.appraised_rates.sell_rate && (get_element("sell_rate").value = e.appraised_rates.sell_rate, u.appraised_sell_rate = parseFloat(e.appraised_rates.sell_rate)), e.appraised_rates.buy_rate && e.appraised_rates.sell_rate && (get_element("curr_rate").innerHTML = num_fix(.5 * (parseFloat(e.appraised_rates.buy_rate) + parseFloat(e.appraised_rates.sell_rate)), 2)), e.appraised_rates.max_rate && (get_element("ticker_high").innerHTML = e.appraised_rates.max_rate), e.appraised_rates.min_rate && (get_element("ticker_low").innerHTML = e.appraised_rates.min_rate), e.appraised_rates.rate_24h_ago && (get_element("last_rate_change").innerHTML = rate_change(get_element("curr_rate").innerHTML, e.appraised_rates.rate_24h_ago)))
					},
					error: function(t, n, e) {}
				})
			},
			recheck: function() {
				u.reload_main_rates()
			}
		},
		c = {
			push_order: [],
			reload_push_order: function() {
				var t = {
					type: "push_order_list",
					symbol: e
				};
				$.ajax({
					type: "get",
					//url: "/json_svr/query_push/?u=13" + page_rand(),
					url: "/json_svr/u13.json",
					data: t,
					xhrFields: {
						withCredentials: !0
					},
					success: function(t, n) {
						var e = t;
						e && e.result && (e.push_order && e.push_order.length > 0 ? (c.push_order = e.push_order, c.rebuild_biz_order_table()) : (c.push_order.length = 0, c.rebuild_biz_order_table()))
					},
					error: function(t, n, e) {}
				})
			},
			rebuild_biz_order_table: function() {
				var t, n = 0,
					e = "",
					i = c.push_order,
					a = "red",
					l = "green";
				for(void 0 !== $.cookie("lang") && "" != $.cookie("lang") && "cn" != $.cookie("lang") && (a = "green", l = "red"), t = 0; i.length > t; t++) {
					var s, r = i[t].pay_type_num.split(","),
						o = "";
					for(s = 0; r.length > s; s++) "" != r[s] && (o += "<img class=pay_icon" + r[s] + " src=../images/pay_type_icon" + r[s] + ".svg />");
					e += "<tr class='odd' onclick='set_vol(" + i[t].amount + ");'>", e += "<td align='left'>" + ("sell" == i[t].type ? "<span class='" + l + "'>" + lang_string("卖出") + "</span>" : "<span class='" + a + "'>" + lang_string("买入") + "</span>") + "</td>", e += "<td align='right'>" + i[t].rate + "</td>", e += "<td align='right'>" + i[t].amount + "</td>", e += "<td align='right'>" + i[t].total + "</td>", e += "<td align='right'>" + i[t].limit_total + "</td>", e += "<td align='right'>" + i[t].online_status + "</td>", e += "<td align='right'>" + i[t].complete_number + "</td>", e += "<td align='right'>" + i[t].used_time + "</td>", e += "<td align='right'>" + o + "</td>", e += "<td align='right'>" + ('<a href="javascript:quick_show(' + i[t].is_sell + "," + i[t].oid + "," + i[t].rate + "," + i[t].amount + "," + i[t].total + ",'" + i[t].limit_total + "','" + i[t].pay_type_num + "','" + i[t].online_status + '\');" class="' + i[t].btn_css + '">' + i[t].button + "</a>") + "</td>", e += "</tr>", n++
				}
				e += "<tr class='table-empty'><td style='text-align: center'><p><i>i</i>" + lang_string("暂无挂单") + "</p></td></tr>", get_element("pushOrder") && (get_element("pushOrder").innerHTML = e), n > 0 && $("#pushOrder").css("display", "")
			},
			recheck: function() {
				$("#divPushOrder").is(":visible") && c.reload_push_order()
			}
		},
		d = {
			reload_push_notice: function() {
				var t = {
					type: "push_notice",
					orders: orders
				};
				$.ajax({
					type: "get",
					//url: "/json_svr/query_push/?u=13" + page_rand(),
					url: "/json_svr/u13.json",
					data: t,
					xhrFields: {
						withCredentials: !0
					},
					success: function(t, n) {
						var e = t;
						e && e.result && e.push_notice && e.push_notice.length > 0 && (d.push_notice = e.push_notice, d.update_transactions())
					},
					error: function(t, n, e) {}
				})
			},
			update_transactions: function() {},
			recheck: function() {}
		},
		p = {
			fee: .01 * l,
			fee_sell: .01 * (_ = void 0 !== _ ? _ : l),
			my_orders_num: -1,
			cancelled_orders: [],
			my_orders: [],
			my_transactions_num: -1,
			my_transactions: [],
			my_transtime: [],
			on_request_push: function(t, n, i, l, s, r, o) {
				if(!a || a < 0) gate_warning_noty(lang_string("请您先登录再进行操作"));
				else if(s <= .01) gate_warning_noty(lang_string("单笔交易量太低"));
				else if(s > 15e3) gate_warning_noty(lang_string("单笔交易量超过限额，最高 15000"));
				else if(l >= 1e6 || 0 == l) gate_warning_noty(lang_string("无效交易价格"));
				else {
					var _ = get_paytype_desc(r);
					if("" != _) {
						var g = $.cookie("lang"),
							u = {
								type: "request_push_precheck",
								is_sell: "sell" == t ? 1 : 0,
								symbol: e,
								rate: l,
								vol: s,
								pay_type: r,
								orderid: o
							};
						$.ajax({
							type: "get",
							//url: "/json_svr/query_push/?u=13" + page_rand(),
							url: "/json_svr/u13.json",
							data: u,
							xhrFields: {
								withCredentials: !0
							},
							success: function(e, a) {
								var l = e;
								if(l && l.result && l.push_order) {
									var s, u, c = l.push_order,
										d = c.rate_changed,
										f = "",
										m = "";
									if(d > 0 && (f = "价格浮动太大（超过" + d + "%），请核实后再下单"), c.total > 5e4 && "cn" === g && (f = lang_string("17:00以后及非工作日时间，每笔请拆分5万以内进行转账，否则将延迟到账")), "0" == c.is_sell) u = c.vol, c.total, s = c.rate, m += "<div class='conform-con'><h3><span class=red>" + lang_string("买入") + "</span> " + lang_string("请确认") + "</h3>", m += "<hr/>", m += "<ul id=tablePending class=n-confirm>", m += "<li>" + lang_string("买入数量") + ": <b>" + c.vol + "</b><span class=coin-unit>" + n + "</span></li>", m += "<li>" + lang_string("买入金额") + ": <b>" + c.total + "</b><span class=coin-unit>" + i + "</span></li>", m += "<li>" + lang_string("买入估价") + ": <b>" + c.rate + "</b><span class=coin-unit>" + i + " <span class='red'>（" + lang_string("以实际订单为准") + "）</span></span></li>", m += "<li>" + lang_string("交易方式") + ": <b>" + _ + "</b></li>", "" != f && (m += "<li>" + lang_string("重要提示(必看)") + "：<span class='red'>" + f + "</span></li>"), m += "</ul></div>";
									else {
										if("1" != c.is_sell) return void gate_warning_noty(lang_string("无效交易类型"));
										u = c.vol, c.total, s = c.rate, m += "<div class='conform-con'><h3><span class=green>" + lang_string("卖出") + "</span> " + lang_string("请确认") + "</h3>", m += "<hr/>", m += "<ul id=tablePending class=n-confirm>", m += "<li>" + lang_string("卖出数量") + ": <b>" + c.vol + "</b><span class=coin-unit>" + n + "</span></li>", m += "<li>" + lang_string("卖出金额") + ": <b>" + c.total + "</b><span class=coin-unit>" + i + "</span></li>", m += "<li>" + lang_string("卖出估价") + ": <b>" + c.rate + "</b><span class=coin-unit>" + i + " <span class='red'>（" + lang_string("以实际订单为准") + "）</span></span></li>", m += "<li>" + lang_string("交易方式") + ": <b>" + _ + "</b></li>", "" != f && (m += "<li>" + lang_string("重要提示(必看)") + "： <span class='red'>" + f + "</span></li>"), m += "</ul></div>"
									}
									if(d > 1) return void gate_warning_noty(m);
									noty({
										text: "<div class=noty-padding>" + m + "</div>",
										type: "confirm",
										layout: "center",
										theme: "gateioNotyTheme",
										modal: !0,
										animation: {
											open: {
												height: "toggle"
											},
											close: {
												height: "toggle"
											},
											easing: "swing",
											speed: 50
										},
										buttons: [{
											addClass: "btn btn-primary",
											text: lang_string("确定下单"),
											onClick: function(n) {
												p.on_request_push_confirmed(t, s, u, r, o), n.close()
											}
										}, {
											addClass: "btn btn-error",
											text: lang_string("取消"),
											onClick: function(t) {
												t.close()
											}
										}]
									})
								} else gate_warning_noty(m = "<div class='cancel_content'>" + l.msg + "</div>")
							},
							error: function(t, n, e) {}
						})
					} else gate_warning_noty(lang_string("无效支付方式"))
				}
			},
			on_request_push_confirmed: function(t, n, i, l, o, _) {
				if(_ = void 0 !== _ ? _ : "", !a || a < 0) gate_warning_noty(lang_string("请您先登录再进行操作"));
				else if(i <= 0) gate_warning_noty(lang_string("请输入交易量"));
				else if(n >= 1e6 || 0 == n) gate_warning_noty(lang_string("无效价格"));
				else if(i > 15e3) gate_warning_noty(lang_string("无效交易量"));
				else if("" != l) {
					var g = {
						type: t,
						symbol: e,
						rate: n,
						vol: i,
						pay_type: l,
						fundpass: _,
						orderid: o
					};
					$.ajax({
						type: "get",
						url: "/json_svr/push/?u=1" + page_rand(),
						data: g,
						xhrFields: {
							withCredentials: !0
						},
						success: function(a, _) {
							var g = a,
								u = "";
							if(g.pending && ("buy" == t ? (u += lang_string("购买下单成功"), u += "<hr/>", u += "<table id='tableRecords'>", u += "<tr>", u += "<td>" + lang_string("价格") + ": " + num_fix(g.pending.rate, s) + "&nbsp;" + get_view_symbol(e, "r") + "</td> ", u += "<td> " + lang_string("数量") + ": " + num_fix(g.pending.vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></tr>", u += "</table>", u += "<br/>") : "sell" == t && (u += lang_string("卖出下单成功"), u += "<hr/>", u += "<table id='tableRecords'>", u += "<tr>", u += "<td>" + lang_string("价格") + ": " + num_fix(g.pending.rate, s) + "&nbsp;" + get_view_symbol(e, "r") + "</td>", u += "<td> " + lang_string("数量") + ": " + num_fix(g.pending.vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></tr>", u += "</table>", u += "<br/>")), g.require_fundpass) {
								Math.random(), u = "<h3 style='margin-bottom:10px'>" + lang_string("资金密码") + ":</h3><hr>";
								u += "<table id='tablePending' style='width: 90%'>", u += "<tr><td class='noty-td'>" + lang_string("输入资金密码") + ": </td><td width='70%'><input class='inputRate' type='password' name='fundpass' id='fundpass' autocomplete='new-password' placeholder='" + lang_string("请输入资金密码") + "'></td></tr>", u += "<tr><td class='noty-td'>" + lang_string("有效期限") + ": </td><td width='70%'>" + lang_string("2小时") + " &nbsp;&nbsp;（" + lang_string("如有IP变化仍需输入") + "）</td></tr>", u += "</table><tr><td><label name='tips' id='tips'>" + g.msg + "</label></td></tr>";
								var c = noty({
									text: u,
									type: "confirm",
									layout: "center",
									theme: "gateioNotyTheme",
									modal: !0,
									animation: {
										open: {
											height: "toggle"
										},
										close: {
											height: "toggle"
										},
										easing: "swing",
										speed: 50
									},
									callback: {
										afterShow: function() {
											$("#fundpass").keyup(function(t) {
												13 == t.keyCode && d()
											})
										}
									},
									buttons: [{
										addClass: "btn btn-success dp-noty-btn",
										text: lang_string("确定提交"),
										onClick: function() {
											d()
										}
									}, {
										addClass: "btn btn-error dp-noty-btn",
										text: lang_string("取消"),
										onClick: function(t) {
											return t.close(), !1
										}
									}]
								});

								function d() {
									var e = $("#fundpass").val();
									return "" == e ? ($("#tips").html("<span style=color:#ff5d5d>" + lang_string("密码不能为空，请再次输入") + "</span>"), $("#fundpass").focus(), !1) : (p.on_request_push_confirmed(t, n, i, l, o, e), c.close(), !0)
								}
							} else if(g.result) gate_success_noty(u), p.my_orders_num = -1;
							else {
								var f = g.rescode;
								if(1 == f) var m = lang_string("去登记");
								else if(2 == f) m = lang_string("去绑定");
								else m = lang_string("确定");
								$(".noty_container").noty({
									text: "<div class=noty-padding>" + g.msg + "</div>",
									type: "confirm",
									layout: "center",
									theme: "gateioNotyTheme",
									modal: !0,
									animation: {
										open: {
											height: "toggle"
										},
										close: {
											height: "toggle"
										},
										easing: "swing",
										speed: 50
									},
									buttons: [{
										addClass: "btn btn-success dp-noty-btn",
										text: m,
										onClick: function(t) {
											1 == f ? window.location.href = "/myaccount/id_setup" : 2 == f ? window.location.href = "/myaccount/payment_setup" : t.close()
										}
									}, {
										addClass: "btn btn-error dp-noty-btn",
										text: lang_string("取消"),
										onClick: function(t) {
											return t.close(), !1
										}
									}],
									callback: {
										onShow: function() {
											p.my_orders_num = -1
										},
										afterShow: function() {
											var t = $(".noty_container").find("ul"),
												n = document.body.clientHeight;
											t.css("top", (n - t.height()) / 2)
										},
										afterClose: function() {
											$(".noty_modal").remove()
										}
									}
								})
							}
							g = null
						},
						error: function(t, n, e) {
							gate_error_noty(lang_string("网络错误") + ": " + t.status + " " + t.responseText + " " + status + " " + e), p.my_orders_num = -1
						}
					})
				} else gate_warning_noty(lang_string("无效支付方式"))
			},
			on_request_biz_push: function(t, n, e, i, l, _, g, c, d, f) {
				if(!a || a < 0) gate_warning_noty(lang_string("请您先登录再进行操作"), 1);
				else {
					var m = "",
						b = 0;
					if(0 == c) {
						if(d < 0) return void gate_warning_noty(lang_string("无效参考价格"), 1);
						if(f < -20 || f > 20) return void gate_warning_noty(lang_string("无效浮动价格设置"), 1);
						b = num_fix(i * (1 + .01 * f) * l, o), m = lang_string("参考价格"), m += i, m += "<br>" + lang_string("浮动百分比"), m += f, m += "%"
					} else {
						if(i >= 1e6 || 0 == i) return void gate_warning_noty(lang_string("无效交易价格"), 1);
						b = num_fix(i * l, o), m = num_fix(i, s)
					}
					var y = .5 * (parseFloat(u.appraised_buy_rate) + parseFloat(u.appraised_sell_rate)),
						h = "",
						v = "";
					if("sell" == t) {
						if(get_element("biz_sell_pay_ali") && get_element("biz_sell_pay_ali").checked && (h = "pay_ali"), get_element("biz_sell_pay_wechat") && get_element("biz_sell_pay_wechat").checked && (h += ",pay_wechat"), get_element("biz_sell_pay_bank") && get_element("biz_sell_pay_bank").checked && (h += ",pay_bank"), "" == (k = get_paytype_desc(h))) return void gate_warning_noty(lang_string("无效支付方式"), 1);
						var x = get_element("balance_sell_able").value;
						if(l > Number(x)) return void gate_warning_noty(lang_string("超出可卖出额，请检查后重新输入"), 1);
						v += "<h3>" + lang_string("请确认商家") + "<span class=green>" + lang_string("卖出") + "</span>" + lang_string("挂单") + ":</h3>", v += "<hr/>", v += "<ul id=tablePending>", v += "<li>" + lang_string("卖出价格") + ": <span class=red>" + m + "</span><span class=coin-unit>" + e + "</span></li>", v += "<li>" + lang_string("卖出数量") + ": <b>" + num_fix(l, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("卖出金额") + ": <b>" + b + "</b><span class=coin-unit>" + e + "</span></li>", v += "<li>" + lang_string("最小数量") + ": <b>" + num_fix(_, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("最大数量") + ": <b>" + num_fix(g, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("支付方式") + ": <b>" + k + "</b><span class=coin-unit></li>", oper = y > 0 ? (y - i) / y * 100 : 0, oper > 10 && (v += "<li><font color=red>" + lang_string("警告") + ": <b>" + lang_string("您的") + "<font color=red>" + lang_string("卖出") + "</font>" + lang_string("价格") + "<font color=red>" + lang_string("低于") + "</font>" + lang_string("市场平均价格") + " <font color=red>" + num_fix(oper, 1) + "%</font>，" + lang_string("请务必检查确认") + "。</b><span class=coin-unit></li>"), v += "</ul>"
					} else {
						if("buy" != t) return void gate_error_noty(lang_string("无效交易类型"), 1);
						var k;
						if(get_element("biz_buy_pay_ali") && get_element("biz_buy_pay_ali").checked && (h = "pay_ali"), get_element("biz_buy_pay_wechat") && get_element("biz_buy_pay_wechat").checked && (h += "pay_wechat"), get_element("biz_buy_pay_bank") && get_element("biz_buy_pay_bank").checked && (h += "pay_bank"), "" == (k = get_paytype_desc(h))) return void gate_warning_noty(lang_string("无效支付方式"));
						var w = "",
							C = $.cookie("lang");
						b > 5e4 && "cn" === C && (w = lang_string("17:00以后及非工作日时间，每笔请拆分5万以内进行转账，否则将延迟到账")), v += "<h3>" + lang_string("请确认商家") + "<span class=red>" + lang_string("买入") + "</span>" + lang_string("挂单") + ":</h3>", v += "<hr/>", v += "<ul id='tablePending'>", v += "<li>" + lang_string("买入价格") + ": <span class=red>" + m + "</span><span class=coin-unit>" + e + "</span></li>", v += "<li>" + lang_string("买入数量") + ": <b>" + num_fix(l, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("买入金额") + ": <b>" + b + "</b><span class=coin-unit>" + e + "</span></li>", v += "<li>" + lang_string("最小数量") + ": <b>" + num_fix(_, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("最大数量") + ": <b>" + num_fix(g, r) + "</b><span class=coin-unit>" + n + "</span></li>", v += "<li>" + lang_string("支付方式") + ": <b>" + k + "</b><span class=coin-unit></li>", "" != w && (v += "<li>" + lang_string("重要提示(必看)") + ": <span class='red'>" + w + "</span></li>"), oper = y > 0 ? (i - y) / y * 100 : 0, oper > 10 && (v += "<li><font color=red>" + lang_string("警告") + ": <b>" + lang_string("您的") + "<font color=red>" + lang_string("买入") + "</font>" + lang_string("价格") + "<font color=red>" + lang_string("高于") + "</font>" + lang_string("市场平均价格") + " <font color=red>" + num_fix(oper, 1) + "%</font>，" + lang_string("请务必检查确认") + "。</b><span class=coin-unit></li>"), v += "</ul>"
					}
					$(".noty_container").noty({
						text: v,
						type: "confirm",
						layout: "center",
						theme: "gateioNotyTheme",
						animation: {
							open: {
								height: "toggle"
							},
							close: {
								height: "toggle"
							},
							easing: "swing",
							speed: 50
						},
						buttons: [{
							addClass: "btn btn-success",
							text: lang_string("确定下单"),
							onClick: function(n) {
								p.on_request_biz_push_confirmed(t, i, l, _, g, h, c, d, f), n.close()
							}
						}, {
							addClass: "btn btn-error",
							text: lang_string("取消"),
							onClick: function(t) {
								t.close(), $(".noty_modal").remove()
							}
						}],
						callback: {
							onShow: function() {
								p.my_orders_num = -1
							},
							afterShow: function() {
								var t = $(".noty_container").find("ul"),
									n = document.body.clientHeight;
								t.css("top", (n - t.height()) / 2)
							}
						}
					})
				}
			},
			on_request_biz_push_confirmed: function(n, i, l, o, _, g, u, c, d, f) {
				if(f = void 0 !== f ? f : "", !a || a < 0) gate_warning_noty(lang_string("请您先登录再进行操作"), 1);
				else if(l <= .01 || l >= 1e6) gate_warning_noty(lang_string("无效交易量"), 1);
				else if(o <= 0) gate_warning_noty("无效的最小交易量", 1);
				else if(_ <= 0) gate_warning_noty("无效的最大交易量", 1);
				else {
					if("sell" == n) {
						var m = get_element("balance_sell_able").value;
						if(l > Number(m)) return void gate_warning_noty(lang_string("超出可卖出额，请检查后重新输入"), 1)
					} else if("buy" != n) return void gate_error_noty(lang_string("无效交易类型"), 1);
					var b = {
						type: n,
						symbol: e,
						rate: i,
						vol: l,
						vol_min: o,
						vol_max: _,
						pay_type: g,
						rate_fixed: u,
						rate_ref_id: c,
						rate_offset: d,
						fundpass: f
					};
					$.ajax({
						type: "get",
						url: "/json_svr/biz_push/?u=1" + page_rand(),
						data: b,
						xhrFields: {
							withCredentials: !0
						},
						success: function(a, f) {
							var m = a,
								b = "";
							if(m.records) {
								b += lang_string("已匹配") + ":", b += "<hr/>", b += "<table id='tableRecords'>";
								for(var y = 0; y < m.records.length; y++) b += "<tr><td>", b += y + 1 + ".</td><td>", b += lang_string("价格") + ": " + num_fix(m.records[y].rate, s) + "</td>", "buy" == n ? b += "<td>" + lang_string("匹配数量") + ": </td><td>" + num_fix(m.records[y].vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></td>" : "sell" == n && (b += "<td>" + lang_string("匹配数量") + ": </td><td>" + num_fix(m.records[y].vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></td>");
								b += "</table>", b += "<br/>"
							}
							if(m.pending) {
								"sell" == n ? (t = "<font color=red>" + lang_string("卖出") + "</font>", get_element("balance_sell_able").innerHTML = get_element("balance_sell_able").innerHTML - m.pending[0].vol) : t = "<font color=red>" + lang_string("买入") + "</font>", b += lang_string("已挂单") + ":", b += "<hr/>", b += "<table id='tablePending'>";
								for(y = 0; y < m.pending.length; y++) b += "<tr><td>" + lang_string("单号") + ": </td><td>" + m.pending[y].id + "</td></tr>", b += "<tr><td>" + lang_string("价格") + ": </td><td>" + num_fix(m.pending[y].rate, s) + "&nbsp;" + get_view_symbol(e, "r") + "</td></tr>", "buy" == n ? b += "<tr><td>" + lang_string("挂单量") + " </td><td>" + num_fix(m.pending[y].vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></tr>" : "sell" == n && (b += "<tr><td>" + lang_string("挂单量") + ": </td><td>" + num_fix(m.pending[y].vol, r) + "&nbsp;" + get_view_symbol(e, "l") + "</td></tr>");
								b += "</table>", b += "<br/>"
							}
							if(m.require_fundpass) {
								Math.random(), b = "<h3 style='margin-bottom:10px'>" + lang_string("资金密码") + ":</h3><hr>";
								b += "<table id='tablePending' style='width: 90%'>", b += "<tr><td class='noty-td'>" + lang_string("输入资金密码") + ": </td><td width='70%'><input class='inputRate' type='password' name='fundpass' id='fundpass' autocomplete='new-password' placeholder='" + lang_string("请输入资金密码") + "'></td></tr>", b += "<tr><td class='noty-td'>" + lang_string("有效期限") + ": </td><td width='70%'>" + lang_string("2小时") + " &nbsp;&nbsp;（" + lang_string("如有IP变化仍需输入") + "）</td></tr>", b += "</table><tr><td><label name='tips' id='tips'>" + m.msg + "</label></td></tr>";
								var h = $(".noty_container").noty({
									text: b,
									type: "confirm",
									layout: "center",
									theme: "gateioNotyTheme",
									animation: {
										open: {
											height: "toggle"
										},
										close: {
											height: "toggle"
										},
										easing: "swing",
										speed: 50
									},
									buttons: [{
										addClass: "btn btn-success dp-noty-btn",
										text: lang_string("确定提交"),
										onClick: function() {
											v()
										}
									}, {
										addClass: "btn btn-error dp-noty-btn",
										text: lang_string("取消"),
										onClick: function(t) {
											return t.close(), !1
										}
									}],
									callback: {
										onShow: function() {
											p.my_orders_num = -1
										},
										afterShow: function() {
											var t = $(".noty_container").find("ul"),
												n = document.body.clientHeight;
											t.css("top", (n - t.height()) / 2), $("#fundpass").keyup(function(t) {
												13 == t.keyCode && v()
											})
										},
										afterClose: function() {
											$(".noty_modal").remove()
										}
									}
								});

								function v() {
									var t = $("#fundpass").val();
									return "" == t ? ($("#tips").html("<span style=color:#ff5d5d>" + lang_string("密码不能为空，请再次输入") + "</span>"), $("#fundpass").focus(), !1) : (p.on_request_biz_push_confirmed(n, i, l, o, _, g, u, c, d, t), h.close(), !0)
								}
							} else if(m.result) gate_success_noty(b), $(".noty_modal").remove(), p.my_orders_num = -1;
							else {
								var x = m.rescode,
									k = m.res_pay_code;
								if(1 == x) var w = lang_string("去登记");
								else w = lang_string(2 == x || k < 3 ? "去绑定" : 5 == x ? "返回修改" : "确定");
								$(".noty_container").noty({
									text: "<div class=noty-padding>" + m.msg + "</div>",
									type: "confirm",
									layout: "center",
									theme: "gateioNotyTheme",
									modal: !0,
									animation: {
										open: {
											height: "toggle"
										},
										close: {
											height: "toggle"
										},
										easing: "swing",
										speed: 50
									},
									buttons: [{
										addClass: "btn btn-success dp-noty-btn",
										text: w,
										onClick: function(t) {
											1 == x ? window.location.href = "/myaccount/id_setup" : 2 == x || k < 3 ? window.location.href = "/myaccount/payment_setup" : 5 == x ? (t.close(), $(".biz-tips").find("span").text(""), "buy" == n ? setTimeout(function() {
												busi_buy_show(), $("#biz_buy_rate").focus()
											}, 200) : setTimeout(function() {
												busi_sell_show(), $("#biz_sell_rate").focus()
											}, 200)) : t.close()
										}
									}, {
										addClass: "btn btn-error dp-noty-btn",
										text: lang_string("取消"),
										onClick: function(t) {
											return t.close(), !1
										}
									}],
									callback: {
										onShow: function() {
											p.my_orders_num = -1
										},
										afterShow: function() {
											var t = $(".noty_container").find("ul"),
												n = document.body.clientHeight;
											t.css("top", (n - t.height()) / 2)
										},
										afterClose: function() {
											$(".noty_modal").remove()
										}
									}
								})
							}
							m = null
						},
						error: function(t, n, e) {
							$(".noty_container").noty({
								text: lang_string("网络错误") + t.status + " " + t.responseText + " " + status + " " + e,
								type: "error",
								layout: "bottomLeft",
								closeWith: ["button", "click"],
								theme: "gateioNotyTheme",
								animation: {
									open: {
										height: "toggle"
									},
									close: {
										height: "toggle"
									},
									easing: "swing",
									speed: 50
								},
								timeout: 5e3,
								callback: {
									onShow: function() {
										p.my_orders_num = -1
									},
									afterShow: function() {
										var t = $(".noty_container").find("ul"),
											n = document.body.clientHeight;
										t.css("top", (n - t.height()) / 2)
									},
									afterClose: function() {
										$(".noty_modal").remove()
									}
								}
							})
						}
					})
				}
			},
			cancel_biz_push_order: function(t, n) {
				var e = t.split("_"),
					i = "";
				i += lang_string("确定撤销挂单？"), i += "<hr/>", i += "<table id='tablePending'>", i += "<tr><td>" + lang_string("单号") + ": </td><td>" + n + "</td></tr>", i += "<tr><td>" + lang_string("交易对") + ": </td><td>" + e[0].toUpperCase() + "/" + e[1].toUpperCase() + "</td></tr>", i += "</table>", noty({
					text: i,
					type: "confirm",
					layout: "center",
					theme: "gateioNotyTheme",
					modal: !0,
					animation: {
						open: {
							height: "toggle"
						},
						close: {
							height: "toggle"
						},
						easing: "swing",
						speed: 50
					},
					buttons: [{
						addClass: "btn btn-success",
						text: lang_string("确定"),
						onClick: function(e) {
							var a = {
								type: "cancel",
								symbol: t,
								oid: n
							};
							$.ajax({
								type: "get",
								url: "/json_svr/biz_push/?u=1" + page_rand(),
								data: a,
								xhrFields: {
									withCredentials: !0
								},
								success: function(t, e) {
									var a = t;
									a && a.result ? (gate_success_noty(i = "<div class='cancel_content'>" + lang_string("撤单成功") + "!</div>"), p.my_orders_num = -1, p.cancelled_orders.push(n)) : (gate_warning_noty(i = "<div class='cancel_content'>" + lang_string("撤单失败") + "! " + a.msg + "</div>"), p.my_orders_num = -1), a = null
								},
								error: function() {
									gate_error_noty(lang_string("网络错误！"))
								}
							}), e.close()
						}
					}, {
						addClass: "btn btn-error",
						text: lang_string("取消"),
						onClick: function(t) {
							t.close()
						}
					}]
				})
			},
			update_push_order: function(t, n, e, i, a, l, s) {
				var r = "",
					o = "",
					_ = lang_string("确定"),
					g = lang_string("取消");
				if(null == s && (s = 0), "paid" == a) {
					if(1 != s) {
						var u = "<h3>" + lang_string("我已付款") + "</h3><hr/>";
						return u += "<ul id=tablePending class=n-confirm>", u += "<li><span class='recheck-tip'>" + lang_string("卖家收款账号有可能已经变更，请务必在付款时再次核对账号信息！确定已经支付?") + "</span></li>", u += "<li><b><span class='red'>" + lang_string("恶意点击，将会暂停账号功能！") + "</span></b></li>", u += "<li><b><label><input id='pay_risk' name='pay_risk' type='checkbox'/>", u += lang_string("我确认用本人账户已手工转账给") + i + "，<font class=money-font>" + e + "</font>" + lang_string("元") + "</label></b></li>", u += "<label id='update_push_tips'></label>", u += "<br/>", void noty({
							text: u,
							id: "paid_confirm",
							type: "confirm",
							layout: "center",
							theme: "gateioNotyTheme",
							modal: !0,
							animation: {
								open: {
									height: "toggle"
								},
								close: {
									height: "toggle"
								},
								easing: "swing",
								speed: 50
							},
							buttons: [{
								addClass: "btn btn-success",
								text: lang_string("已经支付"),
								onClick: function(s) {
									get_element("pay_risk").checked ? (p.update_push_order(t, n, e, i, a, l, 1), s.close()) : $("#update_push_tips").html("<span style=color:#ff5d5d>" + lang_string("请确认已付款") + "</span>")
								}
							}, {
								addClass: "btn btn-error",
								text: lang_string("返回支付"),
								onClick: function(t) {
									t.close()
								}
							}]
						})
					}
					r = lang_string("我已付款") + "<span class=font-thin>（" + lang_string("非自动扣款，请先给卖家转账然后再进行该操作") + "）</span>", o = lang_string("请使用卖家支持的方式支付，如未实际付款完成，进行该操作，一经核实，将会暂停账号功能！")
				} else if("accepted" == a) r = lang_string("确认已收款") + "<span class=font-thin>（" + lang_string("务必查看是否已收到相应款项") + "）</span>", o = lang_string("请确认已经收到相应款项，操作后资金将直接打给对方，有不可追回风险，慎重操作！"), 1 == s && (o = lang_string("对方可能未付款，有不可追回风险，慎重操作！")), _ = lang_string("确认已收款");
				else if("dispute" == a) r = lang_string("申请仲裁"), o = lang_string("请点击我要申诉提交付款证明等信息");
				else {
					if("cancel" != a) return void gate_warning_noty(lang_string("无效操作"));
					r = lang_string("撤销买单"), o = lang_string("撤单后交易取消，切勿再付款（如已付款切勿撤销），恶意撤销，将禁封交易")
				}
				var c = t.split("_");
				u = "";
				if(u += "<h3>" + lang_string("确认对订单进行以下操作?") + "</h3>", u += "<hr/>", u += "<ul id=tablePending class=n-confirm>", u += "<li>" + lang_string("单号") + ": <b>" + n + "</b></li>", u += "<li>" + lang_string("交易对") + ": <b>" + c[0].toUpperCase() + " / " + c[1].toUpperCase() + "</b></li>", u += "<li>" + lang_string("总额") + ": <font class=money-font>" + e + "</font><span class=coin-unit>" + c[1].toUpperCase() + "</span></li>", void 0 !== i && "" != i && (u += "<li>" + lang_string("对方姓名") + ": <b>" + i + "</b></li>"), u += "<li>" + lang_string("操作") + ": <b>" + r + "</b></li>", u += "<li class='imp-tips'>" + lang_string("重要提示(必看)") + ": <b><span class='red'>" + o + "</span></b></li>", 1 == s && "accepted" == a && (u += "<li>" + lang_string("请选择") + ": <b><label><input id='confirmed_risk' name='confirmed_risk' type='checkbox'/>" + lang_string("已确认收到款项") + "</label></b></li>"), "paid" == a && "" != l) {
					u += "<li>" + lang_string("我的支付方式") + ": ";
					var d, f, m, b = l.split(",");
					for(d = 0; b.length > d; d++) "" != b[d] && ("pay_ali" == b[d] && (m = lang_string("支付宝"), f = 0), "pay_wechat" == b[d] && (m = lang_string("微信"), f = 1), "pay_bank" == b[d] && (m = lang_string("银行卡"), f = 2), u += "<label><input name='sel_paytype' type='radio' value='" + f + "' " + void 0 + "/>" + m + "</label>");
					u += " <span class=coin-unit>(" + lang_string("提示卖家") + ")</span></li>", _ = lang_string("我已付款"), g = lang_string("未完成付款?")
				}
				"cancel" == a && (u += "<li>" + lang_string("请确认") + ": <b><label><input id='cancel_risk' name='cancel_risk' type='checkbox'/>" + lang_string("我确定没有付款，撤单后也不会再付款") + "</label></b></li>"), u += "</ul>", u += "<label id='update_push_tips'></label>", noty({
					text: u,
					type: "confirm",
					layout: "center",
					theme: "gateioNotyTheme",
					modal: !0,
					animation: {
						open: {
							height: "toggle"
						},
						close: {
							height: "toggle"
						},
						easing: "swing",
						speed: 50
					},
					buttons: [{
						addClass: "btn btn-success",
						text: _,
						onClick: function(r) {
							if(1 != s || "accepted" != a || get_element("confirmed_risk").checked) {
								var o = "";
								if("paid" == a)
									if(null == (o = $('input:radio[name="sel_paytype"]:checked').val()) || "" == o || "0" != o && "1" != o && "2" != o) return void $("#update_push_tips").html("<span style=color:#ff5d5d>" + lang_string("请选择实际支付方式") + "</span>");
								if("cancel" != a || get_element("cancel_risk").checked) {
									var _ = {
										type: "update",
										op: a,
										symbol: t,
										tid: n,
										confirmed: s,
										sel_paytype: o
									};
									$.ajax({
										type: "get",
										url: "/json_svr/push/?u=1" + page_rand(),
										data: _,
										xhrFields: {
											withCredentials: !0
										},
										success: function(s, r) {
											var o = s;
											o && (o.require_confirmed ? p.update_push_order(t, n, e, i, a, l, 1) : o && o.result ? (gate_success_noty(u = "<div class='cancel_content'>" + lang_string("操作成功!") + "</div>"), $.removeCookie("od" + n, {
												path: "/"
											})) : gate_warning_noty(u = "<div class='cancel_content'>" + lang_string("操作失败!") + o.msg + "</div>")), o = null
										},
										error: function() {
											gate_error_noty(lang_string("网络错误"))
										}
									}), r.close()
								} else $("#update_push_tips").html("<span style=color:#ff5d5d>" + lang_string("请确认未付款，撤单后也不会再付款") + "</span>")
							} else $("#update_push_tips").html("<span style=color:#ff5d5d>" + lang_string("请确认已收到款项") + "</span>")
						}
					}, {
						addClass: "btn btn-error",
						text: g,
						onClick: function(t) {
							t.close()
						}
					}]
				})
			},
			push_query: function(t, n, e, i) {
				if("cny" == t || "usd" == t || "krw" == t)
					if(n < 0 || n > 1e9) gate_warning_noty(lang_string("请输入有效金额"));
					else if(valid_paytype(i)) {
					var a = {
						type: "push_order_list",
						sell_type: t,
						amount: n,
						want_type: e,
						pay_type: i
					};
					$.ajax({
						type: "get",
						url: "/json_svr/query_push/?u=11" + page_rand(),
						data: a,
						xhrFields: {
							withCredentials: !0
						},
						success: function(t, n) {
							var e = t;
							if(e && e.result && e.push_order_list) {
								var i = p.build_push_order_table(e.push_order_list, 10);
								"" != i && (get_element("ul-push-list").innerHTML = i)
							}
							e = null
						},
						error: function(t, n, e) {
							gate_error_noty(lang_string("网络错误:") + t.status + " " + t.responseText + " " + status + " " + e)
						}
					})
				} else gate_warning_noty(lang_string("无效支付方式"));
				else gate_warning_noty(lang_string("无效交易类型"))
			},
			build_push_order_table: function(t, n) {
				for(var e = 0, i = "", a = 0; a < t.length; a++) {
					var l = t[a];
					if(++e > n) break;
					line_class = e % 2 == 1 ? "odd hanga" : "even hangb";
					var s = l.orderid,
						r = l.rate,
						o = l.amount,
						_ = l.total,
						g = l.min_vol,
						u = l.pay_type;
					l.rate <= 0 || l.total <= 0 || l.min_vol <= 0 || (l.mine ? i += "<li  class='orderline orderline_mine " + line_class + "'> " : i += "<li  class='orderline " + line_class + "'> ", i += '<span class= "right-align">' + s + '</span>  <span class= "right-align">' + r + '</span>  <span class= "right-align">' + o + '</span>   <span class= "right-align">' + _ + '</span>   <span class= "right-align">' + g + '</span> <span class= "right-align">' + u + '</span> <span class= "right-align"><a href="javascript:void(0)" onclick="buy(' + s + "," + r + "," + o + "," + _ + "," + g + ');" style="font-size:14px;">' + lang_string("购买") + "</a></span>", i += "</li>")
				}
				return i
			},
			rebuild_my_order_table: function() {
				var t, n = 0,
					i = 0,
					a = "",
					l = p.my_orders,
					s = p.cancelled_orders,
					r = "red",
					o = "green";
				for(void 0 !== $.cookie("lang") && "" != $.cookie("lang") && "cn" != $.cookie("lang") && (r = "green", o = "red"), t = 0; l.length > t; t++) {
					i = 0;
					for(var _ = 0; _ < s.length; _++)
						if(l[t].orderid == s[_]) {
							i = 1;
							break
						}
					if(0 == i) {
						var g, u = l[t].pay_type_num.split(","),
							c = "";
						for(g = 0; u.length > g; g++) "" != u[g] && (c += "<img class=pay_icon" + u[g] + " src=../images/pay_type_icon" + u[g] + ".svg />");
						a += "<tr>", a += "<td>" + l[t].orderid + "</td>", a += "<td align='right'>" + l[t].time + "</td>", a += "<td align='right'>" + ("sell" == l[t].type ? "<span class='" + o + "'>" + lang_string("卖出") + "</span>" : "<span class='" + r + "'>" + lang_string("买入") + "</span>") + "</td>", a += "<td align='right'>" + l[t].rate + "</td>", a += "<td align='right'>" + l[t].amount + "</td>", a += "<td align='right'>" + l[t].total + "</td>", a += "<td align='right'>" + l[t].limit_total + "</td>", a += "<td align='right'>" + l[t].locked_amount + "</td>", a += "<td align='right'>" + c + "</td>", a += "<td align='right'>" + (l[t].orderid > 0 ? "<a href='javascript:void(0)', onclick='_page.obj.cancel_biz_push_order(\"" + e + '",' + l[t].orderid + ");'>" + lang_string("撤单") + "</a>" : "--") + "</td>", a += "</tr>", n++
					}
				}
				a += "<tr class='table-empty'><td style='text-align: center'><p><i>i</i>" + lang_string("暂无订单") + "</p></td></tr>", get_element("businessPushOrder") && (get_element("businessPushOrder").innerHTML = a), n > 0 && $("#businessPushOrder").css("display", ""), p.my_orders_num = n
			},
			rebuild_my_transaction_table: function() {
				var t, n = 0,
					i = "--",
					l = "",
					s = "",
					r = p.my_transactions,
					o = "red",
					_ = "green";
				for(void 0 !== $.cookie("lang") && "" != $.cookie("lang") && "cn" != $.cookie("lang") && (o = "green", _ = "red"), t = 0; r.length > t; t++) {
					var g = r[t].txid;
					$("#order_" + g).hasClass("new-order") ? s += "<tr id=order_" + g + " class='odd new-order' data-id=" + t + ">" : s += "<tr id=order_" + g + " class=odd data-id=" + t + ">", s += "<td class=o-txid>" + g + "<i class=caret></i></td>", s += "<td class=o-type align='left'>" + (r[t].suid == a ? "<span class='" + _ + "'>" + lang_string("卖出") + "</span>" : "<span class='" + o + "'>" + lang_string("买入") + "</span>") + "</td>", s += "<td align='right'>" + r[t].rate + "</td>", s += "<td align='right'>" + r[t].amount + "</td>", s += "<td class=o-total align='right'>" + r[t].total + "</td>", l = r[t].status, i = "--";
					var u = "";

					function c(t) {
						$.removeCookie("od" + t, {
							path: "/"
						})
					}
					u = "1" == r[t].show_bank ? "pay_bank" : "", u += "1" == r[t].show_ali ? ",pay_ali" : "", u += "1" == r[t].show_wechat ? ",pay_wechat" : "", "unpay" == l ? (r[t].buid == a ? i = "<button class='btn-success tooltip' title='" + lang_string("非自动扣款，请先给卖家转账然后再进行该操作") + "' onclick='_page.obj.update_push_order(\"" + e + '","' + g + '","' + r[t].total + '","' + r[t].its_realname + '","paid","' + u + "\");'>" + lang_string("我已付款") + "</button>" : r[t].suid == a && (i = "<button class='btn-normal tooltip' title='" + lang_string("务必查看是否已收到相应款项") + "' onclick='_page.obj.update_push_order(\"" + e + '","' + g + '","' + r[t].total + '","' + r[t].its_realname + '","accepted","' + u + "\");'>" + lang_string("确认已收款") + "</button>"), l = lang_string("待付款")) : "paid" == l ? (l = lang_string("已付款"), i = "<button class=btn-warn onclick='_page.obj.update_push_order(\"" + e + '", "' + g + '", "' + r[t].total + '", "", "dispute");\'>' + lang_string("申请仲裁") + "</button>") : "unconfirmed" == l ? (l = lang_string("已付款"), i = "<button class=btn-normal onclick='_page.obj.update_push_order(\"" + e + '", "' + g + '", "' + r[t].total + '","' + r[t].its_realname + '", "accepted","' + u + "\");'>" + lang_string("确认已收款") + "</button>") : "expired" == l ? (l = lang_string("已经过期"), c(g)) : "finished" == l ? l = lang_string("已完成") : "locked" == l ? l = lang_string("已锁定") : "cancel" == l ? (l = lang_string("已取消"), c(g)) : "bclosed" == l ? l = lang_string("已完成") : "sclosed" == l && (l = lang_string("已取消"), c(g)), s += "<td class=o-status align='right'>" + l + "</td>", s += "<td class=o-name align='right'>" + r[t].its_realname + "</td>", s += "<td class=o-time align='right'>" + r[t].timest + "</td>", s += "<td align='right' class=order-operator><span>" + i + "</span>", s += "</td>", s += "</tr>", n++
				}
				if(s += "<tr class='table-empty'><td style='text-align: center'><p><i>i</i>" + lang_string("暂无订单") + "</p></td></tr>", get_element("myPushOrder")) {
					var d = $("#myPushOrder").find(".order-opened").attr("id"),
						f = $(".type-active").index(); - 1 == f && (f = 0), get_element("myPushOrder").innerHTML = s, $(".tooltip").toolTip(), null == d ? initMyPushOrder("", "", r) : initMyPushOrder(d, f, r)
				}
				n > 0 && $("#myPushOrder").css("display", "")
			},
			rebuild_my_transaction_time: function() {
				var t = p.my_transtime;
				if(!(t.length <= 0) && get_element("myPushOrder")) {
					var n = $("#myPushOrder").find(".order-opened"),
						e = n.attr("data-id");
					if(null != e) {
						var i = t[e].od_time;
						orderTimeGo(n, i)
					}
				}
			},
			reload_order_data: function() {
				var n, i = {
					type: "my_push_order_list",
					symbol: e
				};
				p.my_orders_num = 0, "undefined" == typeof oldData && (oldData = null), $.ajax({
					type: "get",
					url: "/json_svr/query_push/?u=13" + page_rand(),
					data: i,
					xhrFields: {
						withCredentials: !0
					},
					success: function(i, a) {
						var l, _ = i;
						if(_ && _.result) {
							0 == _.balance_sell_able ? get_element("balance_sell_able").innerHTML = "0.0000" : get_element("balance_sell_able").innerHTML = _.balance_sell_able, _.order && _.order.length > 0 ? (p.my_orders = _.order, p.rebuild_my_order_table()) : (p.my_orders.length = 0, p.rebuild_my_order_table()), n = _.transaction;
							var g = JSON.stringify(n);
							if(oldData != g && (_.transaction && _.transaction.length > 0 ? (p.my_transactions = _.transaction, p.rebuild_my_transaction_table()) : (p.my_transactions.length = 0, p.rebuild_my_transaction_table())), oldData = g, _.trans_time && _.trans_time.length > 0 ? (p.my_transtime = _.trans_time, p.rebuild_my_transaction_time()) : (p.my_transtime.length = 0, p.rebuild_my_transaction_time()), _.my_trade_noty && _.my_trade_noty.length > 0) {
								var u = "";
								for(l = 0; l < _.my_trade_noty.length; l++)
									if(t = _.my_trade_noty[l], u = "", t.result) {
										get_element("audio").play(), u += t.trade_type + " " + get_view_symbol(e, "l") + lang_string("已匹配"), u += "<hr/>", gate_success_noty(u += "<ul id='tableTradeNoty'><li>" + lang_string("匹配价格") + ": <span>" + num_fix(t.rate, s) + "</span><i>" + get_view_symbol(e, "r") + "</i></li><li>" + lang_string("匹配数量") + ": <span>" + num_fix(t.vol, r) + "</span><i>" + get_view_symbol(e, "l") + "</i></li><li>" + lang_string("总额") + ": <span>" + num_fix(t.total, o) + "</span><i>" + get_view_symbol(e, "r") + "</i></li></ul>");
										var c = $(".type-active").index(),
											d = $("#order_" + t.tid); - 1 == c && (c = 0), d.siblings().hasClass("order-opened") ? d.addClass("new-order") : expandOrder(d, 1, 1, 1, c, n)
									} else gate_warning_noty(u = "<div class='cancel_content'>" + lang_string("匹配失败! 请稍后再试") + "</div>")
							}
							if(_.my_cancel_noty && _.my_cancel_noty.length > 0) {
								u = "";
								for(l = 0; l < _.my_cancel_noty.length; l++) t = _.my_cancel_noty[l], u = "", u += "<span class=red>" + lang_string("订单") + lang_string("已取消") + "</span>", u += "<hr/>", u += "<ul id='tableTradeNoty'><li>" + lang_string("订单号") + ": <span>" + t.tid + "</span></li>", u += "<li>" + lang_string("取消时间") + ": <span>" + t.datetime + "</span></li>", u += "<li><div class='cancel_content'>" + lang_string("取消订单切勿再付款，如操作失误，请点击") + "<a href='/myaccount/apply_dispute/" + t.tid + "' target=_blank>" + lang_string("这里提交申诉") + "</a>," + lang_string("及时上传付款证明等资料") + "</div></li>", gate_warning_noty(u += "</ul>")
							}
						}
					},
					error: function(t, n, e) {
						p.my_orders_num = -1
					}
				})
			},
			recheck_order_list: function() {
				a && a > 0 && p.reload_order_data()
			},
			recheck: function() {
				p.recheck_order_list()
			}
		},
		f = {
			re_data: [],
			reload_station_news: function() {
				var t = {
					type: "station_news",
					uid: a
				};
				$.ajax({
					type: "get",
					url: "/json_svr/query_push/?u=13" + page_rand(),
					data: t,
					xhrFields: {
						withCredentials: !0
					},
					success: function(t, n) {
						var e = t;
						if(e && e.result && e.data.length > 0) {
							var l = e.data;
							for(msgHtml = "", i = 0; l.length > i; i++) op = l[i].message, txid = l[i].txid, timest = l[i].timest, salt = l[i].salt, 1 != f.re_data[salt] && (f.re_data[salt] = 1, "cancel" == op ? status = lang_string("买家取消订单") : "dispute" == op ? status = lang_string("申请仲裁") : "paid" == op ? status = lang_string("买家已确认付款") : "accepted" == op && (status = lang_string("卖家已确认收款")), msgHtml += '<li onclick="_page.push_news_obj.message_expand_det(' + txid + ')"><span class="message-id">' + timest + " 单号：" + txid + '</span><span class="message-status">' + status + '</span><span><input type="radio" onclick="_page.push_news_obj.read_news(\'' + salt + "','" + txid + "','" + a + "',$(this))\" ></span></li>");
							get_element("massages-item").getElementsByTagName("li").length > 0 ? $(".massages-item").append(msgHtml) : $(".massages-item").html(msgHtml)
						} else {
							0 == get_element("massages-item").getElementsByTagName("li").length && $(".massages-item").html('<div class="no-unread text-center">' + lang_string("当前没有待处理订单消息") + "</div>")
						}
					},
					error: function(t, n, e) {}
				})
			},
			message_expand_det: function(t) {
				var n = "order_" + t;
				try {
					get_element(n).click()
				} catch(t) {}
			},
			read_news: function(t, n, e, i) {
				var a = {
					type: "read_news",
					txid: n,
					salt: t
				};
				$.ajax({
					type: "get",
					url: "/json_svr/query_push/?u=13" + page_rand(),
					data: a,
					xhrFields: {
						withCredentials: !0
					},
					success: function(t) {
						t && t.result && setTimeout(function() {
							i.parent().parent().remove()
						}, 3e3)
					},
					error: function(t, n, e) {}
				})
			},
			recheck: function() {
				f.reload_station_news()
			}
		};
	return {
		main_rate: u,
		obj: p,
		push_notice: d,
		push_news_obj: f,
		run: function() {
			p.recheck(), $.timer(function() {
				c.recheck()
			}, 5e3, !0), $.timer(function() {
				p.recheck()
			}, 5e3, !0), $.timer(function() {
				u.recheck()
			}, 1e4, !0)
		}
	}
}! function(t, n) {
	"function" == typeof define && define.amd ? define(["jquery"], n) : "object" == typeof exports ? module.exports = n(require("jquery")) : n(t.jQuery)
}(this, function(t, n) {
	function e(t, n, e) {
		var i = g[n.type] || {};
		return null == t ? e || !n.def ? null : n.def : (t = i.floor ? ~~t : parseFloat(t), i.mod ? (t + i.mod) % i.mod : Math.min(i.max, Math.max(0, t)))
	}

	function i(n) {
		var e = o(),
			i = e._rgba = [];
		return n = n.toLowerCase(), u(r, function(t, a) {
			var l, s = a.re.exec(n),
				r = s && a.parse(s),
				o = a.space || "rgba";
			if(r) return l = e[o](r), e[_[o].cache] = l[_[o].cache], i = e._rgba = l._rgba, !1
		}), i.length ? ("0,0,0,0" === i.join() && t.extend(i, l.transparent), e) : l[n]
	}

	function a(t, n, e) {
		return 6 * (e = (e + 1) % 1) < 1 ? t + (n - t) * e * 6 : 2 * e < 1 ? n : 3 * e < 2 ? t + (n - t) * (2 / 3 - e) * 6 : t
	}
	var l, s = /^([\-+])=\s*(\d+\.?\d*)/,
		r = [{
			re: /rgba?\(\s*(\d{1,3})\s*,\s*(\d{1,3})\s*,\s*(\d{1,3})\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
			parse: function(t) {
				return [t[1], t[2], t[3], t[4]]
			}
		}, {
			re: /rgba?\(\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
			parse: function(t) {
				return [2.55 * t[1], 2.55 * t[2], 2.55 * t[3], t[4]]
			}
		}, {
			re: /#([a-f0-9]{2})([a-f0-9]{2})([a-f0-9]{2})/,
			parse: function(t) {
				return [parseInt(t[1], 16), parseInt(t[2], 16), parseInt(t[3], 16)]
			}
		}, {
			re: /#([a-f0-9])([a-f0-9])([a-f0-9])/,
			parse: function(t) {
				return [parseInt(t[1] + t[1], 16), parseInt(t[2] + t[2], 16), parseInt(t[3] + t[3], 16)]
			}
		}, {
			re: /hsla?\(\s*(\d+(?:\.\d+)?)\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
			space: "hsla",
			parse: function(t) {
				return [t[1], t[2] / 100, t[3] / 100, t[4]]
			}
		}],
		o = t.Color = function(n, e, i, a) {
			return new t.Color.fn.parse(n, e, i, a)
		},
		_ = {
			rgba: {
				props: {
					red: {
						idx: 0,
						type: "byte"
					},
					green: {
						idx: 1,
						type: "byte"
					},
					blue: {
						idx: 2,
						type: "byte"
					}
				}
			},
			hsla: {
				props: {
					hue: {
						idx: 0,
						type: "degrees"
					},
					saturation: {
						idx: 1,
						type: "percent"
					},
					lightness: {
						idx: 2,
						type: "percent"
					}
				}
			}
		},
		g = {
			byte: {
				floor: !0,
				max: 255
			},
			percent: {
				max: 1
			},
			degrees: {
				mod: 360,
				floor: !0
			}
		},
		u = t.each;
	u(_, function(t, n) {
		n.cache = "_" + t, n.props.alpha = {
			idx: 3,
			type: "percent",
			def: 1
		}
	}), o.fn = t.extend(o.prototype, {
		parse: function(a, s, r, g) {
			if(a === n) return this._rgba = [null, null, null, null], this;
			(a.jquery || a.nodeType) && (a = t(a).css(s), s = n);
			var c = this,
				d = t.type(a),
				p = this._rgba = [];
			return s !== n && (a = [a, s, r, g], d = "array"), "string" === d ? this.parse(i(a) || l._default) : "array" === d ? (u(_.rgba.props, function(t, n) {
				p[n.idx] = e(a[n.idx], n)
			}), this) : "object" === d ? (u(_, a instanceof o ? function(t, n) {
				a[n.cache] && (c[n.cache] = a[n.cache].slice())
			} : function(n, i) {
				var l = i.cache;
				u(i.props, function(t, n) {
					if(!c[l] && i.to) {
						if("alpha" === t || null == a[t]) return;
						c[l] = i.to(c._rgba)
					}
					c[l][n.idx] = e(a[t], n, !0)
				}), c[l] && t.inArray(null, c[l].slice(0, 3)) < 0 && (c[l][3] = 1, i.from && (c._rgba = i.from(c[l])))
			}), this) : void 0
		},
		is: function(t) {
			var n = o(t),
				e = !0,
				i = this;
			return u(_, function(t, a) {
				var l, s = n[a.cache];
				return s && (l = i[a.cache] || a.to && a.to(i._rgba) || [], u(a.props, function(t, n) {
					if(null != s[n.idx]) return e = s[n.idx] === l[n.idx]
				})), e
			}), e
		},
		_space: function() {
			var t = [],
				n = this;
			return u(_, function(e, i) {
				n[i.cache] && t.push(e)
			}), t.pop()
		},
		transition: function(t, n) {
			var i = o(t),
				a = i._space(),
				l = _[a],
				s = 0 === this.alpha() ? o("transparent") : this,
				r = s[l.cache] || l.to(s._rgba),
				c = r.slice();
			return i = i[l.cache], u(l.props, function(t, a) {
				var l = a.idx,
					s = r[l],
					o = i[l],
					_ = g[a.type] || {};
				null !== o && (null === s ? c[l] = o : (_.mod && (o - s > _.mod / 2 ? s += _.mod : s - o > _.mod / 2 && (s -= _.mod)), c[l] = e((o - s) * n + s, a)))
			}), this[a](c)
		},
		blend: function(n) {
			if(1 === this._rgba[3]) return this;
			var e = this._rgba.slice(),
				i = e.pop(),
				a = o(n)._rgba;
			return o(t.map(e, function(t, n) {
				return(1 - i) * a[n] + i * t
			}))
		},
		toRgbaString: function() {
			var n = "rgba(",
				e = t.map(this._rgba, function(t, n) {
					return null != t ? t : n > 2 ? 1 : 0
				});
			return 1 === e[3] && (e.pop(), n = "rgb("), n + e.join() + ")"
		},
		toHslaString: function() {
			var n = "hsla(",
				e = t.map(this.hsla(), function(t, n) {
					return null == t && (t = n > 2 ? 1 : 0), n && n < 3 && (t = Math.round(100 * t) + "%"), t
				});
			return 1 === e[3] && (e.pop(), n = "hsl("), n + e.join() + ")"
		},
		toHexString: function(n) {
			var e = this._rgba.slice(),
				i = e.pop();
			return n && e.push(~~(255 * i)), "#" + t.map(e, function(t) {
				return("0" + (t || 0).toString(16)).substr(-2)
			}).join("")
		},
		toString: function() {
			return 0 === this._rgba[3] ? "transparent" : this.toRgbaString()
		}
	}), o.fn.parse.prototype = o.fn, _.hsla.to = function(t) {
		if(null == t[0] || null == t[1] || null == t[2]) return [null, null, null, t[3]];
		var n, e, i = t[0] / 255,
			a = t[1] / 255,
			l = t[2] / 255,
			s = t[3],
			r = Math.max(i, a, l),
			o = Math.min(i, a, l),
			_ = r - o,
			g = r + o,
			u = .5 * g;
		return n = o === r ? 0 : i === r ? 60 * (a - l) / _ + 360 : a === r ? 60 * (l - i) / _ + 120 : 60 * (i - a) / _ + 240, e = 0 === _ ? 0 : u <= .5 ? _ / g : _ / (2 - g), [Math.round(n) % 360, e, u, null == s ? 1 : s]
	}, _.hsla.from = function(t) {
		if(null == t[0] || null == t[1] || null == t[2]) return [null, null, null, t[3]];
		var n = t[0] / 360,
			e = t[1],
			i = t[2],
			l = t[3],
			s = i <= .5 ? i * (1 + e) : i + e - i * e,
			r = 2 * i - s;
		return [Math.round(255 * a(r, s, n + 1 / 3)), Math.round(255 * a(r, s, n)), Math.round(255 * a(r, s, n - 1 / 3)), l]
	}, u(_, function(i, a) {
		var l = a.props,
			r = a.cache,
			_ = a.to,
			g = a.from;
		o.fn[i] = function(i) {
			if(_ && !this[r] && (this[r] = _(this._rgba)), i === n) return this[r].slice();
			var a, s = t.type(i),
				c = "array" === s || "object" === s ? i : arguments,
				d = this[r].slice();
			return u(l, function(t, n) {
				var i = c["object" === s ? t : n.idx];
				null == i && (i = d[n.idx]), d[n.idx] = e(i, n)
			}), g ? ((a = o(g(d)))[r] = d, a) : o(d)
		}, u(l, function(n, e) {
			o.fn[n] || (o.fn[n] = function(a) {
				var l, r, o, _, g = t.type(a);
				return r = (l = this[_ = "alpha" === n ? this._hsla ? "hsla" : "rgba" : i]())[e.idx], "undefined" === g ? r : ("function" === g && (a = a.call(this, r), g = t.type(a)), null == a && e.empty ? this : ("string" === g && (o = s.exec(a)) && (a = r + parseFloat(o[2]) * ("+" === o[1] ? 1 : -1)), l[e.idx] = a, this[_](l)))
			})
		})
	}), o.hook = function(n) {
		var e = n.split(" ");
		u(e, function(n, e) {
			t.cssHooks[e] = {
				set: function(n, a) {
					var l;
					"transparent" === a || "string" === t.type(a) && !(l = i(a)) || (a = (a = o(l || a)).toRgbaString()), n.style[e] = a
				}
			}, t.fx.step[e] = function(n) {
				n.colorInit || (n.start = o(n.elem, e), n.end = o(n.end), n.colorInit = !0), t.cssHooks[e].set(n.elem, n.start.transition(n.end, n.pos))
			}
		})
	}, o.hook("backgroundColor borderBottomColor borderLeftColor borderRightColor borderTopColor color columnRuleColor outlineColor textDecorationColor textEmphasisColor"), t.cssHooks.borderColor = {
		expand: function(t) {
			var n = {};
			return u(["Top", "Right", "Bottom", "Left"], function(e, i) {
				n["border" + i + "Color"] = t
			}), n
		}
	}, l = t.Color.names = {
		aqua: "#00ffff",
		black: "#000000",
		blue: "#0000ff",
		fuchsia: "#ff00ff",
		gray: "#808080",
		green: "#008000",
		lime: "#00ff00",
		maroon: "#800000",
		navy: "#000080",
		olive: "#808000",
		purple: "#800080",
		red: "#ff0000",
		silver: "#c0c0c0",
		teal: "#008080",
		white: "#ffffff",
		yellow: "#ffff00",
		transparent: [null, null, null, 0],
		_default: "#ffffff"
	}
});
var lang_stringlist = [];
lang_stringlist["买入数量"] = "매수수량", lang_stringlist["买入金额"] = "매수금액", lang_stringlist["买入估价"] = "예상매수가격", lang_stringlist["交易方式"] = "거래방법", lang_stringlist["确定下单"] = "확인", lang_stringlist["卖出数量"] = "매도수량", lang_stringlist["卖出金额"] = "매도금액", lang_stringlist["卖出估价"] = "예상매도가격", lang_stringlist["取消"] = "취소", lang_stringlist["无效价格，请重新输入"] = "가격 오류. 다시 입력하십시오", lang_stringlist["支付宝"] = "알리페이", lang_stringlist["微信"] = "위챗", lang_stringlist["银行卡"] = "은행카드", lang_stringlist["银行转账"] = "계좌이체", lang_stringlist["无效兑换额，请重新输入"] = "주문금액 오류. 다시 입력하십시오", lang_stringlist["无效参考价格，请重新输入"] = "기준가격 오류. 다시 입력하십시오", lang_stringlist["无效卖出数量，请重新输入"] = "매도수량 오류. 다시 입력하십시오", lang_stringlist["无效买入数量请重新输入"] = "매수수량 오류. 다시 입력하십시오", lang_stringlist["无效最小交易量，请重新输入"] = "최소 거래금액 오류. 다시 입력하십시오", lang_stringlist["无效最大交易量，请重新输入"] = "최대 거래금액 오류. 다시 입력하십시오", lang_stringlist["无效参考市场"] = "기준시장 오류", lang_stringlist["无效参考价格"] = "기준가격 오류", lang_stringlist["无效浮动价格"] = "변동가격 오류", lang_stringlist["无效浮动价格设置"] = "변동가격 설정 오류", lang_stringlist["参考价格"] = "기준가격", lang_stringlist["浮动百分比"] = "변동비율", lang_stringlist["卖出"] = "매도", lang_stringlist["买入"] = "매수", lang_stringlist["暂无挂单"] = "주문이 없습니다", lang_stringlist["请您先登录再进行操作"] = "로그인 하신 다음에 이용하십시오", lang_stringlist["单笔交易量太低"] = "거래량이 적습니다", lang_stringlist["单笔交易量超过限额，最高 15000"] = "거래량 한도초과. 최고 15000", lang_stringlist["无效交易价格"] = "거래가격 오류", lang_stringlist["无效支付方式"] = "지불방법 오류", lang_stringlist["请确认"] = "주문을 확인하십시오", lang_stringlist["订单"] = "주문이", lang_stringlist["订单号"] = "주문번호", lang_stringlist["取消时间"] = "취소 시간", lang_stringlist["取消订单切勿再付款，如操作失误，请点击"] = "주문취소 후 송금하지 마십시오. 실수한 경우", lang_stringlist["这里提交申诉"] = "이곳을", lang_stringlist["及时上传付款证明等资料"] = "클릭하여 송금 자료 증거를 첨부해 주시기 바랍니다.", lang_stringlist["重要提示"] = "중요사항", lang_stringlist["以实际订单为准"] = "매칭된 주문가격 기준", lang_stringlist["无效交易类型"] = "거래구분 오류", lang_stringlist["购买下单成功"] = "매수 주문성공", lang_stringlist["卖出下单成功"] = "매도 주문성공", lang_stringlist["价格"] = "가격", lang_stringlist["数量"] = "수량", lang_stringlist["挂单量"] = "주문수량", lang_stringlist["资金密码"] = "보안비밀번호", lang_stringlist["输入资金密码"] = "보안비밀번호를 입력하십시오", lang_stringlist["请输入资金密码"] = "보안비밀번호를 입력하십시오", lang_stringlist["有效期限"] = "만료날짜", lang_stringlist["2小时"] = "2 시간", lang_stringlist["如有IP变化仍需输入"] = "IP주소 변경시 다시 입력하시십시오", lang_stringlist["密码不能为空，请再次输入"] = "비밀번호를 입력하십시오", lang_stringlist["图形验证码不能为空，请再次输入"] = "이미지 택스트를 입력하십시오", lang_stringlist["去登记"] = "인증하러 가기", lang_stringlist["去绑定"] = "바인딩하러 가기", lang_stringlist["确定"] = "확인", lang_stringlist["网络错误"] = "네트워크 오류", lang_stringlist["网络错误:"] = "네트워크 오류:", lang_stringlist["网络错误！"] = "네트워크 오류", lang_stringlist["超出可卖出额，请检查后重新输入"] = "매도가능금액 초과. 다시 입력하십시오.", lang_stringlist["请确认商家"] = "상가를 확인하십시오", lang_stringlist["挂单"] = "주문", lang_stringlist["最小数量"] = "최소수량", lang_stringlist["最大数量"] = "최대수량", lang_stringlist["卖出价格"] = "매도가격", lang_stringlist["买入价格"] = "매수가격", lang_stringlist["支付方式"] = "지불방법", lang_stringlist["重要提示(必看)"] = "중요제시", lang_stringlist["警告"] = "경고", lang_stringlist["您的"] = "당신의", lang_stringlist["低于"] = "이하", lang_stringlist["市场平均价格"] = "시장 평균가격", lang_stringlist["请务必检查确认"] = "자세히 확인하십시오", lang_stringlist["无效交易量"] = "거래량 오류", lang_stringlist["无效的最小交易量"] = "최소거래량 오류", lang_stringlist["无效的最大交易量"] = "최대거래량 오류", lang_stringlist["确定提交"] = "제출하기", lang_stringlist["返回修改"] = "뒤로가서 수정하기", lang_stringlist["卖家收款账号有可能已经变更，请务必在付款时再次核对账号信息！确定已经支付?"] = "지불시 매도상가수취인계좌번호를 다시 확인하십시오! 이미 지불완료 되셨습니까?", lang_stringlist["我已付款"] = "결제완료", lang_stringlist["非自动扣款，请先给卖家转账然后再进行该操作"] = "비용을 자동적으로 공제하지 않습니다. 매도자에게 직접 계좌이체를 하십시오. ", lang_stringlist["非自动扣款，务必本人实际付款后再操作"] = "비용을 자동적으로 공제하지 않습니다. 반드시 본인이 지불완료하신 다음에 계속 진행하십시오.", lang_stringlist["请使用卖家支持的方式支付，如未实际付款完成，进行该操作，一经核实，将会暂停账号功能！"] = "매도자 지원하는 지불방법을 이용하십시오. 실제적으로 지불완료가 아닌 경우에 본인계정을 일시중지 당하게 됩니다.", lang_stringlist["恶意点击，将会暂停账号功能！"] = "악의적으로 버튼을 누르면 본인계정을 일시중지 당하게 됩니다. ", lang_stringlist["确认收款"] = "수금확인", lang_stringlist["务必查看是否已收到相应款项"] = "해당 송금을 잘 받았는지를 확인하십시오 ", lang_stringlist["请确认已经收到相应款项，操作后资金将直接打给对方，有不可追回风险，慎重操作！"] = "해당 송금을 잘 받았는지를 확인하십시오. 확인하신 다음에 자금을 상대방에게 보내줍니다. 됫찾기 불가하오니 조작시 조심하십시오! ", lang_stringlist["对方可能未付款，有不可追回风险，慎重操作！"] = "상대방이 실제적으로 지불을 안하신 가능성이 있으니 조작시 조심하십시오!", lang_stringlist["确认已收款"] = "수취 확인", lang_stringlist["申请仲裁"] = "중재신청", lang_stringlist["请点击我要申诉提交付款证明等信息"] = "나는 지불증명 등 정보를 제출하겠습니다는 버튼을 클릭하십시오", lang_stringlist["撤销买单"] = "매수주문 취소", lang_stringlist["撤单后交易取消，切勿再付款（如已付款切勿撤销），恶意撤销，将禁封交易"] = "취소를 누르시면 주문이 취소됩니다. 취소 후 송금 하지마십시오(송금 완료시 취소 하지 마십시오) 악의적으로 취소한 경우 거래에 제한을 받을 수 있습니다.", lang_stringlist["无效操作"] = "조작오류", lang_stringlist["确认对订单进行以下操作?"] = "이하 진행되는 조작을 확실하시겠습니까?", lang_stringlist["单号"] = "주문번호", lang_stringlist["交易对"] = "페어스", lang_stringlist["总额"] = "총금액", lang_stringlist["对方姓名"] = "상대방이름", lang_stringlist["操作"] = "조작", lang_stringlist["请选择"] = "선택 하십시오", lang_stringlist["已确认收到款项"] = "수금확인완료", lang_stringlist["我的支付方式"] = "나의 지불방법", lang_stringlist["提示卖家"] = "매도자 제시", lang_stringlist["未完成付款?"] = "지불 미완료?", lang_stringlist["我确定没有付款，撤单后也不会再付款"] = "지불을 안했습니다. 주문을 취소해도 지불을 안하겠습니다.", lang_stringlist["请确认已收到款项"] = "수금확인하십시오", lang_stringlist["请确认已付款"] = "확인해 이미 지불했어요", lang_stringlist["请选择实际支付方式"] = "실제 지불방법을 선택하십시오", lang_stringlist["请确认未付款，撤单后也不会再付款"] = "지불을 안했습니다. 주문을 취소해도 지불을 안하겠습니다.", lang_stringlist["操作成功!"] = "조작성공!", lang_stringlist["操作失败!"] = "조작실패!", lang_stringlist["请输入有效金额"] = "사용금액한도를 입력하십시오", lang_stringlist["购买"] = "매수", lang_stringlist["撤单"] = "취소", lang_stringlist["暂无订单"] = "주문이 없습니다", lang_stringlist["待付款"] = "지불대기", lang_stringlist["已付款"] = "지불완료", lang_stringlist["已过期取消"] = "기간이 만료되었으니 취소가 되었습니다", lang_stringlist["已完成"] = "완료되었습니다", lang_stringlist["已锁定"] = "잠겨있습니다", lang_stringlist["订单"] = "주문이", lang_stringlist["已取消"] = "취소 되었습니다", lang_stringlist["已经过期"] = "이미 기간이 만료되었습니다", lang_stringlist["已经支付"] = "이미 지불되었습니다", lang_stringlist["返回支付"] = "지불로 뒤로가기", lang_stringlist["通过该方式付款 <b>完成后</b>，必须立即点击 <b>“我已付款”</b> 按钮，完成付款确认流程。系统才会通知卖家给您放币。"] = "송금완료된 후, 바로 [결제완료] 버튼을 클릭하시기  바랍니다. 지불완료 후 수취확인이 되면 USDT가 지급됩니다.", lang_stringlist["此订单已关闭，<b>切勿</b>再次给卖家付款。当前信息仅供浏览。"] = "클로즈드 주문입니다,<b>절대</b>매도자에게 더이상 지불하지 마십시오. 현재정보 보기만 가능합니다.", lang_stringlist["此订单您已付款，<b>切勿</b>再次给卖家付款。当前信息仅供浏览。"] = "이미 지불되셨습니다，<b>매도자에게 더이상 지불하지 마십시오. 현재정보 보기만 가능합니다.", lang_stringlist["请及时查看账户，确认到账后及时放币（点击确认收款）"] = "계정을 즉시 체크해보십시오. 수금확인하시면 코인을 제때에 보내줍니다(수금확인 클릭).", lang_stringlist["我知道了"] = "알겠습니다", lang_stringlist["卖家姓名"] = "매도자이름", lang_stringlist["支付宝账号"] = "알리페이 아이디", lang_stringlist["付款时请备注"] = "지불시 메모를 적어두십시오", lang_stringlist["收款码"] = "수금코드", lang_stringlist["立即查看"] = "즉시 체크해보세요", lang_stringlist["支付宝收款码"] = "알리페이 수금코드", lang_stringlist["复制"] = "복사", lang_stringlist["卖家昵称"] = "매도자 닉네임", lang_stringlist["微信账号"] = "위챗 아이디", lang_stringlist["微信收款码"] = "위챗 수금코드", lang_stringlist["买家信息"] = "매수자 정보", lang_stringlist["买家姓名"] = "매수자 이름", lang_stringlist["联系对方"] = "상대방에게 연락하기", lang_stringlist["还剩 0分0秒"] = "0 분  0 초 남았습니다", lang_stringlist["还剩"] = "남은시간", lang_stringlist["分"] = "분", lang_stringlist["秒"] = "초", lang_stringlist["切勿付款"] = "절대 지불하지 마십시오", lang_stringlist["确定撤销挂单？"] = "주문을 취소하시겠습니까?", lang_stringlist["已匹配"] = "매칭되었습니다", lang_stringlist["匹配数量"] = "매칭수량", lang_stringlist["匹配价格"] = "매칭가격", lang_stringlist["已挂单"] = "주문을 하셨습니다", lang_stringlist["撤单成功"] = "주문을 취소하셨습니다", lang_stringlist["撤单失败"] = "주문취소를 실패하셨습니다", lang_stringlist["高于"] = "이상", lang_stringlist["匹配失败! 请稍后再试"] = "매칭실패! 잠시후 다시 시도하십시오", lang_stringlist["元"] = "원", lang_stringlist["我确认用本人账户已手工转账给"] = "양도 이미 내 손을 계정 계좌";
var language = $.cookie("lang");

function lang_string(t) {
	if("kr" === language) {
		var n;
		try {
			n = lang_stringlist[t]
		} catch(t) {
			n = void 0
		}
		if(void 0 !== n) return n
	}
	return t
}