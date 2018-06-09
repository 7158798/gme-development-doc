package com.manage.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.base.tag.Global;
import com.manage.base.util.Constants;
import com.manage.base.util.FileUploadUtil;


public class UploadServlet extends HttpServlet{
	public void init(ServletConfig servletConfig) throws ServletException {
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter=null;
		String filePath = req.getSession().getServletContext().getRealPath(Constants.DEFAULT_UPLOAD_FILE);
		Map<String,String> map=FileUploadUtil.upload(req, filePath);
		try{
			printWriter=resp.getWriter();
			if(map!=null && map.get("imgFile")!=null){
				String url=Global.getConfig("webUrl")+"/"+Constants.DEFAULT_UPLOAD_FILE+"/"+map.get("imgFile");
				printWriter.println("{\"error\":0,\"url\":\""+url+"\"}");
			}else{
				printWriter.println("{\"error\":1,\"message\":\"上传失败！\"}");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}
}
