package com.gmebtc.web.portal.service;

import com.gmebtc.web.portal.entity.Coin;
import com.gmebtc.web.portal.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface UserService {
    String userPhoneRegister(HttpServletRequest request,HashMap<String, String> hashMap);


    String userEmaillRegister(HttpServletRequest request, HashMap<String, String> hashMap);
}