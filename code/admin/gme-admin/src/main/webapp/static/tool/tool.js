function addClass(element, classToAdd) {
    var currentClassValue = element.className;

    if (currentClassValue.indexOf(classToAdd) == -1) {
        if ((currentClassValue == null) || (currentClassValue === "")) {
            element.className = classToAdd;
        } else {
            element.className += " " + classToAdd;
        }
    }
}

function removeClass(element, classToRemove) {
    var currentClassValue = element.className;
    if (currentClassValue == classToRemove) {
        element.className = "";
        return;
    }
    var classValues = currentClassValue.split(" ");
    var filteredList = [];
    for (var i = 0; i < classValues.length; i++) {
        if (classToRemove != classValues[i]) {
            filteredList.push(classValues[i]);
        }
    }
    element.className = filteredList.join(" ");
}

function currCss(el, name) {
    if (document.defaultView && window.getComputedStyle) {
        var ret, view = el.ownerDocument.defaultView;
        ret = view ? view.getComputedStyle(el, null)[name] : undefined;
        return ret !== '' ? ret : el.style[name];
    } else {
        return el.currentStyle[name];
    }
}

function addLoadEvent(func) {
    var oldonload = window.onload;
    if (typeof window.onload != "function") {
        window.onload = func;
    } else {
        window.onload = function() {
            oldonload();
            func();
        }
    }
}

function setCookies(key, val, h) { //键 、 值 、 时间
    var str = key + "=" + escape(val);

    if (h > 0) { //如果h为0的时候，就是不设置过期时间，浏览器关闭的时候cookie自动删
        var date = new Date();
        var ms = h * 3600 * 1000;
        date.setTime(date.getTime() + ms);
        str += "; expires=" + date.toGMTString(); //根据格林威治时间(GTM)把Date对象转换为字符串
    }
    document.cookie = str;
}

function getCookies(key) {
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if (temp[0] == key) {
            return unescape(temp[1]);
        } else {
            return false;
        }
    }
}

function delCookies(key) {
    var date = new Date();
    date.setTime(-10000);
    document.cookie = key + "=a; expires=" + date.toGMTString();
}

function getAllCookies() {
    var str = document.cookie;
    var arr = document.cookie.split("; ");
    var valArr = [];
    if (str) {
        for (var i = 0; i < arr.length; i++) {
            var temp = arr[i].split("=");
            valArr.push("Key:" + temp[1] + ", Val:" + unescape(temp[1]));
        }
        return valArr;
    } else {
        return false;
    }
}

function setlocalStorage(key, val) {
    window.localStorage.setItem(key, val);
}

function getlocalStorage(key) {
    return window.localStorage.getItem(key);
}

function dellocalStorage(key) {
    window.localStorage.removeItem(key);
}

