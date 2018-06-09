package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_role
 *  注释:角色说明
 */
 
public class Sys_role implements Serializable{
	/**自增ID*/	
	private java.lang.Long id;
	/**角色名称*/	
	private java.lang.String rolename;
	/**说明*/	
	private java.lang.String remark;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setRolename(java.lang.String rolename){
		this.rolename=rolename;
	}
	public java.lang.String getRolename(){
		return this.rolename;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
	}
}
