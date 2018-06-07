<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录/注册 - Gate.io - The Gate of Blockchain Assets Exchange</title>
    <meta name="description" content="网址是 Gate.io， 是一个区块链数字资产交易平台，支持比特币Bitcoin, 以太坊, Ethereum,莱特币, Litecoin，Qtum 等币种交易，其特点是快捷，安全。 ">
    <meta name="keywords" content="比特币, bitcoin, BTC, Ethereum, 以太坊, litecoin, LTC, ETC, Qtum, 代币, ICO, 交易平台，交易网站，比特币交易，比特币兑换，比特币市场 ">
    <meta name="format-detection" content="telephone=no">
    <!--[if lte IE 9]><script type="text/javascript">location.href = '/update.html';</script><![endif]-->
    <link href="css/style.css?v=1526375818" rel="stylesheet" type="text/css">
    <style>.icon-48,.icon-32,.icon-16{background-image:url("/images/coins48.png?v=1526551416")}</style>
    <link href="css/coins_16.css?v=1526551416" rel="stylesheet" type="text/css">
    <link href="css/coins_32.css?v=1526551416" rel="stylesheet" type="text/css">
    <link href="css/coins_48.css?v=1526551416" rel="stylesheet" type="text/css">
                    
                                <link href="css/theme_dark.css?0517" rel="stylesheet" type="text/css" id="darkStyle" disabled="disabled">
                
                    
            <link href="/favicon.ico" rel="shortcut icon">
    <link rel="apple-touch-icon" sizes="120x120" href="/images/apple-touch-icon-120x120.png"/>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?0a1ead8031fdf1a7228954da1b158d36";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <script>var g_lang = 'cn';</script>
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/jquery.common.tools.js?v=0207"></script>
</head>
<body class="">
<div class="header clearfix">
    <div class="top-up">
        <div class="top-con">
            <ul class="topprice">
				<li> BTC/CNY : ￥ <span class="topnum">55309.65</span><i class="icon-arrow-up">&uarr;</i> </li>
                <li> ETH/CNY : ￥ <span class="topnum">4646.10</span><i class="icon-arrow-up">&uarr;</i> </li>
                <li> LTC/CNY : ￥ <span class="topnum">900.66</span><i class="icon-arrow-up">&uarr;</i> </li>
                <li> QTUM/CNY : ￥ <span class="topnum">108.35</span><i class="icon-arrow-up">&uarr;</i> </li>
            </ul>
            <div class="qqtel">
                <a class="ask_ans" href="https://twitter.com/gate_io" target="_blank">
                    <p><i class="tico" title="Twitter"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24"><path fill="#FFF" d="M267.998 248.95c-.882.39-1.83.653-2.825.77 1.016-.606 1.795-1.564 2.164-2.703-.952.56-2.007.966-3.127 1.186-.9-.95-2.177-1.545-3.594-1.545-2.722 0-4.926 2.19-4.926 4.888 0 .38.042.757.126 1.116-4.09-.205-7.72-2.152-10.148-5.106-.425.724-.67 1.563-.67 2.456 0 1.697.872 3.19 2.193 4.07-.806-.027-1.566-.246-2.23-.614v.064c0 2.368 1.7 4.34 3.95 4.792-.414.11-.848.17-1.297.17-.317 0-.625-.026-.925-.087.625 1.94 2.445 3.355 4.6 3.396-1.686 1.31-3.807 2.092-6.113 2.092-.398 0-.79-.025-1.175-.07 2.177 1.387 4.767 2.195 7.547 2.195 9.06 0 14.012-7.448 14.012-13.903 0-.213-.008-.423-.017-.63.96-.694 1.795-1.552 2.457-2.537h-.002z"/></svg></i></p>
                </a>
                <a class="ask_ans" href="https://t.me/gate_io" target="_blank">
                    <p><i class="tico" title="Telegram"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24"><path fill="#FFF" d="M266.38 246.07l-21.26 8.2c-1.45.58-1.442 1.39-.264 1.75l5.302 1.656 2.03 6.22c.246.68.124.95.84.95.55 0 .795-.25 1.103-.55l2.65-2.58 5.517 4.075c1.015.56 1.748.27 2-.94l3.62-17.062c.37-1.486-.567-2.16-1.538-1.72zm-15.39 11.226l11.95-7.54c.598-.363 1.145-.168.695.23l-10.233 9.233-.398 4.248-2.014-6.172z"/></svg></i></p>
                </a>
                <a class="ask_ans" href="javascript:ticketsRoute();">
                    <p><i>?</i>提交工单</p>
                </a>
            </div>
            <ul class="login_lan">
                <li class="top-links">
                    <a href="/mobileapp" target="_blank">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24"><path fill="#010101" d="M262 244h-12c-.83 0-1.5.672-1.5 1.5v21c0 .83.67 1.5 1.5 1.5h12c.83 0 1.5-.67 1.5-1.5v-21c0-.828-.67-1.5-1.5-1.5zm-8.625 1.5h5.25c.208 0 .375.168.375.375s-.167.375-.375.375h-5.25c-.208 0-.375-.168-.375-.375s.167-.375.375-.375zM256 267.25c-.62 0-1.125-.504-1.125-1.125S255.38 265 256 265s1.125.504 1.125 1.125-.504 1.125-1.125 1.125zm6-3h-12v-16.5h12v16.5z"></path></svg>
                        <span>手机APP</span>
                        <div class="add-dn-qr">
                            <h3>扫码下载gate.io APP</h3>
                            <img src="/images/app-code.png" alt="gate.io APP">
                        </div>
                    </a>
                </li>
                                    
                        <li class='toplogin user-info-con'>
                            <div id="topLoginBar">
                                <span class="lv-con"><a class="tier-level tier-icon" href="/article/16273" title="等级"></a></span>
                                <a id="nickName" href="/myaccount"><span>zuoyehengudan</span><i class="caret"></i></a>
                                <div class="tier-info" id="tierMenu">
                                    <ul>
                                        <span class="uccaret umc"></span>
                                        <li>
                                            <b>当前等级：</b>
                                            <span><strong class="tier-level tier-icon"></strong><br/>有效时间至<small> </small></span>
                                        </li>
                                        <li>
                                            <b>当前交易费折扣：</b>
                                            <span><strong></strong></span>
                                        </li>
                                        <li>
                                            <b>最近30天交易量：</b>
                                            <p><strong></strong> BTC 或
                                                <strong></strong> CNY</p>
                                        </li>
                                        <li>
                                            <b>账户总资产：</b>
                                            <p><strong></strong> BTC 或
                                                <strong></strong> CNY</p>
                                        </li>
                                        <li>
                                            <b>升级进度：</b>
                                            <span><strong>%</strong></span>
                                        </li>
                                        <li id="progrLi">
                                            <div id="proBar"></div>
                                        </li>
                                        <li>升级还需要 <strong></strong> BTC 或者
                                            <strong></strong> CNY 30天交易量
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <li class='toplogin user-log-out'><a href="/logout">退出</a></li>
                    
                                    <li class="lang-option">
                    <span>中文版</span><i class="caret"></i>
                    <div class="more-lan">
                        <a href="/lang/en">English</a>
						<a href="/lang/kr">한국어</a>
                    </div>
                </li>
            </ul>
            <ul id="theme">
                <span>主题:</span>
                <li id="dark" title="深色">深色</li>
                <li id="light" title="浅色">浅色</li>
            </ul>
        </div>
    </div>
    <div class="top-dn">
        <div class="logo">
            <a href="https://gate.io" target="_top">
                <![if !IE]><img src="/images/logo.svg" alt="gate.io LOGO"/><![endif]>
                <!--[if IE]><img src="/images/logo.png" alt="LOGO"/><![endif]-->
            </a>
        </div>

        <ul class="gateio-nav">
            <li class="">
                <a href="/">首页</a>
            </li>
			<li class="">
                <a href="/c2c/usdt_cny" class="tooltip" title="法币交易">C2C交易</a>
            </li>
			
            <li class="nav-trade-item ">
                <a href="/trade/BTC_USDT">币币交易<i class="caret"></i></a>
                <ul class="second-nav clearfix">
                    <li>
                        <a href="javascript:;">对BTC交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ADA_BTC'><span class="icon-16-ada icon-16"></span><strong>艾达币 ADA</strong></a></li>
