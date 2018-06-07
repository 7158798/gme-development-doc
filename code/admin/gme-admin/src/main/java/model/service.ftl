package ${servicePackage};

import com.manage.base.entity.PageInfo;
import com.manage.base.util.UserUtil;
import ${daoPackage}.${daoName};
import ${entityPackage}.${entityName};
import ${voPackage}.${voName};
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
 * ${tableComment}服务
 */
@Transactional(readOnly = true)
@Service("${serviceName}")
public class ${serviceName}{

    @Resource(name = "${daoName}")
    private ${daoName} ${tableName}_dao;


    /**
     * 分页查询
     */
    public PageInfo selectPage(${voName} ${tableName}_vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PSIZE", ${tableName}_vo.getRows());
        map.put("BEGIN", (${tableName}_vo.getPage() - 1) * ${tableName}_vo.getRows());
        Integer count = this.${tableName}_dao.selectPageCount(map);
        if (count == 0) {
            return new PageInfo(${tableName}_vo.getRows(), ${tableName}_vo.getPage(), count, new ArrayList<${entityName}>());
        }
        List<${entityName}> list = this.${tableName}_dao.selectPage(map);
        PageInfo pageInfo = new PageInfo(${tableName}_vo.getRows(), ${tableName}_vo.getPage(), count, list);
        return pageInfo;
    }

    /**
     * 查询一条记录
     */
    public ${entityName} get(${priFieldType} ${priField}) throws Exception {
        ${entityName} ${tableName} = ${tableName}_dao.getById(${priField});
        return ${tableName};
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean add(${entityName} ${tableName}) throws Exception {
        Integer result = ${tableName}_dao.add(${tableName});
        return result > 0 ? true : false;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean update(${entityName} ${tableName}) throws Exception {
        Integer result = ${tableName}_dao.update(${tableName});
        return result > 0 ? true : false;
    }
	 /**
     * 删除
     */
    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean delete(${priFieldType} ${priField}) throws Exception {
        Integer result = ${tableName}_dao.deleteById(${priField});
        return result > 0 ? true : false;
    }
    /**
	 * 获取所有数据
	 */
	public List<${entityName}> selectAll(${voName} ${tableName}_vo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return ${tableName}_dao.selectAll(map);
	} 


}
