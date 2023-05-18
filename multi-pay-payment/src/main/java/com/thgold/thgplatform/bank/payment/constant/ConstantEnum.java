package com.thgold.thgplatform.bank.payment.constant;

/**
 * @author DCZhang
 * @title ConstantEnum
 * @date 2023/5/18 10:42
 * @description TODO
 */
public class ConstantEnum {
    public enum PayServiceTypeEnum {
        WX_MINI_MP_V2("微信小程序"),
        WX_MINI_MP_V3("微信小程序3");
        private final String desc;

        public String getDesc() {
            return this.desc;
        }

        private PayServiceTypeEnum(String desc) {
            this.desc = desc;
        }
    }


    public enum VxServiceEnum {
        V2("微信小程序V2"),
        V3("微信小程序V3");
        private final String desc;

        public String getDesc() {
            return this.desc;
        }

        private VxServiceEnum(String desc) {
            this.desc = desc;
        }
    }




}
