package com.manage.sys.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.sys.entity.Mp_settings;
/**
 * 配置表，全局配置 DAO
 */
@MyBatisDao
@Component("Mp_settings_DAO")
public interface Mp_settings_DAO{
	/**
	 * 获取分页数据
	 */
	public List<Mp_settings> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public Mp_settings getById(java.lang.Long id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(Mp_settings mp_settings) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(Mp_settings mp_settings)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<Mp_settings> selectAll(Map<String,Object> map) throws Exception;
}