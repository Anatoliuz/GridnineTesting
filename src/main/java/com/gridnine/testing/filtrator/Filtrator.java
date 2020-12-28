package com.gridnine.testing.filtrator;

import com.gridnine.testing.Flight;
import com.gridnine.testing.rules.Rule;

import java.util.List;

public interface Filtrator {
    List<Flight> getFilteredFlights(List<Flight> flights, Rule... rules);
}
