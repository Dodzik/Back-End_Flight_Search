package com.project.airfield.Entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "connections")
public class Connection {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String place1;
    public String place2;

    public Connection(String place1, String place2) {
        this.place1 = place1;
        this.place2 = place2;
    }

    public Connection() {

    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection connection = (Connection) o;
        return Objects.equals(place1, connection.place1) && Objects.equals(place2, connection.place2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place1, place2);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "place1='" + place1 + '\'' +
                ", place2='" + place2 + '\'' +
                '}';
    }
}

