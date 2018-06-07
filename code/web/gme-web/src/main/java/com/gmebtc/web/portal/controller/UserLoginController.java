package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.entity.User;
import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.UserLoginService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author zhou
 * @Date 2018/5/28 11:59
 * @Desc 用户登录,忘记登录密码,注销登录 控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class UserLoginController {

    @Resource(name = "userLoginService")
    private UserLoginService userLoginService;


    /**
     * @Author zhou
     * @Date 2018/5/28 14:32
     * @Param [request, user]
     * @Desc 用户登录
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object userLogin (HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱或者手机号不能为空");
            map.put("msg2", "登录密码不能为空");
            map.put("msg3", "登录账号格式不正确");
            map.put("msg4", "请输入图像验证码");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Mailbox or cell phone number can not be empty");
            map.put("msg2", "The login password can not be empty");
            map.put("msg3", "Login account format is not correct");
            map.put("msg4", "Please enter the image verification code");
        }

        if (null == user.getUserName() || StringUtils.isBlank(user.getUserName())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(user.getUserName()) && !Toolkits.isPhone(user.getUserName())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setCode(ResultCode.CODE_ERROR_2);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == user.getCheckCode() || StringUtils.isBlank(user.getCheckCode())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("userName", user.getUserName());
        hashMap.put("password", user.getPassword());
        hashMap.put("checkCode", user.getCheckCode());

        String json = userLoginService.login(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/28 14:33
     * @Param [request]
     * @Desc 用户登出
     */
    @RequestMapping(value = "/userLogout",method = RequestMethod.GET)
    public String userLogout (HttpServletRequest request){
        userLoginService.logout(request);
        return "view/unLoginIndex";
    }


    /**
     * @Author zhou
     * @Date 2018/5/28 16:23
     * @Param [request, user]
     * @Desc 用户找回密码
     */
    @RequestMapping(value = "/userForgetPassword",method = RequestMethod.POST)
    @ResponseBody
    public Object userForgetPassword (HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱或者手机号不能为空");
            map.put("msg2", "登录账号格式不正确");
            map.put("msg3", "请输入图像验证码");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Mailbox or cell phone number can not be empty");
            map.put("msg2", "Login account format is not correct");
            map.put("msg3", "Please enter the image verification code");
        }

        if (null == user.getUserName() || StringUtils.isBlank(user.getUserName())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(user.getUserName()) && !Toolkits.isPhone(user.getUserName())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == user.getCheckCode() || StringUtils.isBlank(user.getCheckCode())) {
            result.setCode(ResultCode.CODE_ERROR_14);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("password", user.getPassword());
        hashMap.put("checkCode", user.getCheckCode());

        String json = userLoginService.forgetPassword(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 10:21
     * @Param [request, nonce:时间戳]
     * @Desc 获取图像验证码
     */
    @RequestMapping(value = "/imgCode",method = {RequestMethod.GET,RequestMethod.POST})
    public void getImgCode (HttpServletRequest request, HttpServletResponse response,@RequestParam String nonce) throws IOException {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("nonce", nonce);
        userLoginService.getImgCode(request,response,hashMap);
    }

}
