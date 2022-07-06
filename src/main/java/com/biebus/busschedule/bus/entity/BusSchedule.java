package com.biebus.busschedule.bus.entity;

import com.biebus.busschedule.bus.entity.constant.CollectionName;
import java.util.Date;
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
@Document(collection = CollectionName.BUS_SCHEDULE)
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
