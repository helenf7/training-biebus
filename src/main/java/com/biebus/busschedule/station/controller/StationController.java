package com.biebus.busschedule.station.controller;

import com.biebus.busschedule.station.entity.Station;
import com.biebus.busschedule.station.service.StationService;
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
@RequestMapping("/biebus/station")
public class StationController {

  @Autowired
  private StationService stationService;

  @GetMapping
  public List<Station> fetchStationList(){
    return stationService.getAllStation();
  }

  @GetMapping("/{id}")
  public Station getStationDetail(@PathVariable("id") Long id){
    return stationService.getDetailStationById(id);
  }

  @PostMapping("/add-new")
  String registerNewStation(@RequestBody Station request){
    return stationService.addNewStation(request);
  }

  @PutMapping("/update/{id}")
  String updateMyStationDetail(@RequestBody Station request){
    return stationService.updateStation(request);
  }

  @DeleteMapping("/remove/{id}")
  void removeMyStation(@PathVariable Long id){
    stationService.removeStation(id);
  }
}
