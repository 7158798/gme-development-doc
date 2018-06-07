package com.gmebtc.web.portal.controller;

import com.gmebtc.web.portal.entity.BindCard;
import com.gmebtc.web.portal.entity.BindPhone;
import com.gmebtc.web.portal.entity.UploadIDCard;
import com.gmebtc.web.portal.result.GlobalResult;
import com.gmebtc.web.portal.result.ResultCode;
import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.utils.StringUtil;
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
 * @Date 2018/5/30 18:06
 * @Desc 安全中心
 */
@Controller
@RequestMapping("${ROOT_PATH}/user")
public class SecurityCenterController {

    @Resource(name = "securityConterService")
    private SecurityConterService securityConterService;


    /**
     * @Author zhou
     * @Date 2018/5/30 18:27
     * @Param [request, oldPassword, newPassword, checkCode:图片验证码]
     * @Desc 修改登录密码
     */
    @RequestMapping(value = "/modifyLoginPwd", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyLoginPwd(HttpServletRequest request, @RequestParam String oldPassword
            , @RequestParam String newPassword, @RequestParam String checkCode) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "旧密码不能为空");
            map.put("msg2", "新密码不能为空");
            map.put("msg3", "图像验证码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Old passwords cannot be empty");
            map.put("msg2", "New passwords cannot be empty");
            map.put("msg3", "Image verification code can not be empty");
        }

        if (null == oldPassword || StringUtils.isBlank(oldPassword)) {
            result.setCode(ResultCode.CODE_ERROR_17);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == newPassword || StringUtils.isBlank(newPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == checkCode || StringUtils.isBlank(checkCode)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("oldPassword", oldPassword);
        hashMap.put("newPassword", newPassword);
        hashMap.put("checkCode", checkCode);

        String json = securityConterService.modifyLoginPwd(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 18:59
     * @Param [request, newPassword, idCard, checkCode]
     * @Desc 修改资金密码
     */
    @RequestMapping(value = "/resetPayPassword", method = RequestMethod.POST)
    @ResponseBody
    public Object resetPayPassword(HttpServletRequest request, @RequestParam String newPassword
            , @RequestParam String idCard, @RequestParam String checkCode) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "新密码不能为空");
            map.put("msg2", "身份证信息不能为空");
            map.put("msg3", "图像验证码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "New passwords cannot be empty");
            map.put("msg2", "Id information cannot be empty");
            map.put("msg3", "Image verification code can not be empty");
        }
        if (null == newPassword || StringUtils.isBlank(newPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == idCard || StringUtils.isBlank(idCard)) {
            result.setCode(ResultCode.CODE_ERROR_17);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == checkCode || StringUtils.isBlank(checkCode)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("newPassword", newPassword);
        hashMap.put("idCard", idCard);
        hashMap.put("checkCode", checkCode);
        String json = securityConterService.resetPayPassword(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:01
     * @Param [request, email]
     * @Desc 发送邮件
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public Object sendEmail(HttpServletRequest request, @RequestParam String email) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱格式错误");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Email format error");
        }
        if (null == email || StringUtils.isBlank(email) || !Toolkits.isEmail(email)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", email);

        String json = securityConterService.sendEmail(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:22
     * @Param [request, uploadIdCard]
     * @Desc 实名认证
     */
    @RequestMapping(value = "/identifyAuth", method = RequestMethod.POST)
    @ResponseBody
    public Object identifyAuth(HttpServletRequest request, UploadIDCard uploadIdCard) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "姓名必填");
            map.put("msg2", "证件号码不能为空");
            map.put("msg3", "请上传证件正面照");
            map.put("msg4", "请上传证件反面照");
            map.put("msg4", "请上传手持证件照");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The name cannot be empty");
            map.put("msg2", "The id number should not be blank");
            map.put("msg3", "Please upload the certificate to the front");
            map.put("msg4", "Please upload the certificate in the opposite direction");
            map.put("msg4", "Please upload a handheld certificate");
        }
        if (null == uploadIdCard.getName() || StringUtils.isBlank(uploadIdCard.getName())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == uploadIdCard.getCardNumber() || StringUtils.isBlank(uploadIdCard.getCardNumber())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == uploadIdCard.getFaceImgId() || StringUtils.isBlank(uploadIdCard.getFaceImgId())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == uploadIdCard.getBackImgId() || StringUtils.isBlank(uploadIdCard.getBackImgId())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (null == uploadIdCard.getHandImgId() || StringUtils.isBlank(uploadIdCard.getHandImgId())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }


        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", uploadIdCard.getName());
        hashMap.put("cardType", uploadIdCard.getCardType());
        hashMap.put("cardNumber", uploadIdCard.getCardNumber());
        hashMap.put("faceImgId", uploadIdCard.getFaceImgId());
        hashMap.put("backImgId", uploadIdCard.getBackImgId());
        hashMap.put("handImgId", uploadIdCard.getHandImgId());
        String json = securityConterService.identifyAuth(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:26
     * @Param [request]
     * @Desc 检验是否实名认证
     */
    @RequestMapping(value = "/checkHasIdentify", method = RequestMethod.POST)
    @ResponseBody
    public Object checkHasIdentify(HttpServletRequest request) {
        String json = securityConterService.checkHasIdentify(request);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:40
     * @Param [request, bindCard:银行卡信息]
     * @Desc 绑定银行卡
     */
    @RequestMapping(value = "/payMethedBank", method = RequestMethod.POST)
    @ResponseBody
    public Object payMethedBank (HttpServletRequest request, BindCard bindCard){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "姓名必填");
            map.put("msg2", "开户行不能为空");
            map.put("msg3", "支行不能为空");
            map.put("msg4", "银行卡号不能为空");
            map.put("msg4", "资金密码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The name cannot be empty");
            map.put("msg2", "The opening bank cannot be empty");
            map.put("msg3", "Branches cannot be empty");
            map.put("msg4", "The bank card number cannot be empty");
            map.put("msg4", "Capital cipher can not be empty");

        }
        if (null == bindCard.getName() || StringUtils.isBlank(bindCard.getName())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == bindCard.getBank() || StringUtils.isBlank(bindCard.getBank())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == bindCard.getBranch() || StringUtils.isBlank(bindCard.getBranch())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == bindCard.getBankCard() || StringUtils.isBlank(bindCard.getBankCard())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (null == bindCard.getPayPassword() || StringUtils.isBlank(bindCard.getPayPassword())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", bindCard.getName());
        hashMap.put("bank", bindCard.getBank());
        hashMap.put("branch", bindCard.getBranch());
        hashMap.put("bankCard", bindCard.getBankCard());
        hashMap.put("payPassword", bindCard.getPayPassword());
        String json = securityConterService.payMethedBank(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 20:54
     * @Param [request, bindPhone:支付宝或者微信信息]
     * @Desc 绑定支付宝或者微信
     */
    @RequestMapping(value = "/payMethedAlipayWeChat",method = RequestMethod.POST)
    @ResponseBody
    public Object payMethedAlipayWeChat (HttpServletRequest request, BindPhone bindPhone){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "请上传收款码图片");
            map.put("msg2", "账号不能为空");
            map.put("msg3", "资金密码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The name cannot be empty");
            map.put("msg2", "The account cannot be empty");
            map.put("msg3", "Capital cipher can not be empty");
        }

        if (null == bindPhone.getAlipayImg() || StringUtils.isBlank(bindPhone.getAlipayImg())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == bindPhone.getAccount() || StringUtils.isBlank(bindPhone.getAccount())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == bindPhone.getPayPassword() || StringUtils.isBlank(bindPhone.getPayPassword())) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("alipayImg", bindPhone.getAlipayImg());
        hashMap.put("type", bindPhone.getType());
        hashMap.put("account", bindPhone.getAccount());
        hashMap.put("remark", bindPhone.getRemark());
        hashMap.put("payPassword", bindPhone.getPayPassword());
        String json = securityConterService.payMethedAlipayWeChat(request, hashMap);
        return Toolkits.messageTransformation(request, json);
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 21:05
     * @Param [request, userName:手机或者邮箱, imgCode:图像验证码]
     * @Desc 检查用户是否存在
     */
    @RequestMapping(value = "/checkUserExsit",method = RequestMethod.POST)
    @ResponseBody
    public Object checkUserExsit (HttpServletRequest request,@RequestParam String userName,@RequestParam String imgCode){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "请输入邮箱或手机号");
            map.put("msg2", "图像验证码不能为空");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Please enter your email or phone number");
            map.put("msg2", "Image verification code can not be empty");
        }

        if (null == userName || StringUtils.isBlank(userName)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == imgCode || StringUtils.isBlank(imgCode)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("userName", userName);
        hashMap.put("imgCode", imgCode);
        String json = securityConterService.checkUserExsit(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/30 21:18
     * @Param [request, phone, countryCode, phoneCode, payPassword]
     * @Desc 绑定手机号
     */
    @RequestMapping(value = "/bindPhone",method = RequestMethod.POST)
    @ResponseBody
    public Object bindPhone (HttpServletRequest request,@RequestParam String phone
                            ,@RequestParam String countryCode,@RequestParam String phoneCode,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "手机号不能为空");
            map.put("msg2", "手机号格式不正确");
            map.put("msg3", "手机验证码不能为空");
            map.put("msg4", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Cell phone number can not be empty");
            map.put("msg2", "The format of the phone number is not correct");
            map.put("msg3", "Cell phone verification code can not be empty");
            map.put("msg4", "Capital cipher can not be empty");
        }

        if (null == phone || StringUtils.isBlank(phone)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isPhone(phone)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == phoneCode || StringUtils.isBlank(phoneCode)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("phone", phone);
        hashMap.put("countryCode", countryCode);
        hashMap.put("phoneCode", phoneCode);
        hashMap.put("payPassword", payPassword);
        String json = securityConterService.bindPhone(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/30 21:27
     * @Param [request, email, emailCode, payPassword]
     * @Desc 绑定邮箱
     */
    @RequestMapping(value = "/bindEmail",method = RequestMethod.POST)
    @ResponseBody
    public Object bindEmail (HttpServletRequest request,@RequestParam String email
                            ,@RequestParam String emailCode,@RequestParam String payPassword){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        GlobalResult result = new GlobalResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱不能为空");
            map.put("msg2", "邮箱号格式不正确");
            map.put("msg3", "邮箱验证码不能为空");
            map.put("msg4", "资金密码不能为空");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Mailbox cannot be empty");
            map.put("msg2", "Incorrect mailbox format");
            map.put("msg3", "Mailbox verification code can not be empty");
            map.put("msg4", "Capital cipher can not be empty");
        }

        if (null == email || StringUtils.isBlank(email)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(email)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == emailCode || StringUtils.isBlank(emailCode)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == payPassword || StringUtils.isBlank(payPassword)) {
            result.setCode(ResultCode.CODE_ERROR_3);
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", email);
        hashMap.put("emailCode", emailCode);
        hashMap.put("payPassword", payPassword);
        String json = securityConterService.bindEmail(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }



    /**
     * @Author zhou
     * @Date 2018/5/31 20:55
     * @Param [request, uid, email, nonce:时间, token:加密结果]
     * @Desc 邮箱激活验证
     */
    @RequestMapping(value = "/emailActiveCheck",method = RequestMethod.POST)
    @ResponseBody
    public Object emailActiveCheck (HttpServletRequest request, @RequestParam String uid, @RequestParam String email
                                    , @RequestParam String nonce,@RequestParam String token){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", uid);
        hashMap.put("email", email);
        hashMap.put("nonce", nonce);
        hashMap.put("token", token);
        String json = securityConterService.emailActiveCheck(request,hashMap);
        return Toolkits.messageTransformation(request, json);
    }

}
