package com.thgold.thgplatform.bank.payment.service;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DCZhang
 * @title PayService
 * @date 2023/5/16 10:47
 * @description 实际调用接口
 */
public interface PaymentService {
    /**
     * 创建订单
     */
    void createOrder(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums);
    /**
     * 支付
     *
     * @return
     */
    Result pay(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums);

    /**
     * 支付结果异步调用
     */
    void asyncPay(HttpServletRequest request, HttpServletResponse response, ConstantEnum.PayServiceTypeEnum payTypeEnums);

    /**
     * 支付结果同步调用(内部调用,正金通支付完成调用)
     */
    Result syncPay(PayOrder businessOrder);

    /**
     * 退款回调
     */
    void asyncRefund(HttpServletRequest request, HttpServletResponse response, ConstantEnum.PayServiceTypeEnum payTypeEnums);

    /**
     * 退款申请
     */
     void syncRefund(MerchantProductConfig merchant, PayOrder payOrder, ConstantEnum.PayServiceTypeEnum payTypeEnums);

    /**
     * 关闭渠道订单
     */
    void close(PayOrder businessOrder);


}
