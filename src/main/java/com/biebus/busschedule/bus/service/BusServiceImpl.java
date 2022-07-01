package com.biebus.busschedule.bus.service;

import com.biebus.busschedule.bus.entity.Bus;
import com.biebus.busschedule.bus.repository.BusRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {
  @Autowired
  BusRepository busRepository;

  @Override
  public List<Bus> getAllBus(){
    return busRepository.findAll();
  }

  @Override
  public Bus getDetailBusById(Long id){
    Optional<Bus> detailBus = busRepository.findById(id);
    return detailBus.get();
  }

  @Override
  public String addNewBus(Bus request){
    busRepository.save(request);
    return "Success add new bus with bus number: " + request.getBusNumber();
  }

  @Override
  public String updateBus(Long id, Bus request){
    Optional<Bus> existBus = busRepository.findById(id);
    if(existBus.isPresent()){
      busRepository.save(request);
      return "Success update bus " + id;
    }
    throw new InternalError("Bus not exist !");
  }

  @Override
  public void removeBus(Long request){
    busRepository.deleteById(request);
  }
}
