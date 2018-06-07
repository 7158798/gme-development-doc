package com.gmebtc.web.portal.utils;

import com.gmebtc.web.portal.result.GlobalResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实用工具类。
 * Mar 6, 2014 3:15:41 PM
 */
public final class Toolkits
{
	private static final Logger logger = Logger.getLogger(Toolkits.class);
	private static final JsonParser jsonParser = new JsonParser();
	private static final ResourceBundle systemPropertyBundle = ResourceBundle.getBundle("context");
	private static Gson gson = null;

	static
	{
		
		//构建gson翻译器。
		GsonBuilder gsonBuilder = new GsonBuilder();
		if(Boolean.parseBoolean(getSystemPropertyValue("base.json.console.pretty")))
		{
			gson = gsonBuilder.setPrettyPrinting().create();
		}
		else
		{
			gson = gsonBuilder.create();
		}
	}
	private static final String[] ARRAY_SPECIAL_SCALE34 = 
	{
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
		"A", "B", "C", "D", "E", "F", "G", "H", "J", "K",
		"L", "M", "N", "P", "Q", "R", "S", "T", "U", "V",
		"W", "X", "Y", "Z",
	};


	/**
	 * 将List转换为数组对象。
	 * @param list List实例。
	 * @return 转换后的对象数组。
	 */
	public static final Object[] list2Array(List<?> list)
	{
		Object[] object = list.toArray();
		Object[] array = new String[object.length];
		System.arraycopy(object, 0, array, 0, object.length);
		return array;
	}

	/**
	 * 返回对象的默认字符串形式。如果对象为空，则返回str定义的字符串。
	 * @param object 参数对象。
	 * @return 字符串。
	 */
	public static final String defaultString(Object object)
	{
		return defaultString(object, StringUtils.EMPTY);
	}

	/**
	 * 返回对象的默认字符串形式。如果对象为空，则返回str定义的字符串。
	 * @param object 参数对象。
	 * @param str 默认返回的字符串。
	 * @return 字符串。
	 */
	public static final String defaultString(Object object, String str)
	{
		if(object != null && object.equals("null"))
		{
			object = null;
		}
		return (object == null)? str: object.toString();
	}

