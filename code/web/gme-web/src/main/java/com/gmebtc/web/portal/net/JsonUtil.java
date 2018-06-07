package com.gmebtc.web.portal.net;

import com.gmebtc.web.portal.utils.Assert;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONStringer;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;


public class JsonUtil {

	/**
	 * 设置日期转换格式
	 */
	static {
		// 注册器
		MorpherRegistry mr = JSONUtils.getMorpherRegistry();

		// 可转换的日期格式，即Json串中可以出现以下格式的日期与时间
		DateMorpher dm = new DateMorpher(new String[] { "yyyy-MM-dd HH:mm:ss",
				"yyyyMMdd","yyyy-MM-dd" });
		mr.registerMorpher(dm);
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param pojoCalss
	 * @return
	 */
	public static Object getObjectJsonString(String jsonString, Class pojoCalss) {
		Object pojo;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		pojo = JSONObject.toBean(jsonObject, pojoCalss);
		return pojo;
	}

	/**
	 * list变为json
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJson(List<?> list) {
		return JSONSerializer.toJSON(list).toString();
	}

	/**
	 * 将java对象转换成json字符串 带时间格式化的
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonStringJavaArray(Object javaObj) {
		JSONArray json;
		json = JSONArray.fromObject(javaObj, configJson("yyyy-MM-dd HH:mm:ss"));
		// json = JSONArray.fromObject(javaObj);
		return json.toString();
	}

	public static String getJsonStringJavaArrayX(Object javaObj) {
		JSONArray json;
		JsonConfig jsonConfig=configJsonX("yyyy-MM-dd HH:mm:ss");
		json = JSONArray.fromObject(javaObj,jsonConfig );
		// json = JSONArray.fromObject(javaObj);
		return json.toString();
	}

	/**
	 * 从json HASH表达式中获取一个map，改map支持嵌套功能
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String,Object> getMapJson(String jsonString) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator keyIter = jsonObject.keys();
		String key;
		Object value;
		Map valueMap = new HashMap();

		while (keyIter.hasNext()) {
			key = (String) keyIter.next();
			value = jsonObject.get(key);
			valueMap.put(key, value);
		}

		return valueMap;
	}
	
	/**
	 * json添加数据
	 * @param json
	 * @param key
	 * @param value
	 * @return
	 */
	public static String putJson(String json,String key ,String value){
		JSONObject jsonObject = JSONObject.fromObject(json);
		jsonObject.put(key, value);
		json = jsonObject.toString();
		return json;
	}

	/**
	 * 从json数组中得到相应java数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Object[] getObjectArrayJson(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();

	}

	/**
	 * 从json对象集合表达式中得到一个java对象列表
	 * 
	 * @param jsonString
	 * @param pojoClass
	 * @return
	 */
	public static List getListJson(String jsonString, Class pojoClass) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		Object pojoValue;

		List list = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++) {

			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toBean(jsonObject, pojoClass);
			list.add(pojoValue);

		}
		return list;

	}

	/**
	 * 从前置机json对象的resultList集合表达式中得到一个java对象列表
	 * 
	 * @param jsonString
	 * @param pojoClass
	 * @return
	 */
	public static List getListJsonFromHisResult(String jsonString,
			Class pojoClass) {
		JSONObject jo = JSONObject.fromObject(jsonString);
		JSONArray jsonArray = jo.getJSONArray("resultList");
		JSONObject jsonObject;
		Object pojoValue;
		List list = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toBean(jsonObject, pojoClass);
			list.add(pojoValue);
		}
		return list;
	}
	
	/**
	 * 从json数组中解析出java字符串数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static String[] getStringArrayJson(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			stringArray[i] = jsonArray.getString(i);

		}

		return stringArray;
	}

	/**
	 * 从json数组中解析出javaLong型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Long[] getLongArrayJson(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Long[] longArray = new Long[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			longArray[i] = jsonArray.getLong(i);

		}
		return longArray;
	}

	/**
	 * 从json数组中解析出java Integer型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Integer[] getIntegerArrayJson(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Integer[] integerArray = new Integer[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			integerArray[i] = jsonArray.getInt(i);

		}
		return integerArray;
	}

	/**
	 * 从json数组中解析出java Date 型对象数组，使用本方法必须保证
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Date[] getDateArrayJson(String jsonString, String DataFormat) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Date[] dateArray = new Date[jsonArray.size()];
		String dateString;
		Date date;

		for (int i = 0; i < jsonArray.size(); i++) {
			dateString = jsonArray.getString(i);
			date = stringToDate(dateString, DataFormat);
			dateArray[i] = date;

		}
		return dateArray;
	}

	/**
	 * dataFormat 是空时 为 yyyy-MM-dd
	 * 
	 * @param dateString
	 * @param dataFormat
	 * @return
	 */
	private static Date stringToDate(String dateString, String dataFormat) {
		Date date = null;
		try {
			// "yyyy-MM-dd HH:mm:ss"
			if (dataFormat == null) {
				dataFormat = "yyyy-MM-dd";
			}
			SimpleDateFormat dateFormatter = new SimpleDateFormat(dataFormat);
			date = dateFormatter.parse(dateString);
		} catch (ParseException ex) {
		}
		return date;
	}

	/**
	 * 从json数组中解析出java Integer型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Double[] getDoubleArrayJson(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Double[] doubleArray = new Double[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			doubleArray[i] = jsonArray.getDouble(i);

		}
		return doubleArray;
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonStringJavaPOJO(Object javaObj) {
		JSONObject json;
		json = JSONObject
				.fromObject(javaObj, configJson("yyyy-MM-dd HH:mm:ss"));
		return json.toString();

	}
	
	
	/**
	 * 将java对象转换成json字符串 时间格式yyyy-MM-dd
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonStringJavaPOJODateFormat(Object javaObj) {
		JSONObject json;
		json = JSONObject
				.fromObject(javaObj, configJson("yyyy-MM-dd"));
		return json.toString();

	}
	
	

	/**
	 * 将java对象转换成json字符串,并设定日期格式
	 * 
	 * @param javaObj
	 * @param dataFormat
	 * @return
	 */
	public static String getJsonStringJavaPOJO(Object javaObj, String dataFormat) {
		JSONObject json;
		JsonConfig jsonConfig = configJson(dataFormat);
		json = JSONObject.fromObject(javaObj, jsonConfig);
		return json.toString();

	}

	public static <T> T jsonToBean(String json, Class<T> clazz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (T) JSONObject.toBean(jsonObject, clazz);
	}

	/**
	 * JSON 时间解析器具
	 * 
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJson(String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "" });
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(datePattern));
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				// if(Assert.equals("fsendtime", name) ||
				// Assert.equals("fgettime", name)){
				// return true;
				// }
				// 过滤掉时间为空的情况，不然会转换异常
				Field field = null;
				Class cls = source.getClass();
				Field[] fieldlist = cls.getDeclaredFields();
				for (int i = 0; i < fieldlist.length; i++) {
					Field fld = fieldlist[i];
					// 字符串不能用==比较 ，这里耽误半天
					if (Assert.equals(fld.getName(), name)) {
						field = fld;
						break;
					}
				}
				if (field != null && field.getType() == Date.class
						&& value == null) {
					return true;
				}
				return false;
			}
		});

		return jsonConfig;
	}

	/**
	 * JSON 时间解析器具
	 * 
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJsonX(String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "" });
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(datePattern));
		jsonConfig.registerDefaultValueProcessor(Integer.class,
				new DefaultValueProcessor() {
					public Object getDefaultValue(Class type) {
						return null;
					}
				});
		jsonConfig.registerDefaultValueProcessor(Double.class,
				new DefaultValueProcessor() {
					public Object getDefaultValue(Class type) {
						return null;
					}
				});
		jsonConfig.registerDefaultValueProcessor(Long.class,
				new DefaultValueProcessor() {
					public Object getDefaultValue(Class type) {
						return null;
					}
				});

		return jsonConfig;
	}

	/**
	 * 
	 * @param excludes
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJson(String[] excludes, String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(datePattern));

		return jsonConfig;
	}

	static class DateJsonValueProcessor implements JsonValueProcessor {

		public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

		private DateFormat dateFormat;

		/**
		 * 
		 * 构造方法.
		 * 
		 * 
		 * 
		 * @param datePattern
		 *            日期格式
		 */

		public DateJsonValueProcessor(String datePattern) {

			if (null == datePattern)

				dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

			else

				dateFormat = new SimpleDateFormat(datePattern);

		}

		/*
		 * （非 Javadoc）
		 * 
		 * @see
		 * net.sf.json.processors.JsonValueProcessor#processArrayValue(java.
		 * lang.Object, net.sf.json.JsonConfig)
		 */

		public Object processArrayValue(Object arg0, JsonConfig arg1) {

			// TODO 自动生成方法存根

			return process(arg0);

		}

		/*
		 * （非 Javadoc）
		 * 
		 * @see
		 * net.sf.json.processors.JsonValueProcessor#processObjectValue(java
		 * .lang.String, java.lang.Object, net.sf.json.JsonConfig)
		 */

		public Object processObjectValue(String arg0, Object arg1,
				JsonConfig arg2) {

			// TODO 自动生成方法存根

			return process(arg1);

		}

		private Object process(Object value) {

			return dateFormat.format((Date) value);

		}

	}
	/**
	 * 将string转为对应类型的值
	 * @param typeName
	 * @param strValue
	 * @return
	 */
	public static Object convertValue(String typeName,String strValue){
		Object value=null;
		try {
			if("java.lang.String".equals(typeName)){
				value=strValue;
				return value;
			}
			if("java.lang.Integer".equals(typeName)){
				value=Integer.valueOf(strValue);
				return value;
			}
			if("java.lang.Double".equals(typeName)){
				value=Double.valueOf(strValue);
				return value;
			}
			if("java.lang.Long".equals(typeName)){
				value=Long.valueOf(strValue);
				return value;
			}
			if("java.util.Date".equals(typeName)){
				SimpleDateFormat sdf=null;
				if(strValue!=null&&strValue.length()<12){
					sdf = new SimpleDateFormat("yyyy-MM-dd");
				}else{
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
				Date date = sdf.parse(strValue);
				return date;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将实体类转成json，第一个参数是返回给客户端实体类中的字段
	 * @param keys
	 * @param listValues
	 * @return
	 */
	public static String getJosnStringByKey(String[] keys ,List<?> listValues){
		if(listValues==null||listValues.size()==0){
			return "[]";
		}
		Class<?> c=listValues.get(0).getClass();
		try {
			JSONStringer js = new JSONStringer();
			js.array();
			
			for (int i = 0; i < listValues.size(); i++) {
				JSONObject jb = new JSONObject();
				for(int x=0;x<keys.length;x++){
					Field field=c.getDeclaredField(keys[x]);
					field.setAccessible(true);
					String valueXX;
					if(field.get(listValues.get(i))==null){
						valueXX="";
					}else{
						if("java.util.Date".equals(field.getType().getName())){
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							valueXX =format.format(field.get(listValues.get(i)));
						}else{
							valueXX=field.get(listValues.get(i)).toString();
						}
					}
					jb.put(keys[x],valueXX);
				}
				js.value(jb);
			}
			js.endArray();
			return js.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "[]";
	}
	//map转换为json字符串
	public static String hashMapToJson(HashMap map) {  
	    String string = "{";  
	    for (Iterator it = map.entrySet().iterator(); it.hasNext();) {  
	        Entry e = (Entry) it.next();  
	        string += "'" + e.getKey() + "':";  
	        string += "'" + e.getValue() + "',";  
	    }  
	    string = string.substring(0, string.lastIndexOf(","));  
	    string += "}";  
	    return string;  
	} 
}