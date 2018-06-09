package com.manage.base.util; 
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.manage.base.tag.Global;

/**
 * 对OSS服务器进行上传删除等的处理
* @ClassName: OSSManageUtil 
*
 */
public class OSSManageUtil {
	/**
	 * 上传OSS服务器文件
	* @Title: uploadFile 
	* @Description: 
	* @param file 需要上传的图片或者其他   
	* @return 返回可直接访问的阿里云图片全地址  
	* @throws
	 */
	public static String uploadFile(File file,String fileName,String youKey) throws Exception{
		String endpoint = Global.getConfig("aly.endpoint");
        String accessKeyId = Global.getConfig("aly.accessKeyId");
     	String accessKeySecret = Global.getConfig("aly.accessKeySecret");
     	String bucketName = Global.getConfig("aly.bucketName");
		
     	if(StringUtils.isEmpty(endpoint) || StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(bucketName) || StringUtils.isEmpty(youKey)){
     		return null;
     	}
     	
		InputStream fileContent=null;
		fileContent=new FileInputStream(file);
		
		OSSClient ossClient=new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String remoteFilePath = youKey.replaceAll("\\\\","/")+"/";
		//创建上传Object的Metadata
		ObjectMetadata objectMetadata=new ObjectMetadata();
		objectMetadata.setContentLength(fileContent.available());
		objectMetadata.setCacheControl("no-cache");
		objectMetadata.setHeader("Pragma", "no-cache");
		if(StringUtils.isNotEmpty(fileName) && fileName.lastIndexOf(".") >= 0){
			objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf(".")+1)));
		}else{
			objectMetadata.setContentType(contentType("jpeg"));
		}
		objectMetadata.setContentDisposition("inline;filename=" + fileName);
		//上传文件
		PutObjectResult putObjectResult=ossClient.putObject(bucketName, remoteFilePath + fileName, fileContent, objectMetadata);
		if(putObjectResult==null || putObjectResult.getETag()==null){
			throw new Exception("文件上传到阿里云失败");
		}
		return endpoint+"/"+bucketName+"/"+youKey+"/"+ fileName;
	}
	
	/**
	 * 上传OSS服务器文件
	* @Title: uploadFile 
	* @Description: 
	* @param file 需要上传的图片或者其他   
	* @param fileMd5 文件md5值
	* @return 返回可直接访问的阿里云图片全地址  
	* @throws
	 */
	public static String uploadString(String content,String fileName,String youKey,String fileMd5) throws Exception{
		String endpoint = Global.getConfig("aly.endpoint");
        String accessKeyId = Global.getConfig("aly.accessKeyId");
     	String accessKeySecret = Global.getConfig("aly.accessKeySecret");
     	String bucketName = Global.getConfig("aly.bucketName");
     	
     	if(StringUtils.isEmpty(endpoint) || StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(bucketName) || StringUtils.isEmpty(youKey)){
     		return null;
     	}
     	
		ByteArrayInputStream fileContent=null;
		fileContent=new ByteArrayInputStream(content.getBytes("utf-8"));
		
		OSSClient ossClient=new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String remoteFilePath = youKey.replaceAll("\\\\","/")+"/";
		//创建上传Object的Metadata
		ObjectMetadata objectMetadata=new ObjectMetadata();
		objectMetadata.setContentLength(fileContent.available());
		objectMetadata.setCacheControl("no-cache");
		objectMetadata.setHeader("Pragma", "no-cache");
		if(StringUtils.isNotEmpty(fileName) && fileName.lastIndexOf(".") >= 0){
			objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf(".")+1)));
		}else{
			objectMetadata.setContentType(contentType("jpeg"));
		}
		objectMetadata.setContentDisposition("inline;filename=" + fileName);
		//上传文件
		PutObjectResult putObjectResult=ossClient.putObject(bucketName, remoteFilePath + fileName, fileContent, objectMetadata);
