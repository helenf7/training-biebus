package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.BusSchedule;
import com.biebus.busschedule.bus.repository.BusScheduleRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
  @Autowired
  BusScheduleRepository busScheduleRepository;

  @Override
  public Flux<BusSchedule> getAllBusSchedule(){
    return busScheduleRepository.findAll();
  }

  @Override
  public Mono<BusSchedule> getDetailScheduleById(String id){
    Mono<BusSchedule> detailSchedule = busScheduleRepository.findById(id);
    return detailSchedule;
  }

  @Override
  public Flux<BusSchedule> findScheduleByDestination(String destination) {
    return busScheduleRepository.findBusSchedulesByDestination(destination);
  }

  @Override
  public String addNewSchedule(BusSchedule request){
    busScheduleRepository
        .save(request)
        .subscribe();
    return "Success add new schedule with destination : " + request.getDestination();
  }

  @Override
  public String updateSchedule(String id, BusSchedule request){
    Mono<BusSchedule> existSchedule = busScheduleRepository.findById(id);
    if(Objects.isNull(existSchedule)){
      throw new InternalError("Bus schedule not exist !");
    }

    busScheduleRepository
        .save(request)
        .subscribe();
    return "Success updated schedule with id : " + id;
  }

  @Override
  public void removeSchedule(String request){
    busScheduleRepository
        .deleteById(request)
        .subscribe();
  }

}
