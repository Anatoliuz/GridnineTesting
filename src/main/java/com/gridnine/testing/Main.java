package com.gridnine.testing;

import com.gridnine.testing.filtrator.Filtrator;
import com.gridnine.testing.filtrator.FiltratorImpl;
import com.gridnine.testing.rules.*;

import java.time.LocalDateTime;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Before filtration");
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }

        System.out.println("After filtration");

        Filtrator filtrator = new FiltratorImpl();

        Rule[] rules1 = {new RuleTrue(), new FlyOffBeforeRule(LocalDateTime.now())};
        List<Flight> filteredFlights = filtrator.getFilteredFlights(flights, rules1);
        for (Flight flight : filteredFlights) {
            System.out.println(flight.toString());
        }

        System.out.println("After filtration 2");

        Rule[] rules2 = {new SegmentsNumberRule(2)};
        List<Flight> filteredFlights2 = filtrator.getFilteredFlights(flights, rules2);
        for (Flight flight : filteredFlights2) {
            System.out.println(flight.toString());
        }

        System.out.println("After filtration 3");

        Rule[] rules3 = {new ArrivalEarlierThenDepartureRule()};
        List<Flight> filteredFlights3 = filtrator.getFilteredFlights(flights, rules3);
        for (Flight flight : filteredFlights3) {
            System.out.println(flight.toString());
        }

        System.out.println("After filtration 4");

        Rule[] rules4 = {new LandingTimeExceedsInputHrsRule(2)};
        List<Flight> filteredFlights4 = filtrator.getFilteredFlights(flights, rules4);
        for (Flight flight : filteredFlights4) {
            System.out.println(flight.toString());
        }

    }
}
