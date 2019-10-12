package com.googlecode.hotire.springdatajpa.Item;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Builder
@Getter
@Entity
public class TimeEntity {
  @Id @GeneratedValue
  private Long id;
//  @Column(columnDefinition = "TIMESTAMP")
  private Instant instant;
//  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime localDateTime;
//  @Column(columnDefinition = "TIMESTAMP")
  private OffsetDateTime offsetDateTime;
//  @Column(columnDefinition = "TIMESTAMP")
  private ZonedDateTime zonedDateTime;

  @Column(columnDefinition = "TIMESTAMP")
  private String startDate;
}
