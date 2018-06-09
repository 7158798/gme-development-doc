package com.manage.base.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author tianyh 
 * @Description:国际短信发送接口demo
 */
public class InternationSMS {
	
	private static final Logger logger = LogManager.getLogger(HttpUtil.class);
	
	public static void main(String[] args){
		
		String cncode = "86";
		String phone = "18838195487";
		String code ="1234";
		
		//请求地址
		String url="http://intapi.253.com/send/json";
		
		//API账号，50位以内。必填
		String account="I6507506";	
		
		//API账号对应密钥，联系客服获取。必填
		String password="FnfRsBSgtK7f62";
		
		//短信内容。长度不能超过536个字符。必填
		String msg = "";
		if(cncode.equals("86")){
			msg = "【玖币交易所】欢迎使用玖币网短信验证码功能，您的验证码为: "+code;// 短信内容
		}else{
			msg = "【Ninecoin Exchange】 Welcome to Ninecoin Exchange SMS verification code process. Your verification code is: "+code;// 短信内容
		}
		
		//手机号码，格式(区号+手机号码)，例如：8615800000000，其中86为中国的区号，区号前不使用00开头,15800000000为接收短信的真实手机号码。5-20位。必填
	//	String mobile="66971811997";//60102399166   //660971811997
		String mobile= cncode + phone;
		
		//组装请求参数
		JSONObject map = new JSONObject();
		map.put("account", account);
		map.put("password", password);
		map.put("msg", msg);
		map.put("mobile", mobile);

		String params = map.toString();
		logger.info("请求参数为:" + params);
		
		try {
			String result = HttpUtil.post(url, params);
			JSONObject jsonObject =  JSON.parseObject(result);
			String status = jsonObject.get("code").toString();
			String msgid = jsonObject.get("msgid").toString();
			String error = jsonObject.get("error").toString();
			logger.info("状态码:" + status + ",状态码说明:" + error + ",消息id:" + msgid);
		} catch (Exception e) {
			logger.error("请求异常：" + e);
		}
	}
	
}
