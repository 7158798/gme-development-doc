package com.manage.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;

import com.manage.base.cache.Sys_menu_cache;
import com.manage.base.cache.Sys_role_cache;
import com.manage.sys.entity.Sys_menu;
import com.manage.sys.entity.Sys_persion;
import com.manage.sys.entity.Sys_rmenu;
import com.manage.sys.entity.Sys_role;
import com.manage.sys.entity.Sys_rpersion;
import com.manage.sys.entity.Sys_user;

/**
 * 登录用户帮助类
 */
public class UserUtil {
	
	/**
	 * 获取用户的 权限列表 缓存中获取
	 * @param roleId 角色编号
	 * @return
	 */
	public static List<String> getUserStringPermission(Long roleId){
		List<Sys_rmenu> list = Sys_role_cache.getOneRoleMenusFromCache(roleId);
		List<Sys_rpersion> list2 = Sys_role_cache.getRoleMenusPersionFromCache();
		List<Sys_persion> list3 = Sys_menu_cache.getPersionListFromCache();
		List<String> permissions = new ArrayList<String>();
		for (Sys_rmenu Ll_sys_rmenu_entiy : list) {
			String rmid = Ll_sys_rmenu_entiy.getId().toString();
			for (Sys_rpersion ll_sys_rpersion : list2) {
				if(ll_sys_rpersion.getRolemenuid().toString().equals(rmid)){
					for (Sys_persion ll_sys_persion : list3) {
						if(ll_sys_persion.getId().toString().equals(ll_sys_rpersion.getPerssionid().toString())){
							permissions.add(ll_sys_persion.getPersion());
							break;
						}
					}
				}
			}
		}
		return permissions;
	}
	
	/**
	 * 获取当前登录用户
	 */
	public static Sys_user getCurUser(){
		Sys_user user = (Sys_user)SecurityUtils.getSubject().getPrincipal();
		return user;
	}
	
	/**
	 * 获取当前登录用户角色
	 */
	public static Sys_role getCurUserRol(){
		Sys_user user = (Sys_user)SecurityUtils.getSubject().getPrincipal();
		Sys_role ll_sys_role = Sys_role_cache.getOneRoleFromCache(user.getRoleid());
		if(ll_sys_role == null){
			return new Sys_role();
		}
		return ll_sys_role;
	}
	
	/**
	 * 获取当前用户的 一级菜单列表
	 * @return
	 */
	public static List<Sys_menu> getUserFirstMenus(){
		try{
			Sys_user user = getCurUser();
			if(user == null){
				return new ArrayList<Sys_menu>();
			}
			List<Sys_rmenu> list = Sys_role_cache.getOneRoleMenusFromCache(user.getRoleid());
			List<Sys_menu> menus = new ArrayList<Sys_menu>();
			Map<Long,Long> map = new HashMap<Long,Long>();
			for (Sys_rmenu ll_sys_rmenu : list) {
				Sys_menu ll_sys_menu = Sys_menu_cache.getOneMenuFromCache(ll_sys_rmenu.getMenu_id());
				if(ll_sys_menu == null){
					continue;
				}
				Sys_menu first = Sys_menu_cache.getOneMenuFromCache(ll_sys_menu.getMenufatherid());
				if(first == null){
					continue;
				}
				if(map.get(ll_sys_menu.getMenufatherid()) == null){
					map.put(ll_sys_menu.getMenufatherid(), ll_sys_menu.getMenufatherid());
					menus.add(first);
				}
			}
			Collections.sort(menus);
			return menus;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当前用户的菜单列表
	 * @return
	 */
	public static Map<Long,List<Sys_menu>> getUserSecondMenus(){
		Sys_user user = getCurUser();
		if(user == null){
			return new HashMap<Long,List<Sys_menu>>();
		}
		List<Sys_rmenu> list = Sys_role_cache.getOneRoleMenusFromCache(user.getRoleid());
		Map<Long,List<Sys_menu>> menus = new HashMap<Long,List<Sys_menu>>();
		for (Sys_rmenu Ll_sys_rmenu_entiy : list) {
			Sys_menu ll_sys_menu = Sys_menu_cache.getOneMenuFromCache(Ll_sys_rmenu_entiy.getMenu_id());
			if(ll_sys_menu == null){
				continue;
			}
			List<Sys_menu> temp = menus.get(ll_sys_menu.getMenufatherid());
			if(temp == null){
				temp = new ArrayList<Sys_menu>();
				menus.put(ll_sys_menu.getMenufatherid(), temp);
			}
			temp.add(ll_sys_menu);
		}
		return menus;
	}

}
