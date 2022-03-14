package com.project.airfield.Entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "airports")
public class Airport {


    @Id
    public String name;


    public Airport(String name) {
        this.name = name;
    }

    public Airport() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
