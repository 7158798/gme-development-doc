package com.manage.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.Sys_role_cache;
import com.manage.sys.dao.Sys_rpersion_DAO;
import com.manage.sys.entity.Sys_rpersion;
/**
 * 角色菜单功能服务
 */
@Transactional(readOnly = true)
@Service("Sys_rpersion_Service")
public class Sys_rpersion_Service{

    @Resource(name = "Sys_rpersion_DAO")
    private Sys_rpersion_DAO sys_rpersion_dao;

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Sys_rpersion ll_sys_rpersion) throws Exception {
        Integer result = sys_rpersion_dao.add(ll_sys_rpersion);
        return result > 0 ? true : false;
    }
    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long rid,java.lang.Long mid,Long perssionId) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(rid!=null){
    		map.put("role_id", rid);
    	}if(mid!=null){
    		map.put("menu_id", mid);
    	}if(perssionId!=null){
    		map.put("perssionId", perssionId);
    	}
        Integer result = sys_rpersion_dao.deleteData(map);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
     * 缓存角色权限
     */
    public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sys_rpersion> list=sys_rpersion_dao.selectAll(map);
		Sys_role_cache.setRoleMenusPersionInCache(list);
	}


}
