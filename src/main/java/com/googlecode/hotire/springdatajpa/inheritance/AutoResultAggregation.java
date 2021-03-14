package com.googlecode.hotire.springdatajpa.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.googlecode.hotire.springdatajpa.inheritance.result.AutoResult;

import lombok.Data;

@Data
@DiscriminatorValue("AUTO")
@Entity
public class AutoResultAggregation extends ResultAggregation<AutoResult>{
}
