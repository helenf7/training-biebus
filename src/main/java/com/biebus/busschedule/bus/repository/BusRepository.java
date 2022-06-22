package com.biebus.busschedule.bus.repository;

import com.biebus.busschedule.bus.entity.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, Long> {

}
