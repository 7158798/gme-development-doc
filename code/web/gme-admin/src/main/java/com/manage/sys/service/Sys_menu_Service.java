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
import com.manage.base.entity.PageInfo;
import com.manage.sys.dao.Sys_menu_DAO;
import com.manage.sys.entity.Sys_menu;
import com.manage.sys.vo.Sys_menu_VO;
/**
 * 菜单服务
 */
@Transactional(readOnly = true)
@Service("Sys_menu_Service")
public class Sys_menu_Service{

    @Resource(name = "Sys_menu_DAO")
    private Sys_menu_DAO sys_menu_dao;

    /**
     * 分页查询
     */
    public PageInfo selectPage(Sys_menu_VO ll_sys_menu_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", ll_sys_menu_vo.getRows());
        map.put("BEGIN", (ll_sys_menu_vo.getPage() - 1) * ll_sys_menu_vo.getRows());
        Integer count = this.sys_menu_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(ll_sys_menu_vo.getRows(), ll_sys_menu_vo.getPage(), count, new ArrayList<Sys_menu>());
        }
        List<Sys_menu> list = this.sys_menu_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(ll_sys_menu_vo.getRows(), ll_sys_menu_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public Sys_menu get(java.lang.Long ID) throws Exception {
        Sys_menu ll_sys_menu = sys_menu_dao.getById(ID);
        return ll_sys_menu;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Sys_menu ll_sys_menu) throws Exception {
        Integer result = sys_menu_dao.add(ll_sys_menu);
        if(result>0){
        	cache(); 
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(Sys_menu ll_sys_menu) throws Exception {
        Integer result = sys_menu_dao.update(ll_sys_menu);
        if(result>0){
        	cache(); 
        }
        return result > 0 ? true : false;
    }
    
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long ID) throws Exception {
    	Sys_menu oldData = get(ID);
        Integer result = sys_menu_dao.deleteById(ID);
        if(result>0){
        	cache(); 
        }
        return result > 0 ? true : false;
    }
    
    /**
	 * 获取所有数据
	 */
	public List<Sys_menu> selectAll(Sys_menu_VO ll_sys_menu_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return sys_menu_dao.selectAll(map);
	} 
	
	/**
	 * 缓存菜单列表
	 */
	public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isShow", 1);
		List<Sys_menu> list = sys_menu_dao.selectAll(map);
		Sys_menu_cache.putAllInCache(list);
	}
	
	/**
	 * 获取所有数据 组成树型返回
	 */
	public List<Sys_menu> selectTree() throws Exception{
		List<Sys_menu> list = sys_menu_dao.selectAll(null);
		List<Sys_menu> tresult = new ArrayList<Sys_menu>();
		for(int i = 0;i < list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0")){
				getChild(list.get(i), list);
				tresult.add(list.get(i));
			}
		}
		return tresult;
	}
	
	private static void getChild(Sys_menu ll_sys_menu,List<Sys_menu> list){
		for(int i  =0;i < list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals(ll_sys_menu.getId().toString())){
				ll_sys_menu.getChildren().add(list.get(i));
				getChild(list.get(i), list);
			}
		}
	}
	
	/**
	 * 获取所有顶级数据
	 */
	public List<Sys_menu> selectAllFather() throws Exception{
		List<Sys_menu> list = Sys_menu_cache.getMenusListFromCache();
		if(list == null){
			cache();
			list = Sys_menu_cache.getMenusListFromCache();
		}
		List<Sys_menu> tresult = new ArrayList<Sys_menu>();
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getMenufatherid().toString().equals("0")){
				tresult.add(list.get(i));
			}
		}
		return tresult;
	}
	
	/**
	 * 缓存中获取 菜单列表
	 * @return
	 * @throws Exception
	 */
	public List<Sys_menu> getAllMenuFromCache()throws Exception{
		List<Sys_menu> list = Sys_menu_cache.getMenusListFromCache();
		if(list == null){
			cache();
		}
		return list;
	}

}
