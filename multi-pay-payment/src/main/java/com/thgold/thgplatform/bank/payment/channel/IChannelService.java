package com.thgold.thgplatform.bank.payment.channel;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;

/**
 * 支付接口 实际使用继承AbstractPayService  @see AbstractPayService
 */
public interface IChannelService {
    /**
     * 支付
     * @return
     */
    Result pay(MerchantProductConfig merchant, PayOrder payOrder);

    /**
     * 支付参数校验
     * @return
     */
    Boolean preCheckParams(MerchantProductConfig merchant, PayOrder payOrder);

    /**
     * 支付类型
     * @return
     */
    ConstantEnum.PayServiceTypeEnum getPayType();

}
