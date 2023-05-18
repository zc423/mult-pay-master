package com.thgold.thgplatform.bank.payment.channel.impl;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.IChannelService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DCZhang
 * @title AbstractPayService
 * @date 2023/5/16 10:30
 * @description 实际继承
 */
@Slf4j
public abstract class AbstractChannelService implements IChannelService {
    /**
     * 实际需要调用支付接口
     *
     * @return
     */
    public Result callPay(MerchantProductConfig merchant, PayOrder payOrder) {
        log.info("支付接口调用,商户:{},订单:{}", merchant, payOrder);
        preCheckParams(merchant, payOrder);
        return pay(merchant, payOrder);
    }

}
