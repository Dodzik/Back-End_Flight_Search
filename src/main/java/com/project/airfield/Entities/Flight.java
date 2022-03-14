package com.project.airfield.Entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String start;
    private String destination;
    private String startTime;

    public Flight(String start, String destination, String startTime) {
        this.start = start;
        this.destination = start;
        this.startTime = startTime;
    }

    public Flight() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(start, flight.start) && Objects.equals(destination, flight.destination) && Objects.equals(startTime, flight.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, destination, startTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", destination='" + destination + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
