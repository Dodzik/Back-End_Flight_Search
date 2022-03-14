package com.project.airfield.BootStrapData;

import com.project.airfield.Entities.Airport;
import com.project.airfield.Entities.Connection;
import com.project.airfield.Entities.Flight;
import com.project.airfield.Repositories.AirportRepository;
import com.project.airfield.Repositories.ConnectRepository;
import com.project.airfield.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Component
public class BootStrapData implements CommandLineRunner {

    Random r = new Random();

    private final AirportRepository airportRepository;
    private final ConnectRepository connectRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public BootStrapData(AirportRepository airportRepository, ConnectRepository connectRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.connectRepository = connectRepository;
        this.flightRepository = flightRepository;
    }

    public String generateData() {
        return "2022/4/" + (r.nextInt(30) + 1);
    }

    @Override
    public void run(String... args) throws Exception {
        String [] airports ={"ATH" ,"BSL", "BFS" ,"BLQ", "BTS" ,"BRS" ,"CRL" ,"BUD" ,"DUB", "EDI",
                "EIN" ,"GLA" ,"HAM" ,"CTA" ,"KEF" ,"CGN" ,"SUF", "LCA" ,"LPL", "LIS" ,"LTN" ,"STN", "MAD"};

        ArrayList<Connection> connections = new ArrayList<>(Arrays.asList(
                new Connection("ATH", "EDI"),
                new Connection("ATH", "GLA"),
                new Connection("ATH", "CTA"),
                new Connection("BFS", "CGN"),
                new Connection("BFS", "LTN"),
                new Connection("BFS", "CTA"),
                new Connection("BTS", "STN"),
                new Connection("BTS", "BLQ"),
                new Connection("CRL", "BLQ"),
                new Connection("CRL", "BSL"),
                new Connection("CRL", "LTN"),
                new Connection("DUB", "LCA"),
                new Connection("LTN", "DUB"),
                new Connection("LTN", "MAD"),
                new Connection("LCA", "HAM"),
                new Connection("EIN", "BUD"),
                new Connection("EIN", "MAD"),
                new Connection("HAM", "BRS"),
                new Connection("KEF", "LPL"),
                new Connection("KEF", "CGN"),
                new Connection("SUF", "LIS"),
                new Connection("SUF", "BUD"),
                new Connection("SUF", "STN"),
                new Connection("STN", "EIN"),
                new Connection("STN", "HAM"),
                new Connection("STN", "DUB"),
                new Connection("STN", "KEF")
        ));
        for (String airport : airports) {
            airportRepository.save(new Airport(airport));
        }
        connectRepository.saveAll(connections);

        for (Connection randomConnection : connections) {
            flightRepository.save(new Flight(randomConnection.getPlace1(), randomConnection.getPlace2(), generateData()));
            flightRepository.save(new Flight(randomConnection.getPlace2(), randomConnection.getPlace1(), generateData()));

        }

    }
}
