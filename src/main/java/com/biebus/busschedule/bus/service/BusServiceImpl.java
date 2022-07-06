package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.Bus;
import com.biebus.busschedule.bus.repository.BusRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusServiceImpl implements BusService {
  @Autowired
  BusRepository busRepository;

  @Override
  public Flux<Bus> getAllBus() {
    return busRepository.findAll();
  }

  @Override
  public Mono<Bus> getDetailBusById(String id) {
    Mono<Bus> detailBus = busRepository.findById(id);
    return detailBus;
  }

  @Override
  public Mono<Bus> findBusByBusNumber(String busNumber) {
    return busRepository.findBusByBusNumber(busNumber);
  }

  @Override
  public String addNewBus(Bus request){
    busRepository.save(request)
        .subscribe();
    return "Success add new bus with bus number: " + request.getBusNumber();
  }

  @Override
  public String updateBus(String id, Bus request){
    Mono<Bus> existBus = busRepository.findById(id);
    if(Objects.isNull(existBus)){
      throw new InternalError("Bus not exist !");
    }
    busRepository
        .save(request)
        .subscribe();
    return "Success update bus with id : " + id;
  }

  @Override
  public void removeBus(String id){
    busRepository
        .deleteById(id)
        .subscribe();
  }
}
