package com.finstrel.spring.batch.venus.step;

import com.finstrel.spring.batch.venus.entity.Aircraft;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftRowMapper implements RowMapper<Aircraft> {

  @Override
  public Aircraft mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    Aircraft aircraft = new Aircraft();
    aircraft.setId(rs.getLong("id"));
    aircraft.setRecordKey(rs.getString("record_key"));
    aircraft.setName(rs.getString("name"));
    aircraft.setIataCode(rs.getString("iata_code"));
    aircraft.setIcaoCode(rs.getString("icao_code"));
    return aircraft;
  }
}
