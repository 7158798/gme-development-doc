package com.manage.bus.dao;

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.manage.bus.entity.GCurrency;
/**
 * 币种表（g_currency）
功能描述：存储币种信息。 DAO
 */
@MyBatisDao
@Component("GCurrencyDAO")
public interface GCurrencyDAO{
	
	/**
	 * 获取分页数据
	 */
	public List<GCurrency> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public GCurrency getById(java.lang.String currency_id) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(GCurrency g_currency) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(GCurrency g_currency)throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(java.lang.String currency_id) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<GCurrency> selectAll(Map<String,Object> map) throws Exception;
}