package com.thgold.thgplatform.bank.payment.bo;

import lombok.Data;

/**
 * 商户支付产品配置信息
 */
@Data
public class MerchantProductConfig {
    /**
     * 商户ID/用户ID
     */
    private Long accountId;
    /**
     * 账号名称
     */
    private String accountName;
    /**
     * 支付产品ID
     */
    private Long productId;
    /**
     * 支付产品类型;WXPAY:微信支付;ALIPAY:支付宝;GOLDPAY:金付宝
     */
    private String productType;
    /**
     * 支付产品服务标识;WXPAY_MINIMP:微信小程序;GOLDPAY_H5:金付宝H5;GOLDPAY_MINIMP:金付宝小程序;GOLDPAY_APP:金付宝APP;
     */
    private String productServiceId;

    /**
     * APPID
     */
    private String appId;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 证书密码
     */
    private String credentialPass;
    /**
     * 证书地址
     */
    private String credentialPath;
    /**
     * 签名类型
     */
    private String signType;
}
