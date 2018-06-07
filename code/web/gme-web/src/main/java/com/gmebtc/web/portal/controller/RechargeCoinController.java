package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.service.RechargeCoinService;
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
 * @Date 2018/5/31 15:40
 * @Desc 充币
 */
@Controller
@RequestMapping("${ROOT_PATH}/user")
public class RechargeCoinController {


    @Resource(name = "rechargeCoinService")
    private RechargeCoinService rechargeCoinService;


    /**
     * @Author zhou
     * @Date 2018/5/31 16:26
     * @Param [request, coinType:币种, page]
     * @Desc 查询充币记录
     */
    @RequestMapping(value = "/getWalletRecharge",method = RequestMethod.POST)
    @ResponseBody
    public Object getWalletRecharge (HttpServletRequest request, @RequestParam String coinType
                                    ,@RequestParam(defaultValue = "1") String page) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", coinType);
        hashMap.put("page", page);
        String json = rechargeCoinService.getWalletRecharge(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }

}
