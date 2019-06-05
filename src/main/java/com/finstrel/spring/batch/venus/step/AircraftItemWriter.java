package com.finstrel.spring.batch.venus.step;

import com.finstrel.spring.batch.venus.entity.Aircraft;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class AircraftItemWriter extends FlatFileItemWriter<Aircraft> {

  public AircraftItemWriter() {
    this.setResource(new FileSystemResource("aircraft.csv"));
    this.setHeaderCallback(writer -> writer.write("Name, IATA code, ICAO code"));
    BeanWrapperFieldExtractor<Aircraft> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<>();
    beanWrapperFieldExtractor.setNames(new String[]{"name", "iataCode", "icaoCode"});
    DelimitedLineAggregator<Aircraft> lineAggregator = new DelimitedLineAggregator<>();
    lineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
    this.setLineAggregator(lineAggregator);
  }
}
