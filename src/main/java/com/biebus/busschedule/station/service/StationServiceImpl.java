package com.biebus.busschedule.station.service;

import com.biebus.busschedule.station.entity.Station;
import com.biebus.busschedule.station.repository.StationRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService{
  @Autowired
  StationRepository stationRepository;

  @Override
  public List<Station> getAllStation(){
    return (List<Station>) stationRepository.findAll();
  }

  @Override
  public Station getDetailStationById(Long id){
    Optional<Station> detailBus = stationRepository.findById(id);
    return detailBus.get();
  }

  @Override
  public String addNewStation(Station request){
    Optional<Station> existStation = stationRepository.findById(request.getStationId());
    if(Objects.nonNull(existStation.get())){
      throw new InternalError("Station already exist !");
    }
    else {
      stationRepository.save(request);
    }
    return "Success update station " + request.getStationName();
  }

  @Override
  public String updateStation(Station request){
    stationRepository.save(request);
    return "Success add new station" + request.getStationName();
  }

  @Override
  public void removeStation(Long request){
    stationRepository.deleteById(request);
  }
}
