package com.project.airfield.Repositories;

import com.project.airfield.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByStartIsAndDestinationIs(String start, String destination);
    List<Flight> findByStartIs(String start);
}
