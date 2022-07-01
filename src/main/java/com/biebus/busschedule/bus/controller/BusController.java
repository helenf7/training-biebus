package com.biebus.busschedule.bus.controller;

import com.biebus.busschedule.bus.entity.Bus;
import com.biebus.busschedule.bus.service.BusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biebus/bus")
public class BusController {

  @Autowired
  private BusService busService;

  @GetMapping
  public List<Bus> fetchBusList(){
    return busService.getAllBus();
  }

  @GetMapping("/{id}")
  public Bus getBusDetail(@PathVariable("id") Long id){
    return busService.getDetailBusById(id);
  }

  @PostMapping("/add-new")
  String addNewBus(@RequestBody Bus request){
    return busService.addNewBus(request);
  }

  @PutMapping("/update/{id}")
  String updateMyBusDetail(@PathVariable("id") Long id, @RequestBody Bus request){
    return busService.updateBus(id, request);
  }

  @DeleteMapping("/remove/{id}")
  void removeMyBus(@PathVariable Long id){
    busService.removeBus(id);
  }
}
