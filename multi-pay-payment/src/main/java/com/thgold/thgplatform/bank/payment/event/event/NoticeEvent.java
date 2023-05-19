package com.thgold.thgplatform.bank.payment.event.event;

import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author DCZhang
 * @title Notice
 * @date 2023/5/19 9:05
 * @description TODO
 */
@Data
public class NoticeEvent {
//    @NotNull
    private PayOrder payOrder;

    public static void main(String[] args) {
    }
}
