package com.gmebtc.web.portal.result;

import java.io.Serializable;

public class ResultCode {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR_1 = -1;               //用户名或密码错误
    public static final int CODE_ERROR_2 = -2;                      // 密码为空
    public static final int CODE_ERROR_3 = -3;                       //资金密码为空
    public static final int CODE_ERROR_4 = -4;                             //邮箱格式错误
    public static final int CODE_ERROR_5= -5;                                  //提币地址为空
    public static final int CODE_ERROR_6 =-6;                                      //验证码失效
    public static final int CODE_ERROR_7 =-7;                     //验证码错误
    public static final int CODE_ERROR_8=-8;                     //原密码错误
    public static final int CODE_ERROR_9 =-9;                     //手机号为空
    public static final int CODE_ERROR_10 =-10;                     //邮箱为空
    public static final int CODE_ERROR_11 =-11;                     //手机验证码为空
    public static final int CODE_ERROR_12 =-12;                     //手机绑定失败
    public static final int CODE_ERROR_13 =-13;                     //手机号格式错误
    public static final int CODE_ERROR_14 =-14;                     //邮箱或者手机号为空
    public static final int CODE_ERROR_15 =-15;                     //验证码类型为空
    public static final int CODE_ERROR_16 =-16;                     //提币数量不能为空
    public static final int CODE_ERROR_17 =-17;                     //为空代码


    public static final int CODE_ERROR = -1000;               //其他错误
    public static final int CODE_ERROR_UN_LOGIN=-99;          //未登录

}
