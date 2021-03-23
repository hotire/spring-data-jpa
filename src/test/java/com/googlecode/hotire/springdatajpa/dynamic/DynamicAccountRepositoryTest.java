package com.googlecode.hotire.springdatajpa.dynamic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DynamicAccountRepositoryTest {

    @Autowired
    private DynamicAccountRepository dynamicAccountRepository;


    @Test
    @Transactional
    void saveTransactional() {
        // given
        final DynamicAccount account = dynamicAccountRepository.saveAndFlush(new DynamicAccount().setName("hello").setType("type"));

        // when
//        dynamicAccountRepository.findById(account.getId())
//                                .ifPresent(saved -> {
//                                    dynamicAccountRepository.saveAndFlush(saved.setName("hotire")
//                                                                               .setType(null));
//                                });

        dynamicAccountRepository.findAll()
                                .forEach(saved -> {
                                    dynamicAccountRepository.saveAndFlush(saved.setName("hotire")
                                                                               .setType(null));
                                });

        dynamicAccountRepository.saveAndFlush(new DynamicAccount().setId(account.getId()).setName("hotire2"));
    }

    @Test
    void save() {
        // given
        final DynamicAccount account = dynamicAccountRepository.saveAndFlush(new DynamicAccount().setName("hello").setType("type"));

        // when
//        dynamicAccountRepository.findById(account.getId())
//                                .ifPresent(saved -> {
//                                    dynamicAccountRepository.saveAndFlush(saved.setName("hotire")
//                                                                               .setType(null));
//                                });
        dynamicAccountRepository.findAll()
                                .forEach(saved -> {
                                    dynamicAccountRepository.saveAndFlush(saved.setName("hotire")
                                                                               .setType(null));
                                });


        dynamicAccountRepository.saveAndFlush(new DynamicAccount().setId(account.getId()).setName("hotire2"));
    }
}