function delAlllocalStorage() {
    window.localStorage.clear();
}
! function($) {
    return $ ? ($.Unslider = function(t, n) {
        var e = this;
        return e._ = "unslider", e.defaults = { autoplay: !1, delay: 3e3, speed: 750, easing: "swing", keys: { prev: 37, next: 39 }, nav: !0, arrows: { prev: '<a class="' + e._ + '-arrow prev">Prev</a>', next: '<a class="' + e._ + '-arrow next">Next</a>' }, animation: "horizontal", selectors: { container: "ul:first", slides: "li" }, animateHeight: !1, activeClass: e._ + "-active", swipe: !0, swipeThreshold: .2 }, e.$context = t, e.options = {}, e.$parent = null, e.$container = null, e.$slides = null, e.$nav = null, e.$arrows = [], e.total = 0, e.current = 0, e.prefix = e._ + "-", e.eventSuffix = "." + e.prefix + ~~(2e3 * Math.random()), e.interval = null, e.init = function(t) {
            return e.options = $.extend({}, e.defaults, t), e.$container = e.$context.find(e.options.selectors.container).addClass(e.prefix + "wrap"), e.$slides = e.$container.children(e.options.selectors.slides), e.setup(), $.each(["nav", "arrows", "keys", "infinite"], function(t, n) { e.options[n] && e["init" + $._ucfirst(n)]() }), jQuery.event.special.swipe && e.options.swipe && e.initSwipe(), e.options.autoplay && e.start(), e.calculateSlides(), e.$context.trigger(e._ + ".ready"), e.animate(e.options.index || e.current, "init")
        }, e.setup = function() {
            e.$context.addClass(e.prefix + e.options.animation).wrap('<div class="' + e._ + '" />'), e.$parent = e.$context.parent("." + e._);
            var t = e.$context.css("position");
            "static" === t && e.$context.css("position", "relative"), e.$context.css("overflow", "hidden")
        }, e.calculateSlides = function() {
            if (e.total = e.$slides.length, "fade" !== e.options.animation) {
                var t = "width";
                "vertical" === e.options.animation && (t = "height"), e.$container.css(t, 100 * e.total + "%").addClass(e.prefix + "carousel"), e.$slides.css(t, 100 / e.total + "%")
            }
        }, e.start = function() {
            return e.interval = setTimeout(function() { e.next() }, e.options.delay), e
        }, e.stop = function() {
            return clearTimeout(e.interval), e
        }, e.initNav = function() {
            var t = $('<nav class="' + e.prefix + 'nav"><ol /></nav>');
            e.$slides.each(function(n) {
                var i = this.getAttribute("data-nav") || n + 1;
                $.isFunction(e.options.nav) && (i = e.options.nav.call(e.$slides.eq(n), n, i)), t.children("ol").append('<li data-slide="' + n + '">' + i + "</li>")
            }), e.$nav = t.insertAfter(e.$context), e.$nav.find("li").on("click" + e.eventSuffix, function() {
                var t = $(this).addClass(e.options.activeClass);
                t.siblings().removeClass(e.options.activeClass), e.animate(t.attr("data-slide"))
            })
        }, e.initArrows = function() { e.options.arrows === !0 && (e.options.arrows = e.defaults.arrows), $.each(e.options.arrows, function(t, n) { e.$arrows.push($(n).insertAfter(e.$context).on("click" + e.eventSuffix, e[t])) }) }, e.initKeys = function() { e.options.keys === !0 && (e.options.keys = e.defaults.keys), $(document).on("keyup" + e.eventSuffix, function(t) { $.each(e.options.keys, function(n, i) { t.which === i && $.isFunction(e[n]) && e[n].call(e) }) }) }, e.initSwipe = function() {
            var t = e.$slides.width();
            "fade" !== e.options.animation && e.$container.on({
                movestart: function(t) {
                    return t.distX > t.distY && t.distX < -t.distY || t.distX < t.distY && t.distX > -t.distY ? !!t.preventDefault() : void e.$container.css("position", "relative")
                },
                move: function(n) { e.$container.css("left", -(100 * e.current) + 100 * n.distX / t + "%") },
                moveend: function(n) { Math.abs(n.distX) / t > e.options.swipeThreshold ? e[n.distX < 0 ? "next" : "prev"]() : e.$container.animate({ left: -(100 * e.current) + "%" }, e.options.speed / 2) }
            })
        }, e.initInfinite = function() {
            var t = ["first", "last"];
            $.each(t, function(n, i) { e.$slides.push.apply(e.$slides, e.$slides.filter(':not(".' + e._ + '-clone")')[i]().clone().addClass(e._ + "-clone")["insert" + (0 === n ? "After" : "Before")](e.$slides[t[~~!n]]())) })
        }, e.destroyArrows = function() { $.each(e.$arrows, function(t, n) { n.remove() }) }, e.destroySwipe = function() { e.$container.off("movestart move moveend") }, e.destroyKeys = function() { $(document).off("keyup" + e.eventSuffix) }, e.setIndex = function(t) {
            return 0 > t && (t = e.total - 1), e.current = Math.min(Math.max(0, t), e.total - 1), e.options.nav && e.$nav.find('[data-slide="' + e.current + '"]')._active(e.options.activeClass), e.$slides.eq(e.current)._active(e.options.activeClass), e
        }, e.animate = function(t, n) {
            if ("first" === t && (t = 0), "last" === t && (t = e.total), isNaN(t)) return e;
            e.options.autoplay && e.stop().start(), e.setIndex(t), e.$context.trigger(e._ + ".change", [t, e.$slides.eq(t)]);
            var i = "animate" + $._ucfirst(e.options.animation);
            return $.isFunction(e[i]) && e[i](e.current, n), e
        }, e.next = function() {
            var t = e.current + 1;
            return t >= e.total && (t = 0), e.animate(t, "next")
        }, e.prev = function() {
            return e.animate(e.current - 1, "prev")
        }, e.animateHorizontal = function(t) {
            var n = "left";
            return "rtl" === e.$context.attr("dir") && (n = "right"), e.options.infinite && e.$container.css("margin-" + n, "-100%"), e.slide(n, t)
        }, e.animateVertical = function(t) {
            return e.options.animateHeight = !0, e.options.infinite && e.$container.css("margin-top", -e.$slides.outerHeight()), e.slide("top", t)
        }, e.slide = function(t, n) {
            if (e.options.animateHeight && e._move(e.$context, { height: e.$slides.eq(n).outerHeight() }, !1), e.options.infinite) {
                var i;
                n === e.total - 1 && (i = e.total - 3, n = -1), n === e.total - 2 && (i = 0, n = e.total - 2), "number" == typeof i && (e.setIndex(i), e.$context.on(e._ + ".moved", function() { e.current === i && e.$container.css(t, -(100 * i) + "%").off(e._ + ".moved") }))
            }
            var o = {};
            return o[t] = -(100 * n) + "%", e._move(e.$container, o)
        }, e.animateFade = function(t) {
            var n = e.$slides.eq(t).addClass(e.options.activeClass);
            e._move(n.siblings().removeClass(e.options.activeClass), { opacity: 0 }), e._move(n, { opacity: 1 }, !1)
        }, e._move = function(t, n, i, o) {
            return i !== !1 && (i = function() { e.$context.trigger(e._ + ".moved") }), t._move(n, o || e.options.speed, e.options.easing, i)
        }, e.init(n)
    }, $.fn._active = function(t) {
        return this.addClass(t).siblings().removeClass(t)
    }, $._ucfirst = function(t) {
        return (t + "").toLowerCase().replace(/^./, function(t) {
            return t.toUpperCase()
        })
    }, $.fn._move = function() {
        return this.stop(!0, !0), $.fn[$.fn.velocity ? "velocity" : "animate"].apply(this, arguments)
    }, void($.fn.unslider = function(t) {
        return this.each(function() {
            var n = $(this);
            if ("string" == typeof t && n.data("unslider")) {
                t = t.split(":");
                var e = n.data("unslider")[t[0]];
                if ($.isFunction(e)) return e.apply(n, t[1] ? t[1].split(",") : null)
            }
            return n.data("unslider", new $.Unslider(n, t))
        })
    })) : console.warn("Unslider needs jQuery")
}(window.jQuery);
(function(o, v) {
    var g = o.document,
        q = g.documentElement,
        J = function() {
            var p = g.body,
                w = !-[1, ],
                r = w && /msie 6/.test(navigator.userAgent.toLowerCase()),
                I = 1,
                y = "cache" + (+new Date + "").slice(-8),
                u = {},
                d = function() {};
            d.prototype = {
                getOptions: function(a) {
                    var b, c = {},
                        e = { container: null, overlay: true, drag: true, fixed: true, follow: null, followX: 0, followY: 0, autoClose: 0, lock: false, callback: null };
                    for (b in e) c[b] = a[b] !== v ? a[b] : e[b];
                    d.data("options", c);
                    return c
                },
                setBodyBg: function() {
                    if (p.currentStyle.backgroundAttachment !== "fixed") {
                        p.style.backgroundImage =
                            "url(about:blank)";
                        p.style.backgroundAttachment = "fixed"
                    }
                },
                appendIframe: function(a) { a.innerHTML = '<iframe style="position:absolute;left:0;top:0;width:100%;height:100%;z-index:-1;border:0 none;filter:alpha(opacity=0)"></iframe>' },
                setFollow: function(a, b, c, e) {
                    b = typeof b === "string" ? g.getElementById(b) : b;
                    a = a.style;
                    a.position = "absolute";
                    a.left = d.getOffset(b, "left") + c + "px";
                    a.top = d.getOffset(b, "top") + e + "px"
                },
                setPosition: function(a, b) {
                    var c = a.style;
                    c.position = r ? "absolute" : b ? "fixed" : "absolute";
                    if (b) {
                        if (r) c.setExpression("top",
                            'fuckIE6=document.documentElement.scrollTop+document.documentElement.clientHeight/2+"px"');
                        else c.top = "50%";
                        c.left = "50%"
                    } else {
                        r && c.removeExpression("top");
                        c.top = q.clientHeight / 2 + d.getScroll("top") + "px";
                        c.left = q.clientWidth / 2 + d.getScroll("left") + "px"
                    }
                },
                createOverlay: function() {
                    var a = g.createElement("div"),
                        b = a.style;
                    b.cssText = "margin:0;padding:0;border:none;width:100%;height:100%;background:#333;opacity:0.6;filter:alpha(opacity=60);z-index:9999;position:fixed;top:0;left:0;";
                    if (r) {
                        p.style.height = "100%";
                        b.position = "absolute";
                        b.setExpression("top", 'fuckIE6=document.documentElement.scrollTop+"px"')
                    }
                    a.id = "overlay";
                    return a
                },
                createDialogBox: function() {
                    var a = g.createElement("div");
                    a.style.cssText = "margin:0;padding:0;border:none;z-index:10000;";
                    a.id = "easyDialogBox";
                    return a
                },
                createDialogWrap: function(a) {
                    var b = typeof a.yesFn === "function" ? '<button class="btn_highlight" id="easyDialogYesBtn">' + (typeof a.yesText === "string" ? a.yesText : "\u786e\u5b9a") + "</button>" : "",
                        c = typeof a.noFn === "function" || a.noFn === true ?
                        '<button class="btn_normal" id="easyDialogNoBtn">' + (typeof a.noText === "string" ? a.noText : "\u53d6\u6d88") + "</button>" : "";
                    a = ['<div class="easyDialog_content">', a.header ? '<h4 class="easyDialog_title" id="easyDialogTitle"><a href="javascript:void(0)" title="\u5173\u95ed\u7a97\u53e3" class="close_btn" id="closeBtn">&times;</a>' + a.header + "</h4>" : "", '<div class="easyDialog_text">' + a.content + "</div>", b === "" && c === "" ? "" : '<div class="easyDialog_footer">' + c + b + "</div>", "</div>"].join("");
                    b = g.getElementById("easyDialogWrapper");
                    if (!b) {
                        b = g.createElement("div");
                        b.id = "easyDialogWrapper";
                        b.className = "easyDialog_wrapper"
                    }
                    b.innerHTML = a.replace(/<[\/]*script[\s\S]*?>/ig, "");
                    return b
                }
            };
            d.data = function(a, b, c) {
                if (typeof a === "string") {
                    if (b !== v) u[a] = b;
                    return u[a]
                } else if (typeof a === "object") {
                    a = a === o ? 0 : a.nodeType === 9 ? 1 : a[y] ? a[y] : a[y] = ++I;
                    a = u[a] ? u[a] : u[a] = {};
                    if (c !== v) a[b] = c;
                    return a[b]
                }
            };
            d.removeData = function(a, b) {
                if (typeof a === "string") delete u[a];
                else if (typeof a === "object") {
                    var c = a === o ? 0 : a.nodeType === 9 ? 1 : a[y];
                    if (c !== v) {
                        var e = function(m) {
                                for (var n in m) return false;
                                return true
                            },
                            f = function() {
                                delete u[c];
                                if (!(c <= 1)) try { delete a[y] } catch (m) { a.removeAttribute(y) }
                            };
                        if (b) {
                            delete u[c][b];
                            e(u[c]) && f()
                        } else f()
                    }
                }
            };
            d.event = {
                bind: function(a, b, c) {
                    var e = d.data(a, "e" + b) || d.data(a, "e" + b, []);
                    e.push(c);
                    if (e.length === 1) {
                        c = this.eventHandler(a);
                        d.data(a, b + "Handler", c);
                        if (a.addEventListener) a.addEventListener(b, c, false);
                        else a.attachEvent && a.attachEvent("on" + b, c)
                    }
                },
                unbind: function(a, b, c) {
                    var e = d.data(a, "e" + b);
                    if (e) {
                        if (c)
                            for (var f = e.length - 1, m = e[f]; f >= 0; f--) m === c && e.splice(f, 1);
                        else e = v;
                        if (!e || !e.length) {
                            c = d.data(a, b + "Handler");
                            if (a.addEventListener) a.removeEventListener(b, c, false);
                            else a.attachEvent && a.detachEvent("on" + b, c);
                            d.removeData(a, b + "Handler");
                            d.removeData(a, "e" + b)
                        }
                    }
                },
                eventHandler: function(a) {
                    return function(b) {
                        b = d.event.fixEvent(b || o.event);
                        for (var c = d.data(a, "e" + b.type), e = 0, f; f = c[e++];)
                            if (f.call(a, b) === false) {
                                b.preventDefault();
                                b.stopPropagation()
                            }
                    }
                },
                fixEvent: function(a) {
                    if (a.target) return a;
                    var b = {},
                        c;
                    b.target = a.srcElement || document;
                    b.preventDefault = function() {
                        a.returnValue =
                            false
                    };
                    b.stopPropagation = function() { a.cancelBubble = true };
                    for (c in a) b[c] = a[c];
                    return b
                }
            };
            d.capitalize = function(a) {
                var b = a.charAt(0);
                return b.toUpperCase() + a.replace(b, "")
            };
            d.getScroll = function(a) {
                a = this.capitalize(a);
                return q["scroll" + a] || p["scroll" + a]
            };
            d.getOffset = function(a, b) {
                var c = this.capitalize(b);
                c = q["client" + c] || p["client" + c] || 0;
                var e = this.getScroll(b),
                    f = a.getBoundingClientRect();
                return Math.round(f[b]) + e - c
            };
            d.drag = function(a, b) {
                var c = "getSelection" in o ? function() { o.getSelection().removeAllRanges() } :
                    function() {
                        try { g.selection.empty() } catch (i) {}
                    },
                    e = this,
                    f = e.event,
                    m = false,
                    n = w ? a : g,
                    h = b.style.position === "fixed",
                    j = d.data("options").fixed;
                f.bind(a, "mousedown", function(i) {
                    m = true;
                    var k = e.getScroll("top"),
                        s = e.getScroll("left"),
                        z = h ? 0 : s,
                        B = h ? 0 : k;
                    d.data("dragData", { x: i.clientX - e.getOffset(b, "left") + (h ? s : 0), y: i.clientY - e.getOffset(b, "top") + (h ? k : 0), el: z, et: B, er: z + q.clientWidth - b.offsetWidth, eb: B + q.clientHeight - b.offsetHeight });
                    if (w) {
                        r && j && b.style.removeExpression("top");
                        a.setCapture()
                    }
                    f.bind(n, "mousemove", l);
                    f.bind(n, "mouseup", t);
                    w && f.bind(a, "losecapture", t);
                    i.stopPropagation();
                    i.preventDefault()
                });
                var l = function(i) {
                        if (m) {
                            c();
                            var k = d.data("dragData"),
                                s = i.clientX - k.x,
                                z = i.clientY - k.y,
                                B = k.et,
                                E = k.er,
                                F = k.eb;
                            k = k.el;
                            var C = b.style;
                            C.marginLeft = C.marginTop = "0px";
                            C.left = (s <= k ? k : s >= E ? E : s) + "px";
                            C.top = (z <= B ? B : z >= F ? F : z) + "px";
                            i.stopPropagation()
                        }
                    },
                    t = function(i) {
                        m = false;
                        w && f.unbind(a, "losecapture", arguments.callee);
                        f.unbind(n, "mousemove", l);
                        f.unbind(n, "mouseup", arguments.callee);
                        if (w) {
                            a.releaseCapture();
                            if (r && j) {
                                var k =
                                    parseInt(b.style.top) - e.getScroll("top");
                                b.style.setExpression("top", "fuckIE6=document.documentElement.scrollTop+" + k + '+"px"')
                            }
                        }
                        i.stopPropagation()
                    }
            };
            var x, G = function(a) { a.keyCode === 27 && D.close() },
                D = {
                    open: function(a) {
                        var b = new d,
                            c = b.getOptions(a || {});
                        a = d.event;
                        var e = q.clientWidth,
                            f = q.clientHeight,
                            m = this,
                            n, h, j, l;
                        if (x) {
                            clearTimeout(x);
                            x = v
                        }
                        if (c.overlay) {
                            n = g.getElementById("overlay");
                            if (!n) {
                                n = b.createOverlay();
                                p.appendChild(n);
                                r && b.appendIframe(n)
                            }
                            n.style.display = "block"
                        }
                        r && b.setBodyBg();
                        h = g.getElementById("easyDialogBox");
                        if (!h) {
                            h = b.createDialogBox();
                            p.appendChild(h)
                        }
                        if (c.follow) {
                            l = function() { b.setFollow(h, c.follow, c.followX, c.followY) };
                            l();
                            a.bind(o, "resize", l);
                            d.data("follow", l);
                            if (n) n.style.display = "none";
                            c.fixed = false
                        } else b.setPosition(h, c.fixed);
                        h.style.display = "block";
                        j = typeof c.container === "string" ? g.getElementById(c.container) : b.createDialogWrap(c.container);
                        if (l = h.getElementsByTagName("*")[0]) {
                            if (l && j !== l) {
                                l.style.display = "none";
                                p.appendChild(l);
                                h.appendChild(j)
                            }
                        } else h.appendChild(j);
                        j.style.display = "block";
                        var t = j.offsetWidth,
                            i = j.offsetHeight;
                        l = t > e;
                        var k = i > f;
                        j.style.marginTop = j.style.marginRight = j.style.marginBottom = j.style.marginLeft = "0px";
                        if (c.follow) h.style.marginLeft = h.style.marginTop = "0px";
                        else {
                            h.style.marginLeft = "-" + (l ? e / 2 : t / 2) + "px";
                            h.style.marginTop = "-" + (k ? f / 2 : i / 2) + "px"
                        }
                        if (r && !c.overlay) {
                            h.style.width = t + "px";
                            h.style.height = i + "px"
                        }
                        e = g.getElementById("closeBtn");
                        f = g.getElementById("easyDialogTitle");
                        j = g.getElementById("easyDialogYesBtn");
                        t = g.getElementById("easyDialogNoBtn");
                        j && a.bind(j, "click",
                            function(s) { c.container.yesFn.call(m, s) !== false && m.close() });
                        if (t) {
                            i = function(s) {
                                if (c.container.noFn === true || c.container.noFn.call(m, s) !== false) m.close()
                            };
                            a.bind(t, "click", i);
                            e && a.bind(e, "click", i)
                        } else e && a.bind(e, "click", m.close);
                        c.lock || a.bind(g, "keyup", G);
                        if (c.autoClose && typeof c.autoClose === "number") x = setTimeout(m.close, c.autoClose);
                        if (c.drag && f && !l && !k) {
                            f.style.cursor = "move";
                            d.drag(f, h)
                        }
                        if (!c.follow && !c.fixed) {
                            i = function() { b.setPosition(h, false) };
                            !l && !k && a.bind(o, "resize", i);
                            d.data("resize",
                                i)
                        }
                        d.data("dialogElements", { overlay: n, dialogBox: h, closeBtn: e, dialogTitle: f, dialogYesBtn: j, dialogNoBtn: t })
                    },
                    close: function() {
                        var a = d.data("options"),
                            b = d.data("dialogElements"),
                            c = d.event;
                        if (x) {
                            clearTimeout(x);
                            x = v
                        }
                        if (a.overlay && b.overlay) b.overlay.style.display = "none";
                        b.dialogBox.style.display = "none";
                        r && b.dialogBox.style.removeExpression("top");
                        b.closeBtn && c.unbind(b.closeBtn, "click");
                        b.dialogTitle && c.unbind(b.dialogTitle, "mousedown");
                        b.dialogYesBtn && c.unbind(b.dialogYesBtn, "click");
                        b.dialogNoBtn && c.unbind(b.dialogNoBtn,
                            "click");
                        if (!a.follow && !a.fixed) {
                            c.unbind(o, "resize", d.data("resize"));
                            d.removeData("resize")
                        }
                        if (a.follow) {
                            c.unbind(o, "resize", d.data("follow"));
                            d.removeData("follow")
                        }
                        a.lock || c.unbind(g, "keyup", G);
                        typeof a.callback === "function" && a.callback.call(D);
                        d.removeData("options");
                        d.removeData("dialogElements")
                    }
                };
            return D
        },
        A = function() { o.easyDialog = J() },
        H = function() {
            if (!g.body) {
                try { q.doScroll("left") } catch (p) {
                    setTimeout(H, 1);
                    return
                }
                A()
            }
        };
    (function() {
        if (g.body) A();
        else if (g.addEventListener) {
            g.addEventListener("DOMContentLoaded",
                function() {
                    g.removeEventListener("DOMContentLoaded", arguments.callee, false);
                    A()
                }, false);
            o.addEventListener("load", A, false)
        } else if (g.attachEvent) {
            g.attachEvent("onreadystatechange", function() {
                if (g.readyState === "complete") {
                    g.detachEvent("onreadystatechange", arguments.callee);
                    A()
                }
            });
            o.attachEvent("onload", A);
            var p = false;
            try { p = o.frameElement == null } catch (w) {}
            q.doScroll && p && H()
        }
    })()
})(window, undefined);
$(function() {
    $.ajaxSetup({
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            if (XMLHttpRequest.status == 403) {
                $.messager.alert("您没有权限访问此资源或进行此操作！");
                return false;
            }
        },
        complete: function(XMLHttpRequest, textStatus) {
            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus， 
            if (sessionstatus == 'timeout') {
                //如果超时就处理 ，指定要跳转的页面  
                if (self.frameElement && self.frameElement.tagName == "IFRAME") {
                    $.dialog.confirm("会话超时重新登录！", function() {
                        parent.location.reload();
                    }, function() {}).zindex();

                }
            }
        }
    });
    (function() {
        var dropdownUl = null;
        $("body").on("click", ".dropdown-toggle", function(e) {
            $('.u-menu').hide();
            var tw = $(this).parent(".dropdown-table").width(),
                ix = parseInt($(this).parent(".dropdown-table").attr("data-row")),
                len = $(this).siblings('.u-menu').find("li").size(),
                event = e || window.event,
                el = event.target || event.srcElement,
                cl = el.className.toLowerCase();
            if (ix < 9) {
                $(this).siblings('.u-menu').css({
                    "top": 10 + "px",
                    "left": (tw / 2 - 100) + "px"
                }).show();
            } else {
                var height = len * 35 - 3;
                $(this).siblings('.u-menu').css({
                    "top": "-" + height + "px",
                    "left": (tw / 2 - 100) + "px"
                }).show();
            }
        });
        $(document).on('click', function(e) {
            var event = e || window.event,
                el = event.target || event.srcElement,
                /*ccl = event.currentTarget.className.toLowerCase(),*/
                cl = el.className.toLowerCase(),
                clid = el.id.toLowerCase();
            if (cl != "dropdown-toggle" && cl != "fa fa-gear") {
                $('.u-menu').hide();
            }
        });
    })();
    /*$("select").selectBoxIt({
        native: true
    });*/
});
function arrAdd(arr){
    //console.log("arr::"+arr+"\r\n");
    var s = 0;
    for (var i = 0,j = arr.length; i < j; i++) {
        if (typeof arr[i] === "number") {
            s = s + arr[i];
        } else {
            s = s + 0;
        }
    }
    return s;
}

