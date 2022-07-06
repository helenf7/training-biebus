package com.biebus.busschedule.bus.repository;

import com.biebus.busschedule.bus.entity.BusSchedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BusScheduleRepository extends ReactiveMongoRepository<BusSchedule, String> {

  Flux<BusSchedule> findAll(Sort sort);
  Flux<BusSchedule> findBusSchedulesByDestination(String destination);
}
