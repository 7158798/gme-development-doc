package com.gmebtc.web.portal.service;

import com.gmebtc.web.portal.entity.Coin;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface IndexService {
    String getTopPrice(HttpServletRequest request, HashMap<String, String> hashMap);

    String getCoinInfo(HttpServletRequest request,HashMap<String,String> hashMap);

}
