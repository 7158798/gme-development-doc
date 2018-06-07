package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.entity.Coin;
import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.WithdrawCoinService;
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
 * @Date 2018/5/29 16:13
 * @Desc 提币控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class WithdrawCoinController {

    @Resource(name = "withdrawCoinService")
    private WithdrawCoinService withdrawCoinService;


    /**
     * @Author zhou
     * @Date 2018/5/29 17:10
     * @Param [request, withdrawId:	提币编号, payPassword:资金密码]
     * @Desc 取消提币
     */
    @RequestMapping(value = "/cancelWithdraw",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelWithdraw (HttpServletRequest request, @RequestParam String withdrawId, @RequestParam String payPassword){
        HttpSession session = request.getSession();
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

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("withdrawId",withdrawId);
        hashMap.put("payPassword",payPassword);
        
        String json = withdrawCoinService.cancelWithdraw(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/29 17:22
     * @Param [request, walletAddressId:钱包地址编号, payPassword:资金密码]
     * @Desc 删除提币地址
     */
    @RequestMapping(value = "/withdrawAddressDel",method = RequestMethod.POST)
    @ResponseBody
    public Object withdrawAddressDel (HttpServletRequest request,@RequestParam String walletAddressId,@RequestParam String payPassword){
        HttpSession session = request.getSession();
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

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("walletAddressId",walletAddressId);
        hashMap.put("payPassword",payPassword);

        String json = withdrawCoinService.withdrawAddressDel(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/29 20:59
     * @Param [request, coinType:币种类型, address:地址, remarks:备注, payPassword:资金密码]
     * @Desc 添加提币地址
     */
    @RequestMapping(value = "/withdrawAddressAdd",method = RequestMethod.POST)
    @ResponseBody
    public Object withdrawAddressAdd (HttpServletRequest request,@RequestParam String coinType,
                                      @RequestParam String address,@RequestParam String remarks,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "提币地址不能为空");
            map.put("msg2", "资金密码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The address of the coin can not be empty");
            map.put("msg2", "Capital cipher can not be empty");
        }
        if (null == address || StringUtils.isBlank(address)) {
            result.setCode(ResultCode.CODE_ERROR_5);
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

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType",coinType);
        hashMap.put("address",address);
        hashMap.put("remarks",remarks);
        hashMap.put("payPassword",payPassword);

        String json = withdrawCoinService.withdrawAddressAdd(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 10:52
     * @Param [request, coinType:币种类型]
     * @Desc 查询提币地址
     */
    @RequestMapping(value = "/withdrawAddress",method = RequestMethod.POST)
    @ResponseBody
    public Object getWithdrawAddress (HttpServletRequest request,@RequestParam String coinType){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType",coinType);
        String json = withdrawCoinService.getWithdrawAddress(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 11:10
     * @Param [request, coinType:币种类型, address:接受币地址, amount:数量, payPassword:资金密码, phoneCode:手机验证码]
     * @Desc 提币请求
     */
    @RequestMapping(value = "/widthrawCoin",method = RequestMethod.POST)
    @ResponseBody
    public Object widthrawCoin (HttpServletRequest request,@RequestParam String coinType,@RequestParam String address
                                ,@RequestParam String amount,@RequestParam String payPassword,@RequestParam String phoneCode){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "提币地址不能为空");
            map.put("msg2", "提币数量不能为空");
            map.put("msg3", "资金密码不能为空");
            map.put("msg4", "手机验证码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The address of the coin can not be empty");
            map.put("msg2", "The amount of money can not be empty");
            map.put("msg3", "Capital cipher can not be empty");
            map.put("msg4", "The phone verification code cannot be empty");
        }
        if (null == address || StringUtils.isBlank(address)) {
            result.setCode(ResultCode.CODE_ERROR_16);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == amount || StringUtils.isBlank(amount)) {
            result.setCode(ResultCode.CODE_ERROR_5);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == phoneCode || StringUtils.isBlank(phoneCode)) {
            result.setCode(ResultCode.CODE_ERROR_11);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        hashMap.put("address", address);
        hashMap.put("amount", amount);
        hashMap.put("payPassword", payPassword);
        hashMap.put("phoneCode", phoneCode);

        String json = withdrawCoinService.widthrawCoin(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/30 16:55
     * @Param [request]
     * @Desc 查询提币历史记录
     */
    @RequestMapping(value = "/withdrawHistory",method = RequestMethod.POST)
    @ResponseBody
    public Object getWithdrawHistory (HttpServletRequest request,@RequestParam String coinType){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        String json = withdrawCoinService.getWithdrawHistory(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


}
