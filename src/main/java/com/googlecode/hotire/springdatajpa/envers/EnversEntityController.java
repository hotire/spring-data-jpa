package com.googlecode.hotire.springdatajpa.envers;

import java.util.List;

import javax.persistence.Id;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/v1/envers")
@RestController
@Slf4j
@RequiredArgsConstructor
public class EnversEntityController {

    private final EnversEntityRepository enversEntityRepository;

    @GetMapping("/{name}")
    public void save(@PathVariable String name) {
        enversEntityRepository.findAll().forEach(it -> enversEntityRepository.save(it.setName(name)));

        List<EnversEntity> enversEntityList =  enversEntityRepository.findAll();

        System.out.println(enversEntityList.get(0).getEnversEntity());
    }

}
