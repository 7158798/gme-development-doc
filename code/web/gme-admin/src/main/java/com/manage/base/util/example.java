package com.manage.base.util;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class example {
	
	private static final Logger logger = LogManager.getLogger(example.class);
	
	public static void main(String[] args) throws IOException {
		
		String cncode = "86";
		String phone = "18826547209";
		String code ="1234";
		
		
	//	String account="jctechhttp";	
	//	String password="J@7y6NvC";
		
		String api_key = "jctechhttp";
		String api_secret= "J@7y6NvC";
		//短信内容。长度不能超过536个字符。必填
		String msg = "";
		if(cncode.equals("86")){
			msg = "【玖币交易所】欢迎使用玖币网短信验证码功能，您的验证码为: "+code;// 短信内容
		}else{
			msg = "【Ninecoin Exchange】 Welcome to Ninecoin Exchange SMS verification code process. Your verification code is: "+code;// 短信内容
		}
		String mobile= cncode + phone;
		
		
		// Declare new MoceanSMS and specify API key and secret
		moceanSMS moceansms = new moceanSMS(api_key,api_secret);
		
		String rest_response;
		// 1. Send SMS - .sendSMS(from, to, message) method to send a message
		String rest_response1 = moceansms.sendSMS("Ninecoin", mobile, msg);
	//	String rest_response1 = moceansms.sendSMS("Ninecoin", "+60102399166", "Hello! This is a test message!");
		System.out.println("\n响应体 ： "+rest_response1);
		
		// 2. Query account balance
		rest_response = moceansms.accountBalance();
		System.out.println("查询账户余额 ： "+rest_response);
	    
	    
	    // 3. Query account pricing .accountPricing(mcc, mnc)
		rest_response = moceansms.accountPricing("502","16");
		System.out.println("查询账户定价 ： "+rest_response);
	    
	    
	    // 4. Query message status .messageStatus(msg_id)
		rest_response = moceansms.messageStatus("mocean123");
		System.out.println("查询消息状态 ： "+rest_response);
		
		//短信状态解析
		JSONObject jsonObject = JSONObject.fromObject(rest_response1);  
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
		logger.info("状态码: " + status + " , 状态码说明: " + error + " , 消息id: " + msgid);
		
		 
	} 
}
