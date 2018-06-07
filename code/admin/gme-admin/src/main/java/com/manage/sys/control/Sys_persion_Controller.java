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
import com.manage.sys.entity.Sys_persion;
import com.manage.sys.service.Sys_persion_Service;
import com.manage.sys.vo.Sys_persion_VO;

/**
 * 菜单功能表控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sys_persion")
public class Sys_persion_Controller{
	private static final Log log = LogFactory.getLog(Sys_persion_Controller.class);

    @Resource(name = "Sys_persion_Service")
    private Sys_persion_Service sys_persion_Service;

	/**
     * 去分页
     */
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/sys/sys_persionList";
    }
    
    /**
     * 分页
     */
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("sys_persion_vo") Sys_persion_VO sys_persion_vo) throws Exception {
        if (sys_persion_vo == null) {
            sys_persion_vo = new Sys_persion_VO();
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	List<Sys_persion> list = sys_persion_Service.selectAll(sys_persion_vo);
	        jsonMap.put("rows",list);
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
    	model.addAttribute("mid", request.getParameter("mid"));
        return "modules/sys/sys_persionAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("sys:sys_menu:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("sys_persion") Sys_persion sys_persion) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_persion_Service.add(sys_persion);
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
        model.addAttribute("item", sys_persion_Service.get(id));
        return "modules/sys/sys_persionUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("sys:sys_menu:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("sys_persion") Sys_persion sys_persion) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = sys_persion_Service.update(sys_persion);
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
    @RequiresPermissions("sys:sys_menu:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model, java.lang.Long id) throws Exception {
        model.addAttribute("item", sys_persion_Service.get(id));
        return "modules/sys/sys_persionInfo";
    }
    
    /**
     * 删除
     */
    @RequiresPermissions("sys:sys_menu:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,java.lang.Long id ) throws Exception {
        boolean result = sys_persion_Service.delete(id,null);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (result) {
            jsonMap.put("success", true);
            jsonMap.put("msg", "操作成功");
        } else {
            jsonMap.put("success", false);
            jsonMap.put("msg", "操作失败");
        }
        return jsonMap;
    }
    
}
