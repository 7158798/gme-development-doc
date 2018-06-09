package com.manage.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;



public class ReadXmlUtil {
	
	private String QrCodeUploadPath; 
	
	

	public String getQrCodeUploadPath() {
		return QrCodeUploadPath;
	}



	public void setQrCodeUploadPath(String qrCodeUploadPath) {
		QrCodeUploadPath = qrCodeUploadPath;
	}



	public static Map ReadXml(String key){
		Map result = new HashMap();
		String path = ReadXmlUtil.class.getResource("/com/manage/sysConfig/SysConfig.xml").toString();
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			if(path!=null){
				doc = reader.read(path);
			}else{
				return null;
			}
			if(doc == null){
				return null;
			}
			//系统配置
			if(key!=null){
				key = StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/"+key).getText());
				result.put("path", key);
				//result.put("path", path);
			}else{
				return null;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("配置文件sysConfig.xml错误",e);
		}
		return result;
	}
	

}
