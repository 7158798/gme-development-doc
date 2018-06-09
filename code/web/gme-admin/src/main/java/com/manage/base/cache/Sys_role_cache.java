package com.manage.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manage.sys.entity.Sys_rmenu;
import com.manage.sys.entity.Sys_role;
import com.manage.sys.entity.Sys_rpersion;

public class Sys_role_cache {
	
	public static Map<String,Object> map = new HashMap<String, Object>();

	public static void setRolesInCache(List<Sys_role> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_roles", list);
		for (Sys_role ll_sys_role : list) {
			map.put("ll_sys_roles_"+ll_sys_role.getId(), ll_sys_role);
		}
	}

	public static List<Sys_role> getRolesFromCache(){
		List<Sys_role> list = (List<Sys_role>)map.get("ll_sys_roles");
		return list;
	}

	public static Sys_role getOneRoleFromCache(Long rId){
		Sys_role ll_sys_role = (Sys_role)map.get("ll_sys_roles_"+rId);
		return ll_sys_role;
	}

	public static void setRoleMenusInCache(List<Sys_rmenu> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_rmenus", list);
	}

	public static List<Sys_rmenu> getRoleMenusFromCache(){
		List<Sys_rmenu> list = (List<Sys_rmenu>)map.get("ll_sys_rmenus");
		return list;
	}

	/**
	 * 获取用户一级菜单
	 * @param rId 用户角色id
	 * @return
	 */
	public static List<Sys_rmenu> getOneRoleMenusFromCache(Long rId){
		List<Sys_rmenu> list = (List<Sys_rmenu>)map.get("ll_sys_rmenus");
		if(list == null){
			return new ArrayList<Sys_rmenu>();
		}
		List<Sys_rmenu> rlist = new ArrayList<Sys_rmenu>();
		for (Sys_rmenu ll_sys_rmenu : list) {
			if(ll_sys_rmenu.getRole_id().toString().equals(rId.toString())){
				rlist.add(ll_sys_rmenu);
			}
		}
		return rlist;
	}
	
	/**
	 * 获取用户二级菜单
	 * @param list
	 */
	public static void setRoleMenusPersionInCache(List<Sys_rpersion> list){
		if(list == null || list.size() == 0){
			return;
		}
		map.put("ll_sys_rpersions", list);
	}

	public static List<Sys_rpersion> getRoleMenusPersionFromCache(){
		List<Sys_rpersion> list = (List<Sys_rpersion>)map.get("ll_sys_rpersions");
		return list;
	}
	
}
