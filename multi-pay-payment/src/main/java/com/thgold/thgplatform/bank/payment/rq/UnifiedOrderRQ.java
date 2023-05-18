package com.thgold.thgplatform.bank.payment.rq;

import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import com.thgold.thgplatform.bank.payment.constant.ProductServiceEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author DCZhang
 * @title UnifiedOrderRQ
 * @date 2023/5/17 14:16
 * @description 创建订单请求参数
 */
@Data
public class UnifiedOrderRQ extends AbstractMchAppRQ {

    /**
     * 商户订单号
     **/
    @NotBlank(message = "商户订单号不能为空")
    private String mchOrderNo;

    /**
     * 支付方式
     **/
    @NotBlank(message = "支付方式不能为空")
    private ConstantEnum.PayServiceTypeEnum wayCode;

    /**
     * 支付金额， 单位：分
     **/
    @NotNull(message = "支付金额不能为空")
    @Min(value = 1, message = "支付金额不能为空")
    private Long amount;

    /**
     * 货币代码
     **/
    @NotBlank(message = "货币代码不能为空")
    private String currency;

    /**
     * 客户端IP地址
     **/
    private String clientIp;

    /**
     * 商品标题
     **/
    @NotBlank(message = "商品标题不能为空")
    private String subject;

    /**
     * 商品描述信息
     **/
    @NotBlank(message = "商品描述信息不能为空")
    private String body;

    /**
     * 特定渠道发起额外参数
     **/
    private String channelExtra;

    /**
     * 商户扩展参数
     **/
    private String extParam;
}
