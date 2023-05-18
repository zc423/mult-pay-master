package com.thgold.thgplatform.bank.payment.channel.impl;

import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.IChannelRefundNoticeService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DCZhang
 * @title AbstractChannelRefundNoticeService
 * @date 2023/5/16 14:59
 * @description 退款回调接口实现
 */
@Slf4j
public abstract class AbstractChannelRefundNoticeService implements IChannelRefundNoticeService {

    public Result syncNotice(PayOrder businessOrder) {
        log.info("退款结果通知,开始处理业务订单:{}", businessOrder);
        preCheckParams(businessOrder);
        Result sync = sync(businessOrder);
        return sync;
    }

    public Result asyncNotice(HttpServletRequest request, HttpServletResponse response) {
        log.info("退款结果通知,开始处理业务订单:{}", request);
        return async(request, response);
    }

    /**
     * 对退款结果进行操作,子类根据情况进行重写
     * @param businessOrder
     * @return
     */
    @Override
    public Result sync(PayOrder businessOrder) {
        // todo  实现退款完成后的业务逻辑
        return null;
    }
}
