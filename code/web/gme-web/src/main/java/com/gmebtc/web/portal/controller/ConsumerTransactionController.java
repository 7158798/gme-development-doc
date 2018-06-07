package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.ConsumerTransactionService;
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
import java.util.Map;

/*
 * @Author zhou
 * @Date 2018/5/31 16:47
 * @Desc c2c交易
 */
@Controller
@RequestMapping("${ROOT_PATH}/user")
public class ConsumerTransactionController {


    @Resource(name = "consumerTransactionService")
    private ConsumerTransactionService consumerTransactionService;


    /**
     * @Author zhou
     * @Date 2018/5/31 16:50
     * @Param [request, orderNum:订单ID, type:1买，2卖, amount:数量, payPassword:资金密码]
     * @Desc 买卖USDT
     */
    @RequestMapping(value = "/c2cBuySellUsdt",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cBuySellUsdt (HttpServletRequest request, @RequestParam String orderNum,@RequestParam String type
                                  ,@RequestParam String amount,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "交易数量不能为空");
            map.put("msg2", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The number of transactions can not be empty");
            map.put("msg2", "Capital cipher can not be empty");
        }
        if (null == amount || StringUtils.isBlank(amount)) {
            result.setCode(ResultCode.CODE_ERROR_3);
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
        hashMap.put("orderNum", orderNum);
        hashMap.put("type", type);
        hashMap.put("amount", amount);
        hashMap.put("payPassword", payPassword);

        String json = consumerTransactionService.c2cBuySellUsdt(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 17:13
     * @Param [request, coinType:币种类型，现在默认USDT,
     * amount:数量, type:1买。2卖, min:最小数量, price:价格,
     * payMethed:支付宝，微信，银行卡, payPassword:资金密码]
     * @Desc 商家发布买卖订单
     */
    @RequestMapping(value = "/c2cBusAddBuySellOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cBusAddBuySellOrder (HttpServletRequest request,@RequestParam String coinType
                                        ,@RequestParam String amount,@RequestParam String type,@RequestParam String min
                                        ,@RequestParam String price,@RequestParam String payMethed,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "交易数量不能为空");
            map.put("msg2", "最小数量不能为空");
            map.put("msg3", "至少选择一种交易方式");
            map.put("msg4", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The number of transactions can not be empty");
            map.put("msg2", "The minimum number can not be empty");
            map.put("msg3", "Choose at least one way of trading");
            map.put("msg4", "Capital cipher can not be empty");
        }
        if (null == amount || StringUtils.isBlank(amount)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == min || StringUtils.isBlank(min)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == payMethed || StringUtils.isBlank(payMethed)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        hashMap.put("amount", amount);
        hashMap.put("type", type);
        hashMap.put("min", min);
        hashMap.put("price", price);
        hashMap.put("payMethed", payMethed);
        hashMap.put("payPassword", payPassword);

        String json = consumerTransactionService.c2cBusAddBuySellOrder(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 17:28
     * @Param [request, orderNum, coinType, payPassword]
     * @Desc 商家取消订单
     */
    @RequestMapping(value = "/c2cBusCanceOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cBusCanceOrder (HttpServletRequest request,@RequestParam String orderNum
                                    ,@RequestParam String coinType,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Capital cipher can not be empty");
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("orderNum", orderNum);
        hashMap.put("coinType", coinType);
        hashMap.put("payPassword", payPassword);
        String json = consumerTransactionService.c2cBusCanceOrder(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 17:32
     * @Param [request, coinType, page]
     * @Desc 获取市场挂单
     */
    @RequestMapping(value = "/c2cGetBuySellOrders",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cGetBuySellOrders (HttpServletRequest request,@RequestParam String coinType
                                        ,@RequestParam(defaultValue = "1") String page){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        hashMap.put("page", page);
        String json = consumerTransactionService.c2cGetBuySellOrders(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/31 17:36
     * @Param [request, orderNum, payPassword, remarks:备注]
     * @Desc 用户取消订单
     */
    @RequestMapping(value = "/c2cCancelByUser",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cCancelByUser (HttpServletRequest request,@RequestParam String orderNum
                                    ,@RequestParam String payPassword,@RequestParam String remarks){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Capital cipher can not be empty");
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("orderNum", orderNum);
        hashMap.put("payPassword", payPassword);
        hashMap.put("remarks", remarks);
        String json = consumerTransactionService.c2cCancelByUser(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/31 17:40
     * @Param [request, coinType, tradeType, status, startDate, endDate, page]
     * @Desc 用户订单记录
     */
    @RequestMapping(value = "/c2cUserOrderHistory",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cUserOrderHistory (HttpServletRequest request,@RequestParam String coinType
                                        ,@RequestParam String tradeType,@RequestParam String status
                                        ,@RequestParam String startDate,@RequestParam String endDate
                                        ,@RequestParam String page){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        hashMap.put("tradeType", tradeType);
        hashMap.put("status", status);
        hashMap.put("startDate", startDate);
        hashMap.put("endDate", endDate);
        hashMap.put("page", page);
        String json = consumerTransactionService.c2cUserOrderHistory(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/31 17:45
     * @Param [request]
     * @Desc 申请成为商家
     */
    @RequestMapping(value = "/c2cApplyBus",method = RequestMethod.POST)
    @ResponseBody
    public Object c2cApplyBus (HttpServletRequest request){
        String json = consumerTransactionService.c2cApplyBus(request);
        return Toolkits.messageTransformation(request, json);
    }
}
