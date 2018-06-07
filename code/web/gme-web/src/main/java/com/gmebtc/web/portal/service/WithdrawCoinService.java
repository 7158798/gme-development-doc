package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface WithdrawCoinService {
    String cancelWithdraw(HttpServletRequest request, HashMap<String,String> hashMap);

    String withdrawAddressDel(HttpServletRequest request, HashMap<String, String> hashMap);

    String withdrawAddressAdd(HttpServletRequest request, HashMap<String, String> hashMap);

    String getWithdrawAddress(HttpServletRequest request, HashMap<String, String> hashMap);

    String widthrawCoin(HttpServletRequest request, HashMap<String, String> hashMap);

    String getWithdrawHistory(HttpServletRequest request,HashMap<String, String> hashMap);
}
