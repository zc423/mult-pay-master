package com.thgold.thgplatform.bank.payment.event.listener;

import com.thgold.thgplatform.bank.payment.config.ExecuteLog;
import com.thgold.thgplatform.bank.payment.event.event.NoticeEvent;
import com.thgold.thgplatform.bank.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author DCZhang
 * @title NoticeEventListener
 * @date 2023/5/19 9:07
 * @description TODO
 */
@Component
@Slf4j
@AllArgsConstructor
public class NoticeEventListener {

    private PaymentService paymentService;

    @ExecuteLog
    @EventListener
    public void execute(NoticeEvent event) {
        log.info("{}:收到事件通知:{}", new Object().getClass().getEnclosingMethod().getName(), event);
        paymentService.syncPay(event.getPayOrder());
    }

}
