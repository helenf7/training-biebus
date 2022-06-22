package com.biebus.busschedule.station.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long stationId;
  private String stationName;
  private String city;
  private double longitude;
  private double latitude;
}
