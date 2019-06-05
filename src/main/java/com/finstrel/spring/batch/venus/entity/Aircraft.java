package com.finstrel.spring.batch.venus.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft implements Serializable {

  private static final long serialVersionUID = 9058350955651091145L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String recordKey;

  @Column(nullable = false)
  private String name;

  private String iataCode;

  private String icaoCode;
}
