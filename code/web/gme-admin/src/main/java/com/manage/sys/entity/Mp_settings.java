package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：mp_settings
 *  注释:配置表，全局配置
 */
 
public class Mp_settings implements Serializable{
	/**主键自曾长*/	
	private java.lang.Long id;
	/**配置表键*/	
	private java.lang.String skey;
	/**配置表 值*/	
	private java.lang.String svalue;
	/**配置表，字段描述*/	
	private java.lang.String sdesc;
	/**创建时间*/	
	private java.sql.Timestamp createDate;
	
	private String sshow;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setSkey(java.lang.String skey){
		this.skey=skey;
	}
	public java.lang.String getSkey(){
		return this.skey;
	}
	public void setSvalue(java.lang.String svalue){
		this.svalue=svalue;
	}
	public java.lang.String getSvalue(){
		return this.svalue;
	}
	public void setSdesc(java.lang.String sdesc){
		this.sdesc=sdesc;
	}
	public java.lang.String getSdesc(){
		return this.sdesc;
	}
	public void setCreateDate(java.sql.Timestamp createDate){
		this.createDate=createDate;
	}
	public java.sql.Timestamp getCreateDate(){
		return this.createDate;
	}
	public String getSshow() {
		return sshow;
	}
	public void setSshow(String sshow) {
		this.sshow = sshow;
	}
	
}
