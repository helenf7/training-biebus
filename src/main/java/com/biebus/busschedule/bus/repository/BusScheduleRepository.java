package com.biebus.busschedule.bus.repository;

import com.biebus.busschedule.bus.entity.BusSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusScheduleRepository extends MongoRepository<BusSchedule, String> {

}
