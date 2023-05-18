package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelRefundNoticeService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import com.thgold.thgplatform.bank.payment.constant.ProductServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author DCZhang
 * @title ChannelRefundNoticeServiceFactoey
 * @date 2023/5/16 16:05
 * @description TODO
 */
@Service
public class ChannelRefundNoticeServiceFactory {
    @Autowired
    private static List<AbstractChannelRefundNoticeService> REFUND_SERVICE_LIST;

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelRefundNoticeService> REFUND_SERVICE_MAP = new HashMap<>();

    static {
        if (CollectionUtil.isNotEmpty(REFUND_SERVICE_LIST)) {
            REFUND_SERVICE_LIST.forEach(refundService -> {
                REFUND_SERVICE_MAP.put(refundService.getPayType(), refundService);
            });
        }

    }

    public AbstractChannelRefundNoticeService getRefundNoticeService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelRefundNoticeService refundService = REFUND_SERVICE_MAP.get(payTypeEnums);
        return refundService;
    }
}
