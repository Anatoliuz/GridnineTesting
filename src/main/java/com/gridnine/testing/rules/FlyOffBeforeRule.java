package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * Правило по которому полеты должны быть до указанной даты с точностью
 * до секунды.
 */
public class FlyOffBeforeRule implements Rule {
    private final LocalDateTime insertedTime;

    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments()
                .stream()
                .min(Comparator.comparing(Segment::getDepartureDate))
                .map(Segment::getDepartureDate)
                .filter(firstDepartDate -> firstDepartDate.isBefore(insertedTime))
                .isPresent();
    }

    public FlyOffBeforeRule(LocalDateTime time) {
        this.insertedTime = time;
    }
}
