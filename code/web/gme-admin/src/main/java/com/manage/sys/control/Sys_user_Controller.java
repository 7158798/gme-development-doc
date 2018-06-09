package com.manage.sys.control;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.base.cache.Sys_role_cache;
import com.manage.base.entity.PageInfo;
import com.manage.base.util.Constants;
import com.manage.base.util.UserUtil;
import com.manage.sys.entity.Sys_user;
import com.manage.sys.service.Sys_user_Service;
import com.manage.sys.vo.Sys_user_VO;

/**
 * 后台管理员控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sys_user")
public class Sys_user_Controller{
	private static final Log log = LogFactory.getLog(Sys_user_Controller.class);

    @Resource(name = "Sys_user_Service")
    private Sys_user_Service sys_user_Service;

	/**
     * 去分页
     */
    @RequiresPermissions("sys:sys_user:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	model.addAttribute("roles", Sys_role_cache.getRolesFromCache());
    	return "modules/sys/sys_userList";
    }
    
    /**
     * 分页
     */
    @RequiresPermissions("sys:sys_user:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sys_user_vo") Sys_user_VO sys_user_vo) throws Exception {
        if (sys_user_vo == null) {
            sys_user_vo = new Sys_user_VO();
        }
        if (request.getParameter("page") != null) {
            sys_user_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            sys_user_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = sys_user_Service.selectPage(sys_user_vo);
	        jsonMap.put("total", pageInfo.getTotalCount());
	        jsonMap.put("pages", pageInfo.getTotalPageCount());
	        jsonMap.put("rows", pageInfo.getData());
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("sys:sys_user:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	model.addAttribute("roles", Sys_role_cache.getRolesFromCache());
        return "modules/sys/sys_userAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sys_user:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sys_user") Sys_user sys_user) throws Exception {
    	sys_user.setCreatetime(new Timestamp(System.currentTimeMillis()));
    	
    	System.out.println("1 =====>>>> : "+sys_user);
    	System.out.println("2 用户名  =====>>>> : "+sys_user.getUsername());
    	System.out.println("3 密码  =====>>>> : "+sys_user.getUserpwd());
    	System.out.println("3 密码  =====>>>> : "+sys_user.getUserpwd());
    	System.out.println("3 密码  =====>>>> : "+sys_user.getUserpwd());
    	
        String newPwd = new SimpleHash(Constants.PASSWORD_TYPE, sys_user.getUserpwd(), sys_user.getUsername().toLowerCase(),2).toString();
    	System.out.println("4 newPwd  =====>>>> : "+newPwd);
    	
        sys_user.setUserpwd(newPwd);
    	sys_user.setStatus(Integer.parseInt("1"));//默认用户状态:1-正常;2-禁用
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_user_Service.add(sys_user);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }

    /**
     * 去修改
     */
    @RequiresPermissions("sys:sys_user:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
    	model.addAttribute("roles", Sys_role_cache.getRolesFromCache());
        model.addAttribute("item", sys_user_Service.get(id));
        return "modules/sys/sys_userUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sys_user:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sys_user") Sys_user sys_user) throws Exception {
    	boolean isCheck=false;
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		Sys_user_VO sys_user_VO=new Sys_user_VO();
    		sys_user_VO.setUserName(sys_user.getUsername());
        	List<Sys_user> list=sys_user_Service.selectAll(sys_user_VO);
    		if(list==null && list.size()==0){
    			isCheck=true;
    		}else{
    			boolean t=false;
    			for(int i=0;i<list.size();i++){
    				if(list.get(i).getUsername().equals(sys_user.getUsername()) && !list.get(i).getId().toString().equals(sys_user.getId().toString())){
    					t=true;
    				}
    			}
    			if(t){
    				jsonMap.put("success", false);
                    jsonMap.put("msg", "已经有了该用户！");
    			}else{
    				isCheck=true;
    			}
    		}
    		if(isCheck){
    	        boolean result = sys_user_Service.update(sys_user);
    	        if (result) {
    	            jsonMap.put("success", true);
    	            jsonMap.put("msg", "操作成功");
    	        } else {
    	            jsonMap.put("success", false);
    	            jsonMap.put("msg", "操作失败");
    	        }
    		}
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
		return jsonMap;
    }
    /**
     * 删除
     */
    @RequiresPermissions("sys:sys_user:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id ) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_user_Service.delete(id);
        	if (result) {
                jsonMap.put("success", true);
                jsonMap.put("msg", "操作成功");
            } else {
                jsonMap.put("success", false);
                jsonMap.put("msg", "操作失败");
            }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }
    /**
     * 查看详情
     */
    @RequiresPermissions("sys:sys_user:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_user_Service.get(id));
        model.addAttribute("roles", Sys_role_cache.getRolesFromCache());
        return "modules/sys/sys_userInfo";
    }
    
    /**
     * 重置密码
     */
    @RequiresPermissions("sys:sys_user:update")
    @RequestMapping(value = "rsetPass")
    @ResponseBody
    public Map<String, Object> rsetPass(HttpServletRequest request, HttpServletResponse response, Model model, @FormModel("sys_user") Sys_user sys_user) throws Exception {
    	String newPwd = new SimpleHash(Constants.PASSWORD_TYPE, Constants.DEFAULT_PAS, sys_user.getUsername().toLowerCase(),2).toString();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		boolean result = sys_user_Service.update(sys_user);
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功新密码为："+Constants.DEFAULT_PAS);
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }
    /**
     * 校验用户名是否重名
     */
    @RequiresPermissions("sys:sys_user:view")
    @RequestMapping(value = "checkUser")
    @ResponseBody
    public Map<String, Object> checkUser(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sys_user_vo") Sys_user_VO sys_user_vo) throws Exception {
    	sys_user_vo.setUserName(request.getParameter("param"));
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		if(sys_user_vo.getCheckType().equals("1")){
        		List<Sys_user> list=sys_user_Service.selectAll(sys_user_vo);
        		if(list!=null && list.size()>0){
        			jsonMap.put("status", "n");
                    jsonMap.put("info", "已经有了该用户！");
        		}else{
        			jsonMap.put("status", "y");
                    jsonMap.put("info", "校验通过！");
        		}
        		return jsonMap;
        	}
        	if(sys_user_vo.getCheckType().equals("2")){
        		List<Sys_user> list=sys_user_Service.selectAll(sys_user_vo);
        		if(list==null && list.size()==0){
        			jsonMap.put("status", "y");
                    jsonMap.put("info", "校验通过！");
        		}else{
        			boolean t=false;
        			for(int i=0;i<list.size();i++){
        				if(list.get(i).getUsername().equals(sys_user_vo.getUserName()) && !list.get(i).getId().toString().equals(sys_user_vo.getId().toString())){
        					t=true;
        				}
        			}
        			if(t){
        				jsonMap.put("status", "n");
                        jsonMap.put("info", "已经有了该用户！");
        			}else{
        				jsonMap.put("status", "y");
                        jsonMap.put("info", "校验通过！");
        			}
        		}
        		return jsonMap;
        	}
        	jsonMap.put("status", "n");
            jsonMap.put("info", "操作异常！");
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }
    /**
     * 查看当前用户详情
     */
    @RequiresUser
    @RequestMapping(value = "curInfo")
    public String curInfo(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception { 
    	 model.addAttribute("item", UserUtil.getCurUser());
    	 return "modules/sys/modifyUserInfo";
    }
    /**
     * 去修改当前用户密码
     */
    @RequiresUser
    @RequestMapping(value = "toCurUpdatePass")
    public String toCurUpdatePass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	
    	return "modules/sys/modifyPassword";
    }
    /**
     * 校验用户密码
     */
    @RequestMapping(value = "checkUserPass")
    @ResponseBody
    public Map<String, Object> checkUserPass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	Sys_user sys_user=UserUtil.getCurUser();
    	String userOldPass=request.getParameter("param");
    	String oldPwd = new SimpleHash(Constants.PASSWORD_TYPE,userOldPass, sys_user.getUsername().toLowerCase(),2).toString();
    	if(!sys_user.getUserpwd().equals(oldPwd)){
    		jsonMap.put("status", "n");
            jsonMap.put("info", "旧密码错误！");
            return jsonMap;
    	}
    	jsonMap.put("status", "y");
        jsonMap.put("info", "通过信息验证！");
        return jsonMap;
    }
    /**
     * 修改当前用户密码
     */
    @RequiresUser
    @RequestMapping(value = "curUpdatePass")
    @ResponseBody
    public Map<String, Object> curUpdatePass(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	String userOldPass=request.getParameter("oldPassword");
    	String userNewPass=request.getParameter("newPassword");
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	Sys_user sys_user=UserUtil.getCurUser();
    	String oldPwd = new SimpleHash(Constants.PASSWORD_TYPE,userOldPass, sys_user.getUsername().toLowerCase(),2).toString();
    	String newPwd = new SimpleHash(Constants.PASSWORD_TYPE,userNewPass, sys_user.getUsername().toLowerCase(),2).toString();
    	if(!sys_user.getUserpwd().equals(oldPwd)){
    		jsonMap.put("success", false);
            jsonMap.put("msg", "旧密码错误！");
            return jsonMap;
    	}
    	Sys_user sys_user2=new Sys_user();
    	sys_user2.setUserpwd(newPwd);
    	sys_user2.setId(sys_user.getId());
    	try{
    		boolean result = sys_user_Service.update(sys_user2);
            if (result) {
            	sys_user.setUserpwd(newPwd);
                jsonMap.put("success", true);
                jsonMap.put("msg", "操作成功");
            } else {
                jsonMap.put("success", false);
                jsonMap.put("msg", "操作失败");
            }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
        return jsonMap;
    }
    /**
     * 修改当前用户信息
     */
    @RequestMapping(value = "curUpdate")
    @ResponseBody
    public Map<String, Object> curUpdate(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sys_user") Sys_user sys_user) throws Exception {
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	try{
    		boolean result = sys_user_Service.update(sys_user);
 	        if (result) {
 	        	Sys_user sessionUser=UserUtil.getCurUser();
 	        	sessionUser.setPhone(sys_user.getPhone());
 	        	sessionUser.setQq(sys_user.getQq());
 	        	sessionUser.setTruename(sys_user.getTruename());
 	        	sessionUser.setEmail(sys_user.getEmail());
 	            jsonMap.put("success", true);
 	            jsonMap.put("msg", "操作成功");
 	        } else {
 	            jsonMap.put("success", false);
 	            jsonMap.put("msg", "操作失败");
 	        }
        }catch (Exception e) {
        	log.error("系统异常",e);
        	jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
		}
		return jsonMap;
    }
}
