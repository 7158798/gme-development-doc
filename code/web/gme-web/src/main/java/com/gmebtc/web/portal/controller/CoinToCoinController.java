package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.CoinToCoinService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;


/*
 * @Author zhou
 * @Date 2018/5/30 16:58
 * @Desc 币币交易
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class CoinToCoinController {


    @Resource(name = "coinToCoinService")
    private CoinToCoinService coinToCoinService;


    /**
     * @Author zhou
     * @Date 2018/5/30 17:07
     * @Param [request]
     * @Desc 取消订单
     */
    @RequestMapping(value = "/cancelBBOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object cancelBBOrder(HttpServletRequest request,@RequestParam String orderNum) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("orderNum", orderNum);
        String json = coinToCoinService.cancelBBOrder(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 17:26
     * @Param [request, coinTradeId:交易币种对, amount:交易数量, type:交易类型-1买，2卖, price:交易价格, payPassword:资金密码]
     * @Desc 币币交易
     */
    @RequestMapping(value = "/bbBuySell", method = RequestMethod.POST)
    @ResponseBody
    public Object bbBuySell(HttpServletRequest request, @RequestParam String coinTradeId, @RequestParam String amount
            , @RequestParam String type, @RequestParam String price, @RequestParam String payPassword) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "交易数量不能为空");
            map.put("msg2", "资金密码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The number of transactions cannot be empty");
            map.put("msg2", "Capital cipher can not be empty");
        }
        if (null == amount || StringUtils.isBlank(amount)) {
            result.setCode(ResultCode.CODE_ERROR_17);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinTradeId", coinTradeId);
        hashMap.put("amount", amount);
        hashMap.put("type", type);
        hashMap.put("price", price);
        hashMap.put("payPassword", payPassword);
        String json = coinToCoinService.bbBuySell(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 14:54
     * @Param [request, coinTradeId:币币交易对, page, pageSize]
     * @Desc 平台实时交易
     */
    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public Object getTransactions(HttpServletRequest request, @RequestParam String coinTradeId, @RequestParam(defaultValue = "1") String page
            , @RequestParam String pageSize) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinTradeId", coinTradeId);
        hashMap.put("page", page);
        hashMap.put("pageSize", pageSize);
        String json = coinToCoinService.getTransactions(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:04
     * @Param [request, coinTradeId, page]
     * @Desc 我的交易记录
     */
    @RequestMapping(value = "/userTransactions", method = RequestMethod.POST)
    @ResponseBody
    public Object getUserTransactions(HttpServletRequest request, @RequestParam String coinTradeId
            , @RequestParam(defaultValue = "1") String page) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinTradeId", coinTradeId);
        hashMap.put("page", page);
        String json = coinToCoinService.getUserTransactions(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:06
     * @Param [request, coinTradeId, tradeType:交易类型 1买，2卖, page, pageSize]
     * @Desc 我的委托记录
     */
    @RequestMapping(value = "/userOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object getUserOrder (HttpServletRequest request,@RequestParam String coinTradeId,@RequestParam String tradeType
                                ,@RequestParam(defaultValue = "1") String page,@RequestParam String pageSize){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinTradeId", coinTradeId);
        hashMap.put("tradeType", tradeType);
        hashMap.put("page", page);
        hashMap.put("pageSize", pageSize);
        String json = coinToCoinService.getUserOrder(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 15:10
     * @Param [request, coinTradeId, type, pageSize]
     * @Desc 买卖委托单
     */
    @RequestMapping(value = "/buySellOrders",method = RequestMethod.POST)
    @ResponseBody
    public Object getBuySellOrders (HttpServletRequest request,@RequestParam String coinTradeId,@RequestParam String type
                                    ,@RequestParam String pageSize){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinTradeId", coinTradeId);
        hashMap.put("tradeType", type);
        hashMap.put("pageSize", pageSize);
        String json = coinToCoinService.getBuySellOrders(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }
}
