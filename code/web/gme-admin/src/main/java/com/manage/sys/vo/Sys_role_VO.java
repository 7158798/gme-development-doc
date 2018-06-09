package com.manage.sys.vo;

import com.manage.base.entity.BaseVO;



/**
* 角色说明查询bean
*/
public class Sys_role_VO extends BaseVO{
	/**角色名称*/	
	private java.lang.String roleName;
	/**角色编号*/
	private java.lang.Long id;
	/**新增的菜单列表*/	
	private java.lang.String menuIds;
	
	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(java.lang.String menuIds) {
		this.menuIds = menuIds;
	}

}
