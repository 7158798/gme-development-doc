package com.manage.sys.vo;

import com.manage.base.entity.BaseVO;



/**
* 后台管理员查询bean
*/
public class Sys_user_VO extends BaseVO{
	/**编号*/	
	private java.lang.Long id;
	/**登录名*/	
	private java.lang.String userName;
	/**登录密码*/	
	private java.lang.String userPwd;
	/**用户状态:1-正常;2-禁用*/	
	private java.lang.Integer status;
	/**校验类型 1 新增  2修改*/	
	private java.lang.String checkType;
	
	/**真实姓名*/	
	private java.lang.String truename;
	/**联系电话*/	
	private java.lang.String phone;
	
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.lang.String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(java.lang.String userPwd) {
		this.userPwd = userPwd;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.String getCheckType() {
		return checkType;
	}
	public void setCheckType(java.lang.String checkType) {
		this.checkType = checkType;
	}
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.String getTruename() {
		return truename;
	}
	public void setTruename(java.lang.String truename) {
		this.truename = truename;
	}
	public java.lang.String getPhone() {
		return phone;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

}
