<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的账号 - Gate.io - The Gate of Blockchain Assets Exchange</title>
    <meta name="description" content="网址是 Gate.io， 是一个区块链数字资产交易平台，支持比特币Bitcoin, 以太坊, Ethereum,莱特币, Litecoin，Qtum 等币种交易，其特点是快捷，安全。 ">
    <meta name="keywords" content="比特币, bitcoin, BTC, Ethereum, 以太坊, litecoin, LTC, ETC, Qtum, 代币, ICO, 交易平台，交易网站，比特币交易，比特币兑换，比特币市场 ">
    <meta name="format-detection" content="telephone=no">
    <!--[if lte IE 9]><script type="text/javascript">location.href = '/update.html';</script><![endif]-->
    <link href="/css/style.css?v=1526375818" rel="stylesheet" type="text/css">
    <style>.icon-48,.icon-32,.icon-16{background-image:url("images/coins48.png?v=1526551416")}</style>
    <link href="/css/coins_16.css?v=1526551416" rel="stylesheet" type="text/css">
    <link href="/css/coins_32.css?v=1526551416" rel="stylesheet" type="text/css">
    <link href="/css/coins_48.css?v=1526551416" rel="stylesheet" type="text/css">
                    
                                <link href="/css/theme_dark.css?0517" rel="stylesheet" type="text/css" id="darkStyle" disabled="disabled">
                
                    
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
    <script src="/js/jquery-1.8.2.min.js"></script>
    <script src="/js/jquery.common.tools.js?v=0207"></script>
</head>
<body class="">


<script type="text/javascript">
	$(function() {
		$(".accordion").children("li").find("a").click(function () {
			$(this).toggleClass("menu-hide").next("ul").toggle();
			var lb = $(".leftbar"), mc = $(".main_content"), lh = lb.height(), mh = mc.height();
			lb.css("height", mh)
		});

		var icoType='';
		if(icoType==''){
			$("#buyIco").parent("li").remove()
		}
		
		$("input").focus(function(){
			$(".failed").html("")
		});

		$(".files,.cloud,.mail").find("li").click(function () {
			$.cookie('nav_index', 3,{ path: '/' });
		});
		$(".sign").find("li").click(function () {
			$.cookie('nav_index', 4,{ path: '/' });
		});

		//左菜单active标识
		var url=window.location.href,
			pagename=url.split('nt/')[1];
		$('a[data-id="'+pagename+'"]').addClass("mactive");
		if(url.indexOf('?coin_withdraw') > -1 || url.indexOf('aw/') > -1){
			$('a[data-id=withdraw_coin]').addClass("mactive");
		} else if(url.indexOf('?coin_deposit') > -1 || url.indexOf('it/') > -1){
			$('a[data-id=deposit_coin]').addClass("mactive");
		}
		if(url.indexOf('totp/') > -1){
			$('a[data-id=totp]').addClass("mactive");
		}

		/*$(window).scroll(function () {
			var scrH=$(window).scrollTop();var accHeight=$(".myacc-con").height();
			if(accHeight>834) {
				if (scrH > 100) {
					if(scrH > accHeight-721) {
						$("#marketlist_wrapper").css({"position": "absolute", "top": "", "bottom": "10px", "width": "100%"});
					} else {
						$("#marketlist_wrapper").css({"position": "fixed", "top": "10px", "bottom": "", "width": "22%"});
					}
				} else {
					$("#marketlist_wrapper").attr("style", "");
				}
			}
		});*/
	});
