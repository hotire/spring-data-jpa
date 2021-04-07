package com.googlecode.hotire.springdatajpa.open;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/open")
@RestController
@RequiredArgsConstructor
public class OpenEntityManagerController {
    private final OpenEntityManagerService openEntityManagerService;

    @GetMapping
    public void select() {
        openEntityManagerService.select();
    }
}
