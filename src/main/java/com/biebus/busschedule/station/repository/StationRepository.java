package com.biebus.busschedule.station.repository;

import com.biebus.busschedule.station.entity.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {

}
