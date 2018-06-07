function is_old_ie() {
	return !0
}

function get_element(e, t) {
	return null == t && (t = 0), obj = document.getElementById(e), obj || (obj = document.getElementsByName(e), obj ? obj[t] : null)
}

function check_number(e, t) {
	var n = e.keyCode,
		i = t.indexOf(".") > -1;
	return !(!e.ctrlKey && !e.altKey) || !(!(n >= 48 && n <= 57 || n >= 96 && n <= 105 || 8 == n || 46 == n || 27 == n || 37 == n || 39 == n || 16 == n || 9 == n || 33 == n || 34 == n || 190 == n || n >= 91 && n <= 93 || n >= 110 && n < 124) || i && 190 == n || i && 110 == n)
}

function get_max(e, t) {
	return e > t ? e : t
}

function get_min(e, t) {
	return e < t ? e : t
}

function num_to_sci(e) {
	var t = Number("1e+12");
	if(e > t) {
		var n = e / t,
			i = String(n).split(".")[1].length;
		return n.toFixed(10) + "e+" + i
	}
}

function cut_float_zero(e) {
	var t = e.indexOf(".");
	if(t < 0) return e;
	for(var n = e.length, i = e.length - 1; i >= t && ("0" == e[i] || "." == e[i]); i--) n = i;
	return e.substr(0, n)
}

function num_need_fix(e, t) {
	var n = (e = e.toString()).indexOf(".");
	return !(n < 0) && (e.length - n - 1 > t && (t > 0 ? e.substr(0, n + t + 1) : e.substr(0, n)))
}

function num_fix(e, t) {
	var n = num_need_fix(e = e.toString(), t);
	return n || e
}

function rand(e, t) {
	return Math.floor(Math.random() * t + e)
}

function page_rand() {
	return "&c=" + rand(0, 1e6)
}

function get_view_symbol(e, t) {
	var n;
	return null == t || "l" == t ? (n = e.indexOf("_")) >= 0 ? e.substr(0, n).toUpperCase() : e.substr(0, 3).toUpperCase() : (n = e.indexOf("_")) >= 0 ? e.substr(n + 1, e.length - n - 1).toUpperCase() : e.substr(4).toUpperCase()
}

function get_symbols(e) {
	var t = e.indexOf("_");
	return t >= 0 ? [e.substr(0, t).toUpperCase(), e.substr(t + 1, e.length - t - 1).toUpperCase()] : [""]
}

function trim(e) {
	for(var t = 0; t < e.length && " " == e.charAt(t); t++);
	for(var n = e.length; n > 0 && " " == e.charAt(n - 1); n--);
	return t > n ? "" : e.substring(t, n)
}

function fireEvent(e, t) {
	if(document.createEventObject) {
		var n = document.createEventObject();
		return e.fireEvent("on" + t, n)
	}
	return(n = document.createEvent("HTMLEvents")).initEvent(t, !0, !0), !e.dispatchEvent(n)
}

function get_query_string(e) {
	if(-1 == location.href.indexOf("?") || -1 == location.href.indexOf(e + "=")) return "";
	for(var t, n, i, a = location.href.substring(location.href.indexOf("?") + 1).split("<!@!>"), o = 0; o < a.length; o++)
		if(-1 != (t = a[o].indexOf("=")) && (n = a[o].substring(0, t), i = a[o].substring(t + 1), n == e)) return decodeURI(i.replace(/\+/g, " "));
	return ""
}
if(is_ie) {
	var scriptUrl = is_cn ? "%3Cscript src='/js/highstock_cn3.js' %3E%3C/script%3E" : "%3Cscript src='/js/highstock3.js' %3E%3C/script%3E";
	document.write(decodeURI(scriptUrl))
} else ! function() {
	var e = $(".kline-on-off"),
		t = $(".k-line-container"),
		n = $(".gm-on-off"),
		i = $("#gmCon,#gmTitle"),
		a = $("#globalInfoCon"),
		o = $(".fullscreen,.k-tools,#globalInfoCon"),
		r = $("#kline"),
		s = $(".k-tools"),
		l = a.find(".m_title"),
		_ = $("#topSection");
	$(".fullscreen").toggle(function() {
		e.hide(), $(".right_mcontent,.main_content").css("position", "inherit"), $("body").css("overflow", "hidden").scrollTop(0), $(".box-container").css("height", "93%"), t.css({
			height: $(window).height(),
			width: "100%",
			"padding-right": "0"
		}).addClass("fullscreen-con"), $("#resizeChart,#bigChart").click(), $(this).prop("title", lang_string("退出全屏")).find("path").attr("d", "M1.245 16l2.667-2.668 2.045 2.045v-5.334H.623l2.044 2.045L0 14.755m.623-8.798h5.334V.623L3.912 2.667 1.245 0 0 1.245l2.667 2.667m12.71 2.045l-2.045-2.045L16 1.245 14.755 0l-2.667 2.667L10.043.622v5.335M14.755 16L16 14.755l-2.668-2.667 2.045-2.045h-5.334v5.334l2.045-2.045"), $(".kline-title").css({
			left: "19px",
			top: "12px"
		}).show(), $(".line-option").css({
			right: "23px"
		})
	}, function() {
		e.show(), $("body,.box-container,.right_mcontent,.main_content,.line-option,.kline-title").prop("style", ""), t.removeClass("fullscreen-con"), t.hasClass("full-width") ? t.css("height", "") : t.prop("style", ""), $("#resizeChart,#smallChart").click(), $(this).prop("title", lang_string("全屏")).find("path").attr("d", "M4.712 10.043L2.045 12.71 0 10.667V16h5.334L3.29 13.955l2.667-2.667M5.334 0H0v5.334L2.045 3.29l2.667 2.667 1.245-1.245L3.29 2.045M10.666 0l2.045 2.045-2.666 2.667 1.245 1.245 2.666-2.667L16 5.334V0m-4.712 10.043l-1.245 1.245 2.668 2.667L10.668 16H16v-5.334l-2.045 2.045")
	});
	var d = null;

	function c() {
		n.toggle(function() {
			i.hide(), l.css("opacity", "0"), a.animate({
				width: "0"
			}, 100, function() {
				t.animate({
					width: "100%"
				}, 100, function() {
					n.prop("title", lang_string("显示")).find("svg").css("transform", "rotate(180deg)"), l.css("opacity", "1"), $("#resizeChart").click()
				}).css("padding-right", "0").addClass("full-width")
			}), $.cookie("show_gm", "0", {
				expires: 7
			})
		}, function() {
			l.css("opacity", "0"), t.animate({
				width: "70%"
			}, 100, function() {
				a.animate({
					width: "30%"
				}, 100, function() {
					l.css("opacity", "1")
				}), i.show(), n.prop("title", lang_string("隐藏")).find("svg").prop("style", ""), $("#resizeChart").click()
			}).css("padding-right", "30px").removeClass("full-width"), $.cookie("show_gm", "1", {
				expires: 7
			})
		})
	}

	function g() {
		e.toggle(function() {
			o.hide(), _.css("height", "auto"), r.css("opacity", "0"), t.animate({
				height: "40px"
			}, 100).css({
				overflow: "hidden",
				"margin-bottom": "0"
			}), e.prop("title", lang_string("显示")).find("svg").css("transform", "rotate(180deg)"), $.cookie("show_kline", "0", {
				expires: 7
			})
		}, function() {
			t.animate({
				height: "330px"
			}, 100, function() {
				o.show(), _.css("height", "370px"), r.css("opacity", "1"), $(this).css({
					overflow: "",
					"margin-bottom": "30px"
				});
				var e = $(".leftbar"),
					t = $(".main_content"),
					n = e.height(),
					i = t.height();
				n < i && e.css("height", i)
			}), e.prop("title", lang_string("隐藏")).find("svg").prop("style", ""), $.cookie("show_kline", "1", {
				expires: 7
			})
		})
	}
	$(window).bind("resize", function() {
		d && clearTimeout(d), d = setTimeout(function() {
			e.is(":visible") || t.css("height", $(window).height()), $("#resizeChart").click()
		}, 100)
	}), "0" === $.cookie("show_gm") ? (i.hide(), a.css("width", "0"), t.css({
		width: "100%",
		"padding-right": "0"
	}).addClass("full-width"), n.on("click", function() {
		l.css("opacity", "0"), t.animate({
			width: "70%"
		}, 100, function() {
			a.animate({
				width: "30%"
			}, 100, function() {
				l.css("opacity", "1")
			}), i.show(), n.off("click").prop("title", lang_string("隐藏")).find("svg").prop("style", ""), $("#resizeChart").click(), $.cookie("show_gm", "1", {
				expires: 7
			}), c()
		}).css("padding-right", "30px").removeClass("full-width")
	}).prop("title", lang_string("显示")).find("svg").css("transform", "rotate(180deg)")) : c(), "0" === $.cookie("show_kline") ? (o.hide(), r.css("opacity", "0"), _.css("height", "auto"), t.css({
		height: "40px",
		overflow: "hidden",
		"margin-bottom": "0"
	}), e.on("click", function() {
		t.animate({
			height: "330px"
		}, 100, function() {
			o.show(), r.css("opacity", "1"), $(this).css({
				overflow: "",
				"margin-bottom": "30px"
			}), $("#resizeChart").click();
			var e = $(".leftbar"),
				t = $(".main_content"),
				n = e.height(),
				i = t.height();
			n < i && e.css("height", i)
		}), $(this).prop({
			style: "",
			title: lang_string("隐藏")
		}).off("click"), g(), $.cookie("show_kline", "1", {
			expires: 7
		})
	}).css("transform", "rotate(180deg)").prop("title", lang_string("显示"))) : g(), s.hover(function() {
		$(".line-option").show().hover(function() {
			$(this).addClass("lo-active")
		}, function() {
			$(this).removeClass("lo-active").hide(), s.removeClass("tool-active")
		}), $(this).addClass("tool-active")
	}, function() {
		setTimeout(function() {
			$(".line-option").hasClass("lo-active") || ($(".line-option").hide(), s.removeClass("tool-active"))
		}, 300)
	})
}();

