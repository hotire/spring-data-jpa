package com.googlecode.hotire.springdatajpa.open;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.AccountService;
import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenEntityManagerService {
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    @PostConstruct
    public void init() {
        accountRepository.save(new Account().setUsername("hotire"));
    }

    @OpenEntityManager
    public void selectWithOpenEntityManager() {
        accountRepository.findByName("hotire").forEach(it -> {
                                                           accountRepository.findById(it.getId());
                                                           accountRepository.findById(it.getId());
                                                       }
        );
    }

    public void select() {
        accountRepository.findByName("hotire").forEach(it -> {
            accountRepository.findById(it.getId());
            accountRepository.findById(it.getId());
        }
        );
    }
}
