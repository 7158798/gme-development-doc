/*
 * 文 件 名  :  ResultJson.java
 * 版    权    :  Ltd. Copyright (c) 2013 深圳市商巢互联网软件有限公司,All rights reserved
 * 描    述    :  <描述>
 * 创建人    :  彭彩云
 * 创建时间:  下午3:37:26
 */
package com.gmebtc.web.portal.net.modle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * JSON对象
 * 
 * @author 彭彩云
 * @version [版本号, 2013-7-1]
 */
public class ResultJson implements Serializable {

	private static final long serialVersionUID = -8948747420144666605L;

	private boolean success = false;
	private String code;
	private String message;
	private Object data;

	public ResultJson(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 返回该类的json字符串
	 * 
	 * @return
	 */
	public String toString() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", code);
		resultMap.put("message", message);
		resultMap.put("object", data);
		JSONObject jsonObject = JSONObject.fromObject(resultMap);
		return jsonObject.toString();
	}
}
