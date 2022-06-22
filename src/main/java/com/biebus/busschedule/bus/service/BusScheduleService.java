package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.BusSchedule;
import java.util.List;

public interface BusScheduleService {
  List<BusSchedule> getAllBusSchedule();
  BusSchedule getDetailScheduleById(String id);
  String addNewSchedule(BusSchedule request);
  String  updateSchedule(BusSchedule request);
  void removeSchedule(String request);
}
