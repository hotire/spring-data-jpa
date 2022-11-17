package com.googlecode.hotire.springdatajpa.core;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class CoreController {

    private final CoreService coreService;

    @GetMapping("/transactional")
    public void transactional() throws InterruptedException {
        coreService.transactional();
    }

    @GetMapping("/list-in-transactional")
    public void listInTransactional() {
        coreService.listInTransactional();
    }
}
