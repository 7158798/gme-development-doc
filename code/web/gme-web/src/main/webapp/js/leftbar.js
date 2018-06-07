var LocalStorage = function(t) {
	return {
		get: function(e, a) {
			return t ? a && function(e) {
				var a = t.getItem(e);
				if(!a) return !0;
				var s = parseInt(a);
				return((new Date).getTime() - s) / 1e3 / 60 / 2 > 1
			}(e + "_time") ? {
				status: -3,
				msg: "expired"
			} : t.getItem(e) ? {
				status: 0,
				msg: "get success",
				data: t.getItem(e)
			} : {
				status: -2,
				msg: "not store"
			} : {
				status: -1,
				msg: "storage is unavailable"
			}
		},
		set: function(e, a) {
			if(t) {
				try {
					t.setItem(e, a)
				} catch(r) {
					if("QuotaExceededError" === r.name) {
						console.log("storage reset!"), localStorage.clear();
						for(var s = document.cookie.split(";"), i = 0; i < s.length; i++) {
							var l = s[i].split("=")[0].toString().trim();
							l.indexOf("_time") > -1 && $.removeCookie(l, {
								path: "/"
							})
						}
						t.setItem(e, a)
					}
				}
				var r = (new Date).getTime();
				return t.setItem(e + "_time", r.toString()), $.cookie(e + "_time", r.toString(), {
					path: "/"
				}), {
					status: 0,
					msg: "store success"
				}
			}
			return {
				status: -1,
				msg: "storage is unavailable"
			}
		}
	}
}(window.localStorage);

function TableSorter(t) {
	if(this.Table = this._(t), !(this.Table.rows.length <= 1)) {
		var e = [];
		if(arguments.length > 1)
			for(var a = 1; a < arguments.length; a++) e.push(arguments[a]);
		this.Init(e)
	}
}

function build_marketlist_table(t, e) {
	var a = "",
		s = $.cookie("custom"),
		i = "red",
		l = "green";
	for(var r in void 0 === s && (s = ""), t)
		if("custom" != e || "custom" == e && s.indexOf(t[r].pair) > -1) {
			var o = t[r].pair,
				n = t[r].curr_a,
				d = t[r].curr_b,
				c = t[r].vol_b,
				u = t[r].trend,
				m = t[r].name_cn,
				b = t[r].rate_percent;
			a += "<tr id='market_" + o + "_" + e + "' data-trade=" + o + " title='" + lang_string("交易量") + c + " " + d + "'>", "up" != u && "down" != u && (u = "up"), "custom" != e && is_cn && "limited" != e ? a += '<td><span class="icon-16 icon-16-' + n.toLowerCase() + '"></span><span class="bizhong_en">' + t[r].symbol + "</span> <span class=cname title=" + m + ">" + m + "</span> </td>" : a += '<td><span class="icon-16 icon-16-' + n.toLowerCase() + '"></span><span class="bizhong_en">' + n + "/" + d + "</span></td>", a += '<td><span class="left-price rate_' + u + '">' + t[r].rate + "</span></td>", is_cn || (i = "green", l = "red"), a += b > 0 ? '<td class="rzd"><span class=' + i + '>+<span class="p-num">' + b + "</span> %</span></td>" : '<td class="rzd"><span class=' + l + '><span class="p-num">' + b + "</span> %</span></td>", a += '<td class="custom-option">', s.indexOf(o) > -1 ? a += '<i class="add-fav custom-on" data-id=' + o + ' title="' + lang_string("取消自选") + '"></i>' : a += '<i class="add-fav" data-id=' + o + ' title="' + lang_string("加自选") + '"></i>', a += "</td></tr>"
		}
	return a
}
TableSorter.prototype = {
	_: function(t) {
		return document.getElementById(t)
	},
	Init: function(t) {
		this.Rows = [], this.Header = [], this.ViewState = [], this.LastSorted = null, this.NormalCss = "sortable", this.SortAscCss = "sorting_asc", this.SortDescCss = "sorting_desc";
		for(var e = 0; e < this.Table.rows.length; e++) this.Rows.push(this.Table.rows[e]);
		this.Header = this.Rows.shift().cells;
		for(e = 0; e < (t.length ? t.length : this.Header.length); e++) {
			var a = t.length ? t[e] : e;
			a >= this.Header.length || (this.ViewState[a] = !1, this.Header[a].style.cursor = "pointer", $(this.Header[a]).on("click", this.GetFunction(this, "Sort", a)))
		}
	},
	GetFunction: function(t, e, a) {
		return function() {
			t[e](a)
		}
	},
	Sort: function(t) {
		this.LastSorted && (this.LastSorted.className = this.NormalCss);
		for(var e = !0, a = 0; a < this.Rows.length && e; a++) e = 1 == t || 2 == t;
		this.Rows.sort(function(a, s) {
			var i, l;
			return i = a.cells[t].textContent, l = s.cells[t].textContent, 2 == t && (i = i.replace(/[^\d\-\.]/g, ""), l = l.replace(/[^\d\-\.]/g, "")), i == l ? 0 : (e ? parseFloat(i) > parseFloat(l) : i > l) ? -1 : 1
		}), this.ViewState[t] ? (this.Rows.reverse(), this.ViewState[t] = !1, this.Header[t].className = this.SortAscCss) : (this.ViewState[t] = !0, this.Header[t].className = this.SortDescCss), this.LastSorted = this.Header[t];
		var s = document.createDocumentFragment();
		for(a = 0; a < this.Rows.length; a++) s.appendChild(this.Rows[a]);
		this.Table.tBodies[0].appendChild(s), this.OnSorted(this.Header[t], this.ViewState[t])
	},
	addRow: function() {
		this.Rows = [];
		for(var t = this.Table.rows, e = 0; e < t.length; e++) this.Rows.push(t[e]);
		this.Rows.splice(0, 1)
	},
	removeRow: function(t) {
		console.log(this.Rows);
		for(var e = 0; e < this.Rows.length; e++) console.log(this.Rows[e].id), this.Rows[e].id == t && this.Rows.splice(e);
		console.log(this.Rows)
	},
	destroy: function() {
		return console.log(this.Header), $(this.Header).off("click"), TableSorter = this.Table = this.Header = this.Rows = this.LastSorted = this.ViewState = null, null
	},
	OnSorted: function(t, e) {}
}, "SNET" == base && (base = "QTUM");
var marketlist_usdt = $("#marketlist_usdt"),
	marketlist_btc = $("#marketlist_btc"),
	marketlist_eth = $("#marketlist_eth"),
	marketlist_qtum = $("#marketlist_qtum"),
	marketlist_custom = $("#marketlist_custom"),
	marketlist_limited = $("#marketlist_limited");
