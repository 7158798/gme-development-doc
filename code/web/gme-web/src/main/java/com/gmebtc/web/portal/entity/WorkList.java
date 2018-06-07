package com.gmebtc.web.portal.entity;

public class WorkList {
    /* 币种*/
    private String coinType;
    /* 工单类型（1充值，2提现，3申诉，4，仲裁，5其他）*/
    private String workListType;
    /* 充值或者提现编号*/
    private String orderNum;
    /* 描述*/
    private String desc;
    /* 图片1*/
    private String img1;
    /* 图片2*/
    private String img2;
    /* 图片3*/
    private String img3;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getWorkListType() {
        return workListType;
    }

    public void setWorkListType(String workListType) {
        this.workListType = workListType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
