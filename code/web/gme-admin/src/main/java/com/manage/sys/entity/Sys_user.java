package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_user
 *  注释:后台管理员
 */
 
public class Sys_user implements Serializable{
	/***/	
	private java.lang.Long id;
	/**登录名*/	
	private java.lang.String username;
	/**登录密码*/	
	private java.lang.String userpwd;
	/**真实姓名*/	
	private java.lang.String truename;
	/**联系电话*/	
	private java.lang.String phone;
	/**qq*/	
	private java.lang.String qq;
	/**邮箱*/	
	private java.lang.String email;
	/**角色ID：对应sys_role的id*/	
	private java.lang.Long roleid;
	/**用户状态:1-正常;2-禁用*/	
	private java.lang.Integer status;
	/**记录创建时间*/	
	private java.sql.Timestamp createtime;
	
	private String language;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setUsername(java.lang.String username){
		this.username=username;
	}
	public java.lang.String getUsername(){
		return this.username;
	}
	public void setUserpwd(java.lang.String userpwd){
		this.userpwd=userpwd;
	}
	public java.lang.String getUserpwd(){
		return this.userpwd;
	}
	public void setTruename(java.lang.String truename){
		this.truename=truename;
	}
	public java.lang.String getTruename(){
		return this.truename;
	}
	public void setPhone(java.lang.String phone){
		this.phone=phone;
	}
	public java.lang.String getPhone(){
		return this.phone;
	}
	public void setQq(java.lang.String qq){
		this.qq=qq;
	}
	public java.lang.String getQq(){
		return this.qq;
	}
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	public java.lang.String getEmail(){
		return this.email;
	}
	public void setRoleid(java.lang.Long roleid){
		this.roleid=roleid;
	}
	public java.lang.Long getRoleid(){
		return this.roleid;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return this.createtime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Sys_user [id=" + id + ", username=" + username + ", userpwd=" + userpwd + ", truename=" + truename + ", phone=" + phone + ", qq="
				+ qq + ", email=" + email + ", roleid=" + roleid + ", status=" + status + ", createtime=" + createtime + ", language=" + language
				+ "]";
	}
	
}
