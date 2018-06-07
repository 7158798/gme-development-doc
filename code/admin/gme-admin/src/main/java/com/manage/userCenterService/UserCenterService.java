package com.manage.userCenterService;


import com.manage.base.util.Md5;
import com.manage.sysConfig.SysConfig;

import net.sf.json.JSONObject;

public  class UserCenterService {

	public static JSONObject getRuid(String userCenterId){
		String tid = "2";
		String key = "adf!@#$BNXZGD!.12";
		String sign =  Md5.md5(tid+userCenterId+key);
		String url = SysConfig.getConfig().getUserCenterAPI()+"getRuid.html?tid="+tid+"&uid="+userCenterId+"&sign="+sign;
		JSONObject result = HttpRequestUtils.httpPost(url, null);
		return result;
	}
	 
}
