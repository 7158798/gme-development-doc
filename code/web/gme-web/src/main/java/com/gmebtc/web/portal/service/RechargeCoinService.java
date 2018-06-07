package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface RechargeCoinService {
    String getWalletRecharge(HttpServletRequest request, HashMap<String, String> hashMap);
}
