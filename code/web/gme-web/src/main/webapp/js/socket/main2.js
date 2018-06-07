var g_ask_list = null,
	g_bid_list = null,
	g_trade_list = null,
	g_fiat = "",
	g_last_fiat = "",
	g_latest_price = get_element("orderbook_last_rate").innerHTML,
	g_left_side_price = [];

function innerOd(e, t) {
	var a = 5;
	if(1 == ordersCo && (a = 10), t && (a = 31), g_ask_list && (0 == e || 1 == e)) {
		var i = build_order_table(g_ask_list, 1, a);
		"" != i && (get_element("ul-ask-list").innerHTML = i)
	}
	if(g_bid_list && (0 == e || 2 == e)) {
		var r = build_order_table(g_bid_list, 0, a);
		"" != r && (get_element("ul-bid-list").innerHTML = r)
	}
}

function get_global_fiat_rate(e, t) {
	return e = e.toUpperCase(), fiat_rate = 1, "BTC" == e ? "CNY" == t ? fiat_rate = global_btc_cny_rate : "KRW" == t ? fiat_rate = global_btc_krw_rate : "USD" == t && (fiat_rate = global_btc_usd_rate) : "ETH" == e ? "CNY" == t ? fiat_rate = global_eth_cny_rate : "KRW" == t ? fiat_rate = global_eth_krw_rate : "USD" == t && (fiat_rate = global_eth_usd_rate) : "USDT" == e ? "CNY" == t ? fiat_rate = global_usdt_cny_rate : "KRW" == t && (fiat_rate = global_usdt_krw_rate) : "QTUM" == e && ("CNY" == t ? fiat_rate = global_qtum_cny_rate : "KRW" == t ? fiat_rate = global_qtum_krw_rate : "USD" == t && (fiat_rate = global_qtum_usd_rate)), fiat_rate
}

function get_currency_unitSymbol(e) {
	return e = e.toUpperCase(), unitSymbol = "$", "BTC" == e ? unitSymbol = "฿" : "ETH" == e ? unitSymbol = "E" : "USDT" == e ? unitSymbol = "$" : "QTUM" == e && (unitSymbol = "Q"), unitSymbol
}

function rebuild_orderbook_trade_list(e) {
	g_last_fiat = g_fiat, g_fiat = e;
	var t = trade_global.symbol.split("_"),
		a = t[0].toUpperCase(),
		i = t[1].toUpperCase();
	if(change_fiat_tags(e, a, i), g_ask_list && g_ask_list[0]) {
		var r = build_order_table(g_ask_list, 1, 31);
		"" != r && (get_element("ul-ask-list").innerHTML = r)
	}
	if(g_bid_list && g_bid_list[0]) {
		var l = build_order_table(g_bid_list, 0, 31);
		"" != l && (get_element("ul-bid-list").innerHTML = l)
	}
	if(g_trade_list && g_trade_list[0]) {
		var _ = build_trade_history_table(g_trade_list);
		"" != _ && (get_element("ul-trade-list").innerHTML = _)
	}
	var s = 1,
		o = $("#ask_rate"),
		n = $("#bid_rate"),
		d = $("#ul-ask-list").find("li"),
		c = $("#ul-bid-list").find("li"),
		p = o.val(),
		g = n.val(),
		b = .5 * (parseFloat(d.eq(0).find(".price").html()) + parseFloat(c.eq(0).find(".price").html()));
	parseFloat(p), parseFloat(g);
	0 == b && (b = 1e-7), g_last_fiat == g_fiat ? (o.val(d.eq(0).find(".price").html()), n.val(c.eq(0).find(".price").html())) : (s = get_global_fiat_rate(i, "" == g_fiat ? g_last_fiat : g_fiat), "" == g_fiat ? (p /= s, g /= s) : (p *= s, g *= s), rate_decimals = p >= 10 ? 2 : p >= 1 ? 3 : p >= .1 ? 4 : p >= .01 ? 5 : p >= .001 ? 6 : 7, p = p.toFixed(rate_decimals), g = g.toFixed(rate_decimals), o.val(p), n.val(g)), _page.obj.on_input_bid_rate(), _page.obj.recalc_fee("bid"), _page.obj.on_input_ask_rate(), _page.obj.recalc_fee("ask")
}

