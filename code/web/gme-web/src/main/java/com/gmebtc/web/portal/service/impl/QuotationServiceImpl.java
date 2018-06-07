package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.QuotationService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service(value = "quotationService")
public class QuotationServiceImpl implements QuotationService {

    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;

    /**
     * @Author zhou
     * @Date 2018/5/29 11:54
     * @Param [request, map]
     * @Desc k线接口
     */
    @Override
    public String kline(HttpServletRequest request,HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "kline&";
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/29 12:00
     * @Param [request, map]
     * @Desc 币行情
     */
    @Override
    public String ticker(HttpServletRequest request,HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "ticker&";
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }
}
