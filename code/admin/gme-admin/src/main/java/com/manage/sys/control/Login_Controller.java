package com.manage.sys.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manage.base.tag.Global;
import com.manage.base.util.UserUtil;
import com.manage.sys.entity.Sys_user;

/**
 * 登录控制类
 */
@Controller
public class Login_Controller {
	
	private static final Log log = LogFactory.getLog(Login_Controller.class);
	
	/**
	 * 前往登录页
	 */
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.GET)
	public String login(HttpSession session,HttpServletRequest request, HttpServletResponse response, Model model) {
		Sys_user user = UserUtil.getCurUser();
		// 如果已经登录，则跳转到管理首页
		if(user != null){
			session.setAttribute("user",user);
			return "redirect:"+Global.getAdminPath();
		}
		return "login";
	}
	
	/**
	 * 管理登录
	 */
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.POST)
	public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,HttpServletRequest request, HttpServletResponse response, Model model) {
		Sys_user user = UserUtil.getCurUser();
		// 如果已经登录，则跳转到管理首页
		if(user != null){
			return "redirect:"+Global.getAdminPath();
		}else{
			return "login";
		}
	}
	
	/**
	 * 登录成功，进入管理首页
	 */
	@RequiresUser
	@RequestMapping(value = "${adminPath}")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Sys_user user=UserUtil.getCurUser();
		// 如果没有登录,则跳转到登录页面
		if(user==null){
			return "redirect:"+Global.getAdminPath()+"/login";
		}
		return "index";
	}
	
	/**
	 *首页内容页
	 */
	@RequiresUser
	@RequestMapping(value = "${adminPath}/main")
	public String indexinfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "main";
	}
	
}