function build_trade_history_table(e) {
	if(!e || !e[0]) return "";
	var t = parseInt($("#ul-trade-list").height() / 24) + 1,
		a = 1;
	e.length > 0 && (a = e[0][1]);
	var i, r = 3,
		l = a * (i = get_global_fiat_rate(trade_global.symbol.split("_")[1].toUpperCase(), g_fiat));
	r = l >= 10 ? 2 : l >= 1 ? 3 : l >= .1 ? 4 : l >= .01 ? 5 : l >= .001 ? 6 : 7;
	for(var _ = "", s = 0; s < e.length; s++)
		if(s <= t) {
			var o, n = e[s];
			if(n.length < 7) continue;
			o = "sell" == n[5] ? "down" : "up";
			var d = new Date(1e3 * n[4]),
				c = d.getHours(),
				p = "0" + d.getMinutes(),
				g = "0" + d.getSeconds(),
				b = c + ":" + p.substr(-2) + ":" + g.substr(-2),
				u = n[2],
				f = n[3],
				m = n[1];
			"" != g_fiat && (m *= i, f = (f *= i).toFixed(2), m = m.toFixed(r)), _ += "<li title=" + n[5] + ' data-id="list-item" tid="' + n[6] + '" class="' + o + '">', _ += '<span class="time" data-id="time">' + b + "</span>", _ += '<span class="price" data-id="price">' + m + "</span>", _ += '<span class="amount" data-id="amount">' + u + "</span>", _ += '<span class="total" data-id="total">' + f + "</span>", _ += "</li>"
		}
	return _
}

function get_bid_or_ask_decimals(e, t, a) {
	var i = t || "";
	a = a || !1;
	"" == i && (i = trade_global.symbol.split("_")[1].toUpperCase());
	var r = e,
		l = 1,
		_ = typeof r;
	"object" == _ && r.length > 0 && (l = r[0][0]), "string" != _ && "number" != _ || (l = r);
	var s, o = g_fiat;
	a && "" == o && (o = is_cn ? "CNY" : is_kr ? "KRW" : "USD");
	var n = l * (s = get_global_fiat_rate(i, o));
	return {
		unitSymbol: get_currency_unitSymbol(i),
		fiat_rate_decimals: n >= 10 ? 2 : n >= 1 ? 3 : n >= .1 ? 4 : n >= .01 ? 5 : n >= .001 ? 6 : 7,
		fiat_rate: s
	}
}

function get_orderbook_vol_sum(e, t, a, i, r) {
	var l = 0;
	r <= 0 && (r = 1e-8);
	for(var _ = 0; _ < e.length && !(_ > a); _++) {
		e[_];
		l += t ? parseFloat(e[_][1]) : parseFloat(e[_][2])
	}
	return t ? i || (l *= r) : i && (l /= r), l
}

function get_ask_bid_list_vol_sum(e, t, a) {
	var i = 0,
		r = 0;
	return g_ask_list && (i = get_orderbook_vol_sum(g_ask_list, 1, e, t, a)), g_bid_list && (r = get_orderbook_vol_sum(g_bid_list, 0, e, t, a)), r > i ? r : i
}

