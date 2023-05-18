//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.thgold.thgplatform.bank.payment.exception;


import com.thgold.thgplatform.bank.payment.constant.SystemErrorEnum;

public class BizException extends RuntimeException {
    private Integer code;

    public BizException(String message) {
        super(message);
        this.code = SystemErrorEnum.SYS_ERROR.getCode();
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BizException(SystemErrorEnum systemError) {
        super(systemError.getMessage());
        this.code = systemError.getCode();
    }

    public BizException(String message, Exception e) {
        super(message, e);
        this.code = SystemErrorEnum.FAILED.getCode();
    }

    public BizException() {
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
