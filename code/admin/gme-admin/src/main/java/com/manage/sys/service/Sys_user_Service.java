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

import com.manage.base.entity.PageInfo;
import com.manage.sys.dao.Sys_user_DAO;
import com.manage.sys.entity.Sys_user;
import com.manage.sys.vo.Sys_user_VO;
/**
 * 后台管理员服务
 */
@Transactional(readOnly = true)
@Service("Sys_user_Service")
public class Sys_user_Service{

    @Resource(name = "Sys_user_DAO")
    private Sys_user_DAO sys_user_dao;

    /**
     * 分页查询
     */
    public PageInfo selectPage(Sys_user_VO ll_sys_user_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", ll_sys_user_vo.getRows());
        map.put("BEGIN", (ll_sys_user_vo.getPage() - 1) * ll_sys_user_vo.getRows());
        if(ll_sys_user_vo!=null){
        	if(ll_sys_user_vo.getTruename()!=null){
            	map.put("truename", ll_sys_user_vo.getTruename());
            }if(ll_sys_user_vo.getUserName()!=null){
            	map.put("userName", ll_sys_user_vo.getUserName());
            }if(ll_sys_user_vo.getPhone()!=null){
            	map.put("phone", ll_sys_user_vo.getPhone());
            }
        }
        Integer count = this.sys_user_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(ll_sys_user_vo.getRows(), ll_sys_user_vo.getPage(), count, new ArrayList<Sys_user>());
        }
        List<Sys_user> list = this.sys_user_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(ll_sys_user_vo.getRows(), ll_sys_user_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public Sys_user get(java.lang.Long id) throws Exception {
        Sys_user ll_sys_user = sys_user_dao.getById(id);
        return ll_sys_user;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Sys_user ll_sys_user) throws Exception {
        Integer result = sys_user_dao.add(ll_sys_user);
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(Sys_user ll_sys_user) throws Exception {
        Integer result = sys_user_dao.update(ll_sys_user);
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id) throws Exception {
    	Sys_user ll_sys_user =get(id);
        Integer result = sys_user_dao.deleteById(id);
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<Sys_user> selectAll(Sys_user_VO ll_sys_user_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(ll_sys_user_vo!=null){
		  if(ll_sys_user_vo.getUserName()!=null){
			  map.put("userName", ll_sys_user_vo.getUserName());
		  }
		  if(ll_sys_user_vo.getStatus()!=null){
			  map.put("status", ll_sys_user_vo.getStatus());
		  }
		}
		return sys_user_dao.selectAll(map);
	} 


}