function checkEmpty(e) {
	is_login && updateOrderTab(e)
}

function buildGlobal(e) {
	if(null != e && "" != e) {
		var t = "";
		if(is_cn)
			for(var n = 0, i = e.length; n < i; n++) t += '<li class="clearfix">', t += '<span class="ex-name">' + e[n].name_cn + "</span>", t += '<span class="ex-pair">' + e[n].curr_a + "/" + e[n].curr_b + "</span>", t += '<span class="ex-price">' + e[n].last + '<div class="green">￥' + e[n].last_cny + "</div></span>", t += '<span class="ex-amount">' + e[n].vol_curr_a + '<div class="green">￥' + e[n].vol_cny + "</div></span>", t += "</li>";
		else
			for(n = 0, i = e.length; n < i; n++) t += '<li class="clearfix">', t += '<span class="ex-name">' + e[n].name_en + "</span>", t += '<span class="ex-pair">' + e[n].curr_a + "/" + e[n].curr_b + "</span>", t += '<span class="ex-price">' + e[n].last + '<div class="green">$' + e[n].last_usd + "</div></span>", t += '<span class="ex-amount">' + e[n].vol_curr_a + '<div class="green">$' + e[n].vol_usd + "</div></span>", t += "</li>";
		$("#ulGlobalMarkets").html(t)
	} else $("#ulGlobalMarkets").html('<li class="red">' + lang_string("暂无数据") + "!</li>")
}

function updateOrderTab(e) {
	var t = $("#ulMyOrderList"),
		n = $("#my-trade-list"),
		i = t.find("li").length,
		a = n.find("li").length,
		o = $("#currOrder"),
		r = $("#currOrder,#historyOrder"),
		s = $("#myFundCon"),
		l = $("#my-fund-list").data("dataFuns");

	function _(e, t) {
		e.css("height", "272px"), t.css("height", "231px"), s.css("height", "231px"), $("#p_od_tip").css("display", "inline-block"), $("#odPriceCol").addClass("odp-active")
	}
	if(2 != e) {
		var d = $("#order-info-box"),
			c = d.find(".noorder-tip").length,
			g = o.height();
		switch(i) {
			case 0:
				0 == c && (d.append("<div class=noorder-tip><i class='order-tip-icon'>i</i><i>" + lang_string("暂无委托") + "</i></div>"), o.css("height", "110px"), t.css("height", "70px"), $("#p_od_tip").css("display", "none"), $("#odPriceCol").removeClass("odp-active")), "undefined" == typeof hasAllfund && 1 == e && (fundNumStatus = 1, page_obj.build_my_fund_list(l), hasAllfund = 1), s.css("height", "395px");
				break;
			case 1:
				110 == g && d.find(".noorder-tip").remove(), _(o, t);
				break;
			default:
				110 == g && d.find(".noorder-tip").remove(), _(o, t)
		}
	} else {
		var u = $("#history-info-box"),
			m = u.find(".noorder-tip").length,
			p = r.height();
		switch(a) {
			case 0:
				0 == m && (u.append("<div class=noorder-tip><i class='order-tip-icon'>i</i><i>" + lang_string("暂无委托") + "</i></div>"), r.css("height", "110px"), n.css("height", "70px")), "undefined" == typeof hasAllfund && (fundNumStatus = 1, page_obj.build_my_fund_list(l), hasAllfund = 1), s.css("height", "395px");
				break;
			case 1:
				110 == p && u.find(".noorder-tip").remove(), _(r, n);
				break;
			default:
				110 == p && u.find(".noorder-tip").remove(), _(r, n)
		}
	}
}

function largeOrders() {
	$("#tableAskList").css("height", "598px"), $("#ul-trade-list").css("height", "313px"), $("#ask-list, #bid-list").css("height", "240px"), $("#moreOrders").addClass("more-order-active")
}

function smallOrders() {
	$("#tableAskList,#ask-list, #bid-list").css("height", ""), $("#ul-trade-list").css("height", "553px"), $("#ask-list").scrollTop(767), $("#moreOrders").removeClass("more-order-active")
}

function sell_all() {
	var e, t, n = "undefined" != typeof global_precision_vol ? global_precision_vol : 6,
		i = "undefined" != typeof global_precision_total ? global_precision_total : 6;
	(t = parseFloat(get_element("balance_bid_able").innerHTML)) > 0 && (e = parseFloat(get_element("bid_rate").value)) > 0 && (get_element("bid_vol").value = num_fix(t, n), get_element("bid_amount").value = num_fix(e * t, i))
}

