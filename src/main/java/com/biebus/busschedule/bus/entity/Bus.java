package com.biebus.busschedule.bus.entity;

import com.biebus.busschedule.bus.entity.constant.CollectionName;
import com.biebus.busschedule.bus.entity.constant.enums.BusType;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionName.BUS)
public class Bus {
  @Id
  @GeneratedValue
  private String id;
  private String busNumber;
  private String busName;
  private int busCapacity;
  private BusType busType;
  private BusFacility busFacility;
}
