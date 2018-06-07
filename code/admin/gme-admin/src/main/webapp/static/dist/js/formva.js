(function($, window, document, undefined) {
    var defaults = {
            content  : null,    // String   工具提示的内容
            maxWidth : 200,     // Number   工具提示的最大显示宽度
            position : "top",   // String   工具提示显示的方位
            trigger  : "hover", // String   触发工具提示的事件类型
            zIndex   : 9999,    // Number   工具提示的层级
            space    : 10       // Number   工具提示离触发元素的间距
        },

        Tooltip = function(ele, opt) {
            this.element = ele;
            this.contents = {};   //contents.contEle 存放tooltip
            this.options = $.extend({}, defaults, opt);
        },

        vstopPropagation = function(a) {
            if (a && a.stopPropagation) a.stopPropagation();
            else if (window.event) window.event.cancelBubble = true
        },

        vpreventDefault = function(b) {
            var a = b ? b : window.event;
            if (a.preventDefault) a.preventDefault();
            else if (a) a.returnValue = false
        },

        getHighestIndex = function() {
            var highestIndex = 0,
                currentIndex = 0,
                el = [];
            el = document.getElementsByTagName("div");
            for (var i = 0; i < el.length; i++) {
                if (el[i].currentStyle) {
                    currentIndex = parseFloat(el[i].currentStyle["zIndex"]);
                } else if (window.getComputedStyle) {
                    currentIndex = parseFloat(document.defaultView.getComputedStyle(el[i], null).getPropertyValue("z-index"));
                }
                if (!isNaN(currentIndex) && currentIndex > highestIndex) {
                    highestIndex = currentIndex;
                }
            }
            return highestIndex;
        };

    Tooltip.prototype = {
        init: function(target,p) {
            var opt = this.options,
                self = this;
            if (opt.trigger == "hover") {
                var eventIn = opt.trigger == "hover" ? "mouseenter" : "focus",
                    eventOut = opt.trigger == "hover" ? "mouseleave" : "blur";
                $(target).on(eventIn, function() {
                    self.open(target);
                });
                $(target).on(eventOut, function() {
                    self.close(target);
                });
            } else if (opt.trigger == "click") {
                $(target).on(opt.trigger, function(e) {
                    self.open(target);
                    //e.preventDefault();
                    vpreventDefault(e);
                });
            } else {
            	if(p){
            		self.open(target,p)
            	}else{
            		self.open(target);
            	}
            }
        },

        open: function(target,p) {
            var self = this,
                elem = $(target),
                opt = this.options,
                content = opt.content || elem.attr("data-title");
            if (content === undefined) {
                content = elem.attr("title");
                if (content === undefined) {
                    return;
                }
                elem.removeAttr("title").attr("data-title", content);
            }
            self.contents.contEle = self.createTip(content);
            if (p) {
            	self.contents.contEle.appendTo($("body",window.parent.document))
            } else {
            	self.contents.contEle.appendTo(document.body);
            }
            self.setStyle(self.contents.contEle);
            self.setPosition(elem, self.contents.contEle);
        },

        close: function(ele) {
            $(ele).off(this.options.trigger);
            $(this.contents.contEle).remove();
            this.contents.contEle = null;
        },

        createTip: function(content) {
            var contentTmp = $('<div class="cui-tooltip"><div class="cui-tooltip-wrap"><div class="cui-tooltip-arrow"></div><a href="javascript:;" class="cui-tooltip-close" title="关闭">&times;</a><div class="cui-tooltip-content">'+content+'</div></div></div>');
            return contentTmp;
        },

        setPosition: function(target, ele) {
            var self = this,
                element = $(ele),
                eh = element.outerHeight(true),
                ew = element.outerWidth(true),
                el = target.offset().left,
                et = target.offset().top,
                ow = target.width(),
                oh = target.height(),
                left = el - ew / 2 + ow / 2,
                top = et - eh / 2 + oh / 2;
            switch (self.options.position) {
                case "top":
                    top = et - eh - self.options.space;
                    break;
                case "bottom":
                    top = et + oh + self.options.space;
                    break;
                case "right":
                    left = el + ow + self.options.space;
                    break;
                case "left":
                    left = el - ew - self.options.space;
                    break;
                default:
                    break;
            }

            element.css({
                position: "absolute",
                zIndex: Math.max(this.options.zIndex, getHighestIndex() + 1),
                left: left + "px",
                top: top + "px",
                visibility: ""
            }).show();
        },

        setStyle: function(ele) {
            var self = this,
                element = $(ele),
                arrowElem = element.find(".cui-tooltip-arrow"),
                btnClose = element.find(".cui-tooltip-close"),
                wrapElem = element.find(".cui-tooltip-wrap");
            switch (self.options.position) {
                case "top":
                    arrowElem.addClass("tooltip-arrow-top");
                    break;
                case "bottom":
                    arrowElem.addClass("tooltip-arrow-bottom");
                    break;
                case "right":
                    arrowElem.addClass("tooltip-arrow-right");
                    break;
                case "left":
                    arrowElem.addClass("tooltip-arrow-left");
                    break;
                default:
                    arrowElem.addClass("tooltip-arrow-top");
                    break;
            }

            if (self.options.trigger !== "mouseenter" && self.options.trigger !== "hover") {
                wrapElem.css("padding-right", "25px");
                btnClose.css("display", "block").on("click", function(e) {
                    self.close(element);
                    //e.preventDefault();
                    vpreventDefault(e);
                });
            } else {
                wrapElem.css("padding-right", "10px");
                btnClose.css("display", "none").off("click");
            }

            // 关键点：设置tooltip有布局但不显示
            element.css({
                visibility: "hidden",
                display: "block"
            });

            wrapElem.css({
                width: "",
                display: "inline-block"
            });

            var wrapWidth = wrapElem.width();
            wrapWidth = Math.min(self.options.maxWidth, wrapWidth);

            // 设置合适的宽度
            wrapElem.css("width", wrapWidth + "px");
        }

    };

    $.fn.tooltip = function(opt) {
        if(this.length > 0){
            return this.each(function() {
                var tooltip = new Tooltip(this, opt);
                tooltip.init(this);
            });
        }
    };

    if (!window.fui) {
        fui = window.fui = {};
    }

    fui.Tooltip = Tooltip;

})(jQuery, window, document);

