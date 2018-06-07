function ticketsRoute() {
	is_login ? location.href = "/myaccount/tickets" : noty({
		text: "<div class='n-con'>" + lang_string("请登录后再提交工单。如果无法登录，请发送邮件到") + " <a href='mailto:support@mail.gate.io' target='_blank'>support@mail.gate.io</a> " + lang_string("联系我们") + ' !</div><button class=\'btn btn-long\' id=\'button-0\' onclick=\'if(window.location.pathname != "/login"){location.href="/login"} else {$.noty.close("login_noty");$("#email").focus()}\'>' + lang_string("立即登录") + "</button>",
		type: "warning",
		id: "login_noty",
		layout: "center",
		closeWith: ["button"],
		theme: "gateioNotyTheme",
		modal: !0
	})
}
$(function() {
	var t = $("#ProgressBar").width(),
		o = $("#topLoginBar"),
		i = $("#tierMenu"),
		e = $("#pbCon"),
		a = e.find("i"),
		s = $("#proBar"),
		n = $("#fproBar"),
		r = tier_next_progress;
	o.hover(function() {
		i.stop().slideDown(200), $(this).stop().css("color", "#f80"), a.css("opacity", "0"), s.animate({
			width: r + "%"
		}, 800)
	}, function() {
		i.stop().slideUp(100), $(this).stop().css("color", "#fff"), a.css("opacity", "1"), s.css("width", "0")
	}), i.css("width", t), n.animate({
		width: r + "%"
	}, 800), r > 0 && n.addClass("has-pro-val"), $.fn.animateProgress = function(t, o) {
		return this.each(function() {
			$(this).animate({
				width: t + "%"
			}, {
				duration: 800,
				easing: "swing",
				step: function(t) {
					$(".value").text(Math.ceil(t) + "%")
				},
				complete: function(t, i, e) {
					o && o.call(this, i, e)
				}
			})
		})
	}, "" == r ? e.animateProgress(0) : e.animateProgress(r);
	var l = $(".leftbar"),
		c = $(".main_content"),
		d = l.height(),
		h = c.height();
	d < h && l.css("height", h), $("#siteNoty").on("click", "a", function() {
		var t = $("#siteNotyCon").text();
		$.cookie("notice", t, {
			expires: 365,
			path: "/",
			secure: !0
		}), $("#siteNoty").hide()
	});
	var p, u = $("#veriCon");
	p = $('<span class="backToTop"></span>'), 1 == u.length ? p.appendTo(u).css({
		position: "absolute",
		top: "-45px",
		bottom: "auto"
	}) : p.appendTo($(".footer")), p.text("^").click(function() {
		$("html, body").animate({
			scrollTop: 0
		}, 500)
	}), $backToTopFun = function() {
		var t = $(document).scrollTop();
		$(window).height(), t > 0 ? p.show() : p.hide()
	}, $(window).bind("scroll", $backToTopFun), $(function() {
		$backToTopFun()
	})
}), $("#theme").find("li").click(function() {
	var t = $(this).attr("id"),
		o = $("#darkStyle,#fs_dark");
	if("light" == t) o.attr("disabled", "disabled"), $("#lightChart").click(), $("#tradelist").removeClass("dark-tradelist"), $("body").removeClass("dark-body");
	else {
		var i = $("#fs_dark");
		null == $("#darkStyle").attr("id") && "" == i.attr("href") && i.attr("href", "/css/theme_dark.css"), o.removeAttr("disabled"), $("#darkChart").click(), $("#tradelist").addClass("dark-tradelist"), $("body").addClass("dark-body")
	}
	$.cookie("mystyle", t, {
		expires: 30,
		path: "/"
	}), $(this).addClass("cur-theme").siblings().removeClass("cur-theme"), $("#marketlistTabCon").find("tbody").find("tr").attr("style", "")
});
var cookie_style = $.cookie("mystyle");
"light" == cookie_style || void 0 === cookie_style ? $("#light").addClass("cur-theme") : ($("#dark").addClass("cur-theme"), $("#tradelist").addClass("dark-tradelist"));