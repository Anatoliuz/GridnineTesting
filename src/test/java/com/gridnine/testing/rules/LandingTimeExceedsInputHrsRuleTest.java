package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LandingTimeExceedsInputHrsRuleTest {

    @Test
    void negativeCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 29, 12, 0),
                LocalDateTime.of(2020, 12, 29, 13,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 29, 13, 49),
                LocalDateTime.of(2020, 12, 29, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new LandingTimeExceedsInputHrsRule(2);

        assertFalse(rule.isValid(testFlight));
    }

    @Test
    void positiveCase() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 29, 12, 0),
                LocalDateTime.of(2020, 12, 29, 13,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 29, 15, 49),
                LocalDateTime.of(2020, 12, 29, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new LandingTimeExceedsInputHrsRule(2);

        assertTrue(rule.isValid(testFlight));
    }
}