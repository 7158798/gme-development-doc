package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.service.BalanceService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*
 * @Author zhou
 * @Date 2018/5/29 17:59
 * @Desc 我的资产
 */
@Controller
@RequestMapping("${ROOT_PATH}/user")
public class BalanceController {

    @Resource(name = "balanceService")
    private BalanceService balanceService;


    /**
     * @Author zhou
     * @Date 2018/5/29 18:00
     * @Param [request]
     * @Desc  查询我的资产
     */
    @RequestMapping(value = "/balance",method = RequestMethod.POST)
    @ResponseBody
    public Object getBalance (HttpServletRequest request){
       String json = balanceService.getBalance(request);
       return Toolkits.messageTransformation(request,json);
    }

}
