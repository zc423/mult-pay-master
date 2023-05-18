package com.thgold.thgplatform.bank.payment.service.impl;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.factory.*;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import com.thgold.thgplatform.bank.payment.constant.ProductServiceEnum;
import com.thgold.thgplatform.bank.payment.rq.UnifiedOrderRQ;
import com.thgold.thgplatform.bank.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author DCZhang
 * @title PaymentServiceImpl
 * @date 2023/5/16 10:51
 * @description TODO
 */
@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private ChannelPayServiceFactory channelPayServiceFactory;
    private ChannelNoticeServiceFactory channelNoticeServiceFactory;
    private ChannelRefundServiceFactory channelRefundServiceFactory;
    private ChannelRefundNoticeServiceFactory channelRefundNoticeServiceFactory;
    private ChannelUnifiedServiceFactory channelUnifiedServiceFactory;


    /**
     * 创建订单
     */
    @Override
    public void createOrder(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        // 调用统一下单
        channelUnifiedServiceFactory.getUnifiedService(payTypeEnums).callUnified(merchant, payOrder);
    }

    /**
     * 支付
     *
     * @param merchant
     * @param payOrder
     * @param payTypeEnums
     * @return
     */
    @Override
    public Result pay(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        return channelPayServiceFactory.getPayService(payTypeEnums).callPay(merchant, payOrder);
    }

    /**
     * 支付结果异步调用
     */
    @Override
    public void asyncPay(HttpServletRequest request, HttpServletResponse response, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        channelNoticeServiceFactory.getNoticeService(payTypeEnums).asyncNotice(request, response);
    }

    /**
     * 支付结果同步调用
     */
    @Override
    public Result syncPay(PayOrder businessOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        Result notice = channelNoticeServiceFactory.getNoticeService(payTypeEnums).syncNotice(businessOrder);
        return notice;
    }

    /**
     * 退款回调
     */
    @Override
    public void asyncRefund(HttpServletRequest request, HttpServletResponse response, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        channelRefundNoticeServiceFactory.getRefundNoticeService(payTypeEnums).asyncNotice(request, response);
    }

    /**
     * 退款调用
     */
    @Override
    public void syncRefund(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        channelRefundServiceFactory.getRefundService(payTypeEnums).callRefund(merchant, payOrder);
    }

    /**
     * 关闭渠道订单
     */
    @Override
    public void close(PayOrder businessOrder) {

    }
}
