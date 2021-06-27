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
        final Parent parent = new Parent(1L, 50);
        final Parent parent2 = new Parent(2L, 60);
        parentRepository.saveAndFlush(parent);
        parentRepository.saveAndFlush(parent2);

        final Child child = new Child(1L, 20, parent);
        final Child child2 = new Child(2L, 21, parent2);

        childRepository.saveAndFlush(child);
        childRepository.saveAndFlush(child2);
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
