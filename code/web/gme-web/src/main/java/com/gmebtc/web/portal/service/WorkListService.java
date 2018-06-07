package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface WorkListService {
    String getWorkListInfo(HttpServletRequest request);

    String sendWorkList(HttpServletRequest request, HashMap<String, String> hashMap);

    String replyWorkList(HttpServletRequest request, HashMap<String, String> hashMap);
}
