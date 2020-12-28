package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.function.Predicate;

/**
 * Правило, которое находит сегменты в которых время прибытия раньше отправления.
 */
public class ArrivalEarlierThenDepartureRule implements Rule{
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments()
                .stream()
                .anyMatch(arrivalEarlierThenDeparturePredicate());
    }

    private Predicate<Segment> arrivalEarlierThenDeparturePredicate() {
        return segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate());
    }
}
