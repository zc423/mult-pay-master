package com.thgold.thgplatform.bank.payment.channel.impl;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.IChannelRefundService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DCZhang
 * @title AbstractChannelRefundService
 * @date 2023/5/16 16:15
 * @description TODO
 */
@Slf4j
public abstract class AbstractChannelRefundService implements IChannelRefundService {
    /**
     * 退款请求
     *
     * @return Result
     */
    public Result callRefund(MerchantProductConfig merchant, PayOrder payOrder) {
        log.info("支付接口调用,商户:{},订单:{}", merchant, payOrder);
        preCheckParams(merchant, payOrder);
        return refund(merchant, payOrder);
    }
}
