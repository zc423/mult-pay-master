package com.thgold.thgplatform.bank.payment.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author DCZhang
 * @title LogAspectConfig
 * @date 2023/5/19 9:25
 * @description TODO
 */
@Aspect
@Slf4j
public class LogAspectConfig {
    /**
     * 配置切入点，ExecuteLog，此处只是拦截有该注解的方法
     */
    @Pointcut("@annotation(com.thgold.thgplatform.bank.payment.config.ExecuteLog)")
    public void executePointCut() {
    }

    @Before("executePointCut()")
    public void doBefore(JoinPoint point) {
        log.info("LogAspectConfig:{}, args:{}", point.getSignature().getName(), point.getArgs());
    }
}
