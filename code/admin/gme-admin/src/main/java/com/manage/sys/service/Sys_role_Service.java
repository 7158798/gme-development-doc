package com.manage.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.base.cache.Sys_role_cache;
import com.manage.base.entity.PageInfo;
import com.manage.sys.dao.Sys_role_DAO;
import com.manage.sys.entity.Sys_role;
import com.manage.sys.vo.Sys_role_VO;
/**
 * 角色说明服务
 */
@Transactional(readOnly = true)
@Service("Sys_role_Service")
public class Sys_role_Service{

    @Resource(name = "Sys_role_DAO")
    private Sys_role_DAO sys_role_dao;
    @Resource(name = "Sys_rmenu_Service")
    private Sys_rmenu_Service sys_rmenu_Service;
    @Resource(name = "Sys_rpersion_Service")
    private Sys_rpersion_Service sys_rpersion_Service;

    /**
     * 分页查询
     */
    public PageInfo selectPage(Sys_role_VO ll_sys_role_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", ll_sys_role_vo.getRows());
        map.put("BEGIN", (ll_sys_role_vo.getPage() - 1) * ll_sys_role_vo.getRows());
        Integer count = this.sys_role_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(ll_sys_role_vo.getRows(), ll_sys_role_vo.getPage(), count, new ArrayList<Sys_role>());
        }
        List<Sys_role> list = this.sys_role_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(ll_sys_role_vo.getRows(), ll_sys_role_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public Sys_role get(java.lang.Long ID) throws Exception {
        Sys_role ll_sys_role = sys_role_dao.getById(ID);
        return ll_sys_role;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Sys_role ll_sys_role) throws Exception {
        Integer result = sys_role_dao.add(ll_sys_role);
        if(result>0){
        	cache();
        }
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(Sys_role ll_sys_role) throws Exception {
        Integer result = sys_role_dao.update(ll_sys_role);
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
    	Sys_role ll_sys_role=get(ID);
        Integer result = sys_role_dao.deleteById(ID);
        if(result>0){
        	sys_rmenu_Service.delete(null,null,ID);
        	sys_rpersion_Service.delete(ID, null, null);
        	
        	cache();
        }
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<Sys_role> selectAll(Sys_role_VO ll_sys_role_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(ll_sys_role_vo!=null){
			if(StringUtils.isNotEmpty(ll_sys_role_vo.getRoleName())){
				map.put("roleName", ll_sys_role_vo.getRoleName());
			}
		}
		return sys_role_dao.selectAll(map);
	} 

	/**
	 * 缓存角色
	 */
	public void cache()throws Exception{
		List<Sys_role> list=sys_role_dao.selectAll(null);
		Sys_role_cache.setRolesInCache(list);
	}
}
