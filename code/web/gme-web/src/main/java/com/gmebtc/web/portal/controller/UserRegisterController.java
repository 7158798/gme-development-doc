package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.entity.User;
import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.UserService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author zhou
 * @Date 2018/5/26 10:01
 * @Desc 用户控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class UserRegisterController {


    @Resource(name = "userService")
    private UserService userService;



    /**
     * @Author zhou
     * @Date 2018/5/24 14:21
     * @Desc 手机号注册
     */
    @RequestMapping(value = "/userPhoneRegister",method = RequestMethod.POST)
    @ResponseBody
    public Object userPhoneRegister(HttpServletRequest request,User user) {

        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "手机号不能为空");
            map.put("msg2", "手机验证码不能为空");
            map.put("msg3", "登录密码不能为空");
            map.put("msg4", "资金密码不能为空");
            map.put("msg5", "手机号格式错误");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Cell phone number can not be empty");
            map.put("msg2","Cell phone verification code can not be empty");
            map.put("msg3", "The login password can not be empty");
            map.put("msg4", "Capital cipher can not be empty");
            map.put("msg5", "Cell phone number error");

        }

        // 手机号码是否为空
        if (null == user.getPhoneNumber() || StringUtils.isBlank(user.getPhoneNumber())) {
            result.setCode(ResultCode.CODE_ERROR_9);     // 手机号为空状态码
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setCode(ResultCode.CODE_ERROR_2);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == user.getPayPassword() || StringUtils.isBlank(user.getPayPassword())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isPhone(user.getPhoneNumber())) {
            result.setCode(ResultCode.CODE_ERROR_13);
            result.setMessage(Toolkits.defaultString(map.get("msg5")));
            result.setData("");
            return result;
        }
        // 手机验证码是否为空
        if (null == user.getPhoneCode() || StringUtils.isBlank(user.getPhoneCode())) {
            result.setCode(ResultCode.CODE_ERROR_11);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("phoneNumber", user.getPhoneNumber());
        hashMap.put("countryCode", user.getCountryCode());
        hashMap.put("phoneCode", user.getPhoneCode());
        hashMap.put("password", user.getPassword());
        hashMap.put("PayPassword", user.getPayPassword());
        hashMap.put("refereeId", user.getRefereeId());

        // 如果简单验证通过,调用service
        String json = userService.userPhoneRegister(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    @RequestMapping(value = "/userEmailRegister",method = RequestMethod.POST)
    @ResponseBody
    public Object userEmailRegister(HttpServletRequest request,User user) {
        /**
         * @Author zhou
         * @Date 2018/5/28 11:38
         * @Param [user:用户邮箱注册的信息]
         * @Desc 用户邮箱注册
         */
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱不能为空");
            map.put("msg2", "登录密码不能为空");
            map.put("msg3", "资金密码不能为空");
            map.put("msg4", "邮箱格式错误");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Mailbox cannot be empty");
            map.put("msg2", "The login password can not be empty");
            map.put("msg3", "Capital cipher can not be empty");
            map.put("msg4", "Mailbox format error");
        }
        if (null == user.getEmail() || StringUtils.isBlank(user.getEmail())) {
            result.setCode(ResultCode.CODE_ERROR_10);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(user.getEmail())) {
            result.setCode(ResultCode.CODE_ERROR_4);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setCode(ResultCode.CODE_ERROR_2);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == user.getPayPassword() || StringUtils.isBlank(user.getPayPassword())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", user.getEmail());
        hashMap.put("password", user.getPassword());
        hashMap.put("payPassword", user.getPayPassword());
        hashMap.put("refereeId", user.getRefereeId());

        String json = userService.userEmaillRegister(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



}
