package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.Sys_menu;
/**
 * 菜单 DAO
 */
@MyBatisDao
@Component("Sys_menu_DAO")
public interface Sys_menu_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Sys_menu> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Sys_menu getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Sys_menu ll_sys_menu) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Sys_menu ll_sys_menu)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Sys_menu> selectAll(Map<String,Object> map) throws Exception;
}