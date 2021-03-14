package com.googlecode.hotire.springdatajpa.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.googlecode.hotire.springdatajpa.inheritance.result.ManualResult;

import lombok.Data;


@Data
@DiscriminatorValue("MANUAL")
@Entity
public class ManualResultAggregation extends ResultAggregation<ManualResult> {
}
