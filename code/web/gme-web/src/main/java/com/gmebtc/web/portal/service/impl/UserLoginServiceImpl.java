package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.UserLoginService;
import com.gmebtc.web.portal.utils.HttpClientUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;


/*
 * @Author zhou
 * @Date 2018/5/28 12:15
 * @Desc 用户登录,忘记登录密码,注销登录 服务类
 */
@Service(value = "userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    private Logger logger = Logger.getLogger(UserLoginServiceImpl.class);

    // 获得eolinker的基础参数
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;



    /**
     * @Author zhou
     * @Date 2018/5/28 14:22
     * @Param [request, user, method]
     * @Desc 用户登录
     */
    @Override
    public String login(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "userLogin&";
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/28 14:27
     * @Param [request, method]
     * @Desc 用户登出
     */
    @Override
    public String logout(HttpServletRequest request) {
        String method = SERVICE_BASE_PARAM + "userLoginOut&";
        return SendRequestUtil.sendRequest(request,method);
    }

    /**
     * @Author zhou
     * @Date 2018/5/28 16:19
     * @Param [request, user]
     * @Desc 用户忘记密码，重置
     */
    @Override
    public String forgetPassword(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "resetPwd&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }






    /**
     * @Author zhou
     * @Date 2018/5/31 10:22
     * @Param [request, hashMap]
     * @Desc 获取图像验证码
     */
    @Override
    public void getImgCode(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getImgCode&";
        try {
            byte[] isb = HttpClientUtil.doGetForImageCode(method, hashMap);
            ServletOutputStream sos = response.getOutputStream();
            sos.write(isb);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
