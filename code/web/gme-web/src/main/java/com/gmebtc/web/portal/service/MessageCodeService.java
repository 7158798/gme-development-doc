package com.gmebtc.web.portal.service;

import com.gmebtc.web.portal.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface MessageCodeService {

    String getMessageCode(HttpServletRequest request, HashMap<String, String> hashMap);

    String checkPhoneCode(HttpServletRequest request, HashMap<String, String> hashMap);

}