(function($, window, document, undefined) {
    'use strict';

    var FormValidate = function(ele,opt){
    	var defaults = {
    		"0":"该项文字不能少于",
    		"1":"该项文字不能多于",
    		"2":"该项是必填项",
    		"3":"该项不能包含特殊字符",
    		"4":null, //输入正确!
    		"5":"您输入的手机号不正确!",
    		"6":"您输入的邮箱格式不正确!",
    		"7":"您输入的QQ号不正确!",
    		"e":"input",   //验证的控件
    		"parentwindow":null,  //父级窗口 jquery对象
    		"min":1,    //最少字数
    		"max":120   //最多字数
    	};
    	this.submitBtn = null; //提交的按钮ID
        this.options = $.extend({}, defaults, opt);
    };

    FormValidate.prototype = {
    	fvTip:function(target,tipWords){
    		console.log("content::"+tipWords);
    		console.log("target::"+target.val());
    		var tooltip = new fui.Tooltip(target, {
		    	trigger	: "none",
		    	position: "right",
		    	content : tipWords,
		    	space   : 2
		    });
		    return tooltip;
    	},
    	fvStrLen: function(str,min,max){
			var self = this,
				minL = min || self.options["min"],
				maxL = max || self.options["max"],
				strL= trim(str,2).length;
			if (containSpecial($.trim(str))){
				return this.options["3"];
			} else {
				if (strL < minL) {
					return self.options["0"]+minL+"字!";
				} else if (strL > maxL) {
					return self.options["1"]+maxL+"字!";
				} else {
					return self.options["4"];
				}
			}
			
		},
		fvCellPhone:function(str){

			if (!isCellphone($.trim(str))) {
				return this.options["5"];
			}
			return this.options["4"];
		},
		fvContainSpecial:function(str){
			if (!containSpecial($.trim(str))){
				return this.options["3"];
			}
			return this.options["4"];
		},
		fvEmail:function(str){
			if (!isEmail($.trim(str))){
				return this.options["6"];
			}
			return this.options["4"];
		},
		fvQq:function(str){
			if (!isQQ($.trim(str))){
				return this.options["7"];
			}
			return this.options["4"];
		},
		setTipWords:function(dataFormValidate,val,min,max){
			var self = this,tipWords;
	    	if (dataFormValidate == "email") {
	    		tipWords = self.fvEmail(val);
	    	}else if(dataFormValidate == "cellphone"){
	    		tipWords = self.fvCellPhone(val);
	    	}else if(dataFormValidate == "string"){
	    		tipWords = self.fvStrLen(val,min,max);
	    	}else if(dataFormValidate == "qq"){
	    		tipWords = self.fvQq(val);
	    	}else{
	    		tipWords = null;
	    	}
	    	console.log("OOPPPPPPPP::"+tipWords);
	    	return tipWords;
	    },
		init:function(ele,e){
			var opt = this.options,
				element = $(ele),
				submitBtn = $(this.submitBtn),
                self = this,
                tipWords = null,
                requied = element.attr('requied'),
                min = parseInt(element.attr('data-minlength')),
                max = parseInt(element.attr('data-maxlength')),
                dataFormValidate = element.attr('data-vtype') || null,  //如果data-vtype为空值或者为null值，则不需验证
                parent = self.options["parentwindow"],
                tipShow = null;
            submitBtn.attr('disabled', 'disabled');
            console.log("data-vtype:::"+element.attr('data-vtype'));
            if (parent) {
            	var e = parent.find(element);
				e.on("change",function() {
					var val = $(this).val();
					/*if (requied) {
		            	tipWords = self.options["2"];
		            }*/
		            //tipWords = self.setTipWords(dataFormValidate,tipWords,val,min,max);
		            tipWords = self.setTipWords(dataFormValidate,val,min,max);
					if ($.trim(val) != "" || tipWords) {
						tipShow = self.fvTip(e,tipWords);
	            		tipShow.init(e,true);
					}
	            	
	            });
	            e.on("focus",function() {
	            	if (tipShow) {
	            		tipShow.close(e);
	            		tipShow = null;
	            	}
	            });
            } else {
	            element.on("change",function() {
	            	var val = $(this).val();
	            	//tipWords = self.setTipWords(dataFormValidate,tipWords,val,min,max);
	            	tipWords = self.setTipWords(dataFormValidate,val,min,max);
	            	if ($.trim(val) != "" || tipWords) {
						tipShow = self.fvTip(element,tipWords);
	            		tipShow.init(element);
					}
	            });
	            element.on("focus",function() {
	            	if (tipShow) {
	            		tipShow.close(element);
	            		tipShow = null;
	            	}
	            });
	        }    
    	},

    };

    $.fn.formValidate = function(opt) {
        if(this.length > 0){
            return this.each(function() {
                var formValidate = new FormValidate(this, opt);
                formValidate.init(this);
            });
        }
    };

})(jQuery, window, document);

