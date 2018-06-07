package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_rpersion
 *  注释:角色菜单功能
 */
 
public class Sys_rpersion implements Serializable{
	/**自增ID*/	
	private java.lang.Long id;
	/**功能id*/	
	private java.lang.Long rolemenuid;
	/**角色菜单id*/	
	private java.lang.Long perssionid;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setRolemenuid(java.lang.Long rolemenuid){
		this.rolemenuid=rolemenuid;
	}
	public java.lang.Long getRolemenuid(){
		return this.rolemenuid;
	}
	public void setPerssionid(java.lang.Long perssionid){
		this.perssionid=perssionid;
	}
	public java.lang.Long getPerssionid(){
		return this.perssionid;
	}
}