function build_order_table(e, t, a) {
	if(!e || !e[0]) return "";
	var i = get_bid_or_ask_decimals(e),
		r = i.fiat_rate,
		l = i.fiat_rate_decimals;
	d = t ? 1 : 0;
	for(var _, s = 0, o = 0; o < e.length && !(o > a); o++) {
		var n = {};
		e[o];
		t ? s < parseFloat(e[o][1]) && (s = parseFloat(e[o][1])) : s < parseFloat(e[o][2]) && (s = parseFloat(e[o][2]))
	}
	_ = get_ask_bid_list_vol_sum(a, t, parseFloat(e[0][0]));
	var d, c = "",
		p = 0,
		g = 0,
		b = 0;
	for(o = 0; o < e.length; o++) {
		if(0 != +(n = e[o])[1]) {
			if(++b > a) break;
			p += parseFloat(n[1]), g += parseFloat(n[2]), rate = n[0];
			var u = n[1],
				f = n[2],
				m = n[0],
				k = g;
			"" != g_fiat && (f *= r, m *= r, k = (k *= r).toFixed(2), f = f.toFixed(2), m = m.toFixed(l)), v = t ? p : g;
			var h = Math.pow(v, .5) / Math.pow(_, .5) * 55;
			if(h < 1 && (h = 1), !(n.rate <= 0 || n.symbol_l <= 0 || n.symbol_r <= 0)) {
				var y = "onclick='set_price(" + d.toString() + "," + m + "," + p + "," + k + ")'";
				n.mine ? c += "<li  " + y + " class='orderline_mine'> " : c += "<li  " + y + ">", c += t ? '\t\t<span data-id= "price"  class= "price right-align" >' + m + '</span>   <span data-id= "volume" class= "volume right-align"  >' + u + '</span>  <span data-id= "total" class= "right-align total" >' + f + '</span>  <span data-id= "rect" class= "right-align rect orange" style="width: ' + h + 'px;"></span> ' : '<span data-id= "price"  class= "price right-align" >' + m + '</span>  <span data-id= "volume" class= "right-align volume"  >' + u + '</span>   <span data-id= "total" class= "right-align total" >' + f + '</span>   <span data-id= "rect" class= "right-align rect fenlv" style="width: ' + h + 'px;"></span>', c += "</li>"
			}
		}
	}
	return c
}

function latest_price_ischange(e, t, a) {
	var i = a || g_ask_list;
	if(!i && !(i = g_bid_list)) return !1;
	var r = get_bid_or_ask_decimals(i),
		l = r.fiat_rate,
		_ = r.fiat_rate_decimals,
		s = get_element("orderbook_last_rate");
	"string" == typeof e && (e = parseFloat(e));
	var o = (e * l).toFixed(_);
	return s.innerHTML = o, setPageTitle(o), e != t && (s.className = e > t ? "red" : "green"), !0
}

function change_fiat_tags(e, t, a) {
	var i = "" == e ? a.toUpperCase() : e.toUpperCase();
	$(".currb-unit").text(i);
	var r = a;
	if("" == e) get_element("orderbook_last_rate").innerHTML = g_latest_price, setPageTitle(g_latest_price), $(".ask-bid-price").find("span").html(a + "/" + t), $("#orderUnitSymbol").show(), $("#cnySymbol").hide();
	else {
		var l = get_element("orderbook_last_rate").innerHTML;
		latest_price_ischange(l, l), $(".ask-bid-price").find("span").html('<span class="red">' + e + "</span>/" + t), $("#orderUnitSymbol").hide(), $("#cnySymbol").show(), r = '<span class="red">' + e + "</span>"
	}
	$("#ask_total_label").find(".currb-unit").html(r), $("#bid_total_label").find(".currb-unit").html(r), build_left_side(e, a)
}

function build_left_side(e, t) {
	var a = ["btc", "eth", "usdt", "qtum", "custom"];
	if("" != (e = e || g_fiat))
		for(var i in a) {
			g_left_side_price[a[i]] = [], d = [], c = $("#" + a[i] + "Tbody").find("tr");
			for(var r = 0; r < c.length; r++) {
				p = c.eq(r).attr("id");
				var l = c.eq(r).find(".left-price"),
					_ = l.html();
				d[p] = _;
				var s = parseFloat(_);
				if("custom" == a[i]) t = p.split("_")[2];
				else t = a[i];
				var o = get_bid_or_ask_decimals(s, t.toUpperCase()),
					n = o.fiat_rate_decimals;
				s *= o.fiat_rate, l.text(s.toFixed(n))
			}
			$("#marketlist_btc").find(".left-price-type").text("(" + e + ")"), $("#marketlist_eth").find(".left-price-type").text("(" + e + ")"), $("#marketlist_usdt").find(".left-price-type").text("(" + e + ")"), $("#marketlist_qtum").find(".left-price-type").text("(" + e + ")"), g_left_side_price[a[i]] = d
		} else {
			if(void 0 === g_left_side_price.btc) return;
			for(var i in a)
				if(g_left_side_price[a[i]]) {
					var d = g_left_side_price[a[i]],
						c = $("#" + a[i] + "Tbody").find("tr");
					for(r = 0; r < c.length; r++) {
						var p = c.eq(r).attr("id");
						c.eq(r).find(".left-price").text(d[p])
					}
				}
			$("#marketlist_btc").find(".left-price-type").text("(BTC)"), $("#marketlist_eth").find(".left-price-type").text("(ETH)"), $("#marketlist_usdt").find(".left-price-type").text("(USDT)"), $("#marketlist_qtum").find(".left-price-type").text("(QTUM)")
		}
}

