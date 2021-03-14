package com.googlecode.hotire.springdatajpa.inheritance.result;

import com.googlecode.hotire.springdatajpa.inheritance.result.Result;

import lombok.Data;

@Data
public class ManualResult extends Result {
    private String content;
}