"CUSTOM" == customBase && (base = "CUSTOM");
var emptyTip = "<tr><td colspan=4 class=dataTables_empty>" + lang_string("暂无数据") + "</td></tr>",
	storageCurrB = currB;
"USDT" != currB && "BTC" != currB && "ETH" != currB && "QTUM" != currB && (storageCurrB = "QTUM"), "LIMITED" == base && (storageCurrB = base);
var l_d_data = LocalStorage.get("l_d_data_" + storageCurrB, !0);

function buildUSDT() {
	var t, e = $("#usdtTbody");
	return null != listDataUSDT ? (t = build_marketlist_table(listDataUSDT, "usdt"), e.html(t), !0) : (e.html(emptyTip), !1)
}

function buildBTC() {
	var t, e = $("#btcTbody");
	return null != listDataBTC ? (t = build_marketlist_table(listDataBTC, "btc"), e.html(t), !0) : (e.html(emptyTip), !1)
}

function buildETH() {
	var t, e = $("#ethTbody");
	return null != listDataETH ? (t = build_marketlist_table(listDataETH, "eth"), e.html(t), !0) : (e.html(emptyTip), !1)
}

function buildQTUM() {
	var t, e = $("#qtumTbody");
	return null != listDataQTUM ? (t = build_marketlist_table(listDataQTUM, "qtum"), e.html(t), !0) : (e.html(emptyTip), !1)
}

function buildCustom() {
	var t = $("#customTbody");
	if(null != listDataUSDT || null != listDataBTC || null != listDataETH || null != listDataQTUM) {
		var e = "";
		return e += build_marketlist_table(listDataUSDT, "custom"), e += build_marketlist_table(listDataBTC, "custom"), e += build_marketlist_table(listDataETH, "custom"), e += build_marketlist_table(listDataQTUM, "custom"), "" != (e += build_marketlist_table(listDataLIMITED, "custom")) ? (t.html(e), !0) : (t.html(emptyTip), !1)
	}
	return t.html(emptyTip), !1
}

