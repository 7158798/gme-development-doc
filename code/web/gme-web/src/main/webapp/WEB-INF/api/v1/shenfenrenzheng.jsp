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
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/jquery.common.tools.js?v=0207"></script>
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
            .formbox { width:80%;min-height: 200px;  margin:0 auto;border:1px ;min-width:600px;}
            .formbox form{ width: 33.33%; float: left; margin:0 0 10px;}
            .formbox table{ width:100%;border-spacing: 5px;}
            .formbox table th { line-height: 26px; padding:0 0 5px; vertical-align: top; width: 150px; border: none; font-size: 16px; font-weight: normal;}
            .formbox .sfz {
                position: relative;
                overflow: hidden;
                text-align: center;
                float: left;
                padding: 20px;
                min-height: 450px;
                /*display: -webkit-flex;*/
                /*display: flex;*/
                /*justify-content:center; 主轴方向居中对齐*/
                /*align-items: center;*/
            }
            .formbox .sfz-img {  overflow: hidden; }
            .formbox .sfz-img img {  height: auto; width:100% ;/*max-width:330px;*/ margin-top:115px;}
            .dark-body .formbox .sfz{ background: #bebebe;}
            .dark-body .formbox .sfz-img img{-webkit-filter: brightness(.75);filter: brightness(.75);}
            .dark-body .formbox tr td{ border-color: #c1c1c1}
            .formbox select {border: 1px solid rgb(204, 204, 204);padding:0 5px;border-radius: 3px;height:30px;}
            .formbox option {padding: 4px 7px;border-bottom:1px dashed #eee;}
            .myacc-con .sectioncont p{ margin-bottom: 0}
            .formbox  .file { position: absolute; top: 0; left: 0; z-index:3; height: 100%; width:100%;overflow: hidden;line-height: 120px; filter: alpha(Opacity=1); -moz-opacity: 0.01; opacity: 0.01; cursor: pointer; }
            .formbox tr td{border: 1px solid #d3dde6  !important;}
            .id-info-table tr td:first-child{ width:140px}
            .sfz{ position:relative}
            .sfz i{
                position: absolute;
                right: 0;
                bottom: 0;
                width: 24px;
                height: 24px;
                line-height: 24px;
                background: #44d5bc;
                color: #fff;
            }
            .sfz b{
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
            }
            .sfz-cover{ width:100%; height:100%; position:absolute;top:0;left:0; background:rgba(0,0,0,0.6); z-index:-1; opacity:0;/*display: flex;*/  /*align-items: center; */ justify-content: center;}
            .sfz:hover .sfz-cover { opacity:1; z-index:2 }
            .sectioncont .upfile-btn{ margin:50% auto;background: #0c9c83;}
            .re-btn{ padding:10px 20px; border:1px solid #ddd; display: inline-block; margin-left: 5px}
            #reset-form{ width:100%;margin-top: 0}
            .s-title{ margin-top: 20px}
            .s-title i{ color: #fa0; font-size: 24px;position: relative; margin-right: 30px}
            .s-title i:after{content:"";display:inline-block;height:50px;width:1px;background:#fa0;margin-right:10px;position:absolute;left:20px;top:0;transform:rotate(35deg);}
        </style>





        <div class="m_title"><h4>用户信息实名登记</h4></div>
        <div class="sectioncont">
            <p>您的用户信息已经成功登记!!!!!!</p>
            <p>点击<a href="/myaccount/id_setup2">这里</a>进行更高级认证!</p>

        </div>



        <script type="text/javascript">

            $(document).ready(function() {

                $(".kyc.form").on("change", ".file", function(){
                    $(this).parents("form").trigger("submit");
                });
            });


            function  OnResetUpload() {

                noty({
                    text: '是否重新上传',
                    type: 'confirm',
                    layout: 'bottomLeft',
                    theme: 'gateioNotyTheme',
                    modal: true,
                    animation: {
                        open: {height: 'toggle'},
                        close: {height: 'toggle'},
                        easing: 'swing',
                        speed: 100 // opening & closing animation speed
                    },
                    buttons: [
                        {
                            addClass: 'btn btn-primary dp-noty-btn', text: '确定', onClick: function ($noty) {

                                document.getElementById('reset-form').submit();
                                $noty.close();
                                return true;
                            }
                        },
                        {
                            addClass: 'btn btn-danger dp-noty-btn', text: '关闭', onClick: function ($noty) {
                                $noty.close();
                                return false;
                            }
                        }
                    ]
                });
            }

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
    //  if ('https:' != document.location.protocol) { window.location = 'https://' + window.location.hostname + window.location.pathname; }

    //for footer
    var tier_next_progress='0.0';

    $("#usdtAll").text(toThousands(132872908));
    $("#btcAll").text(toThousands(652));
    $("#ltcAll").text(toThousands(2381));
    $("#ethAll").text(toThousands(31911));
    is_login='zuoyehengudan' != '';
</script>
<script src="/js/footer.js?v=0420"></script>

</body>
</html>