</script>
	<div class="main_content acc-m-con">
				<div class='right_mcontent myacc-con'>
	   

	
		
		
			<style>
    .js-copy1,.js-copy2{ margin: 20px 0; display: inline-block}
    .ref-ul li{ width: 50%; float: left; text-align: center; margin: 20px 0 0; box-sizing: border-box}
    .ref-ul li:first-child{border-right: 1px solid #ddd; position: relative}
    .ref-ul li:first-child:after{content: '\6216'; display: inline-block; position: absolute; right: -8px; top:46%; background: #fff; padding: 5px 0; color: #888}
    .ref-ul input{ display: inline-block; text-align: center; font-size: 20px; padding: 0; border: none; font-weight: bold}
    .ref-ul .sub-btn {padding: 10px 33px;}
    .sf-grid td {padding: 12px 0;}
    .QrCode{ cursor: pointer}
    .QrCode p{ padding-top: 0;}
    .QrCode:hover{color: #de5959;}
    .QrCode:hover img{opacity: 0.8}
    .dark-body .ref-ul li:first-child{border-color: #343a48;}
    .dark-body .ref-ul li:first-child:after,.dark-body .ref-ul input{ background: #131a21}
</style>
<div class="m_title"><h4>我的推广链接</h4></div>
<div class="sectioncont">
    <div style="text-align: center">
        <p>通过以下链接推荐其他用户访问本站并注册，您可以获得被推荐用户一年内交易手续的 <span class=red><strong>30%</strong></span> 作为佣金，被推荐用户享受一年内交易费<span class=red><strong> 9折 </strong></span>优惠。</p>
        <p>注：推荐用户跟本人账户IP地址相同的推荐无效，新注册1天内的帐号推荐别人无效。</p>
    </div>
    <ul class="ref-ul clearfix">
        <li id="toSignIn">
            <p>推荐到gate.io注册页面的链接：</p>
            <input type="text" value="https://gateio.io/signup/1581772" readonly>
            <div>
                <span class="js-copy1" data-clipboard-text="https://gateio.io/signup/1581772">
                    <span class="sub-btn">点击复制</span>
                </span>
            </div>
            <p class='copytip c-tip1 green'>复制成功，现在您可以去您的社交媒体粘贴了</p>
            <div class="clearfix">
                <span id="toSignInCode" class="QrCode">
                    <img class="QrCodeImg" src="/libs/qr.php?d=https://gateio.io/signup/1581772" alt="QR code" style="width: 160px; height: 160px"/>
                    <p>点击保存二维码，去您的社交媒体推广</p>
                </span>
            </div>
        </li>
        <li id="toIndex">
            <p>推荐到gate.io首页的链接：</p>
            <input type="text" value="https://gateio.io/ref/1581772" readonly>
            <div>
                <span class="js-copy2" data-clipboard-text="https://gateio.io/ref/1581772">
                    <span class="sub-btn">点击复制</span>
                </span>
            </div>
            <p class='copytip c-tip2 green'>复制成功，现在您可以去您的社交媒体粘贴了</p>
            <div class="clearfix">
                <span class="QrCode">
                    <img class="QrCodeImg" src="/libs/qr.php?d=https://gateio.io/ref/1581772" alt="QR code" style="width: 160px; height: 160px"/>
                    <p>点击保存二维码，去您的社交媒体推广</p>
                </span>
            </div>
        </li>
    </ul>
    <div class="ref-way">
        <h4>推广方法：</h4>
        <p>1. 复制以上任一推广链接，或者下载保存以上二维码，去您的社交媒体推广，让您的朋友们通过此链接访问本站并注册。</p>
        <p>2. 移动端扫码以上二维码，并把打开的gate.io页面分享到您的社交媒体。如微信，扫码以上二维码后，在打开的gate.io页面，点击微信右上角菜单，在弹窗的对话框中，点击发送给朋友、分享到朋友圈、分享到手机QQ或者分享到QQ空间即可。</p>
    </div>
</div>

<div class="m_title"><h4>最近接受推荐的用户</h4></div>
<div class="sectioncont">
    <div id="divMyReferralsList" style="overflow-y: scroll; overflow-x:hidden; max-height: 550px;">
        <table class='sf-grid' id="refUser">
            <thead>
            <tr>
                <td align='center' width="200px"><b>注册日期</b></td>
                <td align='center'><b>用户名</b></td>
            </tr>
            </thead>
                        <tr class="table-empty">
                <td colspan="2" style="text-align: center"><p><i>i</i>暂无有效推荐用户</p></td>
            </tr>
        </table>
    </div>

    <br>
    <p>我的有效推荐用户个数为：<font color=red><strong>0</strong></font></p>

</div>


<div class="m_title"><h4>我的最近30天佣金</h4></div>
<div class="sectioncont">
    <div id="divMyReferralFundsList" style="overflow-y: scroll; overflow-x:hidden; max-height: 550px;">
        <table class='sf-grid' id="refFund">
            <thead>
            <tr>
                <td align='center' width="200px"><b>类型</b></td>
                <td align='right' width="200px"><b>金额</b></td>
                <td align='right'><b>笔数</b></td>
            </tr>
            </thead>
                            <tr class="table-empty">
                    <td colspan="3" style="text-align: center"><p><i>i</i>暂无佣金</p></td>
                </tr>
        </table>
    </div>

</div>
<script src="/js/clipboard.min.js"></script>
<script>
    //复制
    var clipboard1 = new Clipboard('.js-copy1'),clipboard2 = new Clipboard('.js-copy2');
    clipboard1.on('success', function(e) {
        $(".c-tip1").show();
        $(".c-tip2").hide();
        setTimeout(function () {
            $(".c-tip1").hide();
        },6000)
    });
    clipboard2.on('success', function(e) {
        $(".c-tip2").show();
        $(".c-tip1").hide();
        setTimeout(function () {
            $(".c-tip2").hide();
        },6000)
    });

    var $user=$("#refUser"), $fund=$("#refFund");
    if($user.find("tr").size() == 2){
        $user.find(".table-empty").show()
    }
    if($fund.find("tr").size() == 2){
        $fund.find(".table-empty").show()
    }

    window.downloadFile = function (sUrl,isSign) {

        //iOS devices do not support downloading. We have to inform user about this.
        if (/(iP)/g.test(navigator.userAgent)) {
            alert('Your device does not support files downloading. Please try again in desktop browser.');
            return false;
        }

        //If in Chrome or Safari - download via virtual link click
        if (window.downloadFile.isChrome || window.downloadFile.isSafari) {
            //Creating new link node.
            var link = document.createElement('a');
            link.href = sUrl;

            if (link.download !== undefined) {
                //Set HTML5 download attribute. This will prevent file from opening if supported.
                var fileName = 'gateio';
                if(isSign)
                    fileName = 'gateio注册';
                else
                    fileName = 'gateio首页';
                link.download = fileName;
            }

            //Dispatching click event.
            if (document.createEvent) {
                var e = document.createEvent('MouseEvents');
                e.initEvent('click', true, true);
                link.dispatchEvent(e);
                return true;
            }
        }

        // Force file download (whether supported by server).
        if (sUrl.indexOf('?') === -1) {
            sUrl += '?download';
        }
        window.open(sUrl, '_self');
        return true;
    };

    window.downloadFile.isChrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
    window.downloadFile.isSafari = navigator.userAgent.toLowerCase().indexOf('safari') > -1;
    
    $(".QrCode").click(function () {
        var imgurl=$(this).find("img").attr("src"), qcId=$(this).attr("id"), isSign=0;
        if(qcId == 'toSignInCode')
            isSign=1;

        downloadFile(imgurl,isSign)
    });

    $(".ref-ul").on("click","input",function () {
        $(this).select()
    })
</script>


		<br />
	</div> <!-- right_mcontent -->
  </div> <!-- main content -->

 
</div>
<script>
	//ҳ��߶�
	setTimeout(function () {
		var lb=$(".leftbar"), mc=$(".main_content"),lh=lb.height(),mh=mc.height();
		if (lh < mh){lb.css("height",mh)}
	},200)
</script>

<%--
<div class="veri-dmove">
	
	<div class="veri-dmove_gg">
		<div class="veri-dmove_rz_text">
			<span class="n-link" onclick=location.href="/c2c/usdt_cny"><em>★ 提示：您有C2C订单(单号 )未付款(非自动扣款)，如已付款请点击“我已付款”。超过30分钟系统将自动取消订单。多次恶意取消将限制C2C交易。</em><span class=r-btn>View Now</span></span>		</div>
		<a class="close pull-right" href=javascript:$(".veri-dmove_gg").hide();></a>
	</div>
		
</div>
	--%>

<script>
        //force user to use https
       // if ('https:' != document.location.protocol) { window.location = 'https://' + window.location.hostname + window.location.pathname; }
    
    //for footer
    var tier_next_progress='0.0';
   
    $("#usdtAll").text(toThousands(130194484));
    $("#btcAll").text(toThousands(656));
    $("#ltcAll").text(toThousands(2768));
    $("#ethAll").text(toThousands(31361));
    is_login='zuoyehengudan' != '';
</script>
<script src="/js/footer.js?v=0420"></script>

</body>
</html>


