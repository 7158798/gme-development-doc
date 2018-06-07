package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.RechargeCoinService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/31 16:06
 * @Desc 充币
 */
@Service(value = "rechargeCoinService")
public class RechargeCoinServiceImpl implements RechargeCoinService {
    
    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;



    /**
     * @Author zhou
     * @Date 2018/5/31 16:28
     * @Param [request, hashMap]
     * @Desc 查询充币记录
     */
    @Override
    public String getWalletRecharge(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getWalletRecharge&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
}
