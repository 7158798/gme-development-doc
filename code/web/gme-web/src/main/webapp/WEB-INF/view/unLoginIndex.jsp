<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Gate.io - The Gate of Blockchain Assets Exchange</title>
		<meta name="description" content="网址是 Gate.io， 是一个区块链数字资产交易平台，支持比特币Bitcoin, 以太坊, Ethereum,莱特币, Litecoin，Qtum 等币种交易，其特点是快捷，安全。 ">
		<meta name="keywords" content="比特币, bitcoin, BTC, Ethereum, 以太坊, litecoin, LTC, ETC, Qtum, 代币, ICO, 交易平台，交易网站，比特币交易，比特币兑换，比特币市场 ">
		<meta name="format-detection" content="telephone=no">
		<!--[if lte IE 9]><script type="text/javascript">location.href = '/update.html';</script><![endif]-->
		<link href="/css/style.css" rel="stylesheet" type="text/css">
		<style>
			.icon-48,
			.icon-32,
			.icon-16 {
				background-image: url("../yyctjys/images/coins48.png")
			}
		</style>
		<link href="/css/coins_16.css" rel="stylesheet" type="text/css">
		<link href="/css/coins_32.css" rel="stylesheet" type="text/css">
		<link href="/css/coins_48.css" rel="stylesheet" type="text/css">
		<link href="/css/marketlist.css" rel="stylesheet" type="text/css">
		<link href="/css/theme_dark.css" rel="stylesheet" type="text/css" id="darkStyle" disabled="disabled">

		<link href="https://gateio.io/favicon.ico" rel="shortcut icon">
		<link rel="apple-touch-icon" sizes="120x120" href="/images/apple-touch-icon-120x120.png" />
		<script>
			var g_lang = 'cn';
		</script>
		<script src="/js/jquery-1.8.2.min.js"></script>
		<script src="/js/jquery.common.tools.js"></script>
		<script>
            function login(){
                alert("a");
                var url = "/api/v1/user/userLogin.html";
                $.post(url, function(data) {
                    window.location.href="/loginIndex.html"
                },'json');
            }
		</script>
	</head>

	<body class="">
		<div class="content">



			<div id="full-screen-slider">
				<div id="bannerProgress">
					<div id="innerProg"></div>
				</div>
				<div class="l-box-con">
					<div class="login_box">
						<div class="step" id="login-reg" style="">
							<form name="login" id="loginform" method="post" action="/api/v1/user/userLogin.html">
								<b>登录</b>
								<!-- <input type="hidden" name="iprestriction" id="iprestriction" value='1'> -->
								<div class="username">
									<input name="email" id="nick" class="intxt" placeholder="用户名" type="text" onfocus="if(placeholder=='用户名'){ $.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}" onblur="if(placeholder==''){this.style.color='#aaa';placeholder='用户名'}">
								</div>
								<div class="password">
									<input name="password" id="pwd" class="intxt" placeholder="密码" type="password" autocomplete="new-password" onfocus="if(placeholder=='密码'){$.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}" onblur="if(placeholder==''){this.style.color='#aaa';placeholder='密码'}" onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }">
								</div>
								<div class="cap-code">
									<!--<i class="icon-code"><img src="/images/loginpas.png" /></i>-->
									<input name="captcha" id="captcha" class="intxt" placeholder="验证码" type="text" onfocus="if(placeholder=='验证码'){$.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}" onblur="if(placeholder==''){this.style.color='#aaa';placeholder='验证码'}" onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }" maxlength="8">
									<img id="loginCaptcha" src="https://gateio.io/captcha" alt="Captcha" title="看不清？换一张" onclick="document.getElementById('loginCaptcha').src = '/captcha?' + Math.random(); return false">
								</div>
								<div class="btn">
									<a href="javascript:login()" class="button button-flat-action">登录</a>
								</div>
								<div class="wj">
									<a href="https://gateio.io/resetpw" target="_blank">忘记密码?</a> &nbsp;&nbsp;&nbsp;
									<a class="im-new" href="https://gateio.io/login" target="_blank">新用户注册</a>
								</div>
							</form>
						</div>
					</div>

				</div>
				<ul id="slides">
					<li data-id="#972697" data-txt="#e3fdfb">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-qtum"></i>充值Qtum量子链赢取QTUM大奖</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">Qtum充值竞赛现正进行中！关注Qtum x86虚拟机，企业应用，闪电网络 - 转发Twitter分享Airdrop！</span>
									<div class="banner-btn clearfix">

										<span class="r-btn clearfix" onclick="window.location.href='/myaccount/deposit/QTUM'"><i class="icon-32 icon-32-qtum"></i><em>充值QTUM</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/QTUM_USDT'"><i class="icon-32 icon-32-usdt"></i><em>QTUM对USDT交易</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://twitter.com/gate_io'"><i class="icon-32 icon-32-gate"></i><em>转发Twitter</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://gateio.io/article/16451'"><i class="icon-32 icon-32-qtum"></i><em>大奖规则</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#962536" data-txt="#ffdede">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-usdt"></i>比特币，以太坊大涨大跌，法币如何上车？</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">gate.io 提供快捷C2C（点对点）交易，10分钟完成法币买卖USDT，不错过任何行情！</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='/c2c/usdt_cny'"><i class="icon-32 icon-32-usdt"></i><em>C2C交易(微信支付宝)</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/BTC_USDT'"><i class="icon-32 icon-32-btc"></i><em>买卖比特币</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/ETH_USDT'"><i class="icon-32 icon-32-eth"></i><em>买卖以太坊</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/article/16269'"><i class="icon-32 icon-32-usdt"></i><em>什么是USDT</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#113c5f" data-txt="#eee">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-gate"></i>gate.io全球加速 - 官方节点 gateio.io</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">gate.io全球分布，请选择速度最快的节点使用!</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='https://gateio.io'"><i class="icon-32 icon-32-gate"></i><em>主站</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://kr.gateio.io'"><i class="icon-32 icon-32-korea icon-flag"></i><em>韩国节点</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://us.gateio.io'"><i class="icon-32 icon-32-usa icon-flag"></i><em>美国节点</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://gateio.io'"><i class="icon-32 icon-32-japan icon-flag"></i><em>日本节点</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<!--
		<li class="imgli" data-id="#11232d" data-txt="#ffdede">
           <a target=_blank href='/article/16378'><img src="/images/ledu.jpg"></a>
        </li>
		-->

					<li data-id="#11232d" data-txt="#ffdede">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-bts"></i>BTS 比特股 上线交易</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">比特股（BitShares）是一个基于石墨烯区块链技术的去中心化金融服务综合平台。</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='/trade/BTS_BTC'"><i class="icon-32 icon-32-bts"></i><em>BTS/BTC交易</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/BTS_USDT'"><i class="icon-32 icon-32-bts"></i><em>BTS/USDT交易</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#009ab4" data-txt="#e3fdfb">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-nas"></i>星云链(Nebulas)交易开启</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">星云链(Nebulas)是由小蚁创始成员发起的区块链操作系统及搜索引擎。</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='/myaccount/deposit/NAS'"><i class="icon-32 icon-32-nas"></i><em>立即充值NAS</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/NAS_USDT'"><i class="icon-32 icon-32-usdt"></i><em>NAS对USDT交易</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/NAS_ETH'"><i class="icon-32 icon-32-eth"></i><em>NAS对ETH交易</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#11232d" data-txt="#ffdede">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-iota"></i>IOTA 埃欧塔 上线交易</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">IOTA是为物联网而设计，无手续费，实时微交易，专注于解决机器与机器交互的新型数字货币</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='/trade/IOTA_BTC'"><i class="icon-32 icon-32-iota"></i><em>IOTA/BTC交易</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='/trade/IOTA_USDT'"><i class="icon-32 icon-32-iota"></i><em>IOTA/USDT交易</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#257896" data-txt="#e6fffd">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60 add-coin-banner">
								<span class="banner-thin banner-font-42"><i class="icon-48 icon-48-fil"></i>IPFS上线交易</span>
								<div class="banner-s-font">
									<span class="banner-coininfo">星际文件系统 IPFS Filecoin 面向全球的、点对点的分布式版本文件系统</span>
									<div class="banner-btn clearfix">
										<span class="r-btn clearfix" onclick="window.location.href='/trade/FIL_USDT'"><i class="icon-32 icon-32-fil"></i><em>对USDT交易</em></span>
										<span class="r-btn clearfix" onclick="window.location.href='https://filecoin.io/'"><i class="icon-32 icon-32-fil"></i><em>官方网站</em></span>
									</div>
									<div class="bg-txt">gate.io</div>
									<div class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</div>
									<small></small>
								</div>
							</div>
						</div>
					</li>

					<li data-id="#867919" data-txt="#fffed3">
						<div class="l-box-con">
							<div class="txt-banner txt-top-60"><span class="banner-thin banner-m-font">上线优质区块链项目<br>为您提供最佳投资渠道...</span></div>
							<div class="banner-btn clearfix">
								<span class="r-btn clearfix" onclick="window.location.href='/trade/HSR_USDT'"><i class="icon-32 icon-32-hsr"></i><em>HShare交易</em></span>
								<span class="r-btn clearfix" onclick="window.location.href='/trade/NEO_USDT'"><i class="icon-32 icon-32-neo"></i><em>小蚁NEO交易</em></span>
								<span class="r-btn clearfix" onclick="window.location.href='/trade/INK_USDT'"><i class="icon-32 icon-32-ink"></i><em>墨链INK交易</em></span>
								<span class="r-btn clearfix" onclick="window.location.href='/trade/BOT_USDT'"><i class="icon-32 icon-32-bot"></i><em>菩提BOT交易</em></span>
							</div>
						</div>
					</li>

					<li data-id="#384e77" data-txt="#dbe8ff">
						<div class="l-box-con">
							<div class="txt-banner txt-logo">
								<img class="gate-logo" src="/images/gateio.svg" title="gate.io" alt="gate.io logo">
								<span class="banner-thin banner-m-font pull-left">大门交易平台<br>汇聚优质区块链资产</span>
							</div>
						</div>
					</li>

					<li data-id="#387760" data-txt="#e3fff5">
						<div class="l-box-con">
							<div class="txt-banner txt-middle"><span class="banner-thin banner-l-font">秒冲秒提，体验前所未有！</span></div>
						</div>
					</li>

					<li data-id="#542e63" data-txt="#f9ebff">
						<div class="l-box-con">
							<div class="txt-banner txt-top">
								<span class="banner-thin banner-m-font">独有地址共享技术，<br>再也不怕充错地址</span>
								<div class="banner-s-font">BTC, BCH, USDT 地址共享
									<span style="margin-left: 20px">ETH, ETC, Tokens 地址共享</span>
									<p class="bg-txt">gate.io</p>
									<p class="slogan-effect">gate.io Blockchain Assets Trading Platform. The Gate of Blockchain Assets Exchange</p>
									<small></small>
								</div>
							</div>
						</div>
					</li>
				</ul>
				<div class="area-btn-bg"></div>
			</div>

			<div class="left_con">
				<div class="tline_btns clearfix" id="marketlist_controller">
					<button id="usdt" class="tline_btn button btn_selected"><span>对USDT交易区</span></button>
					<button id="btc" class="tline_btn button "><span>对BTC交易区</span></button>
					<button id="eth" class="tline_btn button "><span>对ETH交易区</span></button>
					<button id="qtum" class="tline_btn button "><span>对QTUM交易区</span></button>
					<button id="limited" class="tline_btn button "><span>限时交易区</span></button>
					<button id="custom" class="tline_btn button "><span>我的自选区</span></button>
				</div>
				<div id="mkCon">
					<div id="sBar">
						<div class="bottom-notice">
							<ul>
								<li>
									<svg xmlns="http://www.w3.org/2000/svg" width="13" height="18" viewBox="0 -2.914 13 18">
										<path fill="#666" d="M9.126 5.273l-.88.782v.057c.73.795 1.178 1.884 1.178 3.083 0 1.2-.45 2.29-1.178 3.085v.06l.88.78c.915-1.02 1.476-2.4 1.476-3.925 0-1.523-.56-2.904-1.476-3.922zM0 6.84v4.712h2.356l3.534 3.534V3.306L2.356 6.84" />
										<path fill="#666" d="M10.98 3.625l-.883.782C11.15 5.725 11.78 7.387 11.78 9.2c0 1.814-.63 3.476-1.683 4.784l.882.782c1.234-1.52 1.977-3.457 1.977-5.57 0-2.112-.742-4.054-1.98-5.573v.002z" />
									</svg>
									<a class="n-box" href="gonggaoxiangqing.gonggaoxiangqing.jsp" target=_blank>公告：gate.io充值量子链(QTUM)赢取QTUM大奖活动公告</a>
									<a href="gonggao.gonggao.jsp" style="margin-left: 20px;color: #de5959">更多...</a>
								</li>
							</ul>
						</div>
						<div class="dataTables_wrapper">
							<div class="dataTables_filter search-p">
								<label><input type="search" id="fsBar" placeholder='搜索USDT交易区'></label>
							</div>
						</div>
					</div>
					<div id="marketMain">
						<div id="mianBox" class="USDT-box">
							<table id="listTable" class="marketlist dataTable">
								<thead>
									<tr>
										<th class="sortable"><b>币种对<span class=curr-base>USDT</span></b></th>
										<th class="sortable"><b>价格<span class=curr-base>USDT</span></b></th>
										<th class="sortable"><b>交易量<span class=curr-base>USDT</span></b></th>
										<th class="sortable"><b>总市值</b></th>
										<th class="sortable day-updn"><b>日涨跌</b></th>
										<th class="sorting_disabled price-flot"><b>价格趋势(3日)</b></th>
										<th class="sorting_disabled"></th>
										<th class="sorting_disabled"><i class="fav-icon" title="自选"></i></th>
									</tr>
								</thead>
								<tbody id="list_tbody">
									<tr id=eos_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/EOS_USDT" title="EOS"><span class="icon-32 icon-32-eos"></span><span class="name-con"><b><span class="curr_a">EOS</span></b> <span class="cname">EOS</span> </span>
											</a>
										</td>
										<td class="rate_up">$13.98<span style='color:#999'>/￥90.87</span></td>
										<td>$12,413,778</td>
										<td>$13,980,000,000</td>
										<td class="day-updn"><span class=red>+2.73 %</span></td>
										<td>
											<div class="price-chart" id="eos_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/EOS_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=btm_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/BTM_USDT" title="比原链"><span class="icon-32 icon-32-btm"></span><span class="name-con"><b><span class="curr_a">BTM</span></b> <span class="cname">比原链</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.7438<span style='color:#999'>/￥4.83</span></td>
										<td>$10,927,006</td>
										<td>$1,561,980,000</td>
										<td class="day-updn"><span class=red>+21.20 %</span></td>
										<td>
											<div class="price-chart" id="btm_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/BTM_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=eth_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/ETH_USDT" title="以太币"><span class="icon-32 icon-32-eth"></span><span class="name-con"><b><span class="curr_a">ETH</span></b> <span class="cname">以太币</span> </span>
											</a>
										</td>
										<td class="rate_up">$716.00<span style='color:#999'>/￥4654.00</span></td>
										<td>$9,664,807</td>
										<td>$67,938,734,000</td>
										<td class="day-updn"><span class=red>+1.29 %</span></td>
										<td>
											<div class="price-chart" id="eth_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/ETH_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=pst_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/PST_USDT" title="Primas"><span class="icon-32 icon-32-pst"></span><span class="name-con"><b><span class="curr_a">PST</span></b> <span class="cname">Primas</span> </span>
											</a>
										</td>
										<td class="rate_up">$1.12<span style='color:#999'>/￥7.28</span></td>
										<td>$7,589,121</td>
										<td>$111,700,000</td>
										<td class="day-updn"><span class=red>+10.82 %</span></td>
										<td>
											<div class="price-chart" id="pst_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/PST_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=skm_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/SKM_USDT" title="Skrumble"><span class="icon-32 icon-32-skm"></span><span class="name-con"><b><span class="curr_a">SKM</span></b> <span class="cname">Skrumble</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.1000<span style='color:#999'>/￥0.65</span></td>
										<td>$6,036,275</td>
										<td>$150,000,000</td>
										<td class="day-updn"><span class=red>+11.98 %</span></td>
										<td>
											<div class="price-chart" id="skm_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/SKM_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=trx_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/TRX_USDT" title="波场"><span class="icon-32 icon-32-trx"></span><span class="name-con"><b><span class="curr_a">TRX</span></b> <span class="cname">波场</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.0807<span style='color:#999'>/￥0.52</span></td>
										<td>$5,624,926</td>
										<td>$5,294,329,108</td>
										<td class="day-updn"><span class=red>+14.57 %</span></td>
										<td>
											<div class="price-chart" id="trx_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/TRX_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=ocn_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/OCN_USDT" title="OCOIN"><span class="icon-32 icon-32-ocn"></span><span class="name-con"><b><span class="curr_a">OCN</span></b> <span class="cname">OCOIN</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.0187<span style='color:#999'>/￥0.12</span></td>
										<td>$4,455,720</td>
										<td>$187,000,000</td>
										<td class="day-updn"><span class=red>+10.00 %</span></td>
										<td>
											<div class="price-chart" id="ocn_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/OCN_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=lym_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/LYM_USDT" title="Lympo"><span class="icon-32 icon-32-lym"></span><span class="name-con"><b><span class="curr_a">LYM</span></b> <span class="cname">Lympo</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.0941<span style='color:#999'>/￥0.61</span></td>
										<td>$4,211,714</td>
										<td>$94,100,000</td>
										<td class="day-updn"><span class=red>+4.09 %</span></td>
										<td>
											<div class="price-chart" id="lym_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/LYM_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=iht_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/IHT_USDT" title="云产币"><span class="icon-32 icon-32-iht"></span><span class="name-con"><b><span class="curr_a">IHT</span></b> <span class="cname">云产币</span> </span>
											</a>
										</td>
										<td class="rate_up">$0.2220<span style='color:#999'>/￥1.44</span></td>
										<td>$3,627,125</td>
										<td>$222,000,000</td>
										<td class="day-updn"><span class=red>+7.77 %</span></td>
										<td>
											<div class="price-chart" id="iht_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/IHT_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=bot_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/BOT_USDT" title="菩提"><span class="icon-32 icon-32-bot"></span><span class="name-con"><b><span class="curr_a">BOT</span></b> <span class="cname">菩提</span> </span>
											</a>
										</td>
										<td class="rate_down">$1.26<span style='color:#999'>/￥8.19</span></td>
										<td>$3,594,105</td>
										<td>$126,070,000</td>
										<td class="day-updn"><span class=green>-3.28 %</span></td>
										<td>
											<div class="price-chart" id="bot_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/BOT_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=btc_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/BTC_USDT" title="比特币"><span class="icon-32 icon-32-btc"></span><span class="name-con"><b><span class="curr_a">BTC</span></b> <span class="cname">比特币</span> </span>
											</a>
										</td>
										<td class="rate_up">$8517.24<span style='color:#999'>/￥55362.06</span></td>
										<td>$3,440,469</td>
										<td>$141,352,115,040</td>
										<td class="day-updn"><span class=red>+2.90 %</span></td>
										<td>
											<div class="price-chart" id="btc_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/BTC_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
									<tr id=ont_usdt>
										<td>
											<a class="coin-name " href="https://gateio.io/trade/ONT_USDT" title="本体"><span class="icon-32 icon-32-ont"></span><span class="name-con"><b><span class="curr_a">ONT</span></b> <span class="cname">本体</span> </span>
											</a>
										</td>
										<td class="rate_up">$8.19<span style='color:#999'>/￥53.24</span></td>
										<td>$3,312,557</td>
										<td>$8,185,000,000</td>
										<td class="day-updn"><span class=red>+10.61 %</span></td>
										<td>
											<div class="price-chart" id="ont_usdt_plot"></div>
										</td>
										<td>
											<a class="go-trade-btn r-btn" href="https://gateio.io/trade/ONT_USDT">去交易</a>
										</td>
										<td class="custom-option"><i class="add-fav"></i></td>
									</tr>
								</tbody>
							</table>
							<div class="load8 mload">
								<div class="loader">Loading</div><span>加载中...</span></div>
						</div>
					</div>
				</div>
			</div>
			<div class="advantage">
				<h1>Blockchain Assets Trading Platform</h1>
				<h2>Gate.io</h2>
				<img class="gate-logo" src="/images/gateio_h.svg" title="下载大图" alt="gate.io logo">
			</div>
		</div>

		<script>
			//force user to use https
 			// if ('http:' != document.location.protocol) { window.location = 'http://' + window.location.hostname +":8020"+ window.location.pathname; }

			//for footer
			var tier_next_progress = '';

			$("#usdtAll").text(toThousands(106665737));
			$("#btcAll").text(toThousands(621));
			$("#ltcAll").text(toThousands(2781));
			$("#ethAll").text(toThousands(28028));
			is_login = '' != '';
		</script>

		<script>
			USDT_fiat_rate = '6.50000000';
			BTC_fiat_rate = '55362.06';
			ETH_fiat_rate = '4654';
			QTUM_fiat_rate = '108.615';
			var daysLeftArr = '{"REM":17,"TOMO":24,"HUR":25,"INSTAR":17,"TFD":24,"ELEC":24,"LST":25,"HAV":25,"SHIP":24}';
			var data_expired = '';
		</script>
		<script src="/js/flot.js?0420"></script>
		<script src="/js/marketlist.js?v=1525864037"></script>

		<script src="/js/footer.js?v=0420"></script>

	</body>

</html>

<div class="hide">t:2.058ms</div>