function buildLimited() {
	var t = $("#limitedTbody");
	if(listDataLIMITED) {
		var e = "";
		return e += build_marketlist_table(listDataLIMITED, "limited"), t.html(e), !0
	}
	return t.html(emptyTip), !1
}
0 == l_d_data.status ? (listDataDefault = JSON.parse(l_d_data.data), l_d_data = null) : null != listDataDefault && LocalStorage.set("l_d_data_" + storageCurrB, JSON.stringify(listDataDefault)), "USDT" == base ? (listDataUSDT = listDataDefault, buildUSDT()) : "BTC" == base ? (listDataBTC = listDataDefault, buildBTC()) : "ETH" == base ? (listDataETH = listDataDefault, buildETH()) : "QTUM" == base ? (listDataQTUM = listDataDefault, buildQTUM()) : "CUSTOM" == base ? buildCustom() : "LIMITED" == base ? (listDataLIMITED = listDataDefault, buildLimited()) : (listDataQTUM = listDataDefault, buildQTUM()), listDataDefault = null, $(function() {
	function t(t, e) {
		t.find("tbody").on("click", "tr", function(t) {
			"I" != $(t.target)[0].nodeName && "dataTables_empty" != t.target.className && (window.location = "/trade/" + $(this).data("trade") + e)
		})
	}

	function e(t) {
		"CUSTOM" == base ? customSort = new TableSorter("marketlist_" + base.toLowerCase(), 0, 1, 2) : tableSort = new TableSorter("marketlist_" + base.toLowerCase(), 0, 1, 2), $("#marketlistTabCon").off("click"), t.click()
	}
	t(marketlist_usdt, ""), t(marketlist_btc, ""), t(marketlist_eth, ""), t(marketlist_qtum, ""), t(marketlist_custom, "?my_custom"), t(marketlist_limited, ""), customChanged = !1, $("#marketlistTabCon").on("click", ".sortable", function() {
		e($(this))
	}).find("tbody").on("click", ".add-fav", function() {
		customChanged = !0;
		var t, e, a = $(this);
		if(a.hasClass("custom-on")) {
			if("customTbody" == a.parents("tbody").attr("id")) {
				var s = $("#customTbody");
				0 == s.find("tr").length ? s.html("<tr><td class='dataTables_empty' colspan='4'>" + lang_string("暂无自选币种！") + "</td></tr>") : "undefined" != typeof customSort && customSort.removeRow(a.parent().parent().prop("id")), a.parent().parent().remove()
			}
			a.removeClass("custom-on").attr("title", lang_string("加自选")), t = a.attr("data-id"), void 0 !== (e = $.cookie("custom").split(",")) && (function(t, e) {
				for(var a = 0; a < t.length; a++)
					if(t[a] == e) {
						t.splice(a, 1);
						break
					}
			}(e, t), 0 === e.length ? $.removeCookie("custom", {
				path: "/"
			}) : $.cookie("custom", e, {
				expires: 365,
				path: "/"
			}))
		} else a.addClass("custom-on").attr("title", lang_string("取消自选")),
			function(t) {
				var e = t.attr("data-id");
				if(void 0 !== $.cookie("custom")) {
					var a = $.cookie("custom").split(",");
					if(-1 == $.inArray(e, a)) {
						var s = [a, e];
						$.cookie("custom", s, {
							expires: 365,
							path: "/"
						})
					}
				} else $.cookie("custom", e, {
					expires: 365,
					path: "/"
				})
			}(a)
	});
	var a = "";
	a = "CUSTOM" == base ? ("market_" + currA + "_" + currB + "_custom").toLowerCase() : "LIMITED" == base ? ("market_" + currA + "_" + currB + "_limited").toLowerCase() : ("market_" + currA + "_" + currB + "_" + currB).toLowerCase();
	var s = $("#" + a);
	s.length > 0 && s.addClass("coin-selected");
	var i = currB;

	function l(t) {
		if($("#marketlistTabCon").on("click", ".sortable", function() {
				e($(this))
			}), "USDT" == t) {
			var a = $("#usdtTbody").find("tr").length;
			customChanged && a > 0 && buildUSDT(), a < 1 && buildUSDT(), $("#marketlist_container_usdt").css("display", "block"), base = "USDT", i = base
		} else if("BTC" == t) {
			var s = $("#btcTbody").find("tr").length;
			customChanged && s > 0 && buildBTC(), s < 1 && buildBTC(), $("#marketlist_container_btc").css("display", "block"), base = "BTC", i = base
		} else if("ETH" == t) {
			var l = $("#ethTbody").find("tr").length;
			customChanged && l > 0 && buildETH(), l < 1 && buildETH(), $("#marketlist_container_eth").css("display", "block"), base = "ETH", i = base
		} else if("QTUM" == t) {
			var r = $("#qtumTbody").find("tr").length;
			customChanged && r > 0 && buildQTUM(), r < 1 && buildQTUM(), $("#marketlist_container_qtum").css("display", "block"), base = "QTUM", i = base
		} else if("CUSTOM" == t) {
			var o = $("#customTbody").find("tr").length;
			customChanged && o > 0 && (buildCustom(), "undefined" != typeof customSort && customSort.addRow()), o < 1 && buildCustom(), $("#marketlist_container_custom").css("display", "block"), base = "CUSTOM", i = ""
		} else if("LIMITED" == t) {
			var n = $("#limitedTbody").find("tr").length;
			customChanged && n > 0 && buildLimited(), n < 1 && buildLimited(), $("#marketlist_container_limited").css("display", "block"), base = "LIMITED", i = "ETH"
		}
	}
	var r = $("#marketSearch");

	function o(t) {
		for(var e, a, s, i = t.value.toLowerCase(), l = document.getElementById("marketlist_" + base.toLowerCase()).tBodies[0], r = l.rows, o = 0, n = "", d = 0, c = r.length; d < c; d++) null != (e = r[d]) && (e.children[0].className ? l.deleteRow(d) : null != (a = e.children[0].children[1]) && (s = a.textContent.toLowerCase(), is_cn && e.children[0].children[2] && (n = e.children[0].children[2].textContent.toLowerCase()), -1 == s.indexOf(i) && -1 == n.indexOf(i) ? e.style.display = "none" : (o++, e.style.display = "block")));
		if(0 == o) {
			var u = l.insertRow(-1),
				m = u.insertCell(0);
			u.className = "r-empty", m.colSpan = "4", m.className = "dataTables_empty", "LIMITED" == base ? m.innerHTML = lang_string("限时交易区") + lang_string("搜无 ") + "<b>" + i + "</b>" : "CUSTOM" == base ? m.innerHTML = lang_string("自选区") + lang_string("搜无 ") + "<b>" + i + "</b>" : m.innerHTML = base + lang_string("交易区") + lang_string("搜无 ") + "<b>" + i + "</b>"
		}
	}
	$("#market_controller").on("click", "button", function() {
		var t = $(this),
			e = t.attr("value");
		if(e != base)
			if(r.val(""), o(r[0]), t.addClass("tn_selected").siblings().removeClass("tn_selected"), $("#marketlist_container_usdt,#marketlist_container_btc,#marketlist_container_eth,#marketlist_container_qtum,#marketlist_container_limited,#marketlist_container_custom").css("display", "none"), "" != customBase || "undefined" != typeof dataLoaded && 0 != dataLoaded) l(e);
			else {
				var a = LocalStorage.get("leftbar_data", !0);
				if(0 == a.status) {
					var s = JSON.parse(a.data);
					listDataUSDT = s.USDT, listDataBTC = s.BTC, listDataETH = s.ETH, listDataQTUM = s.QTUM, listDataLIMITED = s.LIMITED, l(e), a = null, s = null, dataLoaded = 1
				} else $("#leftTipPan").html('<div class="load8"><div class="loader"></div></div>'), $.ajax({
					type: "get",
//					url: "/json_svr/get_leftbar/?u=128&c=" + Math.floor(1e6 * Math.random()),
					url: "/json_svr/get_leftbar/index.json",
					xhrFields: {
						withCredentials: !0
					},
					success: function(t) {
						$("#leftTipPan").html(""), listDataUSDT = t.USDT, listDataBTC = t.BTC, listDataETH = t.ETH, listDataQTUM = t.QTUM, listDataLIMITED = t.LIMITED, l(e), LocalStorage.set("leftbar_data", JSON.stringify(t)), t = null, dataLoaded = 1
					},
					error: function(t, e, a) {
						$("#leftTipPan").html("<div class='left-err-tip red'>" + lang_string("网络错误") + ": " + t.status + " " + t.responseText + " " + status + " " + a + "</div>"), dataLoaded = 0
					}
				})
			}
		return !1
	});
	var n = !1;
	r.on("input propertychange", function() {
		n || o(this)
	}).on("compositionstart", function() {
		n = !0
	}).on("compositionend", function() {
		(n = !1) || o(this)
	}).on("keyup", function(t) {
		if(13 == t.keyCode) {
			var e = $("#" + base.toLowerCase() + "Tbody").find("tr:visible")[0];
			if(e && "r-empty" == e.className) return;
			var a = e.children[0].children[1].textContent;
			if("LIMITED" == base) a = a.split("/")[0];
			else if("CUSTOM" == base || !is_cn) {
				var s = a.split("/");
				a = s[0], i = s[1]
			}
			window.location = "/trade/" + a + "_" + i
		}
	})
});