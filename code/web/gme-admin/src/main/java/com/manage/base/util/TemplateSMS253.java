package com.manage.base.util;

import java.io.IOException;

import net.sf.json.JSONArray;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TemplateSMS253 {
	
	private static final Logger logger = LogManager.getLogger(TemplateSMS253.class);
	
	public static int sendSMS(String phone, String msg, String cncode) throws IOException {
		System.out.println("短信请求参数 phone: " + phone+" cncode :"+cncode+" msg : "+msg);
		if(phone.startsWith("0"))
		{
			phone = phone.substring(1, phone.length());
			System.out.println("phone:"+phone+" msg:"+msg+" cncode:"+cncode);
		}
		
		if(cncode.equals("60") || cncode.equals("+60")){
			return sendMoceanSMS(phone, msg, cncode);
		}else{
			return sendInternationSMS(phone, msg, cncode);
		}
	}
	
	//发送国际短信
	public static int sendInternationSMS(String phone, String msg, String cncode){
		
		//请求地址
		String url="http://intapi.253.com/send/json";
		
		//API账号，50位以内。必填
		String account="I6507506";	
		
		//API账号对应密钥，联系客服获取。必填
		String password="FnfRsBSgtK7f62";
		
		//手机号码，格式(区号+手机号码)，例如：8615800000000，其中86为中国的区号，区号前不使用00开头,15800000000为接收短信的真实手机号码。5-20位。必填
	//	String mobile="8618838195487";
		String mobile = cncode+phone;
		
		//组装请求参数
		JSONObject map=new JSONObject();
		map.put("account", account);
		map.put("password", password);
		map.put("msg", msg);
		map.put("mobile", mobile);

		String params = map.toString();
		String status ="";
		try {
			String result = HttpUtil.post(url, params);
			JSONObject jsonObject =  JSON.parseObject(result);
			status = jsonObject.get("code").toString();
			String msgid = jsonObject.get("msgid").toString();
			String error = jsonObject.get("error").toString();
			if(status.equals("0")){
				error = "短信发送成功";
			}
			
			System.out.println("短信回调状态码: " + status + "  ,状态码说明: " + error + "  ,消息id: " + msgid);
		} catch (Exception e) {
			System.out.println("请求异常：" + e);
		}
		return Integer.parseInt(status);
	}
	
	//马来西亚短信发送
	public static int sendMoceanSMS(String phone, String msg, String cncode) throws IOException {
		
		String api_key = "jctechhttp";
		String api_secret= "J@7y6NvC";
		//短信内容。长度不能超过536个字符。必填
		String mobile= cncode + phone;
		
		moceanSMS moceansms = new moceanSMS(api_key,api_secret);
		
		String rest_response = moceansms.sendSMS("Ninecoin", mobile, msg);
	//	String rest_response1 = moceansms.sendSMS("Ninecoin", "+60102399166", "Hello! This is a test message!");
		System.out.println("\n响应体 ： "+rest_response);
		
		//短信状态解析
		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(rest_response);  
        String jsonData = jsonObject.getString("messages");  
		JSONArray jsonArray = JSONArray.fromObject(jsonData);  
        //取出数组第一个元素  
        String status = jsonArray.getJSONObject(0).get("status").toString();  
		String msgid = jsonArray.getJSONObject(0).get("msgid").toString();
		String error = "";
		if(status.equals("0")){
			error="消息发送成功";
		}else{
			error="消息发送失败";
		}
		logger.info("短信状态码: " + status + " , 状态码说明: " + error + " , 消息id: " + msgid);
		
		return Integer.parseInt(status);
	}
	
	
}