<li><a href='/trade/AE_BTC'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a></li>
<li><a href='/trade/BAT_BTC'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a></li>
<li><a href='/trade/BCD_BTC'><span class="icon-16-bcd icon-16"></span><strong>比特币钻石 BCD</strong></a></li>
<li><a href='/trade/BCH_BTC'><span class="icon-16-bch icon-16"></span><strong>BCH(原BCC) BCH</strong></a></li>
<li><a href='/trade/BCX_BTC'><span class="icon-16-bcx icon-16"></span><strong>比特无限 BCX</strong></a></li>
<li><a href='/trade/BIFI_BTC'><span class="icon-16-bifi icon-16"></span><strong>BitcoinFile BIFI</strong></a></li>
<li><a href='/trade/BTF_BTC'><span class="icon-16-btf icon-16"></span><strong>比特信仰 BTF</strong></a></li>
<li><a href='/trade/BTG_BTC'><span class="icon-16-btg icon-16"></span><strong>BTG BTG</strong></a></li>
<li><a href='/trade/BTM_BTC'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a></li>
<li><a href='/trade/BTS_BTC'><span class="icon-16-bts icon-16"></span><strong>比特股 BTS</strong></a></li>
<li><a href='/trade/DASH_BTC'><span class="icon-16-dash icon-16"></span><strong>达世币 DASH</strong></a></li>
<li><a href='/trade/DBC_BTC'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a></li>
<li><a href='/trade/DDD_BTC'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a></li>
<li><a href='/trade/DOGE_BTC'><span class="icon-16-doge icon-16"></span><strong>狗狗币 DOGE</strong></a></li>
<li><a href='/trade/EOS_BTC'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a></li>
<li><a href='/trade/ETC_BTC'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a></li>
<li><a href='/trade/ETH_BTC'><span class="icon-16-eth icon-16"></span><strong>以太币 ETH</strong></a></li>
<li><a href='/trade/GAS_BTC'><span class="icon-16-gas icon-16"></span><strong>小蚁Gas GAS</strong></a></li>
<li><a href='/trade/GOD_BTC'><span class="icon-16-god icon-16"></span><strong>比特币上帝 GOD</strong></a></li>
<li><a href='/trade/GTC_BTC'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a></li>
<li><a href='/trade/GXS_BTC'><span class="icon-16-gxs icon-16"></span><strong>公信宝 GXS</strong></a></li>
<li><a href='/trade/HSR_BTC'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a></li>
<li><a href='/trade/INK_BTC'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a></li>
<li><a href='/trade/IOTA_BTC'><span class="icon-16-iota icon-16"></span><strong>IOTA IOTA</strong></a></li>
<li><a href='/trade/JNT_BTC'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a></li>
<li><a href='/trade/LEDU_BTC'><span class="icon-16-ledu icon-16"></span><strong>Education LEDU</strong></a></li>
<li><a href='/trade/LRC_BTC'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a></li>
<li><a href='/trade/LSK_BTC'><span class="icon-16-lsk icon-16"></span><strong>Lisk LSK</strong></a></li>
<li><a href='/trade/LTC_BTC'><span class="icon-16-ltc icon-16"></span><strong>莱特币 LTC</strong></a></li>
<li><a href='/trade/LYM_BTC'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a></li>
<li><a href='/trade/MDT_BTC'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a></li>
<li><a href='/trade/MOBI_BTC'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a></li>
<li><a href='/trade/NANO_BTC'><span class="icon-16-nano icon-16"></span><strong>Nano NANO</strong></a></li>
<li><a href='/trade/NAS_BTC'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a></li>
<li><a href='/trade/NEO_BTC'><span class="icon-16-neo icon-16"></span><strong>小蚁Neo NEO</strong></a></li>
<li><a href='/trade/OCN_BTC'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a></li>
<li><a href='/trade/OMG_BTC'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a></li>
<li><a href='/trade/PAY_BTC'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a></li>
<li><a href='/trade/POWR_BTC'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a></li>
<li><a href='/trade/QASH_BTC'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a></li>
<li><a href='/trade/QLC_BTC'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a></li>
<li><a href='/trade/QTUM_BTC'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a></li>
<li><a href='/trade/RUFF_BTC'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a></li>
<li><a href='/trade/SBTC_BTC'><span class="icon-16-sbtc icon-16"></span><strong>超级比特币 SBTC</strong></a></li>
<li><a href='/trade/SNT_BTC'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a></li>
<li><a href='/trade/STORJ_BTC'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a></li>
<li><a href='/trade/TNC_BTC'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a></li>
<li><a href='/trade/WAVES_BTC'><span class="icon-16-waves icon-16"></span><strong>波币 WAVES</strong></a></li>
<li><a href='/trade/XLM_BTC'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a></li>
<li><a href='/trade/XMC_BTC'><span class="icon-16-xmc icon-16"></span><strong>门罗原链 XMC</strong></a></li>
<li><a href='/trade/XMR_BTC'><span class="icon-16-xmr icon-16"></span><strong>门罗币 XMR</strong></a></li>
<li><a href='/trade/XRP_BTC'><span class="icon-16-xrp icon-16"></span><strong>瑞波币 XRP</strong></a></li>
<li><a href='/trade/XVG_BTC'><span class="icon-16-xvg icon-16"></span><strong>Verge XVG</strong></a></li>
<li><a href='/trade/ZEC_BTC'><span class="icon-16-zec icon-16"></span><strong>ZCash ZEC</strong></a></li>
<li><a href='/trade/ZPT_BTC'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a></li>
<li><a href='/trade/ZRX_BTC'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">对ETH交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ABT_ETH'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a></li>
<li><a href='/trade/AE_ETH'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a></li>
<li><a href='/trade/ARN_ETH'><span class="icon-16-arn icon-16"></span><strong>Aeron ARN</strong></a></li>
<li><a href='/trade/BAT_ETH'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a></li>
<li><a href='/trade/BCDN_ETH'><span class="icon-16-bcdn icon-16"></span><strong>BlockCDN BCDN</strong></a></li>
<li><a href='/trade/BFT_ETH'><span class="icon-16-bft icon-16"></span><strong>BFToken BFT</strong></a></li>
<li><a href='/trade/BLZ_ETH'><span class="icon-16-blz icon-16"></span><strong>Bluzelle BLZ</strong></a></li>
<li><a href='/trade/BNT_ETH'><span class="icon-16-bnt icon-16"></span><strong>Bancor BNT</strong></a></li>
<li><a href='/trade/BNTY_ETH'><span class="icon-16-bnty icon-16"></span><strong>Bounty0x BNTY</strong></a></li>
<li><a href='/trade/BOT_ETH'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a></li>
<li><a href='/trade/BTM_ETH'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a></li>
<li><a href='/trade/BTO_ETH'><span class="icon-16-bto icon-16"></span><strong>铂链 BTO</strong></a></li>
<li><a href='/trade/CDT_ETH'><span class="icon-16-cdt icon-16"></span><strong>CoinDash CDT</strong></a></li>
<li><a href='/trade/COFI_ETH'><span class="icon-16-cofi icon-16"></span><strong>CoinFi COFI</strong></a></li>
<li><a href='/trade/CS_ETH'><span class="icon-16-cs icon-16"></span><strong>Credits CS</strong></a></li>
<li><a href='/trade/CTR_ETH'><span class="icon-16-ctr icon-16"></span><strong>Centra CTR</strong></a></li>
<li><a href='/trade/CVC_ETH'><span class="icon-16-cvc icon-16"></span><strong>Civic CVC</strong></a></li>
<li><a href='/trade/DADI_ETH'><span class="icon-16-dadi icon-16"></span><strong>DADI DADI</strong></a></li>
<li><a href='/trade/DATA_ETH'><span class="icon-16-data icon-16"></span><strong>Streamr DATA</strong></a></li>
<li><a href='/trade/DBC_ETH'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a></li>
<li><a href='/trade/DDD_ETH'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a></li>
<li><a href='/trade/DGD_ETH'><span class="icon-16-dgd icon-16"></span><strong>DigixDAO DGD</strong></a></li>
<li><a href='/trade/DNT_ETH'><span class="icon-16-dnt icon-16"></span><strong>district0x DNT</strong></a></li>
<li><a href='/trade/DOCK_ETH'><span class="icon-16-dock icon-16"></span><strong>Dock DOCK</strong></a></li>
<li><a href='/trade/DPY_ETH'><span class="icon-16-dpy icon-16"></span><strong>Delphy DPY</strong></a></li>
<li><a href='/trade/DRGN_ETH'><span class="icon-16-drgn icon-16"></span><strong>DragonChain DRGN</strong></a></li>
<li><a href='/trade/ELF_ETH'><span class="icon-16-elf icon-16"></span><strong>aelf ELF</strong></a></li>
<li><a href='/trade/EOS_ETH'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a></li>
<li><a href='/trade/ETC_ETH'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a></li>
<li><a href='/trade/FUEL_ETH'><span class="icon-16-fuel icon-16"></span><strong>Etherparty FUEL</strong></a></li>
<li><a href='/trade/FUN_ETH'><span class="icon-16-fun icon-16"></span><strong>FunFair FUN</strong></a></li>
<li><a href='/trade/GEM_ETH'><span class="icon-16-gem icon-16"></span><strong>Gems GEM</strong></a></li>
<li><a href='/trade/GNT_ETH'><span class="icon-16-gnt icon-16"></span><strong>Golem GNT</strong></a></li>
<li><a href='/trade/GNX_ETH'><span class="icon-16-gnx icon-16"></span><strong>Genaro GNX</strong></a></li>
<li><a href='/trade/GTC_ETH'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a></li>
<li><a href='/trade/HSR_ETH'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a></li>
<li><a href='/trade/ICX_ETH'><span class="icon-16-icx icon-16"></span><strong>ICON ICX</strong></a></li>
<li><a href='/trade/IHT_ETH'><span class="icon-16-iht icon-16"></span><strong>云产币 IHT</strong></a></li>
<li><a href='/trade/INK_ETH'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a></li>
<li><a href='/trade/JNT_ETH'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a></li>
<li><a href='/trade/KICK_ETH'><span class="icon-16-kick icon-16"></span><strong>KickCoin KICK</strong></a></li>
<li><a href='/trade/KNC_ETH'><span class="icon-16-knc icon-16"></span><strong>Kyber KNC</strong></a></li>
<li><a href='/trade/LEDU_ETH'><span class="icon-16-ledu icon-16"></span><strong>Education LEDU</strong></a></li>
<li><a href='/trade/LEND_ETH'><span class="icon-16-lend icon-16"></span><strong>ETHLend LEND</strong></a></li>
<li><a href='/trade/LINK_ETH'><span class="icon-16-link icon-16"></span><strong>ChainLink LINK</strong></a></li>
<li><a href='/trade/LLT_ETH'><span class="icon-16-llt icon-16"></span><strong>流量币 LLT</strong></a></li>
<li><a href='/trade/LRC_ETH'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a></li>
<li><a href='/trade/LRN_ETH'><span class="icon-16-lrn icon-16"></span><strong>路印NEO LRN</strong></a></li>
<li><a href='/trade/LUN_ETH'><span class="icon-16-lun icon-16"></span><strong>Lunyr LUN</strong></a></li>
<li><a href='/trade/LYM_ETH'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a></li>
<li><a href='/trade/MAN_ETH'><span class="icon-16-man icon-16"></span><strong>MatrixAI MAN</strong></a></li>
<li><a href='/trade/MANA_ETH'><span class="icon-16-mana icon-16"></span><strong>Decentraland MANA</strong></a></li>
<li><a href='/trade/MCO_ETH'><span class="icon-16-mco icon-16"></span><strong>Monaco MCO</strong></a></li>
<li><a href='/trade/MDA_ETH'><span class="icon-16-mda icon-16"></span><strong>Moeda MDA</strong></a></li>
<li><a href='/trade/MDS_ETH'><span class="icon-16-mds icon-16"></span><strong>MediShares MDS</strong></a></li>
<li><a href='/trade/MDT_ETH'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a></li>
<li><a href='/trade/MED_ETH'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a></li>
<li><a href='/trade/MITH_ETH'><span class="icon-16-mith icon-16"></span><strong>秘银币 MITH</strong></a></li>
<li><a href='/trade/MKR_ETH'><span class="icon-16-mkr icon-16"></span><strong>MakerDAO MKR</strong></a></li>
<li><a href='/trade/MOBI_ETH'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a></li>
<li><a href='/trade/MTN_ETH'><span class="icon-16-mtn icon-16"></span><strong>Medicalchain MTN</strong></a></li>
<li><a href='/trade/NAS_ETH'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a></li>
<li><a href='/trade/OAX_ETH'><span class="icon-16-oax icon-16"></span><strong>ANX OAX</strong></a></li>
<li><a href='/trade/OCN_ETH'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a></li>
<li><a href='/trade/OMG_ETH'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a></li>
<li><a href='/trade/ONT_ETH'><span class="icon-16-ont icon-16"></span><strong>本体 ONT</strong></a></li>
<li><a href='/trade/OST_ETH'><span class="icon-16-ost icon-16"></span><strong>SimpleToken OST</strong></a></li>
<li><a href='/trade/PAY_ETH'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a></li>
<li><a href='/trade/POWR_ETH'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a></li>
<li><a href='/trade/PST_ETH'><span class="icon-16-pst icon-16"></span><strong>Primas PST</strong></a></li>
<li><a href='/trade/QASH_ETH'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a></li>
<li><a href='/trade/QBT_ETH'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a></li>
<li><a href='/trade/QLC_ETH'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a></li>
<li><a href='/trade/QSP_ETH'><span class="icon-16-qsp icon-16"></span><strong>Quantstamp QSP</strong></a></li>
<li><a href='/trade/QTUM_ETH'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a></li>
<li><a href='/trade/RCN_ETH'><span class="icon-16-rcn icon-16"></span><strong>Ripio RCN</strong></a></li>
<li><a href='/trade/RDN_ETH'><span class="icon-16-rdn icon-16"></span><strong>雷电网络 RDN</strong></a></li>
<li><a href='/trade/REP_ETH'><span class="icon-16-rep icon-16"></span><strong>Augur REP</strong></a></li>
<li><a href='/trade/REQ_ETH'><span class="icon-16-req icon-16"></span><strong>Request REQ</strong></a></li>
<li><a href='/trade/RFR_ETH'><span class="icon-16-rfr icon-16"></span><strong>Refereum RFR</strong></a></li>
<li><a href='/trade/RLC_ETH'><span class="icon-16-rlc icon-16"></span><strong>iExec RLC</strong></a></li>
<li><a href='/trade/RUFF_ETH'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a></li>
<li><a href='/trade/SALT_ETH'><span class="icon-16-salt icon-16"></span><strong>SALT  SALT</strong></a></li>
<li><a href='/trade/SENC_ETH'><span class="icon-16-senc icon-16"></span><strong>Sentinel SENC</strong></a></li>
<li><a href='/trade/SKM_ETH'><span class="icon-16-skm icon-16"></span><strong>Skrumble SKM</strong></a></li>
<li><a href='/trade/SMT_ETH'><span class="icon-16-smt icon-16"></span><strong>SmartMesh SMT</strong></a></li>
<li><a href='/trade/SNET_ETH'><span class="icon-16-snet icon-16"></span><strong>Snetwork SNET</strong></a></li>
<li><a href='/trade/SNT_ETH'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a></li>
<li><a href='/trade/STORJ_ETH'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a></li>
<li><a href='/trade/STX_ETH'><span class="icon-16-stx icon-16"></span><strong>Stox STX</strong></a></li>
<li><a href='/trade/SWTH_ETH'><span class="icon-16-swth icon-16"></span><strong>Switcheo SWTH</strong></a></li>
<li><a href='/trade/THETA_ETH'><span class="icon-16-theta icon-16"></span><strong>Theta THETA</strong></a></li>
<li><a href='/trade/TIO_ETH'><span class="icon-16-tio icon-16"></span><strong>trade.io TIO</strong></a></li>
<li><a href='/trade/TIPS_ETH'><span class="icon-16-tips icon-16"></span><strong>帽子币 TIPS</strong></a></li>
<li><a href='/trade/TNC_ETH'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a></li>
<li><a href='/trade/TNT_ETH'><span class="icon-16-tnt icon-16"></span><strong>Tierion  TNT</strong></a></li>
<li><a href='/trade/TRX_ETH'><span class="icon-16-trx icon-16"></span><strong>波场 TRX</strong></a></li>
<li><a href='/trade/VEN_ETH'><span class="icon-16-ven icon-16"></span><strong>唯链 VEN</strong></a></li>
<li><a href='/trade/WINGS_ETH'><span class="icon-16-wings icon-16"></span><strong>Wings WINGS</strong></a></li>
<li><a href='/trade/XLM_ETH'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a></li>
<li><a href='/trade/ZIL_ETH'><span class="icon-16-zil icon-16"></span><strong>Zilliqa ZIL</strong></a></li>
<li><a href='/trade/ZPT_ETH'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a></li>
<li><a href='/trade/ZRX_ETH'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a></li>
<li><a href='/trade/ZSC_ETH'><span class="icon-16-zsc icon-16"></span><strong>宙斯盾 ZSC</strong></a></li>
                        </ul>
                    </li>
					<li>
                        <a href="javascript:;">对USDT交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ABT_USDT'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a></li>
