package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.Bus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusService {

  Flux<Bus> getAllBus();
  Mono<Bus> getDetailBusById(String id);
  Mono<Bus> findBusByBusNumber(String busNumber);
  String addNewBus(Bus request);
  String  updateBus(String id, Bus request);
  void removeBus(String id);

}
