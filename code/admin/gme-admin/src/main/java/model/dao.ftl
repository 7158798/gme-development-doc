package ${daoPackage};

import java.util.List;
import java.util.Map;
import com.manage.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import ${entityPackage}.${entityName};
/**
 * ${tableComment} DAO
 */
@MyBatisDao
@Component("${daoName}")
public interface ${daoName}{
	/**
	 * 获取分页数据
	 */
	public List<${entityName}> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取分页数据数量
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 获取一条信息
	 */
	public ${entityName} getById(${priFieldType} ${priField}) throws Exception;
	/**
	 * 修改一条信息
	 */
	public Integer update(${entityName} ${tableName}) throws Exception;
	/**
	 * 新增一条信息
	 */
	public Integer add(${entityName} ${tableName})throws Exception;
	/**
	 * 删除一条信息
	 */
	public Integer deleteById(${priFieldType} ${priField}) throws Exception;
	/**
	 * 获取所有数据
	 */
	public List<${entityName}> selectAll(Map<String,Object> map) throws Exception;
}