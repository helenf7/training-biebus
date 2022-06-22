package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.Bus;
import java.util.List;

public interface BusService {

  List<Bus> getAllBus();
  Bus getDetailBusById(Long id);
  String addNewBus(Bus request);
  String  updateBus(Bus request);
  void removeBus(Long request);

}
