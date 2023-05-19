package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DCZhang
 * @title PayServiceFactory
 * @date 2023/5/16 10:43
 * @description TODO
 */
@Service
public class ChannelPayServiceFactory {

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelService> PAY_SERVICE_MAP = new HashMap<>();

    ChannelPayServiceFactory(List<AbstractChannelService> payServiceList) {
        if (CollectionUtil.isNotEmpty(payServiceList)) {
            payServiceList.forEach(payService -> {
                PAY_SERVICE_MAP.put(payService.getPayType(), payService);
            });
        }
    }

    public AbstractChannelService getPayService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelService payService = PAY_SERVICE_MAP.get(payTypeEnums);
        Assert.notNull(payService, "支付类型不存在");
        return payService;
    }
}