<li><a href='/trade/ADA_USDT'><span class="icon-16-ada icon-16"></span><strong>艾达币 ADA</strong></a></li>
<li><a href='/trade/AE_USDT'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a></li>
<li><a href='/trade/BAT_USDT'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a></li>
<li><a href='/trade/BCD_USDT'><span class="icon-16-bcd icon-16"></span><strong>比特币钻石 BCD</strong></a></li>
<li><a href='/trade/BCDN_USDT'><span class="icon-16-bcdn icon-16"></span><strong>BlockCDN BCDN</strong></a></li>
<li><a href='/trade/BCH_USDT'><span class="icon-16-bch icon-16"></span><strong>BCH(原BCC) BCH</strong></a></li>
<li><a href='/trade/BCX_USDT'><span class="icon-16-bcx icon-16"></span><strong>比特无限 BCX</strong></a></li>
<li><a href='/trade/BFT_USDT'><span class="icon-16-bft icon-16"></span><strong>BFToken BFT</strong></a></li>
<li><a href='/trade/BIFI_USDT'><span class="icon-16-bifi icon-16"></span><strong>BitcoinFile BIFI</strong></a></li>
<li><a href='/trade/BLZ_USDT'><span class="icon-16-blz icon-16"></span><strong>Bluzelle BLZ</strong></a></li>
<li><a href='/trade/BNTY_USDT'><span class="icon-16-bnty icon-16"></span><strong>Bounty0x BNTY</strong></a></li>
<li><a href='/trade/BOT_USDT'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a></li>
<li><a href='/trade/BTC_USDT'><span class="icon-16-btc icon-16"></span><strong>比特币 BTC</strong></a></li>
<li><a href='/trade/BTF_USDT'><span class="icon-16-btf icon-16"></span><strong>比特信仰 BTF</strong></a></li>
<li><a href='/trade/BTG_USDT'><span class="icon-16-btg icon-16"></span><strong>BTG BTG</strong></a></li>
<li><a href='/trade/BTM_USDT'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a></li>
<li><a href='/trade/BTO_USDT'><span class="icon-16-bto icon-16"></span><strong>铂链 BTO</strong></a></li>
<li><a href='/trade/BTS_USDT'><span class="icon-16-bts icon-16"></span><strong>比特股 BTS</strong></a></li>
<li><a href='/trade/CDT_USDT'><span class="icon-16-cdt icon-16"></span><strong>CoinDash CDT</strong></a></li>
<li><a href='/trade/COFI_USDT'><span class="icon-16-cofi icon-16"></span><strong>CoinFi COFI</strong></a></li>
<li><a href='/trade/CS_USDT'><span class="icon-16-cs icon-16"></span><strong>Credits CS</strong></a></li>
<li><a href='/trade/CVC_USDT'><span class="icon-16-cvc icon-16"></span><strong>Civic CVC</strong></a></li>
<li><a href='/trade/DADI_USDT'><span class="icon-16-dadi icon-16"></span><strong>DADI DADI</strong></a></li>
<li><a href='/trade/DAI_USDT'><span class="icon-16-dai icon-16"></span><strong>Dai DAI</strong></a></li>
<li><a href='/trade/DASH_USDT'><span class="icon-16-dash icon-16"></span><strong>达世币 DASH</strong></a></li>
<li><a href='/trade/DATA_USDT'><span class="icon-16-data icon-16"></span><strong>Streamr DATA</strong></a></li>
<li><a href='/trade/DBC_USDT'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a></li>
<li><a href='/trade/DDD_USDT'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a></li>
<li><a href='/trade/DGD_USDT'><span class="icon-16-dgd icon-16"></span><strong>DigixDAO DGD</strong></a></li>
<li><a href='/trade/DOCK_USDT'><span class="icon-16-dock icon-16"></span><strong>Dock DOCK</strong></a></li>
<li><a href='/trade/DOGE_USDT'><span class="icon-16-doge icon-16"></span><strong>狗狗币 DOGE</strong></a></li>
<li><a href='/trade/DPY_USDT'><span class="icon-16-dpy icon-16"></span><strong>Delphy DPY</strong></a></li>
<li><a href='/trade/DRGN_USDT'><span class="icon-16-drgn icon-16"></span><strong>DragonChain DRGN</strong></a></li>
<li><a href='/trade/ELF_USDT'><span class="icon-16-elf icon-16"></span><strong>aelf ELF</strong></a></li>
<li><a href='/trade/EOS_USDT'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a></li>
<li><a href='/trade/ETC_USDT'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a></li>
<li><a href='/trade/ETH_USDT'><span class="icon-16-eth icon-16"></span><strong>以太币 ETH</strong></a></li>
<li><a href='/trade/FIL_USDT'><span class="icon-16-fil icon-16"></span><strong>IPFS六月 FIL</strong></a></li>
<li><a href='/trade/FUEL_USDT'><span class="icon-16-fuel icon-16"></span><strong>Etherparty FUEL</strong></a></li>
<li><a href='/trade/FUN_USDT'><span class="icon-16-fun icon-16"></span><strong>FunFair FUN</strong></a></li>
<li><a href='/trade/GAS_USDT'><span class="icon-16-gas icon-16"></span><strong>小蚁Gas GAS</strong></a></li>
<li><a href='/trade/GEM_USDT'><span class="icon-16-gem icon-16"></span><strong>Gems GEM</strong></a></li>
<li><a href='/trade/GNT_USDT'><span class="icon-16-gnt icon-16"></span><strong>Golem GNT</strong></a></li>
<li><a href='/trade/GNX_USDT'><span class="icon-16-gnx icon-16"></span><strong>Genaro GNX</strong></a></li>
<li><a href='/trade/GOD_USDT'><span class="icon-16-god icon-16"></span><strong>比特币上帝 GOD</strong></a></li>
<li><a href='/trade/GTC_USDT'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a></li>
<li><a href='/trade/GXS_USDT'><span class="icon-16-gxs icon-16"></span><strong>公信宝 GXS</strong></a></li>
<li><a href='/trade/HSR_USDT'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a></li>
<li><a href='/trade/ICX_USDT'><span class="icon-16-icx icon-16"></span><strong>ICON ICX</strong></a></li>
<li><a href='/trade/IHT_USDT'><span class="icon-16-iht icon-16"></span><strong>云产币 IHT</strong></a></li>
<li><a href='/trade/INK_USDT'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a></li>
<li><a href='/trade/IOTA_USDT'><span class="icon-16-iota icon-16"></span><strong>IOTA IOTA</strong></a></li>
<li><a href='/trade/JNT_USDT'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a></li>
<li><a href='/trade/KICK_USDT'><span class="icon-16-kick icon-16"></span><strong>KickCoin KICK</strong></a></li>
<li><a href='/trade/KNC_USDT'><span class="icon-16-knc icon-16"></span><strong>Kyber KNC</strong></a></li>
<li><a href='/trade/LEND_USDT'><span class="icon-16-lend icon-16"></span><strong>ETHLend LEND</strong></a></li>
<li><a href='/trade/LINK_USDT'><span class="icon-16-link icon-16"></span><strong>ChainLink LINK</strong></a></li>
<li><a href='/trade/LRC_USDT'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a></li>
<li><a href='/trade/LRN_USDT'><span class="icon-16-lrn icon-16"></span><strong>路印NEO LRN</strong></a></li>
<li><a href='/trade/LSK_USDT'><span class="icon-16-lsk icon-16"></span><strong>Lisk LSK</strong></a></li>
<li><a href='/trade/LTC_USDT'><span class="icon-16-ltc icon-16"></span><strong>莱特币 LTC</strong></a></li>
<li><a href='/trade/LUN_USDT'><span class="icon-16-lun icon-16"></span><strong>Lunyr LUN</strong></a></li>
<li><a href='/trade/LYM_USDT'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a></li>
<li><a href='/trade/MAN_USDT'><span class="icon-16-man icon-16"></span><strong>MatrixAI MAN</strong></a></li>
<li><a href='/trade/MANA_USDT'><span class="icon-16-mana icon-16"></span><strong>Decentraland MANA</strong></a></li>
<li><a href='/trade/MCO_USDT'><span class="icon-16-mco icon-16"></span><strong>Monaco MCO</strong></a></li>
<li><a href='/trade/MDA_USDT'><span class="icon-16-mda icon-16"></span><strong>Moeda MDA</strong></a></li>
<li><a href='/trade/MDS_USDT'><span class="icon-16-mds icon-16"></span><strong>MediShares MDS</strong></a></li>
<li><a href='/trade/MDT_USDT'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a></li>
<li><a href='/trade/MED_USDT'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a></li>
<li><a href='/trade/MITH_USDT'><span class="icon-16-mith icon-16"></span><strong>秘银币 MITH</strong></a></li>
<li><a href='/trade/MKR_USDT'><span class="icon-16-mkr icon-16"></span><strong>MakerDAO MKR</strong></a></li>
<li><a href='/trade/MOBI_USDT'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a></li>
<li><a href='/trade/MTN_USDT'><span class="icon-16-mtn icon-16"></span><strong>Medicalchain MTN</strong></a></li>
<li><a href='/trade/NANO_USDT'><span class="icon-16-nano icon-16"></span><strong>Nano NANO</strong></a></li>
<li><a href='/trade/NAS_USDT'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a></li>
<li><a href='/trade/NEO_USDT'><span class="icon-16-neo icon-16"></span><strong>小蚁Neo NEO</strong></a></li>
<li><a href='/trade/OCN_USDT'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a></li>
<li><a href='/trade/OMG_USDT'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a></li>
<li><a href='/trade/ONT_USDT'><span class="icon-16-ont icon-16"></span><strong>本体 ONT</strong></a></li>
<li><a href='/trade/OST_USDT'><span class="icon-16-ost icon-16"></span><strong>SimpleToken OST</strong></a></li>
<li><a href='/trade/PAY_USDT'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a></li>
<li><a href='/trade/POWR_USDT'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a></li>
<li><a href='/trade/PST_USDT'><span class="icon-16-pst icon-16"></span><strong>Primas PST</strong></a></li>
<li><a href='/trade/QASH_USDT'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a></li>
<li><a href='/trade/QBT_USDT'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a></li>
<li><a href='/trade/QLC_USDT'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a></li>
<li><a href='/trade/QSP_USDT'><span class="icon-16-qsp icon-16"></span><strong>Quantstamp QSP</strong></a></li>
<li><a href='/trade/QTUM_USDT'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a></li>
<li><a href='/trade/RCN_USDT'><span class="icon-16-rcn icon-16"></span><strong>Ripio RCN</strong></a></li>
<li><a href='/trade/RDN_USDT'><span class="icon-16-rdn icon-16"></span><strong>雷电网络 RDN</strong></a></li>
<li><a href='/trade/REQ_USDT'><span class="icon-16-req icon-16"></span><strong>Request REQ</strong></a></li>
<li><a href='/trade/RFR_USDT'><span class="icon-16-rfr icon-16"></span><strong>Refereum RFR</strong></a></li>
<li><a href='/trade/RLC_USDT'><span class="icon-16-rlc icon-16"></span><strong>iExec RLC</strong></a></li>
<li><a href='/trade/RUFF_USDT'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a></li>
<li><a href='/trade/SALT_USDT'><span class="icon-16-salt icon-16"></span><strong>SALT  SALT</strong></a></li>
<li><a href='/trade/SBTC_USDT'><span class="icon-16-sbtc icon-16"></span><strong>超级比特币 SBTC</strong></a></li>
<li><a href='/trade/SENC_USDT'><span class="icon-16-senc icon-16"></span><strong>Sentinel SENC</strong></a></li>
<li><a href='/trade/SKM_USDT'><span class="icon-16-skm icon-16"></span><strong>Skrumble SKM</strong></a></li>
<li><a href='/trade/SMT_USDT'><span class="icon-16-smt icon-16"></span><strong>SmartMesh SMT</strong></a></li>
<li><a href='/trade/SNET_USDT'><span class="icon-16-snet icon-16"></span><strong>Snetwork SNET</strong></a></li>
<li><a href='/trade/SNT_USDT'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a></li>
<li><a href='/trade/STORJ_USDT'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a></li>
<li><a href='/trade/STX_USDT'><span class="icon-16-stx icon-16"></span><strong>Stox STX</strong></a></li>
<li><a href='/trade/SWTH_USDT'><span class="icon-16-swth icon-16"></span><strong>Switcheo SWTH</strong></a></li>
<li><a href='/trade/THETA_USDT'><span class="icon-16-theta icon-16"></span><strong>Theta THETA</strong></a></li>
<li><a href='/trade/TIO_USDT'><span class="icon-16-tio icon-16"></span><strong>trade.io TIO</strong></a></li>
<li><a href='/trade/TNC_USDT'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a></li>
<li><a href='/trade/TNT_USDT'><span class="icon-16-tnt icon-16"></span><strong>Tierion  TNT</strong></a></li>
<li><a href='/trade/TRX_USDT'><span class="icon-16-trx icon-16"></span><strong>波场 TRX</strong></a></li>
<li><a href='/trade/TSL_USDT'><span class="icon-16-tsl icon-16"></span><strong>Energo TSL</strong></a></li>
<li><a href='/trade/VEN_USDT'><span class="icon-16-ven icon-16"></span><strong>唯链 VEN</strong></a></li>
<li><a href='/trade/WAVES_USDT'><span class="icon-16-waves icon-16"></span><strong>波币 WAVES</strong></a></li>
<li><a href='/trade/XLM_USDT'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a></li>
<li><a href='/trade/XMC_USDT'><span class="icon-16-xmc icon-16"></span><strong>门罗原链 XMC</strong></a></li>
<li><a href='/trade/XMR_USDT'><span class="icon-16-xmr icon-16"></span><strong>门罗币 XMR</strong></a></li>
<li><a href='/trade/XRP_USDT'><span class="icon-16-xrp icon-16"></span><strong>瑞波币 XRP</strong></a></li>
<li><a href='/trade/XTZ_USDT'><span class="icon-16-xtz icon-16"></span><strong>Tezos期 XTZ</strong></a></li>
<li><a href='/trade/XVG_USDT'><span class="icon-16-xvg icon-16"></span><strong>Verge XVG</strong></a></li>
<li><a href='/trade/ZEC_USDT'><span class="icon-16-zec icon-16"></span><strong>ZCash ZEC</strong></a></li>
<li><a href='/trade/ZIL_USDT'><span class="icon-16-zil icon-16"></span><strong>Zilliqa ZIL</strong></a></li>
<li><a href='/trade/ZPT_USDT'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a></li>
<li><a href='/trade/ZRX_USDT'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a></li>
<li><a href='/trade/ZSC_USDT'><span class="icon-16-zsc icon-16"></span><strong>宙斯盾 ZSC</strong></a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">对QTUM交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/BOT_QTUM'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a></li>
<li><a href='/trade/INK_QTUM'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a></li>
<li><a href='/trade/LLT_SNET'><span class="icon-16-llt icon-16"></span><strong>流量币 LLT</strong></a></li>
<li><a href='/trade/MED_QTUM'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a></li>
<li><a href='/trade/QBT_QTUM'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a></li>
<li><a href='/trade/TSL_QTUM'><span class="icon-16-tsl icon-16"></span><strong>Energo TSL</strong></a></li>
                        </ul>
                    </li>
					<li>
                        <a href="javascript:;">限时交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ELEC_ETH'><span class="icon-16-elec icon-16"></span><strong>ElectrifyAsia ELEC</strong></a></li>
