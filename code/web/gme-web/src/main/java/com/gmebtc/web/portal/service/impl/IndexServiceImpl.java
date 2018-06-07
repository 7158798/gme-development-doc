package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.entity.Coin;
import com.gmebtc.web.portal.service.IndexService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/29 10:34
 * @Desc 首页top行情,币种行情
 */
@Service(value = "indexService")
public class IndexServiceImpl implements IndexService {

    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/29 10:38
     * @Param [request, map:存放的是当前语言]
     * @Desc 首页Top行情
     */
    @Override
    public String getTopPrice(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getTopPrice&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 14:32
     * @Param [request]
     * @Desc 首页币种行情信息
     */
    @Override
    public String getCoinInfo (HttpServletRequest request,HashMap<String,String> hashMap){
        String method = SERVICE_BASE_PARAM + "getCoinInfo&";
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


}
