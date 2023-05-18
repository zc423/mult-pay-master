package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelNoticeService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import com.thgold.thgplatform.bank.payment.constant.ProductServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private static List<AbstractChannelNoticeService> PAY_SERVICE_LIST;

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelNoticeService> PAY_SERVICE_MAP = new HashMap<>();

    static {
        if (CollectionUtil.isNotEmpty(PAY_SERVICE_LIST)) {
            PAY_SERVICE_LIST.forEach(payService -> {
                PAY_SERVICE_MAP.put(payService.getPayType(), payService);
            });
        }
    }

    public AbstractChannelNoticeService getNoticeService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelNoticeService payService = PAY_SERVICE_MAP.get(payTypeEnums);
        return payService;
    }

}
