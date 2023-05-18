package com.thgold.thgplatform.bank.payment.channel;

import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import com.thgold.thgplatform.bank.payment.constant.ProductServiceEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IChannelRefundNoticeService {
    /**
     * 退款结果同步调用
     * 看需求在子类中进行重写
     */
    Result sync(PayOrder businessOrder);
    /**
     * 支付结果异步调用
     * 子类实现可以调用sync进行实现
     */
    Result async(HttpServletRequest request, HttpServletResponse response);
    /**
     * 支付参数校验
     * @return
     */
    Boolean preCheckParams(PayOrder order);
    /**
     * 支付类型
     * @return
     */
    ConstantEnum.PayServiceTypeEnum getPayType();


}
