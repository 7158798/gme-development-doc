package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.entity.User;
import com.gmebtc.web.portal.service.MessageCodeService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/28 18:07
 * @Desc 短信验证码
 */
@Service(value = "messageCodeService")
public class MessageCodeServiceImpl implements MessageCodeService {

    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/28 18:09
     * @Param [request, user:短信验证码用户信息]
     * @Desc 发送短信验证码
     */
    @Override
    public String getMessageCode(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getPhoneCheckCode&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    /**
     * @Author zhou
     * @Date 2018/5/28 18:34
     * @Param [request, user]
     * @Desc 验证验证码
     */
    @Override
    public String checkPhoneCode(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "checkPhoneCode&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
}
