package com.manage.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manage.sys.entity.Sys_menu;
import com.manage.sys.entity.Sys_persion;


public class Sys_menu_cache {
	
	public static Map<String,Object> map = new HashMap<String, Object>();
	public static Map<String,Object> map2 = new HashMap<String, Object>();

	public static void putAllInCache(List < Sys_menu > list){
		if(list == null || list.size() == 0){
			return;
		}
		map.clear();
		map.put("ll_sys_menus", list);
		for (Sys_menu ll_sys_menu : list) {
			map.put("ll_sys_menu_"+ll_sys_menu.getId(), ll_sys_menu);
		}
	}

	public static List<Sys_menu> getMenusListFromCache(){
		List<Sys_menu> list = (List<Sys_menu>)map.get("ll_sys_menus");
		return list;
	}

	public static Sys_menu getOneMenuFromCache(Long mId){
		Sys_menu sys_menu = (Sys_menu)map.get("ll_sys_menu_"+mId);
		return sys_menu;
	}
	

	public static void setPersionInCache(List<Sys_persion> list){
		if(list == null || list.size() == 0){
			return;
		}
		map2.clear();
		map2.put("ll_sys_persions", list);
	}

	public static List<Sys_persion> getPersionListFromCache(){
		List<Sys_persion> list = (List<Sys_persion>)map2.get("ll_sys_persions");
		return list;
	}

	public static List<Sys_persion> getPersionByMenuIdFromCache(Long mid){
		List<Sys_persion> list = (List<Sys_persion>)map2.get("ll_sys_persions");
		List<Sys_persion> result = new ArrayList<Sys_persion>();
		if(list!=null && list.size() != 0){
			if(list!=null && list.size() != 0){
				for (Sys_persion ll_sys_persion : list) {
					if(ll_sys_persion.getMid().toString().equals(mid.toString())){
						result.add(ll_sys_persion);
					}
				}
			}
		}
		return result;
	}
}
