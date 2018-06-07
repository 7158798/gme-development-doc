package com.gmebtc.web.portal.net;

public class HttpData {

	private int statusCode = 200;
	private String statusText = "";
	private String response = "";
	
	public HttpData() {
		// TODO Auto-generated constructor stub
	}
	
	public HttpData(int statusCode, String statusText, String response) {
		super();
		this.statusCode = statusCode;
		this.statusText = statusText;
		this.response = response;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	

}
