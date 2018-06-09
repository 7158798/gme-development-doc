package com.manage.sys.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单权限列表
 */
public class SysMenuPersions implements Serializable{
	/**编号*/	
	private java.lang.String id;
	/**菜单名*/	
	private java.lang.String menuName;
	/**是否有权限 1 菜单 2 权限*/	
	private java.lang.Integer type;
	/**是否被选中 1是 0否*/	
	private java.lang.Integer isCheck;
	
	/**编号*/	
	private java.lang.String pid;
	
	private List<SysMenuPersions> childrens=new ArrayList<SysMenuPersions>();

	/**类型_父ID_id*/
	private String hj;
	
	public java.lang.String getMenuName() {
		return menuName;
	}


	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}


	public java.lang.Integer getType() {
		return type;
	}


	public void setType(java.lang.Integer type) {
		this.type = type;
	}


	public List<SysMenuPersions> getChildrens() {
		return childrens;
	}


	public void setChildrens(List<SysMenuPersions> childrens) {
		this.childrens = childrens;
	}


	public java.lang.Integer getIsCheck() {
		return isCheck;
	}


	public void setIsCheck(java.lang.Integer isCheck) {
		this.isCheck = isCheck;
	}


	public java.lang.String getId() {
		return id;
	}


	public void setId(java.lang.String id) {
		this.id = id;
	}


	public java.lang.String getPid() {
		return pid;
	}


	public void setPid(java.lang.String pid) {
		this.pid = pid;
	}


	public String getHj() {
		return hj;
	}


	public void setHj(String hj) {
		this.hj = hj;
	}


	
	
}
