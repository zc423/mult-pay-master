package com.thgold.thgplatform.bank.payment.channel.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelUnifiedService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DCZhang
 * @title ChannelUnifiedServiceFactory
 * @date 2023/5/18 14:36
 * @description TODO
 */
@Service
public class ChannelUnifiedServiceFactory {
    @Autowired
    private static List<AbstractChannelUnifiedService> UNIFIED_SERVICE_LIST;

    private static Map<ConstantEnum.PayServiceTypeEnum, AbstractChannelUnifiedService> REFUND_SERVICE_MAP = new HashMap<>();

    static {
        if (CollectionUtil.isNotEmpty(UNIFIED_SERVICE_LIST)) {
            UNIFIED_SERVICE_LIST.forEach(unifiedService -> {
                REFUND_SERVICE_MAP.put(unifiedService.getPayType(), unifiedService);
            });
        }
    }

    public AbstractChannelUnifiedService getUnifiedService(ConstantEnum.PayServiceTypeEnum payTypeEnums) {
        AbstractChannelUnifiedService unifiedService = REFUND_SERVICE_MAP.get(payTypeEnums);
        Assert.notNull(unifiedService, "支付类型不存在");
        return unifiedService;
    }

}
