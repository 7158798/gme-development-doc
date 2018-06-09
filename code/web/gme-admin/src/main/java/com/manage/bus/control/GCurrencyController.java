package com.manage.bus.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.base.annotation.FormModel;
import com.manage.base.entity.PageInfo;
import com.manage.bus.entity.GCurrency;
import com.manage.bus.service.GCurrencyService;
import com.manage.bus.vo.GCurrencyVO;
/**
 * 币种表（g_currency）
功能描述：存储币种信息。控制类
 */
@Controller
@RequestMapping(value = "${adminPath}/bus/g_currency")
public class GCurrencyController{
	private static final Log log = LogFactory.getLog(GCurrencyController.class);

    @Resource(name = "GCurrencyService")
    private GCurrencyService g_currency_service;

	/**
     * 去分页
     */
    @RequiresPermissions("bus:g_currency:view")
    @RequestMapping(value = "toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    	return "modules/bus/g_currencyList";
    }
    /**
     * 分页
     */
    @RequiresPermissions("bus:g_currency:view")
    @RequestMapping(value = "list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response, Model model,
                       @FormModel("g_currency_vo") GCurrencyVO g_currency_vo) throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String bg_create_date = request.getParameter("bg_create_date");
    	if (null != bg_create_date && !"".equals(bg_create_date) && !"null".equals(bg_create_date)) {
    		Date bg_date = sdf.parse(bg_create_date);
    		g_currency_vo.setBg_create_date(bg_date);
    	}
    	String end_create_date = request.getParameter("end_create_date");
    	if (null != end_create_date && !"".equals(end_create_date) && !"null".equals(end_create_date)) {
    		Date end_date = sdf.parse(end_create_date);
    		g_currency_vo.setEnd_create_date(end_date);
    	}
    	
        if (g_currency_vo == null) {
            g_currency_vo = new GCurrencyVO();
        }
        if (request.getParameter("page") != null) {
            g_currency_vo.setPage(Integer.parseInt(request.getParameter("page")));
        }if (request.getParameter("rows") != null) {
            g_currency_vo.setRows(Integer.parseInt(request.getParameter("rows")));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	PageInfo pageInfo = g_currency_service.selectPage(request,g_currency_vo);
	        jsonMap.put("total", pageInfo.getTotalCount());
	        jsonMap.put("pages", pageInfo.getTotalPageCount());
	        jsonMap.put("rows", pageInfo.getData());
        }catch (Exception e) {
        	log.error("币种管理发生异常",e);
		}
        return jsonMap;
    }

    /**
     * 去新增
     */
    @RequiresPermissions("bus:g_currency:add")
    @RequestMapping(value = "toAdd")
    public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "modules/bus/g_currencyAdd";
    }

    /**
     * 新增
     */
    @RequiresPermissions("bus:g_currency:add")
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, Model model,
                      @FormModel("g_currency") GCurrency g_currency) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	g_currency.setCurrency_id("1");
        	boolean result = g_currency_service.add(request,g_currency);
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
    @RequiresPermissions("bus:g_currency:update")
    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(name="id") java.lang.String currency_id) throws Exception {
    	GCurrency currency = g_currency_service.get(request,currency_id);
        model.addAttribute("item", currency);
        return "modules/bus/g_currencyUpdate";
    }

    /**
     * 修改
     */
    @RequiresPermissions("bus:g_currency:update")
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response, Model model,
                         @FormModel("g_currency") GCurrency g_currency) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_service.update(request,g_currency);
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
    @RequiresPermissions("bus:g_currency:delete")
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, Model model,
                         java.lang.String currency_id) throws Exception {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try{
        	boolean result = g_currency_service.delete(request,currency_id);
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
    @RequiresPermissions("bus:g_currency:view")
    @RequestMapping(value = "info")
    public String info(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam(name="id") java.lang.String currency_id) throws Exception {
        model.addAttribute("item", g_currency_service.get(request,currency_id));
        return "modules/bus/g_currencyInfo";
    }
}