//获取最近一个月的时间，返回开始时间、结束时间
function getDt(){
    var y = new Date().getFullYear(),
        m = new Date().getMonth() + 1,
        d = new Date().getDate(),
        sd = 1,
        ed = 1;
    
    if (m == 1) {
        sd = "01";
    } else {
        sd = m - 1;
        if (sd < 10) {
            sd = "0"+sd;
        }
    }
    if (d == 1) {
        ed = "01";
    } else {
        ed = d - 1;
        if (ed < 10) {
            ed = "0"+ed;
        }
    }
    if (m < 10) {
        m = "0"+m;
    }
    if (d < 10) {
        d = "0"+d;
    }
    return {
        startTime: y+"-"+sd+"-"+d,
        endTime: y+"-"+m+"-"+ed
    }
}

function downloadFile(fileName, content) {
    var aLink = document.createElement('a');
    var blob = new Blob([content]);
    var evt = document.createEvent("HTMLEvents");
    evt.initEvent("click", false, false); //initEvent 不加后两个参数在FF下会报错, 感谢 Barret Lee 的反馈
    aLink.download = fileName;
    aLink.href = URL.createObjectURL(blob);
    aLink.dispatchEvent(evt);
}
/**
 * 退出确认框
 * 
 * @param url
 * @param content
 * @param index
 */
