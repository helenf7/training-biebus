package com.biebus.busschedule.station.service;

import com.biebus.busschedule.station.entity.Station;
import java.util.List;

public interface StationService {
  List<Station> getAllStation();
  Station getDetailStationById(Long id);
  String addNewStation(Station request);
  String  updateStation(Station request);
  void removeStation(Long request);
}
