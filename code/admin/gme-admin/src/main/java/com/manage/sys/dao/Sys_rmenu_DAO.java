package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.Sys_rmenu;
/**
 * 角色权限 DAO
 */
@MyBatisDao
@Component("Sys_rmenu_DAO")
public interface Sys_rmenu_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Sys_rmenu> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Sys_rmenu getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Sys_rmenu ll_sys_rmenu) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Sys_rmenu ll_sys_rmenu)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Sys_rmenu> selectAll(Map<String,Object> map) throws Exception;
}