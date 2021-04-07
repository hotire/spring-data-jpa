package com.googlecode.hotire.springdatajpa.open;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
@Component
public class OpenEntityManagerAspect extends EntityManagerFactoryAccessor {

    @Around("@annotation(openEntityManager)")
    public void execute(final ProceedingJoinPoint joinPoint, final OpenEntityManager openEntityManager) throws Throwable {
        EntityManagerFactory emf = obtainEntityManagerFactory();
        EntityManager em = createEntityManager();
        EntityManagerHolder emHolder = new EntityManagerHolder(em);
        TransactionSynchronizationManager.bindResource(emf, emHolder);
        try {
            joinPoint.proceed();
        } finally {
            TransactionSynchronizationManager.unbindResource(obtainEntityManagerFactory());
            logger.debug("Closing JPA EntityManager in OpenEntityManagerAspect");
            EntityManagerFactoryUtils.closeEntityManager(emHolder.getEntityManager());
        }
    }
}
