package com.googlecode.hotire.springdatajpa.core;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class CoreController {

    private final CoreService coreService;
    private final CoreRepository coreRepository;

    @PostConstruct
    public void init() {
        coreRepository.save(new Core().setName("hotire"));
    }

    @GetMapping("/transactional")
    public void transactional() throws InterruptedException {
        coreService.transactional();
    }

    @GetMapping("/list-in-transactional")
    public void listInTransactional() {
        coreService.listInTransactional();
    }

    @GetMapping("/find-by-name")
    public void findByName(@RequestParam String name) {
        coreRepository.findByName(name);
    }

    @GetMapping("/get-by-name")
    public void getByName(@RequestParam String name) {
        coreRepository.getByName(name);
    }
}
