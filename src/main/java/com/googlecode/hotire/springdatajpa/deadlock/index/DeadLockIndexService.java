package com.googlecode.hotire.springdatajpa.deadlock.index;

import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeadLockIndexService {
    private final DeadLockIndexRepository deadLockIndexRepository;

    private final ApplicationContext context;

    public DeadLockIndex saveAndRollback(final DeadLockIndex deadLockIndex) {
        try {
            context.getBean(DeadLockIndexService.class).save(deadLockIndex, it -> {
                ThreadUtils.sleep(3000);
                throw new RuntimeException();
            });
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return deadLockIndex;
    }

    @Transactional
    public DeadLockIndex save(final DeadLockIndex deadLockIndex, final Consumer<DeadLockIndex> afterSave) {
        final DeadLockIndex saved = deadLockIndexRepository.save(deadLockIndex);
        afterSave.accept(saved);
        return saved;
    }
}
