package com.manage.sys.service;

import com.manage.base.entity.PageInfo;
import com.manage.base.util.UserUtil;
import com.manage.sys.dao.Mp_settings_DAO;
import com.manage.sys.entity.Mp_settings;
import com.manage.sys.vo.Mp_settings_VO;

import org.apache.commons.lang.StringUtils;
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
 * 配置表，全局配置服务
 */
@Transactional(readOnly = true)
@Service("Mp_settings_Service")
public class Mp_settings_Service{

    @Resource(name = "Mp_settings_DAO")
    private Mp_settings_DAO mp_settings_dao;


    /**
     * 分页查询
     */
    public PageInfo selectPage(Mp_settings_VO mp_settings_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", mp_settings_vo.getRows());
        map.put("BEGIN", (mp_settings_vo.getPage() - 1) * mp_settings_vo.getRows());
        if(mp_settings_vo!=null){
        	if(StringUtils.isNotEmpty(mp_settings_vo.getSkey())){
        		map.put("skey", mp_settings_vo.getSkey());
        	}
        }
        Integer count = this.mp_settings_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(mp_settings_vo.getRows(), mp_settings_vo.getPage(), count, new ArrayList<Mp_settings>());
        }
        List<Mp_settings> list = this.mp_settings_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(mp_settings_vo.getRows(), mp_settings_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public Mp_settings get(java.lang.Long id) throws Exception {
        Mp_settings mp_settings = mp_settings_dao.getById(id);
        return mp_settings;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(Mp_settings mp_settings) throws Exception {
        Integer result = mp_settings_dao.add(mp_settings);
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(Mp_settings mp_settings) throws Exception {
        Integer result = mp_settings_dao.update(mp_settings);
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(java.lang.Long id) throws Exception {
        Integer result = mp_settings_dao.deleteById(id);
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<Mp_settings> selectAll(Mp_settings_VO mp_settings_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return mp_settings_dao.selectAll(map);
	} 


}
