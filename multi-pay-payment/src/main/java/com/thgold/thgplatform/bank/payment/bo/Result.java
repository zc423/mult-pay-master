package com.thgold.thgplatform.bank.payment.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author DCZhang
 * @title Result
 * @date 2023/5/16 9:24
 * @description 操作返回结果
 */
@Data
@Accessors(chain = true)
public class Result {

    /**
     * 是否通过
     */
    private Boolean success;

    /**
     * 备注
     */
    private String remark;

    /**
     * 通过
     * @return
     */
    public static Result success() {
        Result result = new Result().setSuccess(true);
        return result;
    }
    /**
     * 失败
     */
    public static Result fail() {
        Result result = new Result().setSuccess(false);
        return result;
    }
}