function exit(url, content) {
    $.dialog.confirm(content, function() {
        window.location = url;
    }, function() {}).zindex();
}
/**
 * 提示信息
 */
function tip(msg) {
    if (msg && msg.toLowerCase() != "undefined" && msg.toLowerCase() != "null") {
        try {
            $.dialog.setting.zIndex = 1980;
            easyDialog.open({
                container: {
                    content: msg
                },
                overlay: false,
                /*follow : $('body'),
                followX : -($('body').width() - 326),
                followY : 24,*/
                autoClose: 1000 * 3
            });
            /*$.messager.show({
                title: '提示信息',
                msg: msg,
                timeout: 1000 * 300,
                style: {
                    right: '',
                    top: document.body.scrollTop + document.documentElement.scrollTop,
                    bottom: ''
                }
            });*/
        } catch (e) {
            alert(msg);
        }
    }
    setTimeout(function(){
        $("#psflowProgressDiv").hide();
    },1000);
}
// 普通询问操作调用函数
function confirm(url, content, name) {
    createdialog('提示信息 ', content, url, name);
}
/**
 * 创建询问窗口
 * 
 * @param title
 * @param content
 * @param url
 */
function createdialog(title, content, url, name) {
    $.dialog.confirm(content, function() {
        doSubmit(url, name);
        rowid = '';
    }, function() {}).zindex();
}
/**
 * 执行操作
 * 
 * @param url
 * @param index
 */
