package com.manage.sys.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.manage.sysConfig.SysConfig;



public class ContextLoaderListener extends HttpServlet implements ServletContextListener{
	private Logger log = Logger.getLogger(ContextLoaderListener.class);
	public void contextDestroyed(ServletContextEvent servlet) {
		//tomcat关闭时候执行操作
	}
  
	public void contextInitialized(ServletContextEvent servlet) {
		log.info("---------------------程序加载开始------------------------");
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
		
		//加载配置文件
		SysConfig.getConfig().initConfig();
		
		log.info("---------------------程序加载结束------------------------");
	}

}
