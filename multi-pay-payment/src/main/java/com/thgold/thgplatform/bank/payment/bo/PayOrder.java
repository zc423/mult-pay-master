package com.thgold.thgplatform.bank.payment.bo;

import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author DCZhang
 * @title Order
 * @date 2023/5/16 9:23
 * @description TODO
 */
@Data
@Accessors(chain = true)
public class PayOrder {
    private Long id;

    private ConstantEnum.PayServiceTypeEnum payTypeEnums;
}