function doSubmit(url, name, data) {
    gridname = name;
    var paramsData = data;
    if (!paramsData) {
        paramsData = new Object();
        if (url.indexOf("&") != -1) {
            var str = url.substr(url.indexOf("&") + 1);
            url = url.substr(0, url.indexOf("&"));
            var strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                paramsData[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
            }
        }
    }
    $.ajax({
        async: false,
        cache: false,
        type: 'POST',
        data: paramsData,
        url: url, // 请求的action路径
        error: function() { // 请求失败处理函数
        },
        success: function(data) {
            if (data.success) {
                var msg = data.msg;
                tip(msg);
                reloadTable();
            } else {
                var msg = data.msg;
                tip(msg);
            }
        }
    });
}

var gridname = ""; //操作datagrid对象名称

/**
 * 添加事件打开窗口
 */
function add(title, addurl, name, width, height) {
    gridname = name;
    width = width ? width : 800;
    height = height ? height : 500;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }
    $.dialog({
        content: 'url:' + addurl,
        lock: true,
        //zIndex:1990,
        width: width,
        height: height,
        title: title,
        opacity: 0.3,
        cache: false,
        ok: function() {
            iframe = this.iframe.contentWindow;
            saveObj();
            return false;
        },
        cancelVal: '关闭',
        cancel: true /*为true等价于function(){}*/
    }).zindex();
}
/**
 * 查看详细事件打开窗口
 */
