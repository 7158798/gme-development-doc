package ${entityPackage};
import java.io.Serializable;
/**
 *	表名：${tableName}
 *  注释:${tableComment}
 */
 
public class ${entityName} implements Serializable{
	<#if fields ?exists >
		<#list fields as tem>
	/**${tem[2]}*/	
	private ${tem[0]} ${tem[1]};
		</#list>
	</#if>
	
	<#if fields ?exists >
		<#list fields as tem>
	public void set${tem[1]?cap_first}(${tem[0]} ${tem[1]}){
		this.${tem[1]}=${tem[1]};
	}
	public ${tem[0]} get${tem[1]?cap_first}(){
		return this.${tem[1]};
	}
		</#list>
	</#if>
}