	/**
	 * 返回第一个匹配的字符串。
	 * @param str 要匹配的字符串。
	 * @param patternString 正则表达式。
	 * @return 匹配的字符串。
	 */
	public static final String matcherString(String str, String patternString)
	{
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str.replaceAll("[\\n\\r]", StringUtils.EMPTY));
		if(matcher.find())
		{
//			customPropertyBundle.getKeys();
			return matcher.group(1).trim();
		}
		else
		{
			return StringUtils.EMPTY;
		}
	}

	/**
	 * 获取类的全部方法名。
	 * @param fullClassName 类名。
	 * @param include 包含的关键字。
	 * @return 列表对象。
	 * @throws Exception Exception 实例。
	 */
	public static final List<?> getMethodByClassName(String fullClassName, String include) throws Exception
	{
		int pos = fullClassName.lastIndexOf(".");
		String packageName = fullClassName.substring(0, pos);
		String className = fullClassName.substring(pos + 1);
		return getMethodByClassName(packageName, className, include);
	}

	/**
	 * 获取类的全部方法名。
	 * @param packageName 包名。
	 * @param className 类名。
	 * @param include 包含的关键字。
	 * @return 列表对象。
	 * @throws Exception Exception 实例。
	 */
	public static final List<?> getMethodByClassName(String packageName, String className, String include) throws Exception
	{
		List<String> list = new ArrayList<String>();
		Class<?> clazz = Class.forName(packageName.concat(".").concat(className));
		Method[] method = clazz.getMethods();
		for(int i = 0; i < method.length; i++)
		{
			if(!include.equals(""))
			{
				if(method[i].getName().indexOf(include) != -1)
				{
					list.add(method[i].getName());
				}
			}
			else
			{
				list.add(method[i].getName());
			}
		}
		return list;
	}

	/**
	 * 获取包下的所有类的方法名。
	 * @param packageName 包名。
	 * @return Map 实例。
	 * @throws Exception Exception 实例。
	 */
	public static final Map<?, ?> getAllMethodByPackageName(String packageName) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String packageDirName = packageName.replace('.', '/');
		Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		while(dirs.hasMoreElements())
		{
			URL url = dirs.nextElement();
			File[] files = new File(url.getPath()).listFiles();
			for(int i = 0; i < files.length; i++)
			{
				if(!files[i].isDirectory())
				{
					String className = StringUtils.substringBefore(files[i].getName(), ".class");
					List<?> list = getMethodByClassName(packageName, className, "");
					map.put(packageName.concat(".").concat(className), list);
				}
			}
		}
		return map;
	}

	/**
	 * 获取包下的所有类名。
	 * @param packageName 包名。
	 * @return List 实例。
	 * @throws Exception Exception 实例。
	 */
	public static final List<?> getAllClassByPackageName(String packageName) throws Exception
	{
		return getAllClassByPackageName(packageName, "");
	}

	/**
	 * 获取包下的所有类名。
	 * @param packageName 包名。
	 * @param include 包含的关键字。
	 * @return List 实例。
	 * @throws Exception Exception 实例。
	 */
	public static final List<?> getAllClassByPackageName(String packageName, String include) throws Exception
	{
		List<String> list = new ArrayList<String>();
		String packageDirName = packageName.replace('.', '/');
		Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		while(dirs.hasMoreElements())
		{
			URL url = dirs.nextElement();
			File[] files = new File(url.getPath()).listFiles();
			for(int i = 0; i < files.length; i++)
			{
				if(!files[i].isDirectory())
				{
					String className = StringUtils.substringBefore(files[i].getName(), ".class");
					if(!include.equals(""))
					{
						if(className.indexOf(include) != -1)
						{
							list.add(packageName.concat(".").concat(className));
						}
					}
					else
					{
						list.add(packageName.concat(".").concat(className));
					}
				}
			}
		}
		return list;
	}

	/**
	 * 从指定的资源包加载指定的键值。
	 * @param resourceBundle 资源包。
	 * @param key 指定的键。
	 * @return 指定的键值。
	 * Mar 24, 2016 4:08:40 PM
	 
	 * @since jdk 1.6.X+
	 */
	public static final String getResourceBundleValue(ResourceBundle resourceBundle, String key)
	{
		String value = "";
		try
		{
			value = StringUtils.defaultString(resourceBundle.getString(key));
		}
		catch(Exception ex)
		{}
		return value;
	}


	/**
	 * 获取框架资源文件(context.properties)键对应的值。
	 * @param key 资源文件对应的键。
	 * @return 资源文件键对应的值。
	 */
	public static final String getSystemPropertyValue(String key)
	{
		String value = "";
		try
		{
			value = StringUtils.defaultString(systemPropertyBundle.getString(key));
		}
		catch(Exception ex)
		{
			logger.warn("加载配置项异常: " + ex.toString());
		}
		return value;
	}


	/**
	 * 将10进制转换为36进制字符串(不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的10进制数据。
	 * @param length 转换后的数据长度。
	 * @param leftPad 左边要填充的字符。
	 * @return 转换后的36进制字符串。
	 */
	public static final String toScale36(long number, int length, String leftPad)
	{
		int scale = 36;
		String dest = "";
		List<String> list = new ArrayList<String>();
		long remainder = number % scale;
		list.add((remainder <= 9)? String.valueOf(remainder): String.valueOf((char)(remainder - 10 + 65)));
		while(number / scale >= 1)
		{
			number = number / scale;
			remainder = number % scale;
			list.add((remainder <= 9)? String.valueOf(remainder): String.valueOf((char)(remainder - 10 + 65)));
		}
		for(int i = 0; i < list.size(); i++)
		{
			dest += list.get(list.size() - 1 - i);
		}
		return (length > 0)? StringUtils.leftPad(dest, length, leftPad): dest;
	}

	/**
	 * 将10进制转换为36进制字符串(不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的10进制数据。
	 * @return 转换后的36进制字符串。
	 */
	public static final String toScale36(long number)
	{
		return toScale36(number, 0, "");
	}

	/**
	 * 将10进制转换为特殊的34进制字符串(其中不会包含字母O与字母I, 不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的10进制数据。
	 * @param length 转换后的数据长度。
	 * @param leftPad 左边要填充的字符。
	 * @return 转换后的34进制字符串。
	 */
	public static final String toSpecialScale34(long number, int length, String leftPad)
	{
		int scale = 34;
		String dest = "";
		List<String> list = new ArrayList<String>();
		list.add(ARRAY_SPECIAL_SCALE34[Integer.parseInt(String.valueOf(number % scale))]);
		while(number / scale >= 1)
		{
			number = number / scale;
			list.add(ARRAY_SPECIAL_SCALE34[Integer.parseInt(String.valueOf(number % scale))]);
		}
		for(int i = 0; i < list.size(); i++)
		{
			dest += list.get(list.size() - 1 - i);
		}
		return (length > 0)? StringUtils.leftPad(dest, length, leftPad): dest;
	}

	/**
	 * 将10进制转换为特殊的34进制字符串(其中不会包含字母O与字母I, 不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的10进制数据。
	 * @return 转换后的36进制字符串。
	 */
	public static final String toSpecialScale34(long number)
	{
		return toSpecialScale34(number, 0, "");
	}

	/**
	 * 从特殊的34进制(其中不会包含字母O与字母I)转换为10进制(不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的36进制字符串。
	 * @return 转换后的10进制数。
	 */
	public static final long fromSpecialScale34(String number)
	{
		int index = 0;
		long total = 0;
		StringBuffer sb = new StringBuffer(number.toUpperCase());
		number = sb.reverse().toString();
		for(int i = 0; i < number.length(); i++)
		{
			char oneChar = number.charAt(i);
			for(index = 0; index < ARRAY_SPECIAL_SCALE34.length; index++)
			{
				if(ARRAY_SPECIAL_SCALE34[index].equals(String.valueOf(oneChar)))
				{
					break;
				}
			}
			oneChar = ARRAY_SPECIAL_SCALE34[index].charAt(0);
			int decChar = Character.isDigit(oneChar)? Integer.parseInt(String.valueOf(oneChar)): index;
			total += decChar * (int)Math.pow(34, i);
		}
		return total;
	}

	/**
	 * 从36进制转换为10进制(不能超过ZZZZZZ即10进制的2176782335)。
	 * @param number 要转换的36进制字符串。
	 * @return 转换后的10进制数。
	 */
	public static final long fromScale36(String number)
	{
		long total = 0;
		StringBuffer sb = new StringBuffer(number.toUpperCase());
		number = sb.reverse().toString();
		for(int i = 0; i < number.length(); i++)
		{
			char oneChar = number.charAt(i);
			int decChar = (int)oneChar;
			if(Character.isDigit(oneChar))
			{
				decChar = Integer.parseInt(String.valueOf(oneChar));
			}
			else
			{
				decChar = decChar + 10 - 65;
			}
			total += decChar * (int)Math.pow(36, i);
		}
		return total;
	}

	/**
	 * 获取客户端的IP地址。
	 * @param request HttpServletRequest 实例。
	 * @return 客户端的IP地址。
	 */
	public static final String getIpAddress(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 将对象转换为JSON字符串。
	 * @param objecr 要转换的对象。
	 * @return 转换后的字符串。
	 */
	public static final String fromPojotoJson(Object objecr)
	{
		String returnJson = "";
		if(objecr != null)
		{
			returnJson = gson.toJson(objecr);
		}
		return returnJson;
	}

	/**
	 * 将一个json字符串按配置进行美化输出。
	 * @param json json字符串。
	 * @return 美化后的字符串。
	 */
	public static final String toJson(String json)
	{
		String returnJson = "";
		if(!defaultString(json).equals(""))
		{
			returnJson = gson.toJson(jsonParser.parse(json));
		}
		return returnJson;
	}

	/**
	 * 将JSON字符串转换为对象。
	 * @param json json字符串。
	 * @param clazz 目标对象类类型。
	 * @return 转换后的对象。
	 */
	public static final Object fromJsonToPojo(String json, Class<?> clazz)
	{
		Object returnObject = null;
		if(!defaultString(json).equals("") && clazz != null)
		{
			returnObject = gson.fromJson(json, clazz);
		}
		return returnObject;
	}


	/**
	 * @Author zhou
	 * @Date 2018/5/30 15:30
	 * @Param [json:要被转换的json字符串]
	 * @Desc 验证从后台传过来的状态码,进行国际化的转换
	 */
	public static final GlobalResult messageTransformation (HttpServletRequest request,String json){
		Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		Map<String, String> map = new HashMap<String, String>();
		if ("zh_CN".equals(locale.toString())) {
			// TODO
//			map.put("msg1", "手机号不能为空");
//			map.put("msg2", "验证码类型不能为空");
//			map.put("msg3", "验证码不能为空");
		}
		if ("en_US".equals(locale.toString())) {
			// TODO
//			map.put("msg1", "Cell phone number can not be empty");
//			map.put("msg2", "The type of verifying code can not be empty");
//			map.put("msg3", "The verifying code cannot be empty");
		}
		GlobalResult result = null;
		if (null == json || "".equals(json)) {
			result.setCode(400);
			result.setMessage("服务器发生异常");
			result.setData("");
			logger.info("后台无数据传输");
			return result;
		} else {
			try {
				result = (GlobalResult) fromJsonToPojo(json, GlobalResult.class);
			} catch (Exception e) {
				logger.error("后台数据格式错误");
				result.setCode(400);
				result.setMessage("后台数据格式错误");
				result.setData("");
				return result;
			}
			if (result.getCode() == 200) {
				// TODO
//				result.setMessage(defaultString(map.get("msg1")));
				return result;
			}

		}
		return result;
	}
	


	/**
	 * 判断是否为IE浏览器。
	 * @param request HttpServletRequest 实例。
	 * @return 是否为IE浏览器。
	 * Mar 9, 2016 3:02:01 PM
	 * @since jdk 1.6.X+
	 */
	public static final boolean isMSIE(HttpServletRequest request)
	{
		return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0)? true: false;
	}
	
	/**
	 * 是否为邮箱
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isPhone (String phone){
//		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
		String regExp = "1[358][0-9]{9}";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phone);
		return m.matches();
	}
}