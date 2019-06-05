package com.finstrel.spring.batch.venus.step;

import com.finstrel.spring.batch.venus.entity.Aircraft;
import javax.sql.DataSource;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

@Component
public class AircraftCursorItemReader extends JdbcCursorItemReader<Aircraft> {

  private static final String SQL_COMMAND = "SELECT * FROM aircraft ORDER BY id";

  public AircraftCursorItemReader(final DataSource dataSource, final AircraftRowMapper aircraftRowMapper) {
    this.setDataSource(dataSource);
    this.setRowMapper(aircraftRowMapper);
    this.setSql(SQL_COMMAND);
  }
}
