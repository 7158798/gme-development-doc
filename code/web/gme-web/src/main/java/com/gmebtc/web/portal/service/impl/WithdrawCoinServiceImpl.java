package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.WithdrawCoinService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/29 17:11
 * @Desc 提币service
 */
@Service(value = "withdrawCoinService")
public class  WithdrawCoinServiceImpl implements WithdrawCoinService {

    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/29 17:12
     * @Param [request, withdrawId:	提币编号, payPassword:资金密码]
     * @Desc 取消提币
     */
    @Override
    public String cancelWithdraw(HttpServletRequest request, HashMap<String,String> hashMap) {
        String method = SERVICE_BASE_PARAM + "cancelWithdraw&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/29 17:25
     * @Param [request, hashMap]
     * @Desc 删除提币地址
     */
    @Override
    public String withdrawAddressDel(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "withdrawAddressDel&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/29 21:04
     * @Param [request, hashMap]
     * @Desc 添加提币地址
     */
    @Override
    public String withdrawAddressAdd(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "withdrawAddressAdd&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 10:53
     * @Param [request, hashMap]
     * @Desc 查询提币地址
     */
    @Override
    public String getWithdrawAddress(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getWithdrawAddress&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 16:43
     * @Param [request, hashMap]
     * @Desc 提币请求
     */
    @Override
    public String widthrawCoin(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "widthrawCoin&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 16:54
     * @Param [request]
     * @Desc 查询提币历史记录
     */
    @Override
    public String getWithdrawHistory(HttpServletRequest request,HashMap<String,String> hashMap) {
        String method = SERVICE_BASE_PARAM + "getWithdrawHistory&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


}
