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
import com.manage.sys.service.Sys_menu_Service;
import com.manage.sys.vo.Sys_menu_VO;

/**
 * 菜单控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sys_menu")
public class Sys_menu_Controller{
	private static final Log log = LogFactory.getLog(Sys_menu_Controller.class);

    @Resource(name = "Sys_menu_Service")
    private Sys_menu_Service sys_menu_Service;

	/**
     * 去菜单列表页
     */
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sys_menuList";
    }
    
    /**
     * 获取所有菜单数据
     */
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sys_menu_vo") Sys_menu_VO sys_menu_vo) throws Exception {
        if (sys_menu_vo == null) {
            sys_menu_vo = new Sys_menu_VO();
        }
        if (request.getParameter("page") != null) {
            sys_menu_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            sys_menu_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<Sys_menu> list = sys_menu_Service.selectTree();
	        jsonMap.put("rows", list);
        }catch (Exception e) {
        	log.error("系统异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("sys:sys_menu:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	List<Sys_menu> list=sys_menu_Service.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sys_menuAdd";
    }

    /**
     * 新增菜单
     */
    @RequiresPermissions("sys:sys_menu:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sys_menu") Sys_menu sys_menu) throws Exception {
    	sys_menu.setType(0);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_menu_Service.add(sys_menu);
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
    @RequiresPermissions("sys:sys_menu:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_menu_Service.get(id));
        List<Sys_menu> list=sys_menu_Service.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sys_menuUpdate";
    }

    /**
     * 修改菜单信息
     */
    @RequiresPermissions("sys:sys_menu:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sys_menu") Sys_menu sys_menu) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_menu_Service.update(sys_menu);
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
     * 删除菜单信息
     */
    @RequiresPermissions("sys:sys_menu:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_menu_Service.delete(id);
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
     * 查看菜单详情
     */
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_menu_Service.get(id));
        List<Sys_menu> list = sys_menu_Service.selectAllFather();
    	request.setAttribute("result", list);
        return "modules/sys/sys_menuInfo";
    }
    
}