<li><a href='/trade/HAV_ETH'><span class="icon-16-hav icon-16"></span><strong>Havven HAV</strong></a></li>
<li><a href='/trade/HUR_ETH'><span class="icon-16-hur icon-16"></span><strong>Hurify HUR</strong></a></li>
<li><a href='/trade/INSTAR_ETH'><span class="icon-16-instar icon-16"></span><strong>InsightsNetwork INSTAR</strong></a></li>
<li><a href='/trade/LST_ETH'><span class="icon-16-lst icon-16"></span><strong>Lendroid LST</strong></a></li>
<li><a href='/trade/REM_ETH'><span class="icon-16-rem icon-16"></span><strong>Remme REM</strong></a></li>
<li><a href='/trade/SHIP_ETH'><span class="icon-16-ship icon-16"></span><strong>ShipChain SHIP</strong></a></li>
<li><a href='/trade/TFD_ETH'><span class="icon-16-tfd icon-16"></span><strong>TE-Food TFD</strong></a></li>
<li><a href='/trade/TOMO_ETH'><span class="icon-16-tomo icon-16"></span><strong>TomoChain TOMO</strong></a></li>
                        </ul>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="/myaccount">我的财务</a>
				
            </li>
			 
            <li class="">
                <a href="/myaccount/totp">安全设置</a>
				
            </li>
			<li class="">
                <a href="/articlelist/ann">公告</a>
				
            </li>
			<li class="">
                <a href="/listing">上币申请</a>
				
            </li>
            <li class="">
                <a href="javascript:;">帮助<i class="caret"></i></a>
                <ul class="second-nav clearfix">
					<li>
                        <a href="/help">问题中心</a>
                    </li>
					<li>
                        <a href="javascript:ticketsRoute();">提交工单</a>
                    </li>   					
					<li>
                        <a href="/coins">资料下载<i class="caret"></i></a>
                        <ul class="third-nav nav-help clearfix">                            
                            <li><a href="/mobileapp">手机APP</a></li>  
							<li><a href="https://github.com/gateio/windows_app/releases/download/v1.0.3/Gateio_Setup.7z?v=101" target="_blank">Windows APP</a></li>   
							<li><a href="https://github.com/gateio/mac_app/releases/download/v1.0.2/Gate.io.dmg?v=101" target="_blank">Mac APP</a></li>
                            <li><a href="/coins">币种资料</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>

        <div id="top_last_rate" style="display: none"></div>

    </div>
