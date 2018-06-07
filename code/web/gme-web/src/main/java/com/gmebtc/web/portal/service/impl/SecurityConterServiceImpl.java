package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/30 18:26
 * @Desc 安全中心
 */
@Service(value = "securityConterService")
public class SecurityConterServiceImpl implements SecurityConterService {


    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/30 18:50
     * @Param [request, hashMap]
     * @Desc 修改登录密码
     */
    @Override
    public String modifyLoginPwd(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "modifyLoginPwd&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    /**
     * @Author zhou
     * @Date 2018/5/30 19:03
     * @Param [request, hashMap]
     * @Desc 修改资金密码
     */
    @Override
    public String resetPayPassword(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "resetPayPassword&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:05
     * @Param [request, hashMap]
     * @Desc 发生邮件
     */
    @Override
    public String sendEmail(HttpServletRequest request, HashMap<String, String> hashMap) {
       String method = SERVICE_BASE_PARAM + "sendEmail&";
       return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    /**
     * @Author zhou
     * @Date 2018/5/30 20:21
     * @Param [request, hashMap]
     * @Desc 实名认证
     */
    @Override
    public String identifyAuth(HttpServletRequest request, HashMap<String, String> hashMap) {
       String method = SERVICE_BASE_PARAM + "identifyAuth&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:27
     * @Param [request]
     * @Desc 检验是否实名认证
     */
    @Override
    public String checkHasIdentify(HttpServletRequest request) {
        String method = SERVICE_BASE_PARAM + "checkHasIdentify&";
        return SendRequestUtil.sendRequest(request, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:48
     * @Param [request, hashMap]
     * @Desc 绑定银行卡
     */
    @Override
    public String payMethedBank(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "payMethedBank&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 21:01
     * @Param [request, hashMap]
     * @Desc 绑定支付宝或者微信
     */
    @Override
    public String payMethedAlipayWeChat(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "payMethedAlipayWeChat&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 21:12
     * @Param [request, hashMap]
     * @Desc 检查用户是否存在
     */
    @Override
    public String checkUserExsit(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "checkUserExsit&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 21:25
     * @Param [request, hashMap]
     * @Desc 绑定手机号
     */
    @Override
    public String bindPhone(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "bindPhone&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 21:30
     * @Param [request, hashMap]
     * @Desc 绑定邮箱
     */
    @Override
    public String bindEmail(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "bindEmail&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 20:57
     * @Param [request, hashMap]
     * @Desc 邮箱激活验证
     */
    @Override
    public String emailActiveCheck(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "emailActiveCheck&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
}
