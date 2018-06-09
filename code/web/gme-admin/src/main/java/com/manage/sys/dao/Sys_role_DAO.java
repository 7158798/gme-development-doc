package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.Sys_role;
/**
 * 角色说明 DAO
 */
@MyBatisDao
@Component("Sys_role_DAO")
public interface Sys_role_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Sys_role> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Sys_role getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Sys_role ll_sys_role) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Sys_role ll_sys_role)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Sys_role> selectAll(Map<String,Object> map) throws Exception;
}