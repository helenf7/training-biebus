package com.biebus.busschedule.bus.controller;

import com.biebus.busschedule.bus.entity.Bus;
import com.biebus.busschedule.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/biebus/bus")
public class BusController {

  @Autowired
  private BusService busService;

  @GetMapping
  public Flux<Bus> fetchBusList(){
    return busService.getAllBus();
  }

  @GetMapping("/{id}")
  public Mono<Bus> getBusDetail(@PathVariable("id") String id){
    return busService.getDetailBusById(id);
  }

  @GetMapping("/with-bus-number/{busNumber}")
  public Mono<Bus> getBusWithBusNumber(@PathVariable("busNumber") String busNumber){
    return busService.findBusByBusNumber(busNumber);
  }

  @PostMapping("/add-new")
  String addNewBus(@RequestBody Bus request){
    return busService.addNewBus(request);
  }

  @PutMapping("/update/{id}")
  String updateMyBusDetail(@PathVariable("id") String id, @RequestBody Bus request){
    return busService.updateBus(id, request);
  }

  @DeleteMapping("/remove/{id}")
  void removeMyBus(@PathVariable String id){
    busService.removeBus(id);
  }
}