function buy_all() {
	var e, t, n = "undefined" != typeof global_precision_vol ? global_precision_vol : 6,
		i = "undefined" != typeof global_precision_total ? global_precision_total : 6;
	if(t = parseFloat(get_element("balance_ask_able").innerHTML), "" != g_fiat) {
		var a = get_bid_or_ask_decimals(t);
		t *= a.fiat_rate, i = a.fiat_rate_decimals
	}
	if(t > 0 && (e = parseFloat(get_element("ask_rate").value)) > 0) {
		var o = num_fix(t / e, n);
		get_element("ask_vol").value = o, get_element("ask_amount").value = num_fix(e * o, i)
	}
}

function set_price(e, t, n, i) {
	var a = parseFloat(get_element("balance_bid_able").innerHTML),
		o = parseFloat(get_element("balance_ask_able").innerHTML),
		r = "undefined" != typeof global_precision_vol ? global_precision_vol : 6,
		s = "undefined" != typeof global_precision_total ? global_precision_total : 6;
	o *= get_bid_or_ask_decimals(parseFloat(t).toString()).fiat_rate, -1 != (t = parseFloat(t)).toString().indexOf("e") && (t = t.toFixed(8)), get_element("ask_rate").value = t, get_element("bid_rate").value = t, e ? i - o > 1e-8 && (i = o, n = o / t) : n - a > 1e-8 && (n = a, i = a * t);
	var l = parseFloat(Number(i).toFixed(8)); - 1 != l.toString().indexOf("e") && (l = l.toFixed(8)), e ? (get_element("ask_vol").value = num_fix(n, r), get_element("ask_amount").value = num_fix(l, s)) : (get_element("bid_vol").value = num_fix(n, r), get_element("bid_amount").value = num_fix(l, s))
}