function merge_depth(e, t, a) {
	var i = [],
		r = {
			a: 0,
			b: 0
		};
	if(a)
		for(; r.a < e.length || r.b < t.length;) void 0 === e[r.a] ? i.push(t[r.b++]) : void 0 === t[r.b] ? i.push(e[r.a++]) : parseFloat(e[r.a][0]) > parseFloat(t[r.b][0]) ? i.push(t[r.b++]) : e[r.a][0] == t[r.b][0] ? (parseFloat(t[r.b][1]) > 1e-8 ? i.push(t[r.b++]) : r.b++, r.a++) : i.push(e[r.a++]);
	else
		for(; r.a < e.length || r.b < t.length;) void 0 === e[r.a] ? i.push(t[r.b++]) : void 0 === t[r.b] ? i.push(e[r.a++]) : parseFloat(e[r.a][0]) < parseFloat(t[r.b][0]) ? i.push(t[r.b++]) : e[r.a][0] == t[r.b][0] ? (parseFloat(t[r.b][1]) > 1e-8 ? i.push(t[r.b++]) : r.b++, r.a++) : i.push(e[r.a++]);
	return i
}
g_ask_list = datas_asks, g_bid_list = datas_bids, g_trade_list = datas_trades;
var market_name = trade_global.symbol.toUpperCase();

function get_rand_int(e) {
	return Math.floor(Math.random() * Math.floor(e))
}
var client_id = get_rand_int(1e7);

function socket_send_cmd(e, t, a) {
	a || (a = []);
	var i = {
		id: client_id,
		method: t,
		params: a
	};
	e.send(JSON.stringify(i))
}
var page_reloaded_time = Math.floor(Date.now() / 1e3),
	lockReconnect = !1,
	pollingLock = !1,
	connectTimes = 0;
reconnect = function(e, t) {
	t && (pollingLock = !1), lockReconnect || pollingLock || (lockReconnect = !0, connectTimes++, "undefined" != typeof reTimer && clearTimeout(reTimer), connectTimes < 4 ? reTimer = setTimeout(function() {
		start_websocket(wss_url), lockReconnect = !1
	}, 5e3) : (is_ie || (pollingData(e), pollingLock = !0), connectTimes = 0, lockReconnect = !1))
};
var wss_url = "wss://webws.gateio.io/v3/";

