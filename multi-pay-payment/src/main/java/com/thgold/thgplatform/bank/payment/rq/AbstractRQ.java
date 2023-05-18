package com.thgold.thgplatform.bank.payment.rq;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author DCZhang
 * @title AbstractRQ
 * @date 2023/5/17 14:13
 * @description 请求参数基类
 */
@Data
public class AbstractRQ {

    /** 接口请求时间 **/
    @NotBlank(message="时间戳不能为空")
    protected String reqTime;
}
