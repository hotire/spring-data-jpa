package com.googlecode.hotire.springdatajpa.query.specification;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public List<Content> getContents(String name) {
        return contentRepository.findAll(ContentSpecs.withName(name));
    }
}
