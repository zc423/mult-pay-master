package com.thgold.thgplatform.bank.payment.constant;

public enum ProductServiceEnum {
    WXPAY_MINIMP("微信小程序");
    private final String desc;

    public String getDesc() {
        return this.desc;
    }

    private ProductServiceEnum(String desc) {
        this.desc = desc;
    }
}
