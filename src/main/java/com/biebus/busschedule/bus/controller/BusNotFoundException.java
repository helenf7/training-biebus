package com.biebus.busschedule.bus.controller;

public class BusNotFoundException extends RuntimeException {
  public BusNotFoundException(String id){
    super("Bus with no : " + id + "not found !");
  }

  public String BusScheduleNotFoundException(String id){
    return("Bus with no : " + id + "not found !");
  }
}
