<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <sitemesh:write property='title'/>
    </title>
    <sitemesh:write property='head'/>
</head>
<body>
<div id="siteNoty" class="notification-box"><div class="noty_message">【!!!!重要通知!!!!】： <a id="siteNotyCon" href="/article/16451" >gate.io充值量子链(QTUM)赢取QTUM大奖活动公告</a><a class="close pull-right" href=javascript:;></a></div></div><div class="header clearfix">
    <div class="top-up">
        <div class="top-con">
            <ul class="topprice">
                <li> BTC/CNY : ￥ <span class="topnum">54602.50</span><i class="icon-arrow-up">&uarr;</i> </li>
                <li> ETH/CNY : ￥ <span class="topnum">4583.50</span><i class="icon-arrow-down">&darr;</i> </li>
                <li> LTC/CNY : ￥ <span class="topnum">875.65</span><i class="icon-arrow-down">&darr;</i> </li>
                <li> QTUM/CNY : ￥ <span class="topnum">104.72</span><i class="icon-arrow-down">&darr;</i> </li>
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
                        <span class="lv-con"><a class="tier-level tier-icon0" href="/article/16273" title="等级"></a></span>
                        <a id="nickName" href="/myaccount"><span>zuoyehengudan</span><i class="caret"></i></a>
                        <div class="tier-info" id="tierMenu">
                            <ul>
                                <span class="uccaret umc"></span>
                                <li>
                                    <b>当前等级：</b>
                                    <span><strong class="tier-level tier-icon0"></strong><br/>有效时间至<small> -</small></span>
                                </li>
                                <li>
                                    <b>当前交易费折扣：</b>
                                    <span><strong>无</strong></span>
                                </li>
                                <li>
                                    <b>最近30天交易量：</b>
                                    <p><strong>0.00000</strong> BTC 或
                                        <strong>0.00</strong> CNY</p>
                                </li>
                                <li>
                                    <b>账户总资产：</b>
                                    <p><strong>0.00000</strong> BTC 或
                                        <strong>0.00</strong> CNY</p>
                                </li>
                                <li>
                                    <b>升级进度：</b>
                                    <span><strong>0.0%</strong></span>
                                </li>
                                <li id="progrLi">
                                    <div id="proBar"></div>
                                </li>
                                <li>升级还需要 <strong>3.0</strong> BTC 或者
                                    <strong>163808</strong> CNY 30天交易量
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
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">对ETH交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ABT_ETH'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">对USDT交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ABT_USDT'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">对QTUM交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/BOT_QTUM'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">限时交易区<i class="caret"></i></a>
                        <ul class="third-nav clearfix">
                            <li><a href='/trade/ELEC_ETH'><span class="icon-16-elec icon-16"></span><strong>ElectrifyAsia ELEC</strong></a></li>
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
            <li class="nav-active">
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



