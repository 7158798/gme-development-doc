package com.manage.util.net;

import com.manage.util.net.modle.ResultJson;
import com.manage.util.ConfigUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @param
 * @Description: 封装API消息头 和 连接后台服务
 * @Author : Jinny.Ding
 * @Date: 2016年10月1日 下午3:50:25
 * @Version: 1.0 .
 */
public class CommonUtil {

    public static final String url = ConfigUtil.get("SERVICE_SITE");

    private static Logger log = Logger.getLogger(CommonUtil.class);

    public static final String ROLE_ID = "roleId";

    public static final String USER_ID = "userId";
    public static final String PWD = "pwd";
    public static final String USER_TYPE = "userType";
    public static final String TOKEN = "token";
    public static final String GME = "gme";
    public static final String ACCOUNT = "account";

    public static ResultJson getResultJson(String data, HttpServletRequest request, String method) throws UnsupportedEncodingException {
        return getResultJson(data, request, method, "");
    }

    public static ResultJson getResultJson(HttpServletRequest request, String method) throws UnsupportedEncodingException {
        return getResultJson(request, method, "");
    }
    /**
     * @param
     * @return
     * @throws UnsupportedEncodingException
     * @description 连接后台服务
     * @date 2015-10-17下午3:54:15
     */
    public static ResultJson getResultJson(String data, HttpServletRequest request, String method, String reqUrl) throws UnsupportedEncodingException {
        ResultJson resultJson = new ResultJson(true);
        //HttpSession session = request.getSession();
        Object json = new JSONTokener(data).nextValue();
        Map<String, String> param = getCommonHead(request, method);
        String postUrl = "";
        if ("".equals(reqUrl) && !"".equals(method)) {
            postUrl = url + method;
        } else {
            postUrl = reqUrl;
        }
        if (json instanceof JSONObject) {
            //param.put("data", data);
            JSONObject dataParam = JSONObject.fromObject(data);
            for (Object keyObject : dataParam.keySet()) {
                String key = keyObject.toString();
                String value = dataParam.getString(key);
                param.put(key, value);
            }
        } else if (json instanceof JSONArray) {
            param.put("json_array", data);
        }

        String paramStr = param.toString();
        log.info("请求地址：" + postUrl);
        log.info("请求参数：" + paramStr);


        //String paramStr =  CryptoUtil.aesEncrypt(paramStr, "12456789");
        //logger.info("加密后的参数：" + paramStr);
        doPost(resultJson, param, postUrl);
        return resultJson;
    }

    public static ResultJson getResultJson(HttpServletRequest request, String method, String reqUrl) throws UnsupportedEncodingException {
        ResultJson resultJson = new ResultJson(true);
        //HttpSession session = request.getSession();
        Map<String, String> param = getCommonHead(request, method);
        param.putAll(getParameterMap(request));
        String postUrl = "";
        if ("".equals(reqUrl) && !"".equals(method)) {
            postUrl = url + method;
        } else {
            postUrl = reqUrl;
        }

        String paramStr = param.toString();
        log.info("请求地址：" + postUrl);
        log.info("请求参数：" + paramStr);


        //String paramStr =  CryptoUtil.aesEncrypt(paramStr, "12456789");
        //logger.info("加密后的参数：" + paramStr);
        doPost(resultJson, param, postUrl);
        return resultJson;
    }

    private static void doPost(ResultJson resultJson, Map<String, String> param, String postUrl) {
        try {
            HttpData httpData = HttpTookit.doPost(postUrl, param, "utf-8", true);
            Integer statusCode = httpData.getStatusCode();
            String statusText = httpData.getStatusText();
            String response = httpData.getResponse();
            log.info("statusCode:" + statusCode + "  statusText:" + statusText);
            //response =  CryptoUtil.aesDecrypt(paramStr, "12456789");
//			byte[] responseByte =  Base64Utils.decode(response);
//			response = new String(responseByte,"utf-8");
            log.info("服务器响应内容：" + response);
            if (statusCode == HttpStatus.SC_OK) {
                JSONObject resultObject = JSONObject.fromObject(response);
                String msg = resultObject.getString("message");
                resultJson.setMessage(msg);
                resultJson.setCode("200");
                resultJson.setData(resultObject);

            }
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject resultObject = new JSONObject();
            resultObject.put("code", "-2");
            resultObject.put("message", "系统繁忙，请稍后再试");
            resultObject.put("data", "");
            resultJson.setMessage("系统繁忙，请稍后再试");
            resultJson.setSuccess(false);
            resultJson.setData(resultObject);
        }
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 14:20
     * @Param [request]
     * @Desc 从request中获得参数map,并返回可读的map
     */
    private static Map getParameterMap (HttpServletRequest request){
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }


    /**
     * 封装API消息头
     *
     * @param request
     * @param method
     * @return
     */
    public static Map<String, String> getCommonHead(HttpServletRequest request, String method) {

        HashMap<String, String> head = new HashMap<String, String>();
        HttpSession session = request.getSession();
        String format = ConfigUtil.get("format");
        String appType = ConfigUtil.get("appType");
        String appVersion = ConfigUtil.get("appVersion");
        String timestamp = System.currentTimeMillis() + "";
        //session.setAttribute(USER_ID, "21322");
        Object uid = (session.getAttribute(CommonUtil.USER_ID) == null ? "" : session.getAttribute(CommonUtil.USER_ID));
        Object utype = (session.getAttribute(USER_TYPE) == null ? "" : session.getAttribute(USER_TYPE));
        Object token = (session.getAttribute(TOKEN) == null ? "" : session.getAttribute(TOKEN));

        StringBuffer sb = new StringBuffer(GME);
        sb.append("appKey").append("");
        sb.append("appType").append(appType);
        sb.append("appVersion").append(appVersion);
        sb.append("channelId").append("");
        sb.append("format").append(format);
        sb.append("timestamp").append(timestamp);
        sb.append("token").append(token);
        sb.append("uid").append(uid);
        sb.append("utype").append(utype);
        sb.append(GME);

        String sign = CryptoUtil.md5Encode(sb.toString()).toUpperCase();

        head.put("appKey", "");
        head.put("appType", appType);
        head.put("appVersion", appVersion);
        head.put("channelId", "");
        head.put("format", format);
        head.put("timestamp", timestamp);
        head.put("token", token.toString());
        head.put("uid", uid.toString());
        head.put("utype", utype.toString());
        head.put("sign", sign);


        Map<String, String> requestBody = new HashMap<String, String>();
        requestBody.put("sysParams", JSONObject.fromObject(head).toString());

        return requestBody;
    }
}
