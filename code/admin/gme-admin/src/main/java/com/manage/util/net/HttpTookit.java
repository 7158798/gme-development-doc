package com.manage.util.net;


import com.manage.util.ConfigUtil;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** 
* HTTP工具箱 
* 
* @author leizhimin 2009-6-19 16:36:18 
*/ 
public final class HttpTookit { 
        private static Log log = LogFactory.getLog(HttpTookit.class); 
        private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        private static HttpClient client = new HttpClient(connectionManager); 
        private static int TIME_OUT=com.manage.util.StringUtil.convert2Int(ConfigUtil.get("REQUEST_WAIT_TIME"));

        /** 
         * 执行一个HTTP GET请求，返回请求响应的HTML 
         * 
         * @param url                 请求的URL地址 
         * @param queryString 请求的查询参数,可以为null 
         * @param charset         字符集 
         * @param pretty            是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doGet(String url, String queryString, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpMethod method = new GetMethod(url); 
//                client.setTimeout(100);
                client.getHttpConnectionManager().getParams().setConnectionTimeout(TIME_OUT); //指的是连接一个url的连接等待时间。    
                client.getHttpConnectionManager().getParams().setSoTimeout(TIME_OUT); //指的是连接上一个url，获取response的返回等待时间  
                HttpMethodParams params = new HttpMethodParams();
                params.setContentCharset("UTF-8");
                method.setParams(params);
                try { 
                        if (StringUtils.isNotBlank(queryString)) 
                                //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
                                method.setQueryString(URIUtil.encodeQuery(queryString)); 
                        client.executeMethod(method); 
                        System.out.println("HttpStatus:"+method.getStatusCode()+" "+ method.getStatusText());
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator"));
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (URIException e) { 
                        log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
                } catch (IOException e) { 
                        log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 

        /** 
         * 执行一个HTTP POST请求，返回请求响应的HTML 
         * 
         * @param url         请求的URL地址 
         * @param params    请求的查询参数,可以为null 
         * @param charset 字符集 
         * @param pretty    是否美化 
         * @return 返回请求响应的HTML 
         * @throws IOException 
         */ 
        public static HttpData doPost(String url, Map<String, String> params, String charset, boolean pretty) throws Exception { 
                StringBuffer response = new StringBuffer(); 
                PostMethod method = new PostMethod(url);
                HttpData httpdata = new HttpData();
                //client.setTimeout(100);
                client.getHttpConnectionManager().getParams().setConnectionTimeout(TIME_OUT); //指的是连接一个url的连接等待时间。    
                client.getHttpConnectionManager().getParams().setSoTimeout(TIME_OUT); //指的是连接上一个url，获取response的返回等待时间  
                method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");    
                method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
                //设置Http Post数据 
                if (params != null) { 
                        List<NameValuePair> nvps= new ArrayList<NameValuePair>();
                        NameValuePair temp = null;
                        for (Map.Entry<String, String> entry : params.entrySet()) { 
                        	  temp = new NameValuePair(entry.getKey(), new String(entry.getValue().getBytes("utf-8"), "iso-8859-1"));
                        	  nvps.add(temp);
                        } 
                        NameValuePair[] ddd = new NameValuePair[nvps.size()]; 
                        ddd = nvps.toArray(ddd);
                        method.setRequestBody(ddd);
                } 
                try { 
                        client.executeMethod(method); 
                        httpdata.setStatusCode(method.getStatusCode());
                        httpdata.setStatusText(method.getStatusText());
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator"));
                                        else {
                                                response.append(line);
                                        }
                                }
                                reader.close(); 
                        } 
                        httpdata.setResponse(response.toString());
                } catch (Exception e) { 
                	 httpdata.setStatusCode(999);
                	 httpdata.setStatusText(e.getMessage());
                	 log.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
                	 throw e;
                } finally { 
                        method.releaseConnection(); 
                } 
                return httpdata;
        } 

}