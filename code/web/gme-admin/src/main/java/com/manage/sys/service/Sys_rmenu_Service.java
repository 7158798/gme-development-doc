package com.manage.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.Sys_menu_cache;
import com.manage.base.cache.Sys_role_cache;
import com.manage.sys.dao.Sys_rmenu_DAO;
import com.manage.sys.entity.Sys_menu;
import com.manage.sys.entity.Sys_persion;
import com.manage.sys.entity.Sys_rmenu;
import com.manage.sys.entity.Sys_rpersion;
import com.manage.sys.vo.SysMenuPersions;
/**
 * 角色权限服务
 */
@Transactional(readOnly = true)
@Service("Sys_rmenu_Service")
public class Sys_rmenu_Service{

    @Resource(name = "Sys_rmenu_DAO")
    private Sys_rmenu_DAO sys_rmenu_dao;
    @Resource(name = "Sys_rpersion_Service")
    private Sys_rpersion_Service sys_rpersion_Service;
    /**
     * 批量新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addBatch(String str,Long role_id) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("role_id", role_id);
		sys_rpersion_Service.delete(role_id, null, null);
		sys_rmenu_dao.deleteData(map);
        if(str!=null){
        	String[]st=str.split(",");
        	for(int i=0;i<st.length;i++){
        		if(st[i].equals("")){
        			continue;
        		}
        		String[]ts=st[i].split("_");
        		if(ts[0].toString().equals("2")){
        			continue;
        		}
        		Sys_rmenu ll_sys_rmenu=new Sys_rmenu();
        		ll_sys_rmenu.setMenu_id(Long.parseLong(ts[2]));
        		ll_sys_rmenu.setRole_id(role_id);
        		Integer d=sys_rmenu_dao.add(ll_sys_rmenu);
            	for(int j=0;j<st.length;j++){
            		if(st[j].equals("")){
            			continue;
            		}
            		String[]ts2=st[j].split("_");
            		
            		if(ts[2].equals(ts2[1])){
            			if(ts2[0].equals("1")){
                			continue;
                		}
            			Sys_rpersion ll_sys_rpersion=new Sys_rpersion();
            			ll_sys_rpersion.setPerssionid(Long.parseLong(ts2[2]));
            			ll_sys_rpersion.setRolemenuid(ll_sys_rmenu.getId());
            			sys_rpersion_Service.add(ll_sys_rpersion);
            		}
            	}
            }
        }
        cacheSysRoleMenu();
        sys_rpersion_Service.cache();
        return true;
    }

    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id,java.lang.Long mid,Long rid) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(id!=null){
			map.put("id", id);
		}if(mid!=null){
			map.put("menu_id", mid);
		}if(rid!=null){
			map.put("role_id", rid);
		}
        Integer result = sys_rmenu_dao.deleteData(map);
        if(result>0){
        	cacheSysRoleMenu();
        }
        return result > 0 ? true : false;
    }
    /**
     * 缓存数据
     * @throws Exception
     */
	public void cacheSysRoleMenu()throws Exception{
		List<Sys_rmenu> list=sys_rmenu_dao.selectAll(null);
		Sys_role_cache.setRoleMenusInCache(list);
	}
	
	 /**
	 * 获取所有数据 组成树型返回 缓存中获取
	 */
	public List<SysMenuPersions> selectCheckBoxTree(List<Sys_menu> list,Long roleId) throws Exception{
		if(roleId==null){
			return null;
		}
		List<Sys_rmenu> roleMenus=Sys_role_cache.getOneRoleMenusFromCache(roleId);
		if(roleMenus==null){
			cacheSysRoleMenu();
			roleMenus=Sys_role_cache.getRoleMenusFromCache();
		}
		
		List<SysMenuPersions> result=new ArrayList<SysMenuPersions>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0") && list.get(i).getIsshow().toString().equals("1")){
				SysMenuPersions sysMenuPersions=new SysMenuPersions();
				sysMenuPersions.setId(list.get(i).getId().toString());
				sysMenuPersions.setMenuName(list.get(i).getMenuname());
				sysMenuPersions.setType(1);
				sysMenuPersions.setIsCheck(0);
				sysMenuPersions.setPid("0");
				for(int j=0;j<roleMenus.size();j++){
					if(list.get(i).getId().toString().equals(roleMenus.get(j).getMenu_id().toString())){
						sysMenuPersions.setIsCheck(1);
						break;
					}
				}
				getCheckBoxChild(sysMenuPersions, list,roleMenus);
				result.add(sysMenuPersions);
			}
		}
		return result;
	}
	/**
	 * 组成树返回
	 * @param sysMenuPersions
	 * @param list
	 * @param list2
	 */
	private void getCheckBoxChild(SysMenuPersions sysMenuPersions,List<Sys_menu> list,List<Sys_rmenu> list2){
		List<Sys_rpersion> list3=Sys_role_cache.getRoleMenusPersionFromCache();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals(sysMenuPersions.getId().toString())){
				SysMenuPersions sysMenuPersions2=new SysMenuPersions();
				sysMenuPersions2.setId(list.get(i).getId().toString());
				sysMenuPersions2.setMenuName(list.get(i).getMenuname());
				sysMenuPersions2.setType(1);
				sysMenuPersions2.setIsCheck(0);
				sysMenuPersions.setPid(sysMenuPersions.getId());
				Long rmId=null;
				for(int j=0;j<list2.size();j++){
					if(list.get(i).getId().toString().equals(list2.get(j).getMenu_id().toString())){
						rmId=list2.get(j).getId();
						sysMenuPersions2.setIsCheck(1);
						break;
					}
				}
				sysMenuPersions.getChildrens().add(sysMenuPersions2);
				getCheckBoxChild(sysMenuPersions2,list, list2);
				//获取权限列表
				List<Sys_persion> persions=Sys_menu_cache.getPersionByMenuIdFromCache(Long.parseLong(sysMenuPersions2.getId()));
				if(persions!=null && persions!=null){
					for(int z=0;z<persions.size();z++){
						SysMenuPersions sysMenuPersions3=new SysMenuPersions();
						sysMenuPersions3.setId(persions.get(z).getId().toString());
						sysMenuPersions3.setMenuName(persions.get(z).getPersiondec());
						sysMenuPersions3.setType(2);
						sysMenuPersions3.setIsCheck(0);
						sysMenuPersions3.setPid(sysMenuPersions2.getId());
						if(rmId!=null && list3!=null && list3.size()!=0){
							for(int j=0;j<list3.size();j++){
								if(persions.get(z).getId().toString().equals(list3.get(j).getPerssionid().toString()) && rmId.toString().equals(list3.get(j).getRolemenuid().toString())){
									sysMenuPersions3.setIsCheck(1);
									break;
								}
							}
						}
						sysMenuPersions2.getChildrens().add(sysMenuPersions3);
					}
				}
			}
		}
	}

}
