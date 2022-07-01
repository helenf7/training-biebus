package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.BusSchedule;
import com.biebus.busschedule.bus.repository.BusScheduleRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
  @Autowired
  BusScheduleRepository busScheduleRepository;

  @Override
  public List<BusSchedule> getAllBusSchedule(){
    return busScheduleRepository.findAll();
  }

  @Override
  public BusSchedule getDetailScheduleById(String id){
    Optional<BusSchedule> detailBus = busScheduleRepository.findById(id);
    return detailBus.get();
  }

  @Override
  public List<BusSchedule> findScheduleByDestination(String destination) {
    return busScheduleRepository.findBusSchedulesByDestination(destination);
  }

  @Override
  public String addNewSchedule(BusSchedule request){
    busScheduleRepository.save(request);
    return "Success update schedule with destination" + request.getDestination();
  }

  @Override
  public String updateSchedule(String id, BusSchedule request){
    Optional<BusSchedule> existSchedule = busScheduleRepository.findById(id);
    if(existSchedule.isPresent()){
      busScheduleRepository.save(request);
      return "Success add new schedule with id: " + id;
    }

    throw new InternalError("Bus schedule not exist !");
  }

  @Override
  public void removeSchedule(String request){
    busScheduleRepository.deleteById(request);
  }

}