</div>

<style>
    html, body {height: 100%}
    section {min-height: calc(100% - 451px);}
    .content {border-top: 1px solid #ddd}
    .login2-tab li{ width: 100%; text-align: center; font-size: 18px; padding: 20px 0; margin-bottom: 30px; border-bottom: 1px solid #eee;}
    .login2-tab.show_tab li{ width: 50%;float: left; cursor: pointer}
    .login2-tab .log-tab-active{ border-width: 3px; border-color: #de5959; color: #de5959}
    .login2-table tr td:first-child{ width: 33.33%}
    .sectioncont{ height: 350px;overflow: hidden; position: relative}
    .sectioncont form{position: absolute;top:100px; width: 100%}
    #disablelogin2{ height: 15px; margin-top: 3px; margin-right: 0}
</style>
<section>

    <div id="content" class="content">
        <div id="homepost" style="width: 950px; margin: 0 auto; padding-top: 30px">

            <div class="m_title" style="border: none;text-align:center"><h4>用户登录 - 第二步验证</h4></div>
            <div class="sectioncont">
                <p style="text-align:center; color:#de5959">用户登录第二步验证，是通过 谷歌验证码 或 短信验证码 进一步保证账号的安全的高级安全机制，请输入以下信息：</p>
                <ul class="login2-tab ">
                                        <li>短信验证码</li>                </ul>
                <form id="login2Form" enctype="application/x-www-form-urlencoded" method="post" action="https://gateio.io/login">
                    <input type="hidden" name="login2" id="login2" value="1">
                    <input type="hidden" name="password" id="password" value="c4839b339791889e56244df0c0805b12">
                    <input type="hidden" name="email" id="email" value="zuoyehengudan">
					<input type="hidden" name="usesms" id="usesms" value="0">
                    <table class="login2-table">

                        
                        <!--
                        <tr>
                            <td align="right">图片验证码：</td>
                            <td>
                            <img id="login2Captcha" src="/captcha" alt="Captcha" title="看不清？换一张" onclick="document.getElementById('login2Captcha').src = '/captcha?' + Math.random(); return false"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">请输入上面的验证码：</td><td><input type="text" name="captcha" id="captcha" class="login2-captcha" size="20" > </td>
                        </tr>
                        -->

                        
                                                    <tr name="smstr" id="smstr" style='display:none;'>
                                <td align="right" style="padding-right: 8px">短信验证码：</td>
                                <td>
                                    <input type="text" value="" size="20" name="smscode" id="smscode">
                                    <button name="smsbtn" id="smsbtn" type="button">获取短信验证码</button>
                                    <button name="voicebtn" id="voicebtn" type="button">获取电话语音验证码</button>
                                    <input type="hidden" name="smsid" value="315081" id="smsid">
                                </td>
                            </tr>
                        
                        <tr style='display:none;'>
                            <td></td>
                            <td>
                                <input style="width: 20px;" type="hidden" name="iprestriction" id="iprestriction" value='1' checked>绑定到IP地址 （<font color=red>为保证账号安全如非动态IP切勿去选！</font>）
                            </td>
                        </tr>

                        <tr style='display:none;'>
                            <td align="right"></td>
                            <td style="padding-top: 10px">
                                <input style="width: 20px;" type="checkbox" name="disablelogin2" id="disablelogin2" value='1'> 取消登录第二步验证 （<font color=red> 为保证账号安全，请切勿选择取消 </font>）
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" name="submit" id="submit" class="sub-btn" value=" 登录 " style="margin-top: 20px">
                            </td>
                        </tr>
                    </table>

                </form>
                <br><br>
            </div> <!-- login -->


        </div> <!-- homepost -->
    </div> <!-- content -->


</section>


<script>
    $(function (e) {

        //页面初始化
        var smstr = $("#smstr"),
            totptr = $("#totptr"),
            smsOn='1',
            totpOn='';
        if(smsOn=='1' && totpOn==''){smstr.show()}

        if(smsOn=='1' && totpOn=='1') {
            //tab切换
            $(".login2-tab").find("li").click(function () {
                if ($(this).index() == 1) {
                    $("#login2Form").animate({left:'-950px'},100,function () {
                        smstr.show();
                        totptr.hide();
                        $(this).css("left","950px").animate({left:'0'},100);
						$("#usesms").val(1);
                    });
                } else {
                    $("#login2Form").animate({left:'950px'},100,function () {
                        smstr.hide();
                        totptr.show();
                        $(this).css("left","-950px").animate({left:'0'},100);
						$("#usesms").val(0);
                    });
                }
                $(this).addClass("log-tab-active").siblings().removeClass("log-tab-active");
            })
        }


        $('#smsbtn').click(function () {
            var self = $(this);

            var currentTime = 60;
            var orignialtext = $(this).text();
            var form = self.closest('form');

            self.prop('disabled', true);

            var timer = $.timer(function () {
                currentTime = currentTime - 1;
                self.text(orignialtext + ' (' + currentTime + ')');

                if (currentTime == 0) {
                    resetTimer();
                }
            }, 1000, false);

            var resetTimer = function () {
                timer.stop();
                currentTime = 60;
                self.text(orignialtext).prop('disabled', false);
            }

            var smsid = $('#smsid', form).val();
            var lang = "cn";
            var view_code = "";
            var msg = "";
            $.ajax({
                type: "post", url: "/sms/" + smsid,
                success: function (data, textStatus) {
                    var json_res = data;
                    if (json_res && json_res.result) {
                        self.text(orignialtext + ' (' + currentTime + ')');
                        timer.play();
                        msg = lang == "en" ? "The SMS code has been sent to your cellphone." : "手机短信验证码：" + json_res.msg;
                        $('#smscode', form).prop('disabled', false);
                    } else {
                        msg = lang == "en" ? "Send SMS faild: " + json_res.msg + ", please check your phone number at <a href='/myaccount/sms_setup'>this link</a>." : "短信发送失败：" + json_res.msg;
                        //resetTimer();
                        timer.play();
                    }
                    //apprise( "<div>"+msg+"</div>", {animate:true,textOk:"确定"}, function(r){} );
                    noty({text: msg, type: "error", layout: "bottomLeft",theme:'gateioNotyTheme',timeout: 10000});
                },
                error: function () {
                    //resetTimer();
                    timer.play();
                    //apprise( "网络错误！",{animate:true,textOk:"确定"}, function(r){} );
                    noty({text: '网络错误!', type: "error", layout: "bottomLeft",theme:'gateioNotyTheme', timeout: 10000});
                },
                complete: function () {
                }
            });

            return false;
        });


        $('#voicebtn').click(function () {
            var self = $(this);

            var currentTime = 60;
            var orignialtext = $(this).text();
            var form = self.closest('form');

            self.prop('disabled', true);

            var timer = $.timer(function () {
                currentTime = currentTime - 1;
                self.text(orignialtext + ' (' + currentTime + ')');

                if (currentTime == 0) {
                    resetTimer();
                }
            }, 1000, false);

            var resetTimer = function () {
                timer.stop();
                currentTime = 60;
                self.text(orignialtext).prop('disabled', false);
            }

            var smsid = $('#smsid', form).val();
            var lang = "cn";
            var view_code = "";
            var msg = "";
            $.ajax({
                type: "post", url: "/voiceverify/" + smsid,
                success: function (data, textStatus) {
                    var json_res = data;
                    if (json_res && json_res.result) {
                        self.text(orignialtext + ' (' + currentTime + ')');
                        timer.play();
                        msg = lang == "en" ? "The voide verification code has been sent to your cellphone." : "电话语音验证码：" + json_res.msg;
                        $('#smscode', form).prop('disabled', false);
                    } else {
                        msg = lang == "en" ? "Send voice faild: " + json_res.msg + ", please check your phone number at <a href='/myaccount/sms_setup'>this link</a>." : "电话语音拨打失败：" + json_res.msg ;
                        //resetTimer();
                        timer.play();
                    }
                    //apprise( "<div>"+msg+"</div>", {animate:true,textOk:"确定"}, function(r){} );
                    noty({text: msg, type: "error", layout: "bottomLeft",theme:'gateioNotyTheme', timeout: 10000});
                },
                error: function () {
                    //resetTimer();
                    timer.play();
                    //apprise( "网络错误！",{animate:true,textOk:"确定"}, function(r){} );
                    noty({text: '网络错误!', type: "error", layout: "bottomLeft",theme:'gateioNotyTheme', timeout: 10000});
                },
                complete: function () {
                }
            });

            return false;
        });


    });

</script>


<!--<script src="/jsfile/ipd.js"></script>-->

<div class="footer">
    <div class="fkicon">
        <ul class="clearfix">
            <li><a href="javascript:ticketsRoute();" title="Ticket"><div class="fico fc5"></div>
                <div class="fkcont">
                    <div class="ftel">Ticket</div>
                    <div class="ftelnum">Submit a request</div>
                </div></a>
            </li>
            <li><a href="https://twitter.com/gate_io" target="_blank" title="Twitter"><div class="fico fc-twi"></div>
                <div class="fkcont">
                    <div class="ftel">Twitter</div>
                    <div class="ftelnum">twitter.com/gate_io</div>
                </div></a>
            </li>
            <li><a href="https://t.me/gate_io" target="_blank" title="Telegram"><div class="fico fc3"></div></a></li>
            <li><a href="https://www.instagram.com/gate.io/" target="_blank" title="Instagram"><div class="fico fc7"></div></a></li>
			<li><a href="mailto:support@mail.gate.io" target="_blank" title="Email"><div class="fico fc6"></div>
                <div class="fkcont">
                    <div class="ftel">Email</div>
                    <div class="ftelnum">Email us</div>
                </div></a>
            </li>
            <li><a href="https://github.com/gateio" target="_blank" title="Github"><div class="fico fc4"></div>
                <div class="fkcont">
                    <div class="ftel">Github</div>
                    <div class="ftelnum">gate.io Github</div>
                </div></a>
            </li>
        </ul>
        <div class="fxts">
            <p style="text-align: center"><i>!</i>比特币等密码币的交易存在风险，在全球范围内一周7天，一天24小时无休止交易，没有每日涨停跌停限制，价格受到新闻事件，各国政策，市场需求等多种因素影响，浮动很大。我们强烈建议您事先调查了解，在自身所能承受的风险范围内参与交易。</p>
        </div>
    </div>
	
    <div class="fnav">
        <div class="fnavcon">
            <ul>
                <li class="fnav_list">
                    <!--<div class="fnav_title">关于我们</div>-->
                    <ul>                        
                        <li><a href="/page/contacts">联系我们</a></li>                        
                        <li><a href="/fee">费率标准</a></li>
                        <li><a href="/api2">API文档</a></li>
                        <li><a href="/docs/agreement.pdf">用户协议</a></li>
						<li><a href="/articlelist/ann">本站公告</a></li>
                    </ul>
                </li>
              
            </ul>
        </div>
        <div class="tail">
            <span>gate.io&nbsp;&nbsp;版权所有 © 2018</span>
            <div class="vol-all">
                <span>成交量:</span>
				<span> USDT : $<span id="usdtAll">0</span> </span>
                <span> BTC : ฿<span id="btcAll">0</span> </span>
                <span> LTC : Ł<span id="ltcAll">0</span> </span>
                <span> ETH : E<span id="ethAll">0</span> </span>
            </div>
            <span id="runTime">
                <!--<a href="#">gate.io</a> is powered by <a href="#">gate.io Dev Team</a>-->
                <span class="admin-view"> Elapsed:5.377ms &nbsp; a/e/r </span>
            </span>
        </div>
    </div>
</div>

	

<script>
        //force user to use https
       // if ('https:' != document.location.protocol) { window.location = 'https://' + window.location.hostname + window.location.pathname; }
    
    //for footer
    var tier_next_progress='';
   
    $("#usdtAll").text(toThousands(0));
    $("#btcAll").text(toThousands(0));
    $("#ltcAll").text(toThousands(0));
    $("#ethAll").text(toThousands(0));
    is_login='zuoyehengudan' != '';
</script>
<script src="js/footer.js?v=0420"></script>

</body>
</html>

