package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Правило, которое находит полеты, в которых время приземления по сумме
 * больше заданного количества часов.
 */
public class LandingTimeExceedsInputHrsRule implements Rule {

    private final long hoursInMs;

    public LandingTimeExceedsInputHrsRule(int hours) {
        this.hoursInMs = hours * 3_600_000;
    }

    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments()
                .stream()
                .sorted(Comparator.comparing(Segment::getDepartureDate))
                .collect(Collectors.toList());

        long waitingMs = 0L;
        LocalDateTime prevArrivalDate = null;

        for (Segment s : segments) {
            if (prevArrivalDate != null) {
                waitingMs += Duration.between(prevArrivalDate, s.getDepartureDate()).toMillis();
            }
            prevArrivalDate = s.getArrivalDate();
        }

        return waitingMs > hoursInMs;
    }
}
