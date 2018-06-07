package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface CoinToCoinService {
    String cancelBBOrder(HttpServletRequest request,HashMap<String, String> hashMap);

    String bbBuySell(HttpServletRequest request, HashMap<String, String> hashMap);

    String getTransactions(HttpServletRequest request, HashMap<String, String> hashMap);

    String getUserTransactions(HttpServletRequest request, HashMap<String, String> hashMap);

    String getUserOrder(HttpServletRequest request, HashMap<String, String> hashMap);

    String getBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap);
}
