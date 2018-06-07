package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.entity.WorkList;
import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.WorkListService;
import com.gmebtc.web.portal.utils.Toolkits;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;

/*
 * @Author zhou
 * @Date 2018/5/30 17:40
 * @Desc 工单系统
 */
@Controller
@RequestMapping("${ROOT_PATH}/user")
public class WorkListController {

    @Resource(name = "workListService")
    private WorkListService workListService;


    /**
     * @Author zhou
     * @Date 2018/5/30 17:41
     * @Param [request]
     * @Desc 查看我的工单
     */
    @RequestMapping(value = "/workListInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object getWorkListInfo (HttpServletRequest request){
        String json = workListService.getWorkListInfo(request);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 18:00
     * @Param [request, workList]
     * @Desc 提交工单
     */
    @RequestMapping(value = "/sendWorkList",method = RequestMethod.POST)
    @ResponseBody
    public Object sendWorkList (HttpServletRequest request, WorkList workList){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "无效的编号");
            map.put("msg2", "文字描述字数太少");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Invalid number");
            map.put("msg2", "Too few descriptive words");
        }
        if (null == workList.getOrderNum() || StringUtils.isBlank(workList.getOrderNum())) {
            result.setCode(ResultCode.CODE_ERROR_17);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == workList.getDesc() || StringUtils.isBlank(workList.getDesc())) {
            result.setCode(ResultCode.CODE_ERROR_17);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("coinType", workList.getCoinType());
        hashMap.put("workListType", workList.getWorkListType());
        hashMap.put("orderNum", workList.getOrderNum());
        hashMap.put("desc", workList.getDesc());
        hashMap.put("img1", workList.getImg1());
        hashMap.put("img2", workList.getImg2());
        hashMap.put("img3", workList.getImg3());

        String json = workListService.sendWorkList(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/6/1 19:36
     * @Param [request, workId:工单ID, context:内容]
     * @Desc 回复工单
     */
    @RequestMapping(value = "/replyWorkList",method = RequestMethod.POST)
    @ResponseBody
    public Object replyWorkList (HttpServletRequest request, @RequestParam String workId,@RequestParam String context){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("workId", workId);
        hashMap.put("context", context);
        String json = workListService.replyWorkList(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }

}
