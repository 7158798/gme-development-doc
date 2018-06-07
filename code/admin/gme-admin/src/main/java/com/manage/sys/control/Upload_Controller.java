package com.manage.sys.control;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.manage.base.tag.Global;
import com.manage.base.util.Constants;
import com.manage.base.util.FileUtils;


/**
 * 控制类
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class Upload_Controller {
	private static final Log log = LogFactory.getLog(Upload_Controller.class);

	/**
	 * app活动详单图片上传
	 */
	@RequestMapping(value = "upload")
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (file == null) {
			jsonMap.put("success", false);
			jsonMap.put("msg", "文件上传失败");
			return jsonMap;
		}
		String path=request.getSession().getServletContext().getRealPath(Constants.DEFAULT_UPLOAD_FILE);
		String localPath = saveFile(file, path);
		if (localPath == null) {
			jsonMap.put("success", false);
			jsonMap.put("msg", "文件上传失败");
			return jsonMap;
		}
		jsonMap.put("success", true);
		jsonMap.put("msg", "文件上传成功");
		jsonMap.put("filePath", localPath);
		return jsonMap;
	}


	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
	

	/**
	 * 转换,文件名变成当前日期加随机数
	 * 
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file, String path) {
		File f = null;
		try {
			byte[] data = IOUtils.toByteArray(file.getInputStream());
			String fileName = DigestUtils.md5Hex(data);
			StringBuffer pathstr = new StringBuffer(path); // 临时路径
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			if (StringUtils.isNotEmpty(file.getName()) && file.getName().lastIndexOf(".") >= 0) {
				suffix = fileName.substring(fileName.lastIndexOf("."));
			}
			fileName = fileName + suffix;
			f = new File(pathstr + File.separator + fileName);
			FileUtils.copyInputStreamToFile(file.getInputStream(), f);
			return Global.getConfig("webUrl")+"/"+Constants.DEFAULT_UPLOAD_FILE+"/"+fileName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
