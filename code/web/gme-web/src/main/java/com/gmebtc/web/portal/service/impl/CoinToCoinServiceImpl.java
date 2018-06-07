package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.CoinToCoinService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/*
 * @Author zhou
 * @Date 2018/5/30 17:05
 * @Desc 币币交易
 */
@Service(value = "coinToCoinService")
public class CoinToCoinServiceImpl implements CoinToCoinService {

    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/30 17:05
     * @Param [request]
     * @Desc 取消订单
     */
    @Override
    public String cancelBBOrder(HttpServletRequest request,HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "cancelBBOrder&";
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 17:28
     * @Param [request, hashMap]
     * @Desc 币币交易
     */
    @Override
    public String bbBuySell(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "bbBuySell&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 14:57
     * @Param [request, hashMap]
     * @Desc 平台实时交易记录
     */
    @Override
    public String getTransactions(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getTransactions&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:04
     * @Param [request, hashMap]
     * @Desc 我的交易记录
     */
    @Override
    public String getUserTransactions(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getUserTransactions&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:08
     * @Param [request, hashMap]
     * @Desc 我的委托记录
     */
    @Override
    public String getUserOrder(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getUserOrder&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:11
     * @Param [request, hashMap]
     * @Desc 买卖委托单
     */
    @Override
    public String getBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getBuySellOrders&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
}
