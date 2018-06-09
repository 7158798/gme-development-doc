package com.manage.sys.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.sys.entity.Sys_menu;
import com.manage.sys.entity.Sys_role;
import com.manage.sys.service.Sys_menu_Service;
import com.manage.sys.service.Sys_rmenu_Service;
import com.manage.sys.service.Sys_role_Service;
import com.manage.sys.vo.SysMenuPersions;
import com.manage.sys.vo.Sys_role_VO;

/**
 * 角色说明控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sys_role")
public class Sys_role_Controller{
	private static final Log log = LogFactory.getLog(Sys_role_Controller.class);

    @Resource(name = "Sys_role_Service")
    private Sys_role_Service sys_role_Service;
    @Resource(name = "Sys_menu_Service")
    private Sys_menu_Service sys_menu_Service;
    @Resource(name = "Sys_rmenu_Service")
    private Sys_rmenu_Service sys_rmenu_Service;
	
    /**
     * 去分页
     */
    @RequiresPermissions("sys:sys_role:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sys_roleList";
    }
   
    /**
     * 分页
     */
    @RequiresPermissions("sys:sys_role:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sys_role_vo") Sys_role_VO sys_role_vo) throws Exception {
        if (sys_role_vo == null) {
            sys_role_vo = new Sys_role_VO();
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<Sys_role> list= sys_role_Service.selectAll(sys_role_vo);
	        jsonMap.put("rows", list);
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("sys:sys_role:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/sys/sys_roleAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sys_role:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sys_role") Sys_role sys_role) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_role_Service.add(sys_role);
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
    @RequiresPermissions("sys:sys_role:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_role_Service.get(id));
        return "modules/sys/sys_roleUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sys_role:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sys_role") Sys_role sys_role) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_role_Service.update(sys_role);
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
     * 删除
     */
    @RequiresPermissions("sys:sys_role:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_role_Service.delete(id);
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
    @RequiresPermissions("sys:sys_role:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_role_Service.get(id));
        return "modules/sys/sys_roleInfo";
    }
    /**
     * 查询角色菜单
     */
    @RequiresPermissions("sys:sys_role:view")
    @RequestMapping(value = "listRoleMenu")
    public String listRoleMenu(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sys_role_vo") Sys_role_VO sys_role_VO) throws Exception {
    	List<Sys_menu> list=sys_menu_Service.getAllMenuFromCache();
    	List<SysMenuPersions> list3=sys_rmenu_Service.selectCheckBoxTree(list, sys_role_VO.getId());
    	model.addAttribute("list", list3);
    	model.addAttribute("rid", sys_role_VO.getId());
    	return "modules/sys/set_role_menu_persions";
    }
    /**
     * 设置角色菜单
     */
    @RequiresPermissions("sys:sys_role:add")
    @RequestMapping(value = "addRoleMenu")
    @ResponseBody
    public Map<String, Object> addRoleMenu(HttpServletRequest request, HttpServletResponse response, Model model,@FormModel("sys_role_vo") Sys_role_VO sys_role_VO) throws Exception {
    	try{
	    	boolean result =sys_rmenu_Service.addBatch(sys_role_VO.getMenuIds(), sys_role_VO.getId());
	        Map<String, Object> jsonMap = new HashMap<String, Object>();
	        if (result) {
	            jsonMap.put("success", true);
	            jsonMap.put("msg", "操作成功");
	        } else {
	            jsonMap.put("success", false);
	            jsonMap.put("msg", "操作失败");
	        }
	        return jsonMap;
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return null;
    }
}
