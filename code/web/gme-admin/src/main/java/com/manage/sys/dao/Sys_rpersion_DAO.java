package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.Sys_rpersion;
/**
 * 角色菜单功能 DAO
 */
@MyBatisDao
@Component("Sys_rpersion_DAO")
public interface Sys_rpersion_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Sys_rpersion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Sys_rpersion getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Sys_rpersion ll_sys_rpersion) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Sys_rpersion ll_sys_rpersion)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Sys_rpersion> selectAll(Map<String,Object> map) throws Exception;
}