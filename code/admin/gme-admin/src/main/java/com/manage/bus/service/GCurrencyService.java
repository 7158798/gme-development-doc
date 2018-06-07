package com.manage.bus.service;

import com.manage.base.entity.PageInfo;
import com.manage.base.util.UserUtil;
import com.manage.bus.dao.GCurrencyDAO;
import com.manage.bus.entity.GCurrency;
import com.manage.bus.vo.GCurrencyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
/**
 * 币种表（g_currency）
功能描述：存储币种信息。服务
 */
@Transactional(readOnly = true)
@Service("GCurrencyService")
public class GCurrencyService{

    @Resource(name = "GCurrencyDAO")
    private GCurrencyDAO g_currency_dao;


    /**
     * 分页查询
     */
    public PageInfo selectPage(GCurrencyVO g_currency_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", g_currency_vo.getRows());
        map.put("BEGIN", (g_currency_vo.getPage() - 1) * g_currency_vo.getRows());
        Integer count = this.g_currency_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), count, new ArrayList<GCurrency>());
        }
        List<GCurrency> list = this.g_currency_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(g_currency_vo.getRows(), g_currency_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public GCurrency get(java.lang.String currency_id) throws Exception {
        GCurrency g_currency = g_currency_dao.getById(currency_id);
        return g_currency;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(GCurrency g_currency) throws Exception {
        Integer result = g_currency_dao.add(g_currency);
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(GCurrency g_currency) throws Exception {
        Integer result = g_currency_dao.update(g_currency);
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.String currency_id) throws Exception {
        Integer result = g_currency_dao.deleteById(currency_id);
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<GCurrency> selectAll(GCurrencyVO g_currency_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return g_currency_dao.selectAll(map);
	} 


}