function trade_operator(e, n, a, o, r, s, l, _, d) {
	o = void 0 !== o ? o : 0, fee_percentage_buy = void 0 !== o ? o : 0, _ = void 0 !== _ ? _ : o, r = void 0 !== r ? r : 6, s = void 0 !== s ? s : 6, l = void 0 !== l ? l : 6, d = void 0 !== d ? d : 4086;
	is_old_ie() ? (window.tradeInfoBox = null, window.dealInfoBox = null) : (window.Widget = JUtils.Widget, window.tradeInfoBox = new TradeInfoBox(Widget), window.dealInfoBox = new DealInfoBox(Widget));
	var c = {
			ask_list: [],
			bid_list: [],
			best_ask_rate: 0,
			best_bid_rate: 0,
			init: function(e, t) {
				this.best_ask_rate = t, this.best_bid_rate = e, page_obj.update_best_rate_and_input()
			},
			recalc_best_rate: function() {
				page_obj.update_best_rate()
			},
			reload_ask_bid_grid: function() {
				var e = jQuery("#tableAskList"),
					t = jQuery("#tableBidList");
				e.clearGridData(), t.clearGridData();
				for(var n = 0; n < this.ask_list.length; n++) e.jqGrid("addRowData", n + 1, this.ask_list[n]);
				e.setGridParam({
					sortname: "rate",
					sortorder: "asc"
				}).trigger("reloadGrid");
				for(n = 0; n < this.bid_list.length; n++) t.jqGrid("addRowData", n + 1, this.bid_list[n]);
				t.setGridParam({
					sortname: "rate",
					sortorder: "desc"
				}).trigger("reloadGrid")
			},
			reload_ask_bid_list_table: function() {
				var e = {
					type: "ask_bid_list_table",
					symbol: n
				};
				return $.ajax({
					type: "get",
					url: "/json_svr/query/?u=11" + page_rand(),
					data: e,
					xhrFields: {
						withCredentials: !0
					},
					success: function(e, t) {
						var n = e;
						if(n && n.result) {
							c.best_ask_rate = n.bid_rate0, c.best_bid_rate = n.ask_rate0;
							var i = n.global_markets_table,
								a = i.length;
							if(2 != a && null != i)
								if(a > 2500) LocalStorage.get(currA + "_" + currB + "_gm_data", !0).data != i && (buildGlobal(JSON.parse(i)), LocalStorage.set(currA + "_" + currB + "_gm_data", i));
								else buildGlobal(JSON.parse(i));
							var o = 5,
								r = 5;
							if(1 == ordersCo && (o = 10, r = 10), "undefined" != typeof odSellStatus && (o = 31), "undefined" != typeof odBuyStatus && (r = 31), n.ask_list) {
								g_ask_list = n.ask_list;
								var s = build_order_table(n.ask_list, 1, o);
								"" != s && (get_element("ul-ask-list").innerHTML = s)
							}
							if(n.bid_list) {
								g_bid_list = n.bid_list;
								var l = build_order_table(n.bid_list, 0, r);
								"" != l && (get_element("ul-bid-list").innerHTML = l)
							}
							if(n.trade_list) {
								g_trade_list = n.trade_list;
								var _ = build_trade_history_table(n.trade_list);
								"" != _ && (get_element("ul-trade-list").innerHTML = _)
							}
							get_Price_Percent(n.market_rates)
						}
						page_obj.update_best_rate(), n = null
					}
				}), !0
			},
			reload_ask_bid_list: function() {
				var e = {
					type: "ask_bid_list",
					symbol: n,
					tid: dealInfoBox.latestTid
				};
				return $.ajax({
					type: "get",
					url: "/json_svr/query/?u=12" + page_rand(),
					data: e,
					xhrFields: {
						withCredentials: !0
					},
					success: function(e, t) {
						var n = e;
						n && n.result && (c.best_ask_rate = n.bid_rate0, c.best_bid_rate = n.ask_rate0, tradeInfoBox.update(n.orders), dealInfoBox.update(n.history)), page_obj.update_best_rate(), n = null
					}
				}), !0
			},
			recheck_ask_bid_list: function() {
				is_old_ie() ? c.reload_ask_bid_list_table() : c.reload_ask_bid_list()
			},
			recheck: function() {
				c.recheck_ask_bid_list()
			}
		},
		g = {
			reload_thistory_data_list: function() {
				var e = {
					type: "trade_history_list",
					symbol: n
				};
				$.ajax({
					type: "get",
					url: "/json_svr/query/?u=01" + page_rand(),
					data: e,
					xhrFields: {
						withCredentials: !0
					},
					success: function(e, t) {
						var n = e;
						n && n.result && n.history && dealInfoBox.update(n), n = null
					}
				})
			},
			recheck_thistory_data: function() {
				g.reload_thistory_data_list()
			},
			recheck: function() {
				g.recheck_thistory_data()
			}
		};
	return page_obj = {
		fee: .01 * o,
		fee_sell: .01 * _,
		my_orders_num: -1,
		my_orders: [],
		on_request_ask_bid: function(e, t, i) {
			var o = {
					open: {
						height: "toggle"
					},
					close: {
						height: "toggle"
					},
					easing: "swing",
					speed: 50
				},
				l = 1,
				_ = 3,
				d = trade_global.symbol.split("_"),
				g = (d[0].toUpperCase(), d[1].toUpperCase()),
				u = "CNY";
			if(is_en && (u = "USD"), is_kr && (u = "KRW"), "" != g_fiat && (u = g_fiat), l = get_global_fiat_rate(g, u), "" == g_fiat) _ = (l *= t) >= 10 ? 2 : l >= 1 ? 3 : l >= .1 ? 4 : l >= .01 ? 5 : l >= .001 ? 6 : 7, l = parseFloat(l).toFixed(_);
			else {
				var m = t;
				t = (t = m / l).toFixed(8), l = m
			}
			var p = "";
			if("BTC" != g && "ETH" != g && "USDT" != g && "QTUM" != g || (p = '<span class="coin-unit">(' + lang_string("折合") + "</span> " + l + '<span class="coin-unit">' + u + ")</span>"), !a || a < 0) noty({
				text: lang_string("请您先登录再进行操作"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: o,
				timeout: 5e3
			});
			else if(i <= 0) noty({
				text: lang_string("请输入交易量"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: o,
				timeout: 5e3
			});
			else if(t >= 1e9 || 0 == t) noty({
				text: lang_string("交易价必须大于0且小于10亿"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: o,
				timeout: 5e3
			});
			else if(i >= 1e9) noty({
				text: lang_string("单笔交易量必须小于10亿"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: o,
				timeout: 5e3
			});
			else {
				if("ask" == e) {
					var f = get_element("balance_ask_able").innerHTML;
					if(t * i > Number(f)) return void noty({
						text: lang_string("超出可买入额，请检查后重新输入"),
						type: "warning",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: o,
						timeout: 5e3
					})
				} else {
					if("bid" != e) return void noty({
						text: lang_string("无效交易类型"),
						type: "error",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: o,
						timeout: 5e3
					});
					var b = get_element("balance_bid_able").innerHTML;
					if(i > Number(b)) return void noty({
						text: lang_string("超出可卖出额，请检查后重新输入"),
						type: "warning",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: o,
						timeout: 5e3
					})
				}
				var h = "",
					v = .5 * (c.best_bid_rate + c.best_ask_rate);
				"ask" == e ? (h += lang_string("请确认买入订单:"), h += "<hr/><br>", h += "<table id='tablePending'>", h += "<tr><td width='20%'>" + lang_string("买入价格") + ": </td><td>" + num_fix(t, r) + " " + p + "</td></tr>", h += "<tr><td>" + lang_string("买入数量") + ": </td><td>" + num_fix(i, s) + '<span class="coin-unit">' + get_view_symbol(n, "l") + "</span></td></tr>", oper = v > 0 ? (t - v) / v * 100 : 0, oper > 20 && (h += "<tr><td class='red'>" + lang_string("警告") + ": </td><td>" + lang_string("您的") + "<span class=red>" + lang_string("买入") + " </span>" + lang_string("价格 ") + "<span class=red>" + lang_string("高于") + "</span>" + lang_string("市场平均价格") + " <span class=red>" + num_fix(oper, 1) + "%</span>" + lang_string("，请务必检查确认！") + "</td></tr>")) : "bid" == e && (h += lang_string("请确认卖出订单:"), h += "<hr/><br>", h += "<table id='tablePending'>", h += "<tr><td width='20%'>" + lang_string("卖出价格") + ": </td><td>" + num_fix(t, r) + " " + p + "</td></tr>", h += "<tr><td>" + lang_string("卖出数量") + ": </td><td>" + num_fix(i, s) + "&nbsp;" + get_view_symbol(n, "l") + "</td></tr>", oper = v > 0 ? (v - t) / v * 100 : 0, oper > 20 && (h += "<tr><td class='red'>" + lang_string("警告") + ": </td><td>" + lang_string("您的") + "<span class=red>" + lang_string("卖出") + " </span>" + lang_string("价格 ") + "<span class=red>" + lang_string("低于") + "</span>" + lang_string("市场平均价格") + " <span class=red>" + num_fix(oper, 1) + "%</span>" + lang_string("，请务必检查确认！") + "</td></tr>")), h += "</table>", h += "<br/>", noty({
					text: h,
					type: "confirm",
					layout: "center",
					theme: "gateioNotyTheme",
					modal: !0,
					animation: o,
					killer: !0,
					buttons: [{
						addClass: "btn btn-primary",
						text: lang_string("确定下单"),
						onClick: function(n) {
							page_obj.on_request_ask_bid_confirmed(e, t, i), n.close()
						}
					}, {
						addClass: "btn btn-danger",
						text: lang_string("取消"),
						onClick: function(e) {
							e.close()
						}
					}]
				})
			}
		},
		on_request_ask_bid_confirmed: function(e, t, i, o, l) {
			o = void 0 !== o ? o : "", l = void 0 !== l ? l : "";
			var _ = {
				open: {
					height: "toggle"
				},
				close: {
					height: "toggle"
				},
				easing: "swing",
				speed: 50
			};
			if(!a || a < 0) noty({
				text: lang_string("请您先登录再进行操作"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: _,
				timeout: 5e3
			});
			else if(i <= 0) noty({
				text: lang_string("请输入交易量"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: _,
				timeout: 5e3
			});
			else if(t >= 1e9 || 0 == t) noty({
				text: lang_string("交易价必须大于0且小于10亿"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: _,
				timeout: 5e3
			});
			else if(i >= 1e9) noty({
				text: lang_string("单笔交易量必须小于10亿"),
				type: "warning",
				layout: "bottomLeft",
				closeWith: ["button", "click"],
				theme: "gateioNotyTheme",
				animation: _,
				timeout: 5e3
			});
			else {
				if("ask" == e) {
					var d = get_element("balance_ask_able").innerHTML;
					if(t * i > Number(d)) return void noty({
						text: lang_string("超出可买入额，请检查后重新输入"),
						type: "warning",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: _,
						timeout: 5e3
					})
				} else {
					if("bid" != e) return void noty({
						text: lang_string("无效交易类型"),
						type: "error",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: _,
						timeout: 5e3
					});
					var c = get_element("balance_bid_able").innerHTML;
					if(i > Number(c)) return void noty({
						text: lang_string("超出可卖出额，请检查后重新输入"),
						type: "warning",
						layout: "bottomLeft",
						closeWith: ["button", "click"],
						theme: "gateioNotyTheme",
						animation: _,
						timeout: 5e3
					})
				}
				var g = {
					type: e,
					symbol: n,
					rate: t,
					vol: i,
					fundpass: o,
					captcha: l
				};
				$.ajax({
					type: "get",
					url: "/json_svr/exchange/?u=1" + page_rand(),
					data: g,
					xhrFields: {
						withCredentials: !0
					},
					success: function(a, o) {
						var l = a,
							_ = "";
						if(l.records) {
							_ += lang_string("已成交") + ":", _ += "<hr/>", _ += "<table id='tableRecords' class='noty-table'>", _ += "<thead><tr><th></th><th>" + lang_string("成交价") + "</th><th>" + lang_string("成交量") + "</th><th>" + lang_string("手续费") + "</th></tr></thead>";
							for(var d = 0; d < l.records.length; d++) _ += "<tr><td>", _ += d + 1 + ".</td><td><span class='yellow'>", _ += num_fix(l.records[d].rate, r) + "</span></td>", "ask" == e ? (_ += "<td><span class='yellow'>" + num_fix(l.records[d].vol, s) + "</span> " + get_view_symbol(n, "l") + "</td>", _ += "<td><span class='yellow'>" + num_fix(l.records[d].vol * l.records[d].rate * page_obj.fee, 8) + "</span> " + get_view_symbol(n, "r") + "</td></tr>") : "bid" == e && (_ += "<td><span class='yellow'>" + num_fix(l.records[d].vol, s) + "</span> " + get_view_symbol(n, "l") + "</td>", _ += "<td><span class='yellow'>" + num_fix(l.records[d].vol * page_obj.fee_sell, 8) + "</span> " + get_view_symbol(n, "l") + "</td></tr>");
							_ += "</table>", _ += "<br/>"
						}
						if(l.pending) {
							_ += lang_string("已挂单") + ":", _ += "<hr/>", _ += "<table id='tablePending'>";
							for(d = 0; d < l.pending.length; d++) _ += "<tr><td>" + lang_string("单号") + ": </td><td>" + l.pending[d].id + "</td></tr>", _ += "<tr><td>" + lang_string("价格") + ": </td><td>" + num_fix(l.pending[d].rate, r) + "</td></tr>", "ask" == e ? (_ += "<tr><td>" + lang_string("挂单量") + ": </td><td>" + num_fix(l.pending[d].vol, s) + "&nbsp;" + get_view_symbol(n, "l") + "</td></tr>", _ += "<tr><td>" + lang_string("手续费") + ": </td><td>" + num_fix(l.pending[d].vol * l.pending[d].rate * page_obj.fee, 8) + "&nbsp;" + get_view_symbol(n, "r") + "</td></tr>") : "bid" == e && (_ += "<tr><td>" + lang_string("挂单量") + ": </td><td>" + num_fix(l.pending[d].vol, s) + "&nbsp;" + get_view_symbol(n, "l") + "</td></tr>", _ += "<tr><td>" + lang_string("手续费") + ": </td><td>" + num_fix(l.pending[d].vol * page_obj.fee_sell, 8) + "&nbsp;" + get_view_symbol(n, "l") + "</td></tr>");
							_ += "</table>", _ += "<br/>";
							get_element("balance_ask_able").innerHTML, get_element("balance_bid_able").innerHTML;
							var c = $("#ulMyOrderList"),
								g = (c.find("li").length, ""),
								u = "",
								m = "up";
							"ask" == e ? (u = "<span>" + lang_string("买入") + "</span>", l.pending[0].vol * l.pending[0].rate) : (u = "<span>" + lang_string("卖出") + "</span>", l.pending[0].vol, m = "down");
							var p = 1;
							"BTC" == currB ? p = global_btc_cny_rate : "ETH" == currB ? p = global_eth_cny_rate : "USDT" == currB ? p = global_usdt_cny_rate : "QTUM" == currB && (p = global_qtum_cny_rate);
							var f = l.pending[0].odtime,
								b = new Date(1e3 * f),
								h = b.getMonth() + 1;
							h = h < 10 ? "0" + h : h;
							var v = b.getDate();
							v = v < 10 ? "0" + v : v;
							var y = b.getHours();
							y = y < 10 ? "0" + y : y;
							var k = b.getMinutes(),
								x = b.getSeconds();
							f = h + "-" + v + " " + y + ":" + (k = k < 10 ? "0" + k : k) + ":" + (x = x < 10 ? "0" + x : x);
							var w = l.pending[0].rate.toFixed(r),
								T = (w * p).toFixed(2),
								L = "￥";
							is_cn || (T = (T / global_usdt_cny_rate).toFixed(2), L = "$"), g += "<li class='add-byjs number " + m + "'>", g += "<span class='right-align' id='tlist-date'>" + f + "</span>", g += "<span class='right-align my-type'>" + u + "</span>", g += "<span class='right-align'>" + w + "<span style=color:#999>/≈" + L + T + "</span></span>", g += "<span class='right-align'>" + l.pending[0].vol.toFixed(s) + "</span>", g += "<span class='right-align'>--</span>", g += "</li>", c.append(g), $("#hisTab").hasClass("order-t-active") ? checkEmpty(2) : checkEmpty(0)
						}
						if(l.require_fundpass) {
							_ = "<h3 style='margin-bottom:10px'>" + lang_string("资金密码") + ":</h3>";
							_ += "<div style='border-bottom:1px solid #666'></div><br>", _ += "<table id='tablePending' width='90%'>", _ += "<tr><td class='noty-td'>" + lang_string("输入资金密码") + ": </td><td width='70%'><input class='inputRate' type='password' name='fundpass' id='fundpass' placeholder='" + lang_string("请输入资金密码") + "' autocomplete='new-password'></td></tr>", _ += "<tr><td class='noty-td'>" + lang_string("有效期限") + ": </td><td width='70%'>" + lang_string("2小时 （如有IP变化仍需输入）") + "</td></tr>", _ += "</table><tr><td><label name='tips' id='tips'>" + l.msg + "</label></td></tr>", _ += "<br/>";
							var C = noty({
								text: _,
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
										$("#fundpass").keyup(function(e) {
											13 == e.keyCode && N()
										})
									}
								},
								buttons: [{
									addClass: "btn btn-primary dp-noty-btn",
									text: lang_string("确定提交"),
									onClick: function(e) {
										N()
									}
								}, {
									addClass: "btn btn-danger dp-noty-btn",
									text: lang_string("取消"),
									onClick: function(e) {
										return e.close(), !1
									}
								}]
							});

							function N() {
								var n = $("#fundpass"),
									a = n.val(),
									o = $("#captcha"),
									r = o.val(),
									s = $("#tips");
								return "" == a ? (s.html("<span style=color:#ff5d5d>" + lang_string("密码不能为空，请再次输入") + "</span>"), n.focus(), !1) : "" == r ? (s.html("<span style=color:#ff5d5d>" + lang_string("图形验证码不能为空，请再次输入") + "</span>"), o.focus(), !1) : (page_obj.on_request_ask_bid_confirmed(e, t, i, a, r), C.close(), !0)
							}
						} else if(l.result) {
							var j = "confirm";
							l.records && (j = "success"), noty({
								text: _,
								type: j,
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
										page_obj.my_orders_num = -1
									}
								}
							})
						} else _ = lang_string("处理失败，请稍候再试！原因是：") + l.msg, noty({
							text: _,
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
									page_obj.my_orders_num = -1
								}
							}
						});
						l = null
					},
					error: function(e, t, n) {
						noty({
							text: lang_string("网络错误") + ": " + e.status + " " + e.responseText + " " + status + " " + n,
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
									page_obj.my_orders_num = -1
								}
							}
						})
					}
				})
			}
		},
		recalc_fee: function(e) {
			if("ask" == e) {
				get_element("ask_vol").value, get_element("ask_rate").value;
				var t = get_element("ask_amount").value,
					n = get_element("ask_fee");
				if(g_fiat) t /= get_bid_or_ask_decimals(t).fiat_rate;
				ask_fee_num = cut_float_zero(num_fix(t * this.fee, 8)), ask_fee_num.length > 11 ? n.innerHTML = ask_fee_num.substr(0, 11) : n.innerHTML = ask_fee_num
			} else {
				var i = get_element("bid_vol").value,
					a = (get_element("bid_rate").value, get_element("bid_amount").value, get_element("bid_fee")),
					o = cut_float_zero(num_fix(i * this.fee_sell, 8));
				o.length > 11 ? a.innerHTML = o.substr(0, 11) : a.innerHTML = o
			}
			return !0
		},
		on_input_ask_vol: function() {
			var e = get_element("ask_amount"),
				t = get_element("ask_rate"),
				n = get_element("ask_vol"),
				i = num_need_fix(n.value, s);
			i && (n.value = i);
			var a = t.value * n.value;
			return isNaN(a) && (a = 0), e.value = a, e.value < 1e-4 && (e.value = 0), (i = num_need_fix(e.value, l)) && (e.value = i), !0
		},
		on_input_bid_vol: function() {
			var e = get_element("bid_amount"),
				t = get_element("bid_rate"),
				n = get_element("bid_vol"),
				i = num_need_fix(n.value, s);
			i && (n.value = i);
			var a = t.value * n.value;
			return isNaN(a) && (a = 0), e.value = a, (i = num_need_fix(a, l)) && (e.value = i), !0
		},
		on_input_ask_rate: function() {
			var e = get_element("ask_rate").value;
			if("" != e && $.isNumeric(e) && !(e <= 0)) {
				var t = num_need_fix(e, r);
				t && (e = t);
				var n = get_element("balance_ask_able"),
					i = get_element("amount_ask_able"),
					a = n.innerHTML;
				if(g_fiat) {
					var o = get_bid_or_ask_decimals(a);
					(a *= o.fiat_rate).toFixed(o.fiat_rate_decimals)
				}
				var l = a / e;
				l >= 1e-6 && !isNaN(num_fix(l)) && "0" !== num_fix(l) ? i.innerHTML = num_fix(l, s) : i.innerHTML = "0.0000", page_obj.on_input_ask_vol()
			}
		},
		on_input_bid_rate: function() {
			var e = get_element("bid_rate"),
				t = e.value;
			if("" != t && $.isNumeric(t) && !(t <= 0)) {
				var n = num_need_fix(e.value, r);
				n && (t = n);
				var i = get_element("balance_bid_able"),
					a = get_element("amount_bid_able"),
					o = i.innerHTML,
					l = o * t;
				if(g_fiat) {
					var _ = get_bid_or_ask_decimals(o);
					(l /= _.fiat_rate).toFixed(_.fiat_rate_decimals)
				}
				isNaN(num_fix(l)) || "0" === num_fix(l) ? a.innerHTML = "0.0000" : a.innerHTML = num_fix(l, s), page_obj.on_input_bid_vol()
			}
		},
		on_input_ask_amount: function() {
			var e = get_element("ask_amount"),
				t = get_element("ask_rate"),
				n = get_element("ask_vol");
			(i = num_need_fix(e.value, l)) && (e.value = i);
			var i, a = 1e4 * e.value / t.value;
			a < .01 && (a = 0), a /= 1e4, n.value = a, (i = num_need_fix(a, s)) && (n.value = i)
		},
		on_input_bid_amount: function() {
			var e = get_element("bid_amount"),
				t = get_element("bid_rate"),
				n = get_element("bid_vol");
			(i = num_need_fix(e.value, l)) && (e.value = i);
			var i, a = 1e4 * e.value / t.value;
			return a < .01 && (a = 0), a /= 1e4, n.value = a, (i = num_need_fix(a, s)) && (n.value = i), !0
		},
		cancel_order: function(e, t, n) {
			var i = {
				type: "cancel",
				symbol: e,
				oid: t
			};
			$.ajax({
				type: "get",
				url: "/json_svr/exchange/?u=1" + page_rand(),
				data: i,
				xhrFields: {
					withCredentials: !0
				},
				success: function(e, i) {
					var a = e;
					a && a.result ? (view_code = "<div class='cancel_content'>" + lang_string("撤单成功!") + "</div>", noty({
						text: view_code,
						type: "success",
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
								page_obj.my_orders_num = -1
							}
						}
					}), 1 == n ? $("#ulMyOrderList").find("li").remove() : $("#odID" + t).remove(), checkEmpty(0)) : (view_code = "<div class='cancel_content'>" + lang_string("撤单失败!") + a.msg + "</div>", noty({
						text: view_code,
						type: "warning",
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
								page_obj.my_orders_num = -1
							}
						}
					})), a = null
				},
				error: function() {
					noty({
						text: lang_string("网络错误") + "!",
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
								page_obj.my_orders_num = -1
							}
						}
					})
				}
			})
		},
		update_new_rate: function() {
			var e = 0,
				t = 99999,
				n = 0,
				i = 0;
			if(trade_global && trade_global.time_line)
				for(var a = 0; a < trade_global.time_line.length; a++) tnode = trade_global.time_line[a], e = get_max(e, Number(tnode[2])), t = get_min(t, Number(tnode[3])), n = Number(tnode[4]), i += Number(tnode[5]);
			var o = get_element("pb_close"),
				l = get_element("pb_high"),
				_ = get_element("pb_low"),
				d = get_element("pb_vol");
			o.innerHTML = n.toFixed(r), l.innerHTML = e.toFixed(r), _.innerHTML = t.toFixed(r), d.innerHTML = i.toFixed(s)
		},
		update_best_rate: function() {
			get_element("rate_best_ask").innerHTML = num_fix(Number(c.best_bid_rate).toFixed(10), r), get_element("rate_best_bid").innerHTML = num_fix(Number(c.best_ask_rate).toFixed(10), r), this.update_able_amount()
		},
		update_best_rate_and_input: function() {
			get_element("rate_best_ask").innerHTML = num_fix(Number(c.best_bid_rate).toFixed(10), r), get_element("rate_best_bid").innerHTML = num_fix(Number(c.best_ask_rate).toFixed(10), r), get_element("ask_rate").value = get_element("rate_best_ask").innerHTML, get_element("bid_rate").value = get_element("rate_best_bid").innerHTML, this.update_able_amount()
		},
		update_able_amount: function() {
			var e = c.best_ask_rate,
				t = c.best_bid_rate,
				n = get_element("balance_ask_able").innerHTML,
				i = get_element("balance_bid_able").innerHTML;
			void 0 !== t && 0 != t || (t = 10);
			var a = n / t;
			a = $.isNumeric(a) ? a : n;
			var o = i * e,
				_ = get_element("amount_ask_able").innerHTML;
			get_element("amount_bid_able").innerHTML;
			(_ <= 0 || get_element("rate_best_ask").innerHTML != num_fix(Number(c.best_bid_rate).toFixed(10), r)) && (get_element("amount_ask_able").innerHTML = num_fix(Number(a).toFixed(10), s)), (_ <= 0 || get_element("rate_best_bid").innerHTML != num_fix(Number(c.best_ask_rate).toFixed(10), r)) && (get_element("amount_bid_able").innerHTML = num_fix(Number(o).toFixed(10), l))
		},
		rebuild_my_order_table: function() {
			var e, t, n = $("#ulMyOrderList"),
				a = n.data("myoddata"),
				o = 0,
				r = "",
				s = page_obj.my_orders,
				l = "",
				_ = s.length,
				d = trade_global.symbol.toUpperCase();
			if(null != a && null != s && (e = a.toString(), l = s.toString()), e !== l) {
				for(n.data("myoddata", s), i = 0; _ > i; i++) t = void 0 !== s[i][4] ? s[i][4] : "number down", r += "<li id='odID" + s[i][3] + "' class='" + t + "'>", r += "<span class='right-align' id='tlist-date'>" + s[i][5] + "</span>", r += "<span class='right-align my-type'>" + s[i][0] + "</span>", r += "<span class='right-align'>" + s[i][1] + "</span>", r += "<span class='right-align'>" + s[i][2] + "</span>", s[i][3] > 0 ? (r += "<span class='right-align'><a href='javascript:;'  onclick=\"_page.obj.cancel_order( '" + d + "',", r += s[i][3], r += ');">' + lang_string("撤单") + "</a></span>") : r += "<span class='right-align'>-</span>", r += "</li>", o++;
				n.html(r), $("#hisTab").hasClass("order-t-active") ? checkEmpty(2) : checkEmpty(0), page_obj.my_orders_num = o
			}
		},
		build_my_fund_list: function(e) {
			if(e) {
				var t = $("#my-fund-list"),
					n = t.data("dataFuns"),
					i = e.toString();
				if(null != n && (n = n.toString()), n != i || "undefined" == typeof InitialFund || null != $.cookie("zero_change") || 1 == fundNumStatus) {
					InitialFund = 1, $.removeCookie("zero_change"), t.data("dataFuns", e);
					var a = $.cookie("show_zero_funds"),
						o = parseInt($("#myFundCon").height() / 35) + 1,
						r = 0,
						s = "",
						l = "",
						_ = "",
						d = "",
						c = "",
						g = "",
						u = "",
						m = "",
						p = "",
						f = "";
					r = "undefined" != typeof fundNumStatus ? 0 == fundNumStatus && "undefined" == typeof hasAllfund ? o : e.length : o, fundNumStatus = 0;
					for(var b = 0; b < r; b++) {
						var h = e[b][0];
						if("0" !== a || "" != h) {
							var v = e[b][1],
								y = e[b][2],
								k = e[b][3],
								x = e[b][4],
								w = e[b][5],
								T = e[b][6],
								L = "",
								C = "";
							"ed" == y ? (l = lang_string("充暂停"), d = lang_string("充值暂停，钱包维护中"), c = "err-depo", g = "javascript:;") : (l = lang_string("充值"), d = lang_string("充值正常"), c = "normal-depo", g = "/myaccount/deposit/" + v), "ww" == k ? (_ = lang_string("提缓慢"), u = lang_string("提现缓慢，排队中"), m = "warn-depo", p = "/myaccount/withdraw/" + v) : "ew" == k ? (_ = lang_string("提暂停"), u = lang_string("提现暂停，钱包维护中"), m = "err-depo", p = "javascript:;") : (_ = lang_string("提现"), u = lang_string("提现正常"), m = "normal-depo", p = "/myaccount/withdraw/" + v), "" == h ? s = "data-id=zero" : ("" == x && (L = "fd-emp"), "" == w && (C = "fd-emp")), "" == x && (x = "0.000000"), "" == w && (w = "0.000000"), "" == T && (T = "0.000000"), f += "<li " + s + '><span class="right-align my-type">' + v + '</span><span class="right-align ' + L + '"><i>' + x + '</i><em><a class="' + c + ' fund-deposit" title=' + d + " href=" + g + ">" + l + '</a><a class="' + m + ' fund-withdraw" title=' + u + " href=" + p + ">" + _ + '</a></em></span><span class="right-align ' + C + '">' + w + "</span><span class=right-align>" + T + "</span></li>"
						}
					}
					t.html(f), void 0 === a || "1" === a ? $("#hidezero").prop("checked", !1) : $("#hidezero").prop("checked", !0)
				}
			}
		},
		reload_order_data: function() {
			var e = {
				type: "order_list",
				symbol: n
			};
			page_obj.my_orders_num = 0, $.ajax({
				type: "get",
				url: "/json_svr/query/?u=13" + page_rand(),
				data: e,
				xhrFields: {
					withCredentials: !0
				},
				success: function(e, i) {
					var a, o, _ = e;
					if(_ && _.result) {
						_.balances && 2 == _.balances.length && (0 == _.balances[0] ? get_element("balance_bid_able").innerHTML = "0.0000" : get_element("balance_bid_able").innerHTML = _.balances[0], 0 == _.balances[1] ? get_element("balance_ask_able").innerHTML = "0.0000" : get_element("balance_ask_able").innerHTML = _.balances[1]), _.debuginfo && (get_element("debugbox").innerHTML = _.debuginfo), _.my_trade_list_table && (get_element("my-trade-list").innerHTML = _.my_trade_list_table);
						var d = _.my_funds;
						if(page_obj.build_my_fund_list(d), (o = get_symbols(n)) && o.length > 1 && _.order && _.order.length > 0 ? (page_obj.my_orders = _.order, page_obj.rebuild_my_order_table()) : (page_obj.my_orders.length = 0, page_obj.rebuild_my_order_table()), _.my_trade_noty && _.my_trade_noty.length > 0) {
							var c = "";
							for(a = 0; a < _.my_trade_noty.length; a++) t = _.my_trade_noty[a], c = "", c += t.trade_type + " " + get_view_symbol(n, "l") + lang_string(" 已成交:"), c += "<hr/>", c += "<ul id='tableTradeNoty'><li>" + lang_string("成交价") + ": <span>" + num_fix(t.rate, r) + "</span><i>" + get_view_symbol(n, "r") + "</i></li><li>成交量: <span>" + num_fix(t.vol, s) + "</span><i>" + get_view_symbol(n, "l") + "</i></li><li>总计: <span>" + num_fix(t.total, l) + "</span><i>" + get_view_symbol(n, "r") + "</i></li></ul>", noty({
								text: c,
								type: "information",
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
								timeout: 5e3
							}), $(".add-byjs").remove()
						}
					} else page_obj.my_orders_num = 0;
					_ = null
				},
				error: function() {
					page_obj.my_orders_num = -1
				}
			})
		},
		recheck_order_list: function() {
			a && a > 0 && page_obj.reload_order_data()
		},
		recheck: function() {
			page_obj.recheck_order_list()
		}
	}, {
		main_ask_bid_list: c,
		main_history_grid: g,
		obj: page_obj,
		run: function() {
			$.timer(function() {
				page_obj.recheck()
			}, 3e3, !0), $.timer(function() {
				$.cookie("socketUptTime") || c.recheck()
			}, 5e3, !0)
		}
	}
}

