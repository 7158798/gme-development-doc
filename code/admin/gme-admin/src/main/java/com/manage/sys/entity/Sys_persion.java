package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_persion
 *  注释:菜单功能表
 */
 
public class Sys_persion implements Serializable{
	/**自增ID*/	
	private java.lang.Long id;
	/**菜单编号*/	
	private java.lang.Long mid;
	/**权限*/	
	private java.lang.String persion;
	/**权限描述*/	
	private java.lang.String persiondec;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setMid(java.lang.Long mid){
		this.mid=mid;
	}
	public java.lang.Long getMid(){
		return this.mid;
	}
	public void setPersion(java.lang.String persion){
		this.persion=persion;
	}
	public java.lang.String getPersion(){
		return this.persion;
	}
	public void setPersiondec(java.lang.String persiondec){
		this.persiondec=persiondec;
	}
	public java.lang.String getPersiondec(){
		return this.persiondec;
	}
}
