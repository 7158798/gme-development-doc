package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manage.base.util.FileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class Model {
	
	// 将表名转换成对应的java规范类名
	private static String tableName(String tableName) {
		String[] names = tableName.split("_");
		StringBuffer sb = new StringBuffer();
		for (String s :names) {
			String first = s.substring(0, 1).toUpperCase();
			String surplus = s.substring(1, s.length());
			sb.append(first + surplus);
		}
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://47.106.171.23:3306/gme_db?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
		String username="yyctdbuser";

		String password="Ab1234567.";
		String basePath="E:/java/tools/myeclipse/code/gme-admin-repository/gme-admin/";//工程 路径
		
		String tableName="g_currency";//表名
		String modelName="bus";//模块名称 

		boolean isCEntity=true;//是否生成实体 
		boolean isCDao=true;//是否生成dao
		boolean isCService=true;//是否生成服务 
		boolean isCController=true;//是否生成控制器 
		boolean isCVo=true;//是否生成查询实体
		boolean isCListJsp=true;//是否生成查询jsp
		boolean isCAddJsp=true;//是否生成新增jsp
		boolean isCUpdateJsp=true;//是否生成修改jsp
		boolean isCInfoJsp=true;//是否生成详情jsp322

		
		String entityName=tableName(tableName);
		String daoName=entityName+"DAO";
		String controllerName=entityName+"Controller";
		String voName=entityName+"VO";
		String serviceName=entityName+"Service";
		
		String entityPackage="com.manage."+modelName+".entity";
		String entityPath=basePath+"src/main/java/com/manage/"+modelName+"/entity/";
		
		String voPackage="com.manage."+modelName+".vo";
		String voPath=basePath+"src/main/java/com/manage/"+modelName+"/vo/";
		
		String daoPackage="com.manage."+modelName+".dao";
		String daoPath=basePath+"src/main/java/com/manage/"+modelName+"/dao/";
		
		String servicePackage="com.manage."+modelName+".service";
		String servicePath=basePath+"src/main/java/com/manage/"+modelName+"/service/";
		
		String controlPackage="com.manage."+modelName+".control";
		String controlPath=basePath+"src/main/java/com/manage/"+modelName+"/control/";
		
		String jspPath=basePath+"src/main/webapp/WEB-INF/views/modules/"+modelName+"/";
		
		String mybatisPath = basePath + "src/main/resources/mappings/";
        String mybatisNameSpace = "com.manage." + modelName + ".dao." + daoName;
        
		String tableComment="";//表注解
		List<String[]> fields=new ArrayList<String[]>();//字段集合
		String priField=null;//主键 
		String priFieldType=null;//主键类型
		String priFieldParameterType="long";//主键类型
		
		Class.forName(driver);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from "+tableName+" where 1=2");
		ResultSetMetaData metaData=resultSet.getMetaData();
		int count=metaData.getColumnCount();
		for(int i=1;i<=count;i++){
			String name=metaData.getColumnName(i);
			String type=metaData.getColumnClassName(i);
			String[]field=new String[5];
			field[0]=type;
			field[1]=name;
			fields.add(field);
		}
		resultSet.close();
		
		resultSet=statement.executeQuery(" SHOW FULL FIELDS FROM "+tableName);
		while(resultSet.next()){
			String name=resultSet.getString("FIELD");
			String comment=resultSet.getString("COMMENT");
			String key=resultSet.getString("KEY");
			String isnull=resultSet.getString("NULL");
			String type=resultSet.getString("TYPE");
			String length="";
			String labflag="";
			
			if(isnull.equals("YES")){
				labflag="";
			}else{
				labflag="<font color='red'>*</font>";
			}
			if(type.indexOf("varchar")>-1){//
				length=type.substring(8, type.length()-1);
			}
			
			for (int i=0;i<fields.size();i++) {
				String[]temp=fields.get(i);
				if(temp[1].equals(name)){
					if(key.equals("PRI")){
						priField=name;
						priFieldType=temp[0];
					}
					temp[2]=comment;
					temp[3]=labflag;
					temp[4]=length;
					fields.set(i, temp);
					break;
				}
			}
		}
		resultSet.close();
		
		
		if(tableComment.equals("")){
			resultSet=statement.executeQuery("SHOW TABLE STATUS WHERE NAME='"+tableName+"'");
			if(resultSet.next()){
				String name=resultSet.getString("NAME");
				if(name.equalsIgnoreCase(tableName)){
					tableComment=resultSet.getString("COMMENT");
				}
			}
			resultSet.close();
		}
		
		statement.close();
		connection.close();
		
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(basePath+"src/main/java/model/"));
		
		
		Map<String, Object> modelParam = new HashMap<String, Object>();
		modelParam.put("tableName", tableName);
		modelParam.put("tableComment", tableComment);
		
		modelParam.put("fields", fields);
		
		modelParam.put("entityName", entityName);
		modelParam.put("entityPackage", entityPackage);
		
		modelParam.put("daoName", daoName);
		modelParam.put("daoPackage", daoPackage);
		modelParam.put("mybatisNameSpace", mybatisNameSpace);
		
		modelParam.put("priFieldType", priFieldType);
		modelParam.put("priField", priField);
		modelParam.put("priFieldParameterType", priFieldParameterType);
		
		modelParam.put("serviceName", serviceName);
		modelParam.put("servicePackage", servicePackage);
		
		modelParam.put("voPackage", voPackage);
		modelParam.put("voName", voName);
		
		modelParam.put("controllerName", controllerName);
		modelParam.put("controlPackage", controlPackage);
		
		modelParam.put("module", modelName);
		
		modelParam.put("dollar", "$");
		if(isCEntity){
			createFile(cfg, "entity.ftl", modelParam, entityPath+entityName+".java");
		}
		if(isCDao){
			createFile(cfg, "dao.ftl", modelParam, daoPath+daoName+".java");
            createFile(cfg, "mybatis.ftl", modelParam, mybatisPath + tableName.toUpperCase() + ".xml");
		}
		if(isCService){
			createFile(cfg, "service.ftl", modelParam, servicePath+serviceName+".java");
		}
		if(isCController){
			createFile(cfg, "controller.ftl", modelParam, controlPath+controllerName+".java");
		}
		if(isCVo){
			createFile(cfg, "vo.ftl", modelParam, voPath+voName+".java");
		}
		if(isCListJsp){
			createFile(cfg, "listJsp.ftl", modelParam, jspPath+tableName+"List.jsp");
		}
		if(isCAddJsp){
			createFile(cfg, "addJsp.ftl", modelParam, jspPath+tableName+"Add.jsp");
		}
		if(isCUpdateJsp){
			createFile(cfg, "updateJsp.ftl", modelParam, jspPath+tableName+"Update.jsp");
		}
		if(isCInfoJsp){
			createFile(cfg, "infoJsp.ftl", modelParam, jspPath+tableName+"Info.jsp");
		}
		System.out.println("已经生成完成.....");
	}
	
	public static void createFile(Configuration cfg,String moduleName,Map<String, Object> modelParam,String filePath)throws Exception{
		Template template = cfg.getTemplate(moduleName,"utf-8");
		StringWriter result = new StringWriter();
		template.process(modelParam, result);
		String content = result.toString();
		writeFile(content, filePath);
	}
	/**
	 * 将内容写入文件
	 * @param content
	 * @param filePath
	 */
	public static void writeFile(String content, String filePath) {
		try {
			FileUtils.deleteFile(filePath);
			if (FileUtils.createFile(filePath)){
				OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
				bufferedWriter.write(content);
				bufferedWriter.close();
				outputStreamWriter.close();
			}else{
				System.out.println("生成失败，文件已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
