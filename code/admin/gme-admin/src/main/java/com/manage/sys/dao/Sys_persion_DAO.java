package com.manage.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.manage.base.annotation.MyBatisDao;
import com.manage.sys.entity.Sys_persion;
/**
 * 菜单功能表 DAO
 */
@MyBatisDao
@Component("Sys_persion_DAO")
public interface Sys_persion_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Sys_persion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Sys_persion getById(Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Sys_persion ll_sys_persion) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Sys_persion ll_sys_persion)throws Exception;
	/**
	 * 删除信息
	 */
	public Integer deleteData(Map<String,Object> map) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Sys_persion> selectAll(Map<String,Object> map) throws Exception;
}