package com.project.airfield.Controller;


import com.project.airfield.Entities.Airport;
import com.project.airfield.Entities.Connection;
import com.project.airfield.Entities.Flight;
import com.project.airfield.Repositories.AirportRepository;
import com.project.airfield.Repositories.ConnectRepository;
import com.project.airfield.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
public class Controller {
    private final AirportRepository airportRepository;
    private final ConnectRepository connectRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public Controller(AirportRepository airportRepository, ConnectRepository connectRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.connectRepository = connectRepository;
        this.flightRepository = flightRepository;
    }

    @RequestMapping(value = "/api/airports")
    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }

    @RequestMapping("/api/connections/{name}")
    public List<Connection> getConnections(@PathVariable String name){
        List <Connection> list1 = connectRepository.findByPlace1Is(name);
        List <Connection> list2 = connectRepository.findByPlace2Is(name);

        return Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
    }
    @RequestMapping("/api/flights")
    public List<Flight> getFlights(){
        return  flightRepository.findAll();
    }

    @RequestMapping("/api/flights/{start}")
    public List<Flight> getFlightStart(@PathVariable String start){
        return  flightRepository.findByStartIs(start);
    }
    @RequestMapping("/api/flight/{start}/{destination}")
    public List<Flight> getFlightStartDestination(@PathVariable String start, @PathVariable String destination){
        return  flightRepository.findByStartIsAndDestinationIs(start,destination);
    }


}
