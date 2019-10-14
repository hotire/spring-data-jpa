package com.googlecode.hotire.springdatajpa.Item;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TimeService implements InitializingBean {
  private final TimeRepository timeRepository;

  @Override
  public void afterPropertiesSet() throws Exception {

    final TimeEntity timeEntity = TimeEntity
      .builder()
      .localDateTime(ZonedDateTime.now(ZoneId.of("America/Vancouver")).toLocalDateTime())
      .offsetDateTime(OffsetDateTime.now().withOffsetSameInstant(ZonedDateTime.now(ZoneId.of("America/Vancouver")).getOffset()))
      .zonedDateTime(ZonedDateTime.now(ZoneId.of("America/Vancouver")))
      .instant(Instant.now())
      .build();

    timeEntity.setStartDate(timeEntity.getLocalDateTime().toString());
    timeRepository.save(timeEntity);
  }
}
