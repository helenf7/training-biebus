package com.biebus.busschedule.bus.entity;

import java.util.Date;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusSchedule {
  @Id
  @GeneratedValue
  private String id;
  private Bus bus;
  private Date departurTime;
  private Date arrivalTime;
  private String destination;
  private String departurTerminal;
}