<div class="content">
    <link href="/css/usercenter.css?v=1524284247" rel="stylesheet" type="text/css">

    <table class="leftbar" style="padding-top: 15px">
        <tbody><tr>
            <td style="border-bottom:0;" valign="top">
                <div id="marketlist_wrapper" class="dataTables_wrapper" role="grid">
                    <table class="marketlist dataTable" id="tradelist" cellspacing="0" cellpadding="0">
                        <tbody role="alert" aria-live="polite" aria-relevant="all">
                        <tr>
                            <td class="no-wrap alignRight" style=" width:100%;border:none">
                                <div id="wrapper-250">
                                    <ul class="accordion">
                                        <li id="adn1" class="files"> <a href="#one">我的资金<span class="umicon"></span></a>
                                            <ul class="sub-menu">
                                                <li><a data-id='myfunds' href="/myaccount/myfunds">帐户资金</a></li>
                                                <!--
                                                <li><a data-id='interest' href="/myaccount/interest">每日利息</a></li>
                                                <li><a data-id='dividend' href="/myaccount/dividend">我的分红</a></li>
                                                -->
                                                <li><a data-id='myreferrals' href="/myaccount/myreferrals">推广佣金</a></li>
                                                <li><a data-id='mypurselog' href="/myaccount/mypurselog">账单明细</a></li>
                                            </ul>
                                        </li>

                                        <li id="adn2" class="cloud"> <a href="#one">交易挂单<span class="umicon"></span></a>
                                            <ul class="sub-menu">
                                                <li><a data-id='myorders' href="/myaccount/myorders">我的挂单</a></li>
                                                <li><a data-id='myhistory' href="/myaccount/myhistory">成交记录</a></li>
                                                <li><a data-id='myc2chistory' href="/myaccount/myc2chistory">C2C成交记录</a></li>
                                            </ul>
                                        </li>

                                        <li id="adn3" class="mail"> <a href="#two">充值提现<span class="umicon"></span></a>
                                            <ul class="sub-menu">
                                                <li class="hot-item"><a data-id='usdt_cny' href="/c2c/usdt_cny">购买USDT(C2C)</a></li>
                                                <li class="hot-item"><a data-id='usdt_cny' href="/c2c/usdt_cny">点对点充值提现(C2C)</a></li>
                                                <li><a data-id='deposit_coin' href="/myaccount/myfunds?coin_deposit#wallet">数字货币充值</a></li>
                                                <li><a data-id='withdraw_coin' href="/myaccount/myfunds?coin_withdraw#wallet">数字货币提现</a></li>
                                                <li><a data-id='deposit_gatecode' href="/myaccount/deposit_gatecode">充值码</a></li>
                                                <li><a data-id='mydeposits' href="/myaccount/mydeposits">最近充值记录</a></li>
                                                <li><a data-id='mywithdrawals' href="/myaccount/mywithdrawals">最近提现记录</a></li>
                                                <li><a data-id='lockbook' href="/myaccount/lockbook">领“糖果”（分叉币提前领）</a></li>


                                            </ul>
                                        </li>

                                        <li id="adn4" class="sign"> <a href="#two">安全设置<span class="umicon"></span></a>
                                            <ul class="sub-menu">
                                                <li><a data-id='id_setup' href="/myaccount/id_setup">身份认证</a></li>
                                                <li><a data-id='id_setup2' href="/myaccount/id_setup2">高级认证</a></li>
                                                <li><a data-id='totp' href="/myaccount/totp">谷歌验证器绑定</a></li>
                                                <li><a data-id='sms_setup' href="/myaccount/sms_setup">手机绑定</a></li>
                                                <li><a data-id='login2_setup' href="/myaccount/login2_setup">两步登录保护</a></li>
                                                <li><a data-id='apikeys' href="/myaccount/apikeys">API Keys</a></li>
                                                <li><a data-id='resetpw' href="/resetpw">修改登录密码（自动登出）</a></li>
                                                <li><a data-id='resetfpw' href="/resetfpw">修改资金密码（自动登出）</a></li>
                                                <li><a data-id='email_setup' href="/myaccount/email_setup">邮箱绑定</a></li>
                                                <li><a data-id='payment_setup' href="/myaccount/payment_setup">支付设置</a></li>
                                                <li><a data-id='mylogs' href="/myaccount/mylogs">安全日志</a></li>
                                                <li><a data-id='notify' href="/myaccount/notify">通知设置</a></li>
                                            </ul>
                                        </li>

                                        <li id="adn4" class="sign"> <a href="#two">我的工单<span class="umicon"></span></a>
                                            <ul class="sub-menu">
                                                <li><a data-id='ticket' href="/myaccount/tickets">提交工单</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </td>
        </tr>
        </tbody>
    </table>

<sitemesh:write property='body'/>

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
                    <span> USDT : $<span id="usdtAll">133618084</span> </span>
                    <span> BTC : ฿<span id="btcAll">660</span> </span>
                    <span> LTC : Ł<span id="ltcAll">2418</span> </span>
                    <span> ETH : E<span id="ethAll">31992</span> </span>
                </div>
                <span id="runTime">
                <!--<a href="#">gate.io</a> is powered by <a href="#">gate.io Dev Team</a>-->
                <span class="admin-view"> Elapsed:39.223ms - cnst:9.2;14:0.3;12:0.3;13:1.6; .234 &nbsp; a/e/r </span>
            </span>
            </div>
        </div>
    </div>
</body>
</html>
