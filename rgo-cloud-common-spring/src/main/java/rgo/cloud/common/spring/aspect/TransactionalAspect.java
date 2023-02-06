package rgo.cloud.common.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import rgo.cloud.common.spring.annotation.Transactional;
import rgo.cloud.common.spring.storage.DbTxManager;

@Aspect
@Component
public class TransactionalAspect {
    private final DbTxManager txManager;

    public TransactionalAspect(DbTxManager txManager) {
        this.txManager = txManager;
    }

    @Pointcut("@annotation(tr)")
    public void transactional(Transactional tr) {
    }

    @Around(value = "transactional(tr)", argNames = "jp,tr")
    public Object processedTransactionalOnMethod(ProceedingJoinPoint jp, Transactional tr) {
        return txManager.execute(jp::proceed);
    }
}
