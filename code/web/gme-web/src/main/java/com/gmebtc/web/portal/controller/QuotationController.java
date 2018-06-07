package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.service.QuotationService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/29 11:18
 * @Desc 行情及k线
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class QuotationController {

    @Resource(name = "quotationService")
    private QuotationService quotationService;


    /**
     * @Author zhou
     * @Date 2018/5/29 11:53
     * @Param [request, symbol:交易对比如：（btc_usdt), type:时间]
     * @Desc k线接口
     */
    @RequestMapping(value = "/kline",method = RequestMethod.POST)
    @ResponseBody
    public Object kline (HttpServletRequest request,@RequestParam String symbol,@RequestParam String type){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("symbol", symbol);
        hashMap.put("type", type);
        String json = quotationService.kline(request,hashMap);
        return Toolkits.messageTransformation(request,json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/29 11:58
     * @Param [request, symbol:交易对比如：（btc_usdt)]
     * @Desc 币行情
     */
    @RequestMapping(value = "/ticker",method = RequestMethod.POST)
    @ResponseBody
    public Object ticker (HttpServletRequest request,@RequestParam String symbol){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("symbol", symbol);
        String json = quotationService.ticker(request,hashMap);
        return Toolkits.messageTransformation(request,json);
    }
    
}