function get_Price_Percent(e) {
	var t, n = [],
		i = ["usdt", "btc", "eth", "qtum", "custom"],
		a = "_" + base.toLowerCase(),
		o = Object.prototype.hasOwnProperty,
		r = "CUSTOM" == base,
		s = parseFloat(get_element("currPrice").innerHTML),
		l = parseFloat(get_element("currRateNum").innerHTML);
	for(t in e)
		if(o.call(e, t) && (t.indexOf(a) > -1 || r))
			for(var _ = 0, d = i.length; _ < d; _++) {
				var c = "market_" + t + "_" + i[_],
					g = $("#" + c),
					u = g.find(".left-price").text();
				if(0 != u.length) {
					var m = e[t].length - 1 - e[t].indexOf("."),
						p = +parseFloat(e[t]);
					if($.isNumeric(p) && !(p <= 0)) {
						var f = "";
						f = g_left_side_price[i[_]] && g_left_side_price[i[_]][c] ? g_left_side_price[i[_]][c] : u;
						var b = parseFloat(f);
						if(p != b) {
							var h;
							if(trade_global.symbol == t && s == p) h = l;
							else {
								var v = parseFloat(g.find(".p-num").text()),
									y = parseFloat(100 * b / (100 + v));
								h = (p - y) / y * 100
							}
							if(!$.isNumeric(h)) continue;
							if("" !== g_fiat) {
								var k = get_bid_or_ask_decimals(p, i[_].toUpperCase());
								m = k.fiat_rate_decimals, p *= k.fiat_rate
							}
							var x = p.toFixed(m);
							n.push([x, h, c, i[_]])
						}
					}
				}
			}
	0 != n.length && change_price_percent(n), e = null
}

