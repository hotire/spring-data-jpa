package com.googlecode.hotire.springdatajpa.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class CoreControllerTest {

    @Test
    void test() throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final RestTemplate restTemplate = new RestTemplate();
        executorService.submit(() -> {
            long start = System.currentTimeMillis();
            restTemplate.getForEntity("http://localhost:8080/core/transactional", String.class);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });
        executorService.submit(() -> {
            long start = System.currentTimeMillis();
            restTemplate.getForEntity("http://localhost:8080/core/transactional", String.class);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });

        executorService.shutdown();
        Thread.sleep(100000L);
    }

}