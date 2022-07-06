package com.biebus.busschedule.bus.repository;

import com.biebus.busschedule.bus.entity.Bus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BusRepository extends ReactiveMongoRepository<Bus, String> {
  Mono<Bus> findBusByBusNumber(String busNumber);
}
