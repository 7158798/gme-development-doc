package com.manage.sys.entity;
import java.io.Serializable;
/**
 *	表名：ll_sys_rmenu
 *  注释:角色权限
 */
 
public class Sys_rmenu implements Serializable{
	
	private static final long serialVersionUID = -7296152939176682689L;
	
	/**自增ID*/	
	private java.lang.Long id;
	/**角色编号*/	
	private java.lang.Long role_id;
	/**菜单编号*/	
	private java.lang.Long menu_id;
	
	public void setId(java.lang.Long id){
		this.id = id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setRole_id(java.lang.Long role_id){
		this.role_id = role_id;
	}
	public java.lang.Long getRole_id(){
		return this.role_id;
	}
	public void setMenu_id(java.lang.Long menu_id){
		this.menu_id = menu_id;
	}
	public java.lang.Long getMenu_id(){
		return this.menu_id;
	}
	
	@Override
	public String toString() {
		return "Sys_rmenu [id=" + id + ", role_id=" + role_id + ", menu_id=" + menu_id + "]";
	}
	
}
