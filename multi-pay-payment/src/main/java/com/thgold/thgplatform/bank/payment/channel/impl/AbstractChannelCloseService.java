package com.thgold.thgplatform.bank.payment.channel.impl;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.IChannelCloseService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DCZhang
 * @title AbstractChannelCloseService
 * @date 2023/5/19 17:17
 * @description TODO
 */
@Slf4j
public abstract class AbstractChannelCloseService implements IChannelCloseService {
    /**
     * 实际需要调用支付接口
     *
     * @return
     */
    public Result callClose(MerchantProductConfig merchant, PayOrder payOrder) {
        log.info("支付接口调用,商户:{},订单:{}", merchant, payOrder);
        preCheckParams(merchant, payOrder);
        return close(merchant, payOrder);
    }
}
