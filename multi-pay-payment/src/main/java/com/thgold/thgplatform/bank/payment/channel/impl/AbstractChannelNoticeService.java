package com.thgold.thgplatform.bank.payment.channel.impl;

import cn.hutool.core.util.ObjectUtil;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.IChannelNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DCZhang
 * @title AbstractChannelNoticeService
 * @date 2023/5/16 13:44
 * @description TODO
 */
@Slf4j
public abstract class AbstractChannelNoticeService implements IChannelNoticeService {

    public Result syncNotice(PayOrder businessOrder) {
        log.info("支付结果通知,开始处理业务订单:{}", businessOrder);
        preCheckParams(businessOrder);
        Result sync = sync(businessOrder);
        return sync;
    }

    public Result asyncNotice(HttpServletRequest request, HttpServletResponse response) {
        log.info("支付结果通知,开始处理业务订单:{}", request);
        return async(request, response);
    }

    /**
     * 对支付结果进行操作,子类根据情况进行重写
     * @param businessOrder
     * @return
     */
    @Override
    public Result sync(PayOrder businessOrder) {
        // todo  实现支付完成后的业务逻辑
        return null;
    }

    /**
     * 支付参数校验
     *
     * @param order
     * @return
     */
    @Override
    public void preCheckParams(PayOrder order) {
        if (ObjectUtil.isEmpty(order)){
            throw new RuntimeException("支付订单不能为空");
        } else if (ObjectUtil.isEmpty(order.getId())){
            throw new RuntimeException("支付订单id不能为空");
        }
    }
}
