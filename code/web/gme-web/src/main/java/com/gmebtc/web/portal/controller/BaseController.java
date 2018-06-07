package com.gmebtc.web.portal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/*
 * @Author zhou
 * @Date 2018/6/4 19:50
 * @Desc 页面跳转
 */
@Controller
public class BaseController {

    private static Logger logger = Logger.getLogger(BaseController.class);


    /**
     * @Author zhou
     * @Date 2018/6/4 19:51
     * @Desc 已登录主页
     */
    @RequestMapping(value = "/loginIndex")
    public String loginIndex() {
        return "view/loginIndex";
    }


    /**
     * @Author zhou
     * @Date 2018/6/4 20:03
     * @Desc 未登录页面
     */
    @RequestMapping(value = "/unLoginIndex")
    public String unLoginInde(ModelAndView mav){
        mav.addObject("msg", "aaaaaa");
        return "view/unLoginIndex";
    }



    @RequestMapping(value = "/login")
    public String login(){
        return "view/login";
    }




    @RequestMapping(value = "/tuiguang")
    public String aa (){
        System.out.println("test");
        return "/api/v1/tuiguangyongjin";
    }

    @RequestMapping(value = "/shenfen", method = RequestMethod.GET)
    public String test (){
        System.out.println("shenfenrenzheng");
        return "api/v1/shenfenrenzheng";
    }


    /**
     * 国际化转换
     *
     * @param session
     * @param request
     * @param lang
     */
    @RequestMapping(value = "/changeLang")
    @ResponseBody
    public Object changeLang(HttpSession session, HttpServletRequest request, @RequestParam String lang) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        Locale locale = null;
        if (lang.equals("zh_CN")) {
            locale = new Locale("zh", "CN");
        } else if (lang.equals("en_US")) {
            locale = new Locale("en", "US");
        }

        request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        session.setAttribute("locale", locale.toString());
        map.put("locale", locale.toString());

        return map;
    }
}
