package com.finstrel.spring.batch.venus.step;

import com.finstrel.spring.batch.venus.entity.Aircraft;
import java.util.Optional;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class AircraftItemProcessor implements ItemProcessor<Aircraft, Aircraft> {

  @Override
  public Aircraft process(final Aircraft aircraft) {
    aircraft.setIataCode(Optional.ofNullable(aircraft.getIataCode()).map(String::toUpperCase).orElse(null));
    aircraft.setIcaoCode(Optional.ofNullable(aircraft.getIcaoCode()).map(String::toUpperCase).orElse(null));
    return aircraft;
  }
}