function moveColor(e) {
	var t = setTimeout(function() {
		e.style.backgroundColor = "", clearTimeout(t)
	}, 1e3)
}

function downColor(e, t) {
	e.style.backgroundColor = t, moveColor(e)
}

function upColor(e, t) {
	e.style.backgroundColor = t, moveColor(e)
}

function arrTimerRun(e, t) {
	var n = setTimeout(function() {
		e.style.opacity = 0, t.style.opacity = 0, clearTimeout(n)
	}, 2e3)
}

function setPageTitle(e) {
	var t = (is_cn ? "￥" : is_kr && "₩") || "$",
		n = get_currency_unitSymbol(currB),
		i = e;
	g_fiat && (n = t, i = Number(i).toFixed(2));
	var a = document.title;
	a = a.substr(a.indexOf(" ") + 1), document.title = n + i + " " + a
}

function change_price_percent(e) {
	if(e) {
		var t = "rgba(42, 189, 163, 0.2)",
			n = "rgba(255, 67, 67, 0.2)";
		is_cn || (n = "rgba(42, 189, 163, 0.2)", t = "rgba(255, 67, 67, 0.2)");
		for(var i = 0, a = e.length; i < a; i++) {
			var o = e[i][1];
			if(null != o) {
				var r, s = e[i][0],
					l = Number(e[i][0]),
					_ = e[i][2],
					d = e[i][3],
					c = trade_global.symbol,
					g = "market_" + c.toLowerCase();
				o = Number(o).toFixed(2), r = ("btc" == d ? "btc" : "eth" == d && "eth") || "qtum" == d && "qtum" || "limited" == d && "limited" || "custom" == d && "custom" || "usdt", g_left_side_price[r] && (g_left_side_price[r][_] = l);
				var u = o < 0 ? "green" : "red";
				is_cn || (u = o < 0 ? "red" : "green");
				var m = "<span class =" + u + ">" + (o < 0 ? "" : "+") + "<span class=p-num>" + o + "</span> %</span>",
					p = "<span class='left-price " + (o < 0 ? "rate_down'>" : "rate_up'>") + s + "</span>";
				if(_.indexOf(g) > -1) {
					var f = c.split("_")[1],
						b = get_bid_or_ask_decimals(l, f, !0),
						h = b.unitSymbol,
						v = (is_cn ? "￥" : is_kr && "₩") || "$",
						y = (l * b.fiat_rate).toFixed(2),
						k = s,
						x = o >= 0,
						w = o >= 0,
						$ = get_element("orderbook_last_rate"),
						T = k;
					g_fiat && (k = y, T = y, v), $.innerHTML = T, $.className = u, setPageTitle(k);
					var L = "<small> " + lang_string("或") + ' </small><i id="currFiat"><em>' + v + "</em>" + y + "</i>";
					get_element("top_last_rate_change").innerHTML = '<span class="price-dl"><em>' + h + '</em><i id="currPrice">' + s + "</i>" + L + "</span><em><span class=" + u + ">" + (w ? "+" : "") + "<strong id=currRateNum>" + o + "</strong>%</span></em>";
					var C = get_element("dnArrow"),
						N = get_element("upArrow");
					x ? (C.style.opacity = 0, N.style.opacity = 1) : (C.style.opacity = 1, N.style.opacity = 0), arrTimerRun(C, N)
				}
				var j = get_element(_);
				if(j && (j.cells[1].innerHTML = p, j.cells[2].innerHTML = m, i < 10)) {
					var M = j.offsetTop,
						H = window.scrollY;
					M >= H && M < H + window.innerHeight && "none" != j.style.display && (o < 0 ? downColor(j, t) : upColor(j, n))
				}
			}
		}
		e = null
	}
}
checkEmpty(0),
	function() {
		var e = LocalStorage.get(currA + "_" + currB + "_gm_data", !0);
		0 == e.status ? (buildGlobal(JSON.parse(e.data)), e = null) : (buildGlobal(gmData), null != gmData && gmData.length > 2500 && LocalStorage.set(currA + "_" + currB + "_gm_data", JSON.stringify(gmData)), gmData = null)
	}(), $(function() {
		var e = $("#hideprice"),
			t = "CNY";
		if(is_en ? t = "USD" : is_kr && (t = "KRW"), e.on("click", function() {
				$(this).prop("checked") ? ($.cookie("show_fiat", "1"), rebuild_orderbook_trade_list(t)) : ($.cookie("show_fiat", "0"), rebuild_orderbook_trade_list(""))
			}), 1 == $.cookie("show_fiat") ? (e.prop("checked", !0), rebuild_orderbook_trade_list(t)) : rebuild_orderbook_trade_list(""), window.location.href.indexOf("?on_service") > -1 && 0 != $.cookie("call_serv") && ($.cookie("call_serv", 0, {
				path: "/"
			}), showChatRoom()), 1 == ordersCo ? (largeOrders(), $("#moreOrders").toggle(function() {
				smallOrders(), $.cookie("orders_num", 0, {
					expires: 7
				})
			}, function() {
				largeOrders(), $.cookie("orders_num", 1, {
					expires: 7
				})
			})) : $("#moreOrders").toggle(function() {
				largeOrders(), $.cookie("orders_num", 1, {
					expires: 7
				}), $("#bid-list").scrollTop(1)
			}, function() {
				smallOrders(), $.cookie("orders_num", 0, {
					expires: 7
				})
			}), $("#buyYuE").find("span").click(function() {
				buy_all()
			}), $("#sellYuE").find("span").click(function() {
				sell_all()
			}), is_login) {
			var n = $("#hidezero"),
				i = $("#my-fund-list");
			void 0 === $.cookie("show_zero_funds") || "1" === $.cookie("show_zero_funds") ? n.prop("checked", !1) : (n.prop("checked", !0), i.css("height", "auto")), n.on("click", function(e) {
				$.cookie("zero_change", "0"), n.prop("checked") ? ($.cookie("show_zero_funds", "0"), page_obj.recheck(), i.css("height", "auto")) : ($.cookie("show_zero_funds", "1"), page_obj.recheck(), i.css("height", "3885px"))
			})
		}
		$("#myOrderTab").on("click", "span", function() {
			var e = $(this),
				t = e.index(),
				n = $("#historyOrder"),
				i = $("#currOrder");
			switch(e.addClass("order-t-active").siblings().removeClass("order-t-active"), t) {
				case 0:
					n.hide(), i.show(), checkEmpty(1), $(".clear-all").show();
					break;
				case 1:
					n.show(), i.hide(), checkEmpty(2), $(".clear-all").hide()
			}
		}), $("#myFundCon").on("scroll", function() {
			if("undefined" == typeof hasAllfund) {
				fundNumStatus = 1, $(this).off("scroll");
				var e = $("#my-fund-list").data("dataFuns");
				page_obj.build_my_fund_list(e), hasAllfund = 1
			}
		});
		var a = 0;
		$("#ask-list").on("scroll", function() {
			var e = 1;
			1 == ordersCo && (e = 2), ++a > e && "undefined" == typeof odSellStatus && (odSellStatus = 1, $(this).off("scroll"), innerOd(1, !0))
		}).scrollTop($("#ul-ask-list").height()), $("#bid-list").on("scroll", function() {
			"undefined" == typeof odBuyStatus && (odBuyStatus = 1, $(this).off("scroll"), innerOd(2, !0))
		}), $(".dealbox").on("keydown", "input", function() {
			var e = this.value;
			return "" == e && (e = "i"), check_number(event, e)
		}).on("keyup", "input", function() {
			190 == event.keyCode && this.value.indexOf(".") < 0 ? this.value = this.value.replace("。", ".") : this.value = this.value.replace(/[^0-9.]/g, "")
		}).on("focus", "input", function() {
			0 == this.value && (this.value = "")
		}).on("blur", "input", function() {
			"" == this.value && (this.value = 0)
		})
	});