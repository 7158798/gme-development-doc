package com.gmebtc.web.portal.entity;

import java.io.Serializable;

public class Coin implements Serializable{
    /* 币种类型*/
    private String coinType;
    /* 提币编号*/
    private String withdrawId;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(String withdrawId) {
        this.withdrawId = withdrawId;
    }
}
