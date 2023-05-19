package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelNoticeService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DCZhang
 * @title ChannelNoticeServiceFactory
 * @date 2023/5/16 13:47
 * @description TODO
 */
@Service
public class ChannelNoticeServiceFactory {

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelNoticeService> PAY_SERVICE_MAP = new HashMap<>();

    ChannelNoticeServiceFactory(List<AbstractChannelNoticeService> payServiceList) {
        if (CollectionUtil.isNotEmpty(payServiceList)) {
            payServiceList.forEach(payService -> {
                PAY_SERVICE_MAP.put(payService.getPayType(), payService);
            });
        }
    }

    public AbstractChannelNoticeService getNoticeService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelNoticeService payService = PAY_SERVICE_MAP.get(payTypeEnums);
        return payService;
    }

}
