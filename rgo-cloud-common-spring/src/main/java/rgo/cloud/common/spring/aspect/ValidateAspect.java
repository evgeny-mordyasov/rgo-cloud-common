package rgo.cloud.common.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import rgo.cloud.common.api.rest.Request;

@Slf4j
@Aspect
@Component
public class ValidateAspect {
    public ValidateAspect() {
    }

    @Pointcut("execution(* rgo.cloud.*.boot.api.decorator.*..*(..))")
    public void decorator() {
    }

    @Pointcut("args(rgo.cloud.common.api.rest.Request)")
    public void request() {
    }

    @Pointcut("@target(rgo.cloud.common.spring.aspect.Validate)")
    public void validateAnnotation() {
    }

    @Before("decorator() && request() && validateAnnotation()")
    public void validateRequest(JoinPoint jp) {
        Request rq = ((Request) jp.getArgs()[0]);
        log.info("{} received: {}", rq.getClass().getSimpleName(), rq);
        rq.validate();
    }
}
