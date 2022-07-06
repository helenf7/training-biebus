package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.BusSchedule;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusScheduleService {
  Flux<BusSchedule> getAllBusSchedule();
  Mono<BusSchedule> getDetailScheduleById(String id);
  Flux<BusSchedule> findScheduleByDestination(String destination);
  String addNewSchedule(BusSchedule request);
  String  updateSchedule(String id, BusSchedule request);
  void removeSchedule(String request);
}