//		System.out.println(fileName);
//		System.out.println(putObjectResult.getETag());
		if(putObjectResult==null || putObjectResult.getETag()==null || fileMd5.toUpperCase().indexOf(putObjectResult.getETag().toUpperCase())==-1){
			throw new Exception("文件上传到阿里云失败");
		}
		return endpoint+"/"+bucketName+"/"+youKey+"/"+ fileName;
	}
	/**
	 * 上传OSS服务器文件
	* @Title: uploadFile 
	* @Description: 
	* @param file 需要上传的图片或者其他   
	* @param fileMd5 文件md5值
	* @return 返回可直接访问的阿里云图片全地址  
	* @throws
	 */
	public static String uploadString(InputStream content,String fileName,String youKey) throws Exception{
		String endpoint = Global.getConfig("aly.endpoint");
        String accessKeyId = Global.getConfig("aly.accessKeyId");
     	String accessKeySecret = Global.getConfig("aly.accessKeySecret");
     	String bucketName = Global.getConfig("aly.bucketName");
     	if(StringUtils.isEmpty(endpoint) || StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(bucketName) || StringUtils.isEmpty(youKey)){
     		return null;
     	}
     	
		OSSClient ossClient=new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String remoteFilePath = youKey.replaceAll("\\\\","/")+"/";
		//创建上传Object的Metadata
		ObjectMetadata objectMetadata=new ObjectMetadata();
		objectMetadata.setContentLength(content.available());
		objectMetadata.setCacheControl("no-cache");
		objectMetadata.setHeader("Pragma", "no-cache");
		if(StringUtils.isNotEmpty(fileName) && fileName.lastIndexOf(".") >= 0){
			objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf(".")+1)));
		}else{
			objectMetadata.setContentType(contentType("jpeg"));
		}
		objectMetadata.setContentDisposition("inline;filename=" + fileName);
		//上传文件
		PutObjectResult putObjectResult=ossClient.putObject(bucketName, remoteFilePath + fileName, content, objectMetadata);
		if(putObjectResult==null || putObjectResult.getETag()==null || fileName.toUpperCase().indexOf(putObjectResult.getETag().toUpperCase())==-1){
			throw new Exception("文件上传到阿里云失败");
		}
		return endpoint+"/"+bucketName+"/"+youKey+"/"+ fileName;
	}
	/**
	 * 根据key删除OSS服务器上的文件
	* @Title: deleteFile 
	* @Description: 
	* @param @param ossConfigure
	* @param @param filePath    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void deleteFile(String filePath){
		String endpoint = Global.getConfig("aly.endpoint");
        String accessKeyId = Global.getConfig("aly.accessKeyId");
     	String accessKeySecret = Global.getConfig("aly.accessKeySecret");
     	String bucketName = Global.getConfig("aly.bucketName");
     	if(StringUtils.isEmpty(endpoint) || StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(bucketName)){
     		return;
     	}
     	
		OSSClient ossClient = new OSSClient(endpoint,accessKeyId, accessKeySecret);
		ossClient.deleteObject(bucketName, filePath);
		
	}
	
	 /**
     * Description: 判断OSS服务文件上传时文件的contentType
     * @Version1.0
     * @param FilenameExtension 文件后缀
     * @return String 
     */
	 public static String contentType(String FilenameExtension){
		 FilenameExtension = FilenameExtension.toUpperCase();
		if(FilenameExtension.equals("BMP")){return "image/bmp";}
		if(FilenameExtension.equals("GIF")){return "image/gif";}
		if(FilenameExtension.equals("JPEG")||
		   FilenameExtension.equals("JPG")||	
		   FilenameExtension.equals("PNG")){return "image/jpeg";}
		if(FilenameExtension.equals("HTML")){return "text/html";}
		if(FilenameExtension.equals("TXT")){return "text/plain";}
		if(FilenameExtension.equals("VSD")){return "application/vnd.visio";}
		if(FilenameExtension.equals("PPTX")||
			FilenameExtension.equals("PPT")){return "application/vnd.ms-powerpoint";}
		if(FilenameExtension.equals("DOCX")||
			FilenameExtension.equals("DOC")){return "application/msword";}
		if(FilenameExtension.equals("XML")){return "text/xml";}
		if(FilenameExtension.equals("ZIP")){return "application/zip";}
		if(FilenameExtension.equals("APK")){return "application/vnd.android.package-archive";}
		if(FilenameExtension.equals("IPA")){return "application/vnd.iphone";}
		return "text/html";
	 }

//	 public static void main(String[] args) {
//		try {
//			System.out.println("ios="+uploadFile(new File("D:\\ios.png"), "ios.png", "app/tcode"));
//			System.out.println("android="+uploadFile(new File("D:\\android.png"), "android.png", "app/tcode"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
