currType = "usdt", void 0 !== $.cookie("market_title") && (currType = $.cookie("market_title").toLowerCase());
var LocalStorage = function(t) {
	return {
		get: function(e, a) {
			return t ? a && function(e) {
				var a = t.getItem(e);
				if(!a) return !0;
				var i = parseInt(a);
				return((new Date).getTime() - i) / 1e3 / 60 / 5 > 1
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
				} catch(s) {
					if("QuotaExceededError" === s.name) {
						console.log("storage reset!"), localStorage.clear();
						for(var i = document.cookie.split(";"), r = 0; r < i.length; r++) {
							var n = i[r].split("=")[0].toString().trim();
							n.indexOf("_time") > -1 && $.removeCookie(n, {
								path: "/"
							})
						}
						t.setItem(e, a)
					}
				}
				var s = (new Date).getTime();
				return t.setItem(e + "_time", s.toString()), {
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

function buildDom(t, e, a) {
	var i = "",
		r = 1,
		n = "",
		s = 0,
		o = 2,
		l = "",
		c = "";
	for(var d in void 0 !== $.cookie("custom") && (c = $.cookie("custom").toLowerCase()), "usdt" == e && (r = USDT_fiat_rate), "btc" == e && (r = BTC_fiat_rate), "eth" == e && (r = ETH_fiat_rate), "qtum" == e && (r = QTUM_fiat_rate), "limited" == e && (r = ETH_fiat_rate), t) {
		listNum++;
		var u = t[d].pair;
		if(!(a && c.indexOf(u) < 0 || atTop && listNum > 20 && "qtum" != e && "limited" != e && !a)) {
			var h = t[d].curr_a,
				p = t[d].curr_b,
				f = t[d].rate,
				g = t[d].name_cn,
				m = (t[d].symbol, t[d].trend),
				b = t[d].vol_b,
				v = t[d].marketcap,
				_ = t[d].rate_percent,
				T = t[d].name_en;
			l = "USDT" == p ? "$" : "BTC" == p ? "฿" : "ETH" == p ? "E" : p.substr(0, 1), 1 != r && (o = 2, o = (s = f * r) > 1 ? 2 : s > .1 ? 2 : s > .01 ? 3 : s > .001 ? 4 : 5, s = s.toFixed(o), i = is_cn ? "<span style='color:#999'>/￥" + s + "</span>" : "<span style='color:#999'>/$" + s + "</span>");
			var y = lang_string("去交易"),
				C = "",
				w = "",
				x = "",
				k = "",
				D = "";
			if("limited" == e) {
				var S = JSON.parse(daysLeftArr)[h];
				C = '<div class="left-d">' + lang_string("剩余") + '<span class="red"> ' + S + " </span>" + lang_string("天") + "</div>", w = "limi-row"
			}
			"qtum" != e && !a && is_cn || (k = "/<em>" + p + "</em>"), is_cn && (D = '<span class="cname">' + g + "</span>", T = g), a && (x = "class=" + e + "_type"), n += "<tr id=" + u + " " + x + ">", n += '<td ><a class="coin-name ' + w + '" href="/trade/' + u.toUpperCase() + '" title="' + T + '"><span class="icon-32 icon-32-' + h.toLowerCase() + '"></span><span class="name-con"><b><span class="curr_a">' + h + "</span>" + k + "</b> " + D + C + " </span></a></td>", is_cn ? (n += '<td class="rate_' + m + '">' + l + f + i + "</td>", n += "<td>" + l + b + "</td>", n += "<td>" + l + v + "</td>", n += '<td class="day-updn">' + (_ < 0 ? "<span class=green>" + _ + " %</span>" : 0 == _ || -0 == _ ? "<span class=red>0.00 %</span>" : "<span class=red>+" + _ + " %</span>") + "</td>") : (n += '<td><span class="rate_' + m + '">' + l + f + i + "</td>", n += "<td>" + l + b + "</td>", n += "<td>" + t[d].supply + "</td>", n += "<td>" + l + v + "</td>", n += '<td class="day-updn">' + (_ < 0 ? "<span class=red>" + _ + " %</span>" : 0 == _ || -0 == _ ? "<span class=green>0.00 %</span>" : "<span class=green>+" + _ + " %</span>") + "</td>"), n += '<td><div class="price-chart" id="' + u + '_plot"></div></td>', n += '<td><a class="go-trade-btn r-btn" href="/trade/' + u.toUpperCase() + '">' + y + "</a></td>", n += '<td class="custom-option">', c.indexOf(u) > -1 ? n += '<i class="add-fav custom-on" data-id=' + u + ' title="' + lang_string("取消自选") + '"></i>' : n += '<i class="add-fav" data-id=' + u + ' title="' + lang_string("加自选") + '"></i>', n += "</td></tr>", a || chartFuc.push(u + "_chart();")
		}
	}
	return n
}

function loadChartData(coinType, chartFucRun) {
	$.ajax({
		type: "get",
		//url: "/marketlist/" + coinType + "?u=5",
		url: "/yyctjys//marketlist/new_file.txt",
		dataType: "script",
		success: function(data) {
			if(data) {
				LocalStorage.set("chartFucData_" + coinType, data);
				for(var i = 0; i < chartFucRun.length; i++) try {
					eval(chartFucRun[i])
				} catch(t) {
					console.log(t)
				}
				data = null, chartFucRun = null
			} else $(".price-chart").html("<div class='chart-err'>" + lang_string("加载失败！") + "</div>")
		},
		error: function() {
			$(".price-chart").html("<div class='chart-err'>" + lang_string("加载失败！") + "</div>")
		},
		complete: function() {
			$("#marketlist_controller").find(".load8").remove()
		}
	})
}

function renderChart(coinType, isCustom) {
	var lsData = LocalStorage.get("chartFucData_" + coinType, !0),
		chartFucRun = chartFuc;
	if(isCustom) {
		for(var thisTypeCharts = $("#list_tbody").find("." + coinType + "_type"), thisTypeChartFuc = [], i = 0; i < thisTypeCharts.length; i++) {
			var unchartPair = $(thisTypeCharts[i]).prop("id");
			unchartPair && thisTypeChartFuc.push(unchartPair + "_chart();")
		}
		chartFucRun = thisTypeChartFuc
	}
	if(0 != lsData.status || data_expired) $(".btn_selected").append('<div class="load8"><div class="loader">Loading</div></div>'), loadChartData(coinType, chartFucRun);
	else {
		eval(lsData.data);
		for(var n = 0; n < chartFucRun.length; n++) try {
			eval(chartFucRun[n])
		} catch(t) {
			console.log(t)
		}
		lsData.data = null
	}
	chartFucRun = null
}

function buildAll(t, e) {
	chartFuc = [], void 0 === t && (t = "usdt");
	var a = "",
		i = "",
		r = "";
	if("qtum" != t && "custom" != t && (a = "<span class=curr-base>" + t.toUpperCase() + "</span>"), "limited" == t && (a = "<span class=curr-base>ETH</span>"), e && (i = "show-all"), r += '<table id="listTable" class="marketlist dataTable ' + i + '"><thead><tr><th class="sortable"><b>' + lang_string("币种对"), is_cn && (r += a), r += '</b></th><th class="sortable"><b>' + lang_string("价格") + a + '</b></th><th class="sortable"><b>' + lang_string("交易量") + a + "</b></th>", is_cn || (r += '<th class="sortable"><b>' + lang_string("Supply") + "</b></th>"), r += '<th class="sortable"><b>' + lang_string("总市值") + '</b></th><th class="sortable day-updn"><b>' + lang_string("日涨跌") + '</b></th><th class="sorting_disabled price-flot"><b>' + lang_string("价格趋势(3日)") + '</b></th><th class="sorting_disabled"></th><th class="sorting_disabled"><i class="fav-icon" title=' + lang_string("自选") + '></i></th></tr></thead><tbody id="list_tbody">', "custom" == t) {
		var n = $.cookie("custom");
		void 0 === n ? r += "<tr class='m-err-tip red'><td colspan='8'>" + lang_string("暂无自选币种！") + "</td></tr>" : (r += buildDom(listDataUSDT, "usdt", !0), r += buildDom(listDataBTC, "btc", !0), r += buildDom(listDataETH, "eth", !0), r += buildDom(listDataQTUM, "qtum", !0), r += buildDom(listDataLIMITED, "limited", !0))
	} else "usdt" == t ? r += buildDom(listDataUSDT, t) : "btc" == t ? r += buildDom(listDataBTC, t) : "eth" == t ? r += buildDom(listDataETH, t) : "qtum" == t ? r += buildDom(listDataQTUM, t) : "limited" == t && (r += buildDom(listDataLIMITED, t));
	r += "</tbody></table>", $("#mianBox").html(r), r = null, "custom" == t ? void 0 !== n && (renderChart("usdt", !0), renderChart("btc", !0), renderChart("eth", !0), renderChart("qtum", !0), renderChart("limited", !0)) : renderChart(t)
}

function searchCoin(t, e) {
	var a = t.val().toLowerCase(),
		i = $("#list_tbody"),
		r = $(".coin-name "),
		n = i.find("tr"),
		s = 0;
	if($.each(n, function() {
			var t = $(this),
				i = t.find(".curr_a").text().toLowerCase(),
				r = "";
			if(is_cn && (r = t.find(".cname").text().toLowerCase()), null != i)
				if(-1 == i.indexOf(a) && -1 == r.indexOf(a)) t.hide();
				else if(s++, t.show(), null != e && 13 == e.keyCode) return window.location = "/trade/" + i.toUpperCase() + "_" + currType.toUpperCase(), !1
		}), r.removeHighlight(), a && r.highlight(a), i.find(".r-empty").remove(), 0 == s) {
		var o = currType.toUpperCase() + lang_string("交易区");
		"limited" == currType && (o = lang_string("限时交易区")), "custom" == currType && (o = lang_string("自选区")), i.append('<tr class="r-empty"><td colspan="8" class="dataTables_empty">' + o + lang_string("搜无 ") + "<b>" + a + "</b></td></tr>")
	}
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
			a >= this.Header.length || (this.ViewState[a] = !1, this.Header[a].style.cursor = "pointer", this.Header[a].onclick = this.GetFunction(this, "Sort", a))
		}
	},
	GetFunction: function(t, e, a) {
		return function() {
			t[e](a)
		}
	},
	Sort: function(t) {
		this.LastSorted && (this.LastSorted.className = this.NormalCss);
		for(var e = !0, a = 0; a < this.Rows.length && e; a++) e = is_cn ? 1 == t || 2 == t || 3 == t || 4 == t : 1 == t || 2 == t || 3 == t || 4 == t || 5 == t;
		this.Rows.sort(function(a, i) {
			var r, n;
			return r = a.cells[t].innerHTML, n = i.cells[t].innerHTML, is_cn ? (1 == t && (r = r.split("<sp")[0].substring(1), n = n.split("<sp")[0].substring(1)), 2 != t && 3 != t && 4 != t || (r = r.replace(/[^\d\-\.]/g, ""), n = n.replace(/[^\d\-\.]/g, ""))) : 1 != t && 2 != t && 4 != t && 5 != t || (r = r.replace(/[^\d\-\.]/g, ""), n = n.replace(/[^\d\-\.]/g, "")), r == n ? 0 : (e ? parseFloat(r) > parseFloat(n) : r > n) ? -1 : 1
		}), this.ViewState[t] ? (this.Rows.reverse(), this.ViewState[t] = !1, this.Header[t].className = this.SortAscCss) : (this.ViewState[t] = !0, this.Header[t].className = this.SortDescCss), this.LastSorted = this.Header[t];
		var i = document.createDocumentFragment();
		for(a = 0; a < this.Rows.length; a++) i.appendChild(this.Rows[a]);
		this.Table.tBodies[0].appendChild(i), this.OnSorted(this.Header[t], this.ViewState[t])
	},
	OnSorted: function(t, e) {}
}, chartFuc = [], listNum = 0, listDataUSDT = "", listDataBTC = "", listDataETH = "", listDataQTUM = "", listDataLIMITED = "", jQuery.fn.highlight = function(t) {
	return this.each(function() {
		! function t(e, a) {
			var i = 0;
			if(3 == e.nodeType) {
				var r = e.data.toUpperCase().indexOf(a);
				if(r >= 0) {
					var n = document.createElement("span");
					n.className = "highlight";
					var s = e.splitText(r),
						o = (s.splitText(a.length), s.cloneNode(!0));
					n.appendChild(o), s.parentNode.replaceChild(n, s), i = 1
				}
			} else if(1 == e.nodeType && e.childNodes && !/(script|style)/i.test(e.tagName))
				for(var l = 0; l < e.childNodes.length; ++l) l += t(e.childNodes[l], a);
			return i
		}(this, t.toUpperCase())
	})
}, jQuery.fn.removeHighlight = function() {
	return this.find("span.highlight").each(function() {
		var t = this.parentNode;
		t.replaceChild(this.firstChild, this),
			function t(e) {
				for(var a = 0, i = e.childNodes, r = i.length; a < r; a++) {
					var n = i[a];
					if(1 != n.nodeType) {
						if(3 == n.nodeType) {
							var s = n.nextSibling;
							if(null != s && 3 == s.nodeType) {
								var o = n.nodeValue + s.nodeValue;
								new_node = e.ownerDocument.createTextNode(o), e.insertBefore(new_node, n), e.removeChild(n), e.removeChild(s), a--, r--
							}
						}
					} else t(n)
				}
			}(t)
	}).end()
};
var searchInput = $("#fsBar"),
	cpLock = !1;

function winScroll() {
	"usdt" != currType && "btc" != currType && "eth" != currType || $(window).scroll(function() {
		$("#listTable").hasClass("show-all") ? 20 != $("#list_tbody").find("tr").length && $(this).off("scroll") : (atTop = !1, buildAll(currType, !0))
	})
}
searchInput.on("input propertychange", function() {
	cpLock || searchCoin($(this))
}).on("compositionstart", function() {
	cpLock = !0
}).on("compositionend", function() {
	(cpLock = !1) || searchCoin($(this))
}).on("keyup", function(t) {
	cpLock || searchCoin($(this), t)
}), atTop = !1, 0 == $(window).scrollTop() && (atTop = !0), setTimeout(function() {
	0 != $(window).scrollTop() && atTop && (atTop = !1, buildAll(currType, !0))
}, 200), winScroll();
var leftbar_data = LocalStorage.get("leftbar_data", !0);
if(0 != leftbar_data.status || data_expired) $(".btn_selected").append('<div class="load8"><div class="loader">Loading</div></div>'), $.ajax({
	type: "get",
	//url: "/json_svr/get_leftbar/?u=128&c=" + Math.floor(1e6 * Math.random()),
	 url: "/json_svr/get_leftbar/u128c658006.json",
	//   url: "../json_svr/get_leftbar/u128c658006.json",
	xhrFields: {
		withCredentials: !0
	},
	success: function(t) {
		listDataUSDT = t.USDT, listDataBTC = t.BTC, listDataETH = t.ETH, listDataQTUM = t.QTUM, listDataLIMITED = t.LIMITED, "usdt" == currType || "btc" == currType || "eth" == currType ? buildAll(currType) : (atTop = !1, buildAll(currType, !0)), LocalStorage.set("leftbar_data", JSON.stringify(t)), t = null
	},
	error: function() {
		$("#normal_tbody").html("<tr class='m-err-tip red'><td colspan='8'>" + lang_string("网络错误") + ": " + lang_string("请检查您的网络连接后重试。") + "</td></tr>")
	},
	complete: function() {
		$("#marketlist_controller").find(".load8").remove()
	}
});
else {
	var data = JSON.parse(leftbar_data.data);
	listDataUSDT = data.USDT, listDataBTC = data.BTC, listDataETH = data.ETH, listDataQTUM = data.QTUM, listDataLIMITED = data.LIMITED, "usdt" == currType || "btc" == currType || "eth" == currType ? buildAll(currType) : (atTop = !1, buildAll(currType, !0)), leftbar_data = null, data = null
}

function addCoinCookie(t) {
	var e = t.attr("data-id");
	if(void 0 !== $.cookie("custom")) {
		var a = $.cookie("custom").split(",");
		if(-1 == $.inArray(e, a)) {
			var i = [a, e];
			$.cookie("custom", i, {
				expires: 365,
				path: "/",
				secure: !0
			})
		}
	} else $.cookie("custom", e, {
		expires: 365,
		path: "/"
	})
}

function cutCoinCookie(t) {
	var e = t.attr("data-id"),
		a = $.cookie("custom");
	if(void 0 !== a) {
		var i = a.split(",");
		! function(t, e) {
			for(var a = 0; a < t.length; a++)
				if(t[a] == e) {
					t.splice(a, 1);
					break
				}
		}(i, e), 0 === i.length ? $.removeCookie("custom", {
			path: "/"
		}) : $.cookie("custom", i, {
			expires: 365,
			path: "/",
			secure: !0
		})
	}
}

function setTableSorter(t) {
	var e = $("#listTable").hasClass("show-all"),
		a = $("#mianBox");
	if(!e) {
		if("custom" == currType && $("#list_tbody").find(".m-err-tip").length) return !1;
		listNum = 0, atTop = !1, buildAll(currType), $("#listTable").addClass("show-all")
	}
	is_cn ? tableSort = new TableSorter("listTable", 0, 1, 2, 3, 4) : tableSort = new TableSorter("listTable", 0, 1, 2, 3, 4, 5), a.off("click"), e ? t.click() : a.find("th").eq(t.index()).click()
}

function fixedAlertPosition(t) {
	var e = document.body.clientHeight,
		a = document.body.clientWidth;
	t.css({
		left: (a - 390) / 2,
		top: (e - 598) / 2
	})
}
$("#marketMain").on("click", ".add-fav", function() {
		var t = $(this);
		if(t.hasClass("custom-on")) {
			if("custom" == currType) {
				var e = $("#list_tbody");
				t.parents("tr").remove(), 0 == e.find("tr").length && e.html("<tr class='m-err-tip red'><td colspan='8'>" + lang_string("暂无自选币种！") + "</td></tr>")
			}
			t.removeClass("custom-on").attr("title", lang_string("加自选")), cutCoinCookie(t)
		} else t.addClass("custom-on").attr("title", lang_string("取消自选")), addCoinCookie(t)
	}), $("#mianBox").on("click", ".sortable", function() {
		setTableSorter($(this))
	}), $("#marketlist_controller").on("click", "button", function() {
		if($(this).hasClass("btn_selected")) return !1;
		var t = $(this).attr("id"),
			e = t.toUpperCase() + lang_string("交易区");
		return listNum = 0, tableSort = null, currType = t, $(this).addClass("btn_selected").siblings().removeClass("btn_selected"), $(this).siblings().find(".load8").remove(), searchInput.val(""), $("#mianBox").on("click", ".sortable", function() {
			setTableSorter($(this))
		}).prop("class", t.toUpperCase() + "-box"), "limited" == t && (e = lang_string("限时交易区")), "custom" == t && (e = lang_string("自选区")), $("#fsBar").attr("placeholder", lang_string("搜索") + e), 0 == $(window).scrollTop() ? (atTop = !0, buildAll(currType, !0), $("#listTable").removeClass("show-all"), winScroll()) : (atTop = !1, buildAll(currType, !0), $("#listTable").addClass("show-all")), $.cookie("market_title", t, {
			expires: 365,
			path: "/",
			secure: !0
		}), !1
	}), window.downloadFile = function(t) {
		if(/(iP)/g.test(navigator.userAgent)) return alert("Your device does not support files downloading. Please try again in desktop browser."), !1;
		if(window.downloadFile.isChrome || window.downloadFile.isSafari) {
			var e = document.createElement("a");
			if(e.href = t, void 0 !== e.download) {
				var a = t.substring(t.lastIndexOf("/") + 1, t.length);
				e.download = a
			}
			if(document.createEvent) {
				var i = document.createEvent("MouseEvents");
				return i.initEvent("click", !0, !0), e.dispatchEvent(i), !0
			}
		}
		return -1 === t.indexOf("?") && (t += "?download"), window.open(t, "_self"), !0
	}, window.downloadFile.isChrome = navigator.userAgent.toLowerCase().indexOf("chrome") > -1, window.downloadFile.isSafari = navigator.userAgent.toLowerCase().indexOf("safari") > -1, $(".gate-logo").click(function() {
		var t = "../images/gate.io_logo_en.png",
			e = "../images/gateio_en.svg",
			a = "../images/gateio_h_en.png",
			i = "../images/gateio_h_en.svg";
		is_cn && (t = "../images/gate.io_logo.png", e = "../images/gateio.svg", a = "../images/gateio_h.png", i = "../images/gateio_h.svg"), $("<div class='img-modal logo-img'><div class='img-box'><img src=" + i + "><ul class=save-btn><li onclick=downloadFile('" + a + "')>" + lang_string("保存为") + " <b>png</b> " + lang_string("图片") + "</li><li onclick=downloadFile('" + i + "')>" + lang_string("保存为") + " <b>svg</b> " + lang_string("图片") + "</li></ul></div><div class='img-box'><img src=" + e + "><ul class=save-btn><li onclick=downloadFile('" + t + "')>" + lang_string("保存为") + " <b>png</b> " + lang_string("图片") + "</li><li onclick=downloadFile('" + e + "')>" + lang_string("保存为") + " <b>svg</b> " + lang_string("图片") + "</li></ul></div><span class=img-close>×</span></div>").prependTo("body");
		var r = $(".img-modal");
		fixedAlertPosition(r), $(window).on("resize", function() {
			fixedAlertPosition(r)
		}), $(".img-close").click(function() {
			$(".img-modal").remove(), $(window).off("resize")
		});
		var n = setTimeout(function() {
			$(".img-close").stop().animate({
				opacity: "0"
			})
		}, 1e3);
		r.hover(function() {
			$(".img-close").stop().animate({
				opacity: "1"
			}), clearTimeout(n)
		}, function() {
			$(".img-close").stop().animate({
				opacity: "0"
			})
		})
	}),
	function(t, e) {
		"function" == typeof define && define.amd ? define(["jquery"], e) : "object" == typeof exports ? module.exports = e(require("jquery")) : e(t.jQuery)
	}(this, function(t, e) {
		function a(t, e, a) {
			var i = d[e.type] || {};
			return null == t ? a || !e.def ? null : e.def : (t = i.floor ? ~~t : parseFloat(t), i.mod ? (t + i.mod) % i.mod : Math.min(i.max, Math.max(0, t)))
		}

		function i(e) {
			var a = l(),
				i = a._rgba = [];
			return e = e.toLowerCase(), u(o, function(t, r) {
				var n, s = r.re.exec(e),
					o = s && r.parse(s),
					l = r.space || "rgba";
				if(o) return n = a[l](o), a[c[l].cache] = n[c[l].cache], i = a._rgba = n._rgba, !1
			}), i.length ? ("0,0,0,0" === i.join() && t.extend(i, n.transparent), a) : n[e]
		}

		function r(t, e, a) {
			return 6 * (a = (a + 1) % 1) < 1 ? t + (e - t) * a * 6 : 2 * a < 1 ? e : 3 * a < 2 ? t + (e - t) * (2 / 3 - a) * 6 : t
		}
		var n, s = /^([\-+])=\s*(\d+\.?\d*)/,
			o = [{
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
			l = t.Color = function(e, a, i, r) {
				return new t.Color.fn.parse(e, a, i, r)
			},
			c = {
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
			d = {
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
		u(c, function(t, e) {
			e.cache = "_" + t, e.props.alpha = {
				idx: 3,
				type: "percent",
				def: 1
			}
		}), l.fn = t.extend(l.prototype, {
			parse: function(r, s, o, d) {
				if(r === e) return this._rgba = [null, null, null, null], this;
				(r.jquery || r.nodeType) && (r = t(r).css(s), s = e);
				var h = this,
					p = t.type(r),
					f = this._rgba = [];
				return s !== e && (r = [r, s, o, d], p = "array"), "string" === p ? this.parse(i(r) || n._default) : "array" === p ? (u(c.rgba.props, function(t, e) {
					f[e.idx] = a(r[e.idx], e)
				}), this) : "object" === p ? (u(c, r instanceof l ? function(t, e) {
					r[e.cache] && (h[e.cache] = r[e.cache].slice())
				} : function(e, i) {
					var n = i.cache;
					u(i.props, function(t, e) {
						if(!h[n] && i.to) {
							if("alpha" === t || null == r[t]) return;
							h[n] = i.to(h._rgba)
						}
						h[n][e.idx] = a(r[t], e, !0)
					}), h[n] && t.inArray(null, h[n].slice(0, 3)) < 0 && (h[n][3] = 1, i.from && (h._rgba = i.from(h[n])))
				}), this) : void 0
			},
			is: function(t) {
				var e = l(t),
					a = !0,
					i = this;
				return u(c, function(t, r) {
					var n, s = e[r.cache];
					return s && (n = i[r.cache] || r.to && r.to(i._rgba) || [], u(r.props, function(t, e) {
						if(null != s[e.idx]) return a = s[e.idx] === n[e.idx]
					})), a
				}), a
			},
			_space: function() {
				var t = [],
					e = this;
				return u(c, function(a, i) {
					e[i.cache] && t.push(a)
				}), t.pop()
			},
			transition: function(t, e) {
				var i = l(t),
					r = i._space(),
					n = c[r],
					s = 0 === this.alpha() ? l("transparent") : this,
					o = s[n.cache] || n.to(s._rgba),
					h = o.slice();
				return i = i[n.cache], u(n.props, function(t, r) {
					var n = r.idx,
						s = o[n],
						l = i[n],
						c = d[r.type] || {};
					null !== l && (null === s ? h[n] = l : (c.mod && (l - s > c.mod / 2 ? s += c.mod : s - l > c.mod / 2 && (s -= c.mod)), h[n] = a((l - s) * e + s, r)))
				}), this[r](h)
			},
			blend: function(e) {
				if(1 === this._rgba[3]) return this;
				var a = this._rgba.slice(),
					i = a.pop(),
					r = l(e)._rgba;
				return l(t.map(a, function(t, e) {
					return(1 - i) * r[e] + i * t
				}))
			},
			toRgbaString: function() {
				var e = "rgba(",
					a = t.map(this._rgba, function(t, e) {
						return null != t ? t : e > 2 ? 1 : 0
					});
				return 1 === a[3] && (a.pop(), e = "rgb("), e + a.join() + ")"
			},
			toHslaString: function() {
				var e = "hsla(",
					a = t.map(this.hsla(), function(t, e) {
						return null == t && (t = e > 2 ? 1 : 0), e && e < 3 && (t = Math.round(100 * t) + "%"), t
					});
				return 1 === a[3] && (a.pop(), e = "hsl("), e + a.join() + ")"
			},
			toHexString: function(e) {
				var a = this._rgba.slice(),
					i = a.pop();
				return e && a.push(~~(255 * i)), "#" + t.map(a, function(t) {
					return("0" + (t || 0).toString(16)).substr(-2)
				}).join("")
			},
			toString: function() {
				return 0 === this._rgba[3] ? "transparent" : this.toRgbaString()
			}
		}), l.fn.parse.prototype = l.fn, c.hsla.to = function(t) {
			if(null == t[0] || null == t[1] || null == t[2]) return [null, null, null, t[3]];
			var e, a, i = t[0] / 255,
				r = t[1] / 255,
				n = t[2] / 255,
				s = t[3],
				o = Math.max(i, r, n),
				l = Math.min(i, r, n),
				c = o - l,
				d = o + l,
				u = .5 * d;
			return e = l === o ? 0 : i === o ? 60 * (r - n) / c + 360 : r === o ? 60 * (n - i) / c + 120 : 60 * (i - r) / c + 240, a = 0 === c ? 0 : u <= .5 ? c / d : c / (2 - d), [Math.round(e) % 360, a, u, null == s ? 1 : s]
		}, c.hsla.from = function(t) {
			if(null == t[0] || null == t[1] || null == t[2]) return [null, null, null, t[3]];
			var e = t[0] / 360,
				a = t[1],
				i = t[2],
				n = t[3],
				s = i <= .5 ? i * (1 + a) : i + a - i * a,
				o = 2 * i - s;
			return [Math.round(255 * r(o, s, e + 1 / 3)), Math.round(255 * r(o, s, e)), Math.round(255 * r(o, s, e - 1 / 3)), n]
		}, u(c, function(i, r) {
			var n = r.props,
				o = r.cache,
				c = r.to,
				d = r.from;
			l.fn[i] = function(i) {
				if(c && !this[o] && (this[o] = c(this._rgba)), i === e) return this[o].slice();
				var r, s = t.type(i),
					h = "array" === s || "object" === s ? i : arguments,
					p = this[o].slice();
				return u(n, function(t, e) {
					var i = h["object" === s ? t : e.idx];
					null == i && (i = p[e.idx]), p[e.idx] = a(i, e)
				}), d ? ((r = l(d(p)))[o] = p, r) : l(p)
			}, u(n, function(e, a) {
				l.fn[e] || (l.fn[e] = function(r) {
					var n, o, l, c, d = t.type(r);
					return o = (n = this[c = "alpha" === e ? this._hsla ? "hsla" : "rgba" : i]())[a.idx], "undefined" === d ? o : ("function" === d && (r = r.call(this, o), d = t.type(r)), null == r && a.empty ? this : ("string" === d && (l = s.exec(r)) && (r = o + parseFloat(l[2]) * ("+" === l[1] ? 1 : -1)), n[a.idx] = r, this[c](n)))
				})
			})
		}), l.hook = function(e) {
			var a = e.split(" ");
			u(a, function(e, a) {
				t.cssHooks[a] = {
					set: function(e, r) {
						var n;
						"transparent" === r || "string" === t.type(r) && !(n = i(r)) || (r = (r = l(n || r)).toRgbaString()), e.style[a] = r
					}
				}, t.fx.step[a] = function(e) {
					e.colorInit || (e.start = l(e.elem, a), e.end = l(e.end), e.colorInit = !0), t.cssHooks[a].set(e.elem, e.start.transition(e.end, e.pos))
				}
			})
		}, l.hook("backgroundColor borderBottomColor borderLeftColor borderRightColor borderTopColor color columnRuleColor outlineColor textDecorationColor textEmphasisColor"), t.cssHooks.borderColor = {
			expand: function(t) {
				var e = {};
				return u(["Top", "Right", "Bottom", "Left"], function(a, i) {
					e["border" + i + "Color"] = t
				}), e
			}
		}, n = t.Color.names = {
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
	}), $(function() {
		var t = $("#slides").find("li"),
			e = $("#bannerProgress"),
			a = t.size() - 1,
			i = 0,
			r = 0,
			n = 0,
			s = 5e3;
		$("#full-screen-slider").css("background-color", t.eq(0).attr("data-id")), t.eq(0).find(".txt-banner").css("color", t.eq(0).attr("data-txt")), t.eq(0).siblings("li").css("display", "none");
		var o = '<div id="sCon"><ul id="pagination">',
			l = "",
			c = "</ul></div>";
		! function() {
			for(var t = 0; t <= a; t++) l += '<li><a href="javascript:;">' + (t + 1) + "</a></li>";
			$("#slides").after(o + l + c)
		}();
		var d = $("#pagination").find("li");

		function u() {
			e.find("div").animate({
				width: e.width()
			}, s, function() {
				$(this).attr("style", "")
			})
		}

		function h() {
			var e = i + 1;
			1 == r || (i < a ? (t.eq(i).css("z-index", "900"), t.eq(e).css({
				"z-index": "800"
			}).show(), d.eq(e).addClass("current").siblings("li").removeClass("current"), t.eq(i).css("display", "none").find(".txt-banner").css("color", t.eq(e).attr("data-txt")), t.eq(e).fadeIn(1e3), $("#full-screen-slider").animate({
				"background-color": t.eq(e).attr("data-id")
			}, 1e3), t.eq(e).find(".txt-banner").animate({
				color: t.eq(e).attr("data-txt")
			}, 1e3), i += 1) : (e = 0, t.eq(i).css("z-index", "900"), t.eq(e).stop(!0, !0).css({
				"z-index": "800"
			}).show(), t.eq(i).css("display", "none").find(".txt-banner").css("color", t.eq(e).attr("data-txt")), t.eq(0).fadeIn(1e3), $("#full-screen-slider").animate({
				"background-color": t.eq(0).attr("data-id")
			}, 1e3), t.eq(0).find(".txt-banner").animate({
				color: t.eq(0).attr("data-txt")
			}, 1e3), d.eq(e).addClass("current").siblings("li").removeClass("current"), i = 0), u(), n = setTimeout(h, s))
		}
		d.eq(0).addClass("current"), d.on("click", function() {
			var a = $(this).index();
			t.eq(i).css("z-index", "900"), t.eq(a).css({
				"z-index": "800"
			}).show(), d.eq(a).addClass("current").siblings("li").removeClass("current"), t.eq(i).css("display", "none").find(".txt-banner").css("color", t.eq(a).attr("data-txt")), t.eq(a).fadeIn(1e3), i = a, $("#full-screen-slider").animate({
				"background-color": t.eq(a).attr("data-id")
			}, 1e3), t.eq(a).find(".txt-banner").animate({
				color: t.eq(a).attr("data-txt")
			}, 1e3), e.find("div").css("width", "0")
		}), $("#pagination li,#slides li").hover(function() {
			r = 1, clearTimeout(n), e.find("div").stop()
		}, function() {
			r = 0, n = setTimeout(h, 5e3), u()
		}), u(), n = setTimeout(h, 5e3), $(".banner-coininfo").each(function(t) {
			$(this).text(function(t, e) {
				if(2 * t.length <= e) return t;
				for(var a = 0, i = "", r = 0; r < t.length; r++)
					if(i += t.charAt(r), t.charCodeAt(r) > 128) {
						if((a += 2) >= e) return i.substring(0, i.length - 1) + "..."
					} else if((a += 1) >= e) return i.substring(0, i.length - 2) + "...";
				return i
			}($(this).text(), 128))
		}), 0 == $.cookie("total_fund") && ($("#showHideBtn").addClass("view-hide").removeClass("view-show"), $(".total-num").hide(), $(".hide-num").text("******").show()), 0 == parseFloat($("#assetBTC").text()) && $(".z-hide").hide(), $("#showHideBtn").toggle(function() {
			$(this).addClass("view-hide").removeClass("view-show"), $(".total-num").hide(), $(".hide-num").text("******").show(), $.cookie("total_fund", 0, {
				expires: 365,
				path: "/"
			})
		}, function() {
			$(this).addClass("view-show").removeClass("view-hide"), $(".z-hide").is(":visible") ? $(".total-num").show() : $(".cny-num").show(), $(".hide-num").hide(), $.cookie("total_fund", 1, {
				expires: 365,
				path: "/"
			})
		})
	});