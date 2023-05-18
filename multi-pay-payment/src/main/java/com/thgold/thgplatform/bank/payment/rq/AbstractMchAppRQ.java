package com.thgold.thgplatform.bank.payment.rq;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author DCZhang
 * @title MerchantRQ
 * @date 2023/5/17 14:14
 * @description TODO
 */
@Data
public class AbstractMchAppRQ extends AbstractRQ {

    /** 商户号 **/
    @NotBlank(message="商户号不能为空")
    private String mchNo;

    /** 商户应用ID **/
    @NotBlank(message="商户应用ID不能为空")
    private String appId;

}
