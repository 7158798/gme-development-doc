package com.gmebtc.web.portal.entity;

public class UploadIDCard {
    /* 姓名*/
    private String name;
    /* 证件类型（1，身份证，2，护照，3，军官证，4，台湾居民通行证，2港澳居民通行证）*/
    private String cardType;
    /* 证件号码*/
    private String cardNumber;
    /* 正面*/
    private String faceImgId;
    /* 反面*/
    private String backImgId;
    /* 手持*/
    private String handImgId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFaceImgId() {
        return faceImgId;
    }

    public void setFaceImgId(String faceImgId) {
        this.faceImgId = faceImgId;
    }

    public String getBackImgId() {
        return backImgId;
    }

    public void setBackImgId(String backImgId) {
        this.backImgId = backImgId;
    }

    public String getHandImgId() {
        return handImgId;
    }

    public void setHandImgId(String handImgId) {
        this.handImgId = handImgId;
    }
}
