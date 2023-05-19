package com.thgold.thgplatform.bank.payment.channel;


import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;

/**
 * 统一下单接口
 */
public interface IChannelCloseService {
    /**
     * 统一下单
     * @return
     */
    Result close(MerchantProductConfig merchant, PayOrder payOrder);

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
