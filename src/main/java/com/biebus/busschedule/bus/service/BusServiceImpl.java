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
    Optional<Bus> existBus = busRepository.findById(request.getId());
    if(Objects.nonNull(existBus.get())){
      throw new InternalError("Bus already exist !");
    }
    else {
      busRepository.save(request);
    }
    return "Success update bus " + request.getId();
  }

  @Override
  public String updateBus(Bus request){
    busRepository.save(request);
    return "Success add new bus with id: " + request.getId();
  }

  @Override
  public void removeBus(Long request){
    busRepository.deleteById(request);
  }
}
