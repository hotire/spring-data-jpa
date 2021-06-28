package com.googlecode.hotire.springdatajpa.deadlock.foreign;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import lombok.RequiredArgsConstructor;

/**
 * http://ladm-ci-real.line-apps-dev.com:8080/jenkins/login?from=%2Fjenkins%2Fview%2FLADM-BATCH-STAGE%2F
 */
@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class ParentChildService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    @PostConstruct
    public void init() {
        final DeadLockParent deadLockParent = new DeadLockParent(1L, 50);
        final DeadLockParent deadLockParent2 = new DeadLockParent(2L, 60);
        parentRepository.saveAndFlush(deadLockParent);
        parentRepository.saveAndFlush(deadLockParent2);

        final DeadLockChild deadLockChild = new DeadLockChild(1L, 20, deadLockParent);
        final DeadLockChild deadLockChild2 = new DeadLockChild(2L, 21, deadLockParent2);

        childRepository.saveAndFlush(deadLockChild);
        childRepository.saveAndFlush(deadLockChild2);
    }

    public void save(final Long parentId, final Integer age) {
        parentRepository.findById(parentId)
                        .map(it -> it.setAge(age))
                        .map(parentRepository::saveAndFlush)
                        .orElse(null);

        ThreadUtils.sleep(3000L);

//        childRepository.save()
//        account 의 property save()
//

    }
}
