package com.biebus.busschedule.bus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusFacility {
  private boolean ac;
  private boolean toilet;
  private boolean wifi;
  private boolean tv;
}