function detail(title, url, width, height) {
    width = width ? width : 800;
    height = height ? height : 500;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }
    $.dialog({
        content: 'url:' + url,
        lock: true,
        width: width,
        height: height,
        title: title,
        opacity: 0.3,
        cache: false,
        cancelVal: '关闭',
        cancel: true /*为true等价于function(){}*/
    }).zindex();
}
/**
 * 修改事件打开窗口 
 */
function update(title, addurl, name, width, height) {
    gridname = name;
    width = width ? width : 800;
    height = height ? height : 500;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }
    $.dialog({
        content: 'url:' + addurl,
        lock: true,
        //zIndex:1990,
        width: width,
        height: height,
        title: title,
        opacity: 0.3,
        cache: false,
        ok: function() {
            iframe = this.iframe.contentWindow;
            saveObj();
            return false;
        },
        cancelVal: '关闭',
        cancel: true /*为true等价于function(){}*/
    }).zindex();
}

// 删除调用函数
function delObj(url, name) {
    gridname = name;
    createdialog('删除确认 ', '确定删除该记录吗 ?', url, name);
}
/**
 * 详情 修改 
 */
function infoUpdate(title, url, name, width, height) {
    gridname = name;
    width = width ? width : 800;
    height = height ? height : 500;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }
    $.dialog({
        content: 'url:' + url,
        lock: true,
        width: width,
        height: height,
        title: title,
        opacity: 0.3,
        cache: false,
        button: [{
            name: '编辑',
            callback: function() {
                iframe = this.iframe.contentWindow;
                var te = this.DOM.buttons.context.childNodes;
                $("#info", iframe.document).css("display", "none");
                $("#formobj", iframe.document).css("display", "block");
                if (te) {
                    for (var i = 0; i < te.length; i++) {
                        if (te[i].value == '编辑') { te[i].style.display = 'none'; }
                        if (te[i].value == '取消编辑' || te[i].value == '保存') { te[i].style.display = ''; }
                    }
                }
                this.button({
                    name: '取消编辑',
                    callback: function() {
                        var te = this.DOM.buttons.context.childNodes;
                        if (te) {
                            for (var i = 0; i < te.length; i++) {
                                if (te[i].value == '取消编辑' || te[i].value == '保存') { te[i].style.display = 'none'; }
                                if (te[i].value == '编辑') { te[i].style.display = ''; }
                            }
                        }
                        $("#info", iframe.document).css("display", "block");
                        $("#formobj", iframe.document).css("display", "none");
                        return false;
                    }
                }, {
                    name: '保存',
                    callback: function() {
                        iframe = this.iframe.contentWindow;
                        saveObj();
                        return false;
                    }
                });
                return false;
            }
        }, {
            name: '关闭'
        }]
    }).zindex();
}
/**
 * 详情 修改 
 */
