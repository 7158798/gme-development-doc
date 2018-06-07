package com.manage.base.tag;

import java.util.HashMap;
import java.util.Map;

import com.manage.base.util.PropertiesLoader;


/**
 * 全局配置类
 */
public class Global {
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String,String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}

	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
}
