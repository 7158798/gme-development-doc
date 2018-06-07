package com.gmebtc.web.portal.entity;

public class BindPhone {
    /* 收款码图片*/
    private String alipayImg;
    /* 1，支付宝，2，微信*/
    private String type;
    /* 账号*/
    private String account;
    /* 备注*/
    private String remark;
    /* 资金密码*/
    private String payPassword;

    public String getAlipayImg() {
        return alipayImg;
    }

    public void setAlipayImg(String alipayImg) {
        this.alipayImg = alipayImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
