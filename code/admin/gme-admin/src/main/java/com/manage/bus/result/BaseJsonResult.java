package com.manage.bus.result;

import java.io.Serializable;

/**
 * 基本json返回类
 * @author 
 *
 */
public class BaseJsonResult implements Serializable{
	//  0成功  1失败
	private Integer rtCode;
	//具体执行状态内容描述
	private String rtMsg;
	
	private Object object;
	private java.sql.Timestamp date;
	public Integer getRtCode() {
		return rtCode;
	}
	public void setRtCode(Integer rtCode) {
		this.rtCode = rtCode;
	}
	public String getRtMsg() {
		return rtMsg;
	}
	public void setRtMsg(String rtMsg) {
		this.rtMsg = rtMsg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public java.sql.Timestamp getDate() {
		return date;
	}
	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}
	
}
