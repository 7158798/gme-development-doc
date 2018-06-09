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
import com.manage.sys.dao.Sys_persion_DAO;
import com.manage.sys.entity.Sys_persion;
import com.manage.sys.vo.Sys_persion_VO;
/**
 * 菜单功能表服务
 */
@Transactional(readOnly = true)
@Service("Sys_persion_Service")
public class Sys_persion_Service{

    @Resource(name = "Sys_persion_DAO")
    private Sys_persion_DAO sys_persion_dao;
    @Resource(name = "Sys_rpersion_Service")
    private Sys_rpersion_Service sys_rpersion_Service;

    /**
     * 分页查询
     */
    public PageInfo selectPage(Sys_persion_VO ll_sys_persion_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", ll_sys_persion_vo.getRows());
        map.put("BEGIN", (ll_sys_persion_vo.getPage() - 1) * ll_sys_persion_vo.getRows());
        Integer count = this.sys_persion_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(ll_sys_persion_vo.getRows(), ll_sys_persion_vo.getPage(), count, new ArrayList<Sys_persion>());
        }
        List<Sys_persion> list = this.sys_persion_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(ll_sys_persion_vo.getRows(), ll_sys_persion_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public Sys_persion get(java.lang.Long ID) throws Exception {
        Sys_persion ll_sys_persion = sys_persion_dao.getById(ID);
        return ll_sys_persion;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Sys_persion ll_sys_persion) throws Exception {
        Integer result = sys_persion_dao.add(ll_sys_persion);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(Sys_persion ll_sys_persion) throws Exception {
        Integer result = sys_persion_dao.update(ll_sys_persion);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id,Long mid) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
    	if(id!=null){
    		map.put("id", id);
    	}if(mid!=null){
    		map.put("mid", mid);
    	}
        Integer result = sys_persion_dao.deleteData(map);
        if(result>0){
        	if(id!=null){
        		sys_rpersion_Service.delete(null, null, id);
        	}
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<Sys_persion> selectAll(Sys_persion_VO ll_sys_persion_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(ll_sys_persion_vo!=null){
			if(ll_sys_persion_vo.getMid()!=null){
				map.put("mid", ll_sys_persion_vo.getMid());
			}
		}
		return sys_persion_dao.selectAll(map);
	} 
	/**
	 * 缓存权限
	 */
	public void cache()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sys_persion> list=sys_persion_dao.selectAll(map);
		Sys_menu_cache.setPersionInCache(list);
	}

}
