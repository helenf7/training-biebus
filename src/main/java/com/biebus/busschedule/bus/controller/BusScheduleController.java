package com.biebus.busschedule.bus.controller;

import com.biebus.busschedule.bus.entity.BusSchedule;
import com.biebus.busschedule.bus.service.BusScheduleService;
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
@RequestMapping("/git chbiebus/schedule")
public class BusScheduleController {

  @Autowired
  private BusScheduleService busScheduleService;

  @GetMapping
  public List<BusSchedule> fetchBusList(){
    return busScheduleService.getAllBusSchedule();
  }

  @GetMapping("/{id}")
  public BusSchedule getBusDetail(@PathVariable("id") String id){
    return busScheduleService.getDetailScheduleById(id);
  }

  @PostMapping("/add-new")
  String addNewSchedule(@RequestBody BusSchedule request){
    return busScheduleService.addNewSchedule(request);
  }

  @PutMapping("/update/{id}")
  String updateMyScheduleDetail(@RequestBody BusSchedule request){
    return busScheduleService.updateSchedule(request);
  }

  @DeleteMapping("/remove/{id}")
  void removeMySchedule(@PathVariable String id){
    busScheduleService.removeSchedule(id);
  }
}