function start_websocket(e) {
	"undefined" != typeof pingtimer && clearTimeout(pingtimer);
	var t = new WebSocket(e + "?v=" + Math.floor(1e6 * Math.random()));
	t.onopen = function() {
		console.log("Connected"), socket_send_cmd(t, "server.ping"), global_precision_rate >= 9 ? socket_send_cmd(t, "depth.subscribe", [market_name, 30, "0"]) : socket_send_cmd(t, "depth.subscribe", [market_name, 30, "0.00000001"]), socket_send_cmd(t, "trades.subscribe", [market_name]), socket_send_cmd(t, "ticker.subscribe", [market_name, 86400]), "undefined" != typeof global_price_watch_markets && socket_send_cmd(t, "price.subscribe", global_price_watch_markets), !is_ie && socket_send_cmd(t, "kline.subscribe", [market_name, 1800])
	}, t.onerror = function(e) {
		console.log("ws Error "), reconnect(currLineMode), "undefined" != typeof pingtimer && clearTimeout(pingtimer)
	}, t.onclose = function(e) {
		console.log("ws Closed "), reconnect(currLineMode), "undefined" != typeof pingtimer && clearTimeout(pingtimer)
	}, t.onmessage = function(e) {
		if($.cookie("socketUptTime", (new Date).getTime(), {
				expires: 20 / 24 / 60 / 60
			}), !is_ie && currLineMode.toString() != lineModeStore.toString()) {
			lineModeStore = currLineMode;
			var a = currLineMode[1],
				i = currLineMode[0];
			a > 3 && a < 6 ? i = 1 == i ? 60 : 480 : 6 == a && (i = 1440), socket_send_cmd(t, "kline.subscribe", [market_name, 60 * i]), history.pushState({}, "", "?k=" + i)
		}
		var r = JSON.parse(e.data);
		if("pong" != r.result) switch(r.method) {
			case "depth.update":
				var l = r.params[0],
					_ = r.params[1],
					s = _.asks,
					o = _.bids;
				if(s && s[0])
					for(var n = 0; n < s.length; n++) s[n][2] = s[n][0] * s[n][1], s[n][0] = Number(s[n][0]).toFixed(global_precision_rate), s[n][1] = Number(s[n][1]).toFixed(global_precision_vol), s[n][2] = Number(s[n][2]).toFixed(global_precision_total);
				if(o && o[0])
					for(n = 0; n < o.length; n++) o[n][2] = o[n][0] * o[n][1], o[n][0] = Number(o[n][0]).toFixed(global_precision_rate), o[n][1] = Number(o[n][1]).toFixed(global_precision_vol), o[n][2] = Number(o[n][2]).toFixed(global_precision_total);
				if(s && s[0]) {
					var d = build_order_table(g_ask_list = !g_ask_list || l ? s : merge_depth(g_ask_list, s, 1), 1, 31);
					"" != d && (get_element("ul-ask-list").innerHTML = d)
				}
				if(o && o[0]) {
					var c = build_order_table(g_bid_list = !g_bid_list || l ? o : merge_depth(g_bid_list, o, 0), 0, 31);
					"" != c && (get_element("ul-bid-list").innerHTML = c)
				}
				break;
			case "trades.update":
				var p = r.params[1],
					g = [];
				for(n = 0; n < p.length; n++) {
					var b = (R = p[n]).price,
						u = R.amount,
						f = b * u;
					b = Number(b).toFixed(global_precision_rate), u = Number(u).toFixed(global_precision_vol), f = Number(f).toFixed(global_precision_total), g.push(["", b, u, f, Math.floor(R.time), R.type, R.id])
				}
				var m = g;
				if(m) {
					var k = $("#ul-trade-list"),
						h = k.find("li").length,
						v = k.data("tListData"),
						y = "";
					if(g_trade_list = m, null != v && h < 99) {
						for(var T = [], F = [], M = 0; M < v.length; M++) T[v[M]] = !0;
						for(M = 0; M < m.length; M++) T[m[M]] || F.push(m[M]);
						"" != (y = build_trade_history_table(F)) && k.prepend(y)
					} else "" != (y = build_trade_history_table(m)) && k.html(y);
					k.data("tListData", m)
				}
				break;
			case "ticker.update":
				var w = r.params[1],
					x = w.last,
					S = w.high,
					L = w.low,
					C = r.params[0].toLowerCase(),
					U = C.split("_")[1],
					H = 0;
				g_latest_price = x, w.change && (H = w.change), change_price_percent([
					[x, H, "market_" + C + "_" + U, U]
				]);
				var N = Number(w.baseVolume).toFixed(2);
				is_cn ? N > 1e8 ? N = (N / 1e8).toFixed(2) + "亿" : N > 1e4 && (N = (N / 1e4).toFixed(2) + "万") : N > 1e6 ? N = (N / 1e6).toFixed(2) + "M" : N > 1e3 && (N = (N / 1e3).toFixed(2) + "K"), get_element("ticker_vol_b").innerHTML = N, get_element("tHigh").innerHTML = S, get_element("tLow").innerHTML = L;
				break;
			case "price.update":
				if(Date.now() / 1e3 - page_reloaded_time < 5) break;
				var D = r.params[0].toLowerCase(),
					q = D.split("_")[1],
					R = r.params[1],
					K = R.price,
					W = R.change;
				change_price_percent([
					[K, W, "market_" + D + "_" + q, q]
				]);
				break;
			case "kline.update":
				websocketData = r.params[0], addNewData(websocketData)
		} else pingtimer = setTimeout(function() {
			socket_send_cmd(t, "server.ping")
		}, 1e4)
	}
}
lineModeStore = currLineMode = [30, 3], start_websocket(wss_url);