function infoUpdate2(title, infoUrl, updateUrl, name, width, height) {
    gridname = id;
    width = width ? width : 800;
    height = height ? height : 500;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }
    $.dialog({
        content: 'url:' + infoUrl,
        lock: true,
        width: width,
        height: height,
        title: '详情',
        opacity: 0.3,
        cache: false,
        button: [{
            name: '编辑',
            callback: function() {
                var iframe = this.iframe.contentWindow;
                var te = this.DOM.buttons.context.childNodes;
                iframe.location.href = updateUrl;
                if (te) {
                    for (var i = 0; i < te.length; i++) {
                        if (te[i].value == '编辑') {
                            te[i].style.display = 'none';
                        }
                        if (te[i].value == '取消编辑' || te[i].value == '保存') {
                            te[i].style.display = '';
                        }
                    }
                }
                this.button({
                    name: '取消编辑',
                    callback: function() {
                        var te = this.DOM.buttons.context.childNodes;
                        if (te) {
                            for (var i = 0; i < te.length; i++) {
                                if (te[i].value == '取消编辑' || te[i].value == '保存') {
                                    te[i].style.display = 'none';
                                }
                                if (te[i].value == '编辑') {
                                    te[i].style.display = '';
                                }
                            }
                        }
                        iframe.location.href = infoUrl;
                        return false;
                    }
                }, {
                    name: '保存',
                    callback: function() {
                        $('#btn_sub', this.iframe.contentWindow.document).click();
                        return false;
                    }
                });
                return false;
            }
        }, {
            name: '关闭'
        }]
    });
}
/**
 * 执行保存
 * 
 * @param url
 * @param gridname
 */
function saveObj() {
    $('#btn_sub', iframe.document).click();

    window.setTimeout(function() {
        var div = $("#psflowProgressDiv", iframe.document),
            wrong = $(".Validform_wrong", iframe.document)
        if (div.size() > 0 && wrong.size() <= 0) {
            div.show();
        }
    }, 100);
}
