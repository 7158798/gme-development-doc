package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface ConsumerTransactionService {
    String c2cBuySellUsdt(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cBusAddBuySellOrder(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cBusCanceOrder(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cGetBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cCancelByUser(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cUserOrderHistory(HttpServletRequest request, HashMap<String, String> hashMap);

    String c2cApplyBus(HttpServletRequest request);
}
