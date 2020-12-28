package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

/**
 * Правило, фильтрующее вылеты по заданному количеству сегментов
 */
public class SegmentsNumberRule implements Rule {
    private int number;

    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments().size() == number;
    }

    public SegmentsNumberRule(int number) {
        this.number = number;
    }
}