function toJSON(obj){
	//Object 转换为json 
	/*
		var contact = {};
		contact.firstname = "Jesper";
		contact.surname = "Aaberg";
		contact.phone = ["555-0100", "555-0120"];
		toJSON(contact);
	*/
    var replacement = {};
    for (var val in obj) {
        replacement[val] = obj[val];
    }
    replacement = JSON.stringify(replacement);
    return replacement;
}

function isIP(str) {
	/**
     *
     * @descrition:判断是否是合理的IP地址
     * @param:str->待验证的IP地址
     * @return :true合理的IP地址
     * 
     */
    var pattern = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    return pattern.test(str);
}
function isPostcode(str) {
    //国内邮编以0-8开头的6为数字
    var pattern = /^[0-8]\d{5}$/;
    return pattern.test(str);
}
function isQQ(str) {
    /**
    *@descrition:规则
    * 1-9开头，最少5位。
    */
    var pattern = /^[1-9][0-9]{4,}$/
    return pattern.test(str);
}
function isCellphone(str) {
    /**
    *@descrition:手机号码段规则
    * 13段：130、131、132、133、134、135、136、137、138、139
    * 14段：145、147
    * 15段：150、151、152、153、155、156、157、158、159
    * 17段：170、176、177、178
    * 18段：180、181、182、183、184、185、186、187、188、189
    * 
    */
    var pattern =  /^(13[0-9]|14[57]|15[012356789]|17[0678]|18[0-9])\d{8}$/;
    return pattern.test(str);
}
function isfixedphone(str) {
    /**
    *
    * @desctition:规则->区号3-4位，号码7-8位,可以有分机号，分机号为3-4为，格式如下："0775-85333333-123"
    * 
    */
    var pattern =  /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
    return pattern.test(str);
}
function isEmail(str){
    /**
    * @descrition:邮箱规则
    * 1.邮箱以a-z、A-Z、0-9开头，最小长度为1.
    * 2.如果左侧部分包含-、_、.则这些特殊符号的前面必须包一位数字或字母。
    * 3.@符号是必填项
    * 4.右则部分可分为两部分，第一部分为邮件提供商域名地址，第二部分为域名后缀，现已知的最短为2位。最长的为6为。
    * 5.邮件提供商域可以包含特殊字符-、_、.
    */
    var pattern = /^([a-zA-Z0-9]+[-_.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[-_.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,6}$/;
    return pattern.test(str);
}
function containSpecial(str){
	//检测特殊字符/^.*[\~\!\#\$\%\^\&\*\(\)\+\=\`\{\}\[\]\:\"\|\;\'\\\<\>\?\,\.\/\x20].*$/;
	var reg = /^.*[\￥\~\!\#\$\%\^\&\*\(\)\+\=\`\{\}\[\]\:\"\|\;\'\\\<\>\?\,\.\/].*$/;
	return reg.test(str);
}

function isPassword(str){
	//var reg = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
	var reg = /^[a-zA-Z0-9\!\@\#\$\%\^\&\*\.\-\_\~\\\/\?]{6,16}$/;
	return reg.test(str);
}

function isAvaiableLength(minL,maxL,str){
	/**
	*
	* @description: 判断传入的参数的长度是否在给定的有效范围内
	* @param: minL->给定的最小的长度
	* @param: maxL->给定的最大的长度
	* @param: str->待验证的参数
	* @return : true表示合理，验证通过
	*/
	str = str.replace(/(^[ \t\n\r]+)|([ \t\n\r]+$)/g, ''); //去除左右空格
    return (str.length >= minL && str.length <= maxL) ? true : false;
}
function fistLetterUpper(str) {
	//首字母大写
    return str.charAt(0).toUpperCase()+str.slice(1);
}
function isEmpty(str) {
    //空引用  空字符串  空输入
    //@description : 判断输入的参数是否为空
    return str == null || typeof str == "undefined" || trim(str) == "" ? true : false;
}
function trim(str,dir){
	/**
	* @str字符串
	* @desccrition: 对String类型去除空格的拓展
	* @dir : 被去除空格所在的位置
	* @test: ie6-9 chrome firefox
	*/
    switch (dir) {
        case 0 : //去左边的空格
            return str.replace(/(^\s*)/g,'');
            break;
        case 1 : //去右边的空格
            return str.replace(/(\s*$)/g,'');
            break;
        case 2 : //去掉两边的空格
            return str.replace(/(^\s*)|(\s*$)/g,'');
            break;
        default : //去掉所有的空格
            return str.replace(/(\s*)/g,'');
    }
}

function cutstr(str, len) {
	/**
	*
	* @descrition: 对字符串进行截取，包括普通字符和中文字符
	* @param : str ->待截取的字符串
	* @param : len ->要截取的长度
	* 
	* 比如cutstr('hello',2)->he...  cutstr("您好呀",4)->您好...
	* 优先选择后台进行字符串截取，后css截取，最后js截取
	*/
    var temp,
        icount = 0,
        patrn = /[^\x00-\xff]/g,    //中文字符匹配
        strre = "";

    for (var k = 0; k < str.length; k++) {
        if (icount < len ) {
            temp = str.substr(k, 1);
            if (temp.match(patrn) == null) {
                icount = icount + 1;
            } else {
                icount = icount + 2;
            }
            strre += temp;
        } else {
            break
        }
    }
    return strre + "...";
}
function isNumber(o) {
	/**
	*
	* @descrition: 测试给定的参数是否全部为中文字符，如"中test"不会通过 。
	* @param->str : 传入的参数，类型为字符串。
	* @return : true表示全部为中文,false为不全是中文，或没有中文。
	* 
	*/
    return !isNaN(o);
}
function checkIdCard(num) {
	/**
	*
	* @descrition: 判断输入的参数是否是一个合格的身份证号码。
	* 这个函数对输入的参数检查时候是合格的身份证号码，其身份证有效性无法判断。检测的颗粒度可以定制。
	* @param->str : 待验证的参数
	* @return : true是合格的身份证   false为不合法的身份证
	* 
	*/
    num = num.toUpperCase();
    var cityCode = {11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 "};
    if(!cityCode[num.substr(0,2)]){
        console.log("地址编码错误");
        return false;
    }
    //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
        //alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
        return false;
    }
    //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
    //下面分别分析出生日期和校验位
    var len, re;
    len = num.length;
    if (len == 15) {
        re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
        var arrSplit = num.match(re);

        //检查生日日期是否正确
        var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            //alert('输入的身份证号里出生日期不对！');
            return false;
        }
        else {
            //将15位身份证转成18位
            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var nTemp = 0, k;
            num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
            for (k = 0; k < 17; k++) {
                nTemp += num.substr(k, 1) * arrInt[k];
            }
            num += arrCh[nTemp % 11];
            return true;
        }
    }
    if (len == 18) {
        re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
        var arrSplit = num.match(re);
        //检查生日日期是否正确
        var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            //alert(dtmBirth.getYear());
            //alert(arrSplit[2]);
            //alert('输入的身份证号里出生日期不对！');
            return false;
        }
        else {
            //检验18位身份证的校验码是否正确。
            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
            var valnum;
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var nTemp = 0, k;
            for (k = 0; k < 17; k++) {
                nTemp += num.substr(k, 1) * arrInt[k];
            }
            valnum = arrCh[nTemp % 11];
            if (valnum != num.substr(17, 1)) {
                //alert('18位身份证的校验码不正确！应该为：' + valnum);
                return false;
            }
            return true;
        }
    }
    return false;
}
function parseURL(url) {
	/*
	* @function: 通过a标签解析url标签
	* @param:url  url参数是字符串，解析的目标
	  通过IE6-9 chrome  Firefox测试
	*
	*/
    //创建一个a标签
    var a =  document.createElement('a');
    //将url赋值给标签的href属性。
    a.href = url;
    return {
        source: url,
        protocol: a.protocol.replace(':',''), //协议
        host: a.hostname,   //主机名称
        port: a.port,   //端口
        query: a.search,  //查询字符串
        params: (function(){  //查询参数
            var ret = {},
                    seg = a.search.replace(/^\?/,'').split('&'),
                    len = seg.length, i = 0, s;
            for (;i<len;i++) {
                if (!seg[i]) { continue; }
                s = seg[i].split('=');
                ret[s[0]] = s[1];
            }
            return ret;
        })(),
        file: (a.pathname.match(/\/([^\/?#]+)$/i) || [,''])[1], //文件名
        hash: a.hash.replace('#',''), //哈希参数
        path: a.pathname.replace(/^([^\/])/,'/$1'), //路径
        relative: (a.href.match(/tps?:\/\/[^\/]+(.+)/) || [,''])[1],  //相对路径
        segments: a.pathname.replace(/^\//,'').split('/') //路径片段
    };
}
function unique(arr){
	//数组去重
	var res = [];
	var json = {};
	for(var i = 0; i < arr.length; i++){
		if(!json[arr[i]]){
			res.push(arr[i]);
			json[arr[i]] = 1;
		}
	}
	return res;
}

function google_go(){
	return location.href="https://www.google.com.hk/search?q="+encodeURIComponent("关键词"),
	!1
	/*return location.href="https://www.google.com.hk/search?q="+encodeURIComponent("site:www.cnblogs.com/"+"currentBlogApp"+"/ "+"关键词"),
	!1*/
}

function stopPropagation(a) {
    if (a && a.stopPropagation) a.stopPropagation();
    else if (window.event) window.event.cancelBubble = true
}

function preventDefault(b) {
    var a = b ? b : window.event;
    if (a.preventDefault) a.preventDefault();
    else if (a) a.returnValue = false
}

function showDialog(title,content,width,fun){
	var showDialog = top.dialog({
        title: title,
        content:content,
        width: width,
        id: 'relusDemo',
        //cancelValue:"取&nbsp;消",
        okValue:"关&nbsp;闭",
        ok: function () {
        	if (typeof fun === "function") {
        		fun();
        	}
        	return true;
        }
    });
    showDialog.showModal();
}

function _fireEventer(type,selector,fun,parentObj){
	//事件派发器
	/**
	*
	* @type: str  事件类型
	* @selector: str  选择器
	* @pxselector: str  代理选择器
	* @fun: function  回调函数
	*/
	if (parentObj) {
		$(parentObj).on(type, selector, function(event) {
			event.preventDefault();
			if (typeof fun === "function") {
				fun();
			}
		});
	} else {
		$(selector).on(type, function(event) {
			event.preventDefault();
			if (typeof fun === "function") {
				fun();
			}
		});
	}
}