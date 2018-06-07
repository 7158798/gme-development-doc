package com.manage.base.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 文件上传工具类
 * @author  
 *
 */
public class FileUploadUtil {
	private static final Log log = LogFactory.getLog(FileUploadUtil.class); 
	private static int maxFileSize = 5000 * 1024;
	private static int maxMemSize = 5000 * 1024;
	public static Map<String,String> upload(HttpServletRequest request,String filePath){
		Map<String,String> map=new HashMap<String,String>();
		
		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {
		  DiskFileItemFactory factory = new DiskFileItemFactory();
		  // 设置内存中存储文件的最大值
	      factory.setSizeThreshold(maxMemSize);
	      // 本地存储的数据大于 maxMemSize.
	      factory.setRepository(new File("/upload/"));

	      // 创建一个新的文件上传处理程序
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // 设置最大上传的文件大小
	      upload.setSizeMax( maxFileSize );
	      try{ 
	         // 解析获取的文件
	         List fileItems = upload.parseRequest(request);
	         // 处理上传的文件
	         Iterator i = fileItems.iterator();
	         while ( i.hasNext () ){
	            FileItem fi = (FileItem)i.next();
	            if ( !fi.isFormField () ){
		            // 获取上传文件的参数
		            String fileName = fi.getName();
		            if(fileName==null || fileName.length()==0){
		            	continue;
		            }
		            String hz=fileName.substring(fileName.lastIndexOf("."));
		            String newFileName=System.nanoTime()+hz;
		            // 写入文件
		            File file = new File( filePath+File.separator+newFileName) ;
		            fi.write( file );
		            map.put(fi.getFieldName(), newFileName);
	            }else{
	            	map.put(fi.getFieldName(),fi.getString("utf-8"));
	            }
	         }
	         return map;
	      }catch(Exception ex) {
	    	  log.error("上传文件失败",ex);
	      }
	   }
	   return null;
	}
}
