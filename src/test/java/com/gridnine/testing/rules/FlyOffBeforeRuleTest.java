package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Время написания теста 29 декабря 00:30.
 */
class FlyOffBeforeRuleTest {

    @Test
    void negativeTest() {
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
        var rule = new FlyOffBeforeRule( LocalDateTime.now());
        assertFalse(rule.isValid(testFlight));
    }

    @Test
    void positiveTest() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 28, 12, 0),
                LocalDateTime.of(2020, 12, 28, 13,0)
        ));
        segments.add(new Segment(
                LocalDateTime.of(2020, 12, 28, 13, 49),
                LocalDateTime.of(2020, 12, 28, 17, 58)
        ));
        Flight testFlight = new Flight(segments);
        var rule = new FlyOffBeforeRule( LocalDateTime.now());
        assertTrue(rule.isValid(testFlight));
    }
}