package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelRefundService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DCZhang
 * @title ChannelRefundServiceFactory
 * @date 2023/5/16 16:37
 * @description TODO
 */
@Service
public class ChannelRefundServiceFactory {
    @Autowired
    private static List<AbstractChannelRefundService> REFUND_SERVICE_LIST;

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelRefundService> REFUND_SERVICE_MAP = new HashMap<>();

    static {
        if (CollectionUtil.isNotEmpty(REFUND_SERVICE_LIST)) {
            REFUND_SERVICE_LIST.forEach(refundService -> {
                REFUND_SERVICE_MAP.put(refundService.getPayType(), refundService);
            });
        }
    }

    public AbstractChannelRefundService getRefundService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelRefundService refundService = REFUND_SERVICE_MAP.get(payTypeEnums);
        Assert.notNull(refundService, "支付类型不存在");
        return refundService;
    }
}
