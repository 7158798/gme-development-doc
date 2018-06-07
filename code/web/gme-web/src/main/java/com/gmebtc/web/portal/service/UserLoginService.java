package com.gmebtc.web.portal.service;


import com.gmebtc.web.portal.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public interface UserLoginService {

    String login(HttpServletRequest request, HashMap<String, String> hashMap);

    String logout (HttpServletRequest request);

    String forgetPassword(HttpServletRequest request, HashMap<String, String> hashMap);

    void getImgCode(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> hashMap);
}
