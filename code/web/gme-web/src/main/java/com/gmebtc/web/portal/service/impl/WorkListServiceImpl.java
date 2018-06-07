package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.WorkListService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/30 17:43
 * @Desc 工单系统
 */
@Service(value = "workListService")
public class WorkListServiceImpl implements WorkListService {


    @Value("${SERVICE_BASE_PARAM}")
    private String SERVICE_BASE_PARAM;


    /**
     * @Author zhou
     * @Date 2018/5/30 17:44
     * @Param [request]
     * @Desc 查询我的工单
     */
    @Override
    public String getWorkListInfo(HttpServletRequest request) {
        String method = SERVICE_BASE_PARAM + "getWorkListInfo&";
        return SendRequestUtil.sendRequest(request, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 18:00
     * @Param [request, hashMap]
     * @Desc 提交工单
     */
    @Override
    public String sendWorkList(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "sendWorkList&";
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }

    /**
     * @Author zhou
     * @Date 2018/6/1 19:40
     * @Param [request, hashMap]
     * @Desc 回复工单
     */
    @Override
    public String replyWorkList(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = SERVICE_BASE_PARAM + "replyWorkList&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
}
