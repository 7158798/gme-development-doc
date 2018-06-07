package com.manage.base.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.manage.sys.service.Sys_menu_Service;
import com.manage.sys.service.Sys_persion_Service;
import com.manage.sys.service.Sys_rmenu_Service;
import com.manage.sys.service.Sys_role_Service;
import com.manage.sys.service.Sys_rpersion_Service;
 

/**
 * 系统启动完加载默认数据到缓存
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>{
	private static final Logger LOG = Logger.getLogger(InstantiationTracingBeanPostProcessor.class);
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			try{
				Sys_menu_Service sys_menu_Service= (Sys_menu_Service)SpringContextUtil.getBean("Sys_menu_Service");
				sys_menu_Service.cache();
				LOG.info("系统加载初始化菜单数据完成。。。。");
			}catch (Exception e) {
				LOG.error("加载所有菜单数据失败！",e);
			}
			try{
				Sys_persion_Service ll_sys_persion_Service = (Sys_persion_Service)SpringContextUtil.getBean("Sys_persion_Service");
				ll_sys_persion_Service.cache();
				LOG.info("系统加载菜单功能数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载菜单功能数据失败！",e);
			}
			try{
				Sys_role_Service ll_sys_role_Service= (Sys_role_Service)SpringContextUtil.getBean("Sys_role_Service");
				ll_sys_role_Service.cache();
				LOG.info("系统加载角色数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色数据失败！",e);
			}
			try{
				Sys_rmenu_Service ll_sys_rmenu_Service = (Sys_rmenu_Service)SpringContextUtil.getBean("Sys_rmenu_Service");
				ll_sys_rmenu_Service.cacheSysRoleMenu();
				LOG.info("系统加载角色菜单数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色菜单数据失败！",e);
			}
			try{
				Sys_rpersion_Service ll_sys_rpersion_Service = (Sys_rpersion_Service)SpringContextUtil.getBean("Sys_rpersion_Service");
				ll_sys_rpersion_Service.cache();
				LOG.info("系统加载角色菜单功能数据完成。。。。");
			}catch (Exception e) {
				LOG.error("系统加载角色菜单功能数据失败！",e);
			}
			
		}  
	}

}
