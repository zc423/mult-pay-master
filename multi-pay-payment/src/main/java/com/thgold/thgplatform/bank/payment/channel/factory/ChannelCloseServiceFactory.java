package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelCloseService;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelRefundService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DCZhang
 * @title ChannelCloseServiceFactory
 * @date 2023/5/19 17:17
 * @description TODO
 */
@Service
public class ChannelCloseServiceFactory {

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelCloseService> CLOSE_SERVICE_MAP = new HashMap<>();

    ChannelCloseServiceFactory(List<AbstractChannelCloseService> closeServiceList) {
        if (CollectionUtil.isNotEmpty(closeServiceList)) {
            closeServiceList.forEach(closeService -> {
                CLOSE_SERVICE_MAP.put(closeService.getPayType(), closeService);
            });
        }
    }

    public AbstractChannelCloseService getCloseService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelCloseService refundService = CLOSE_SERVICE_MAP.get(payTypeEnums);
        Assert.notNull(refundService, "支付类型不存在");
        return refundService;
    }
}
