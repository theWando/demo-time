package com.time.demo.controller;

import com.time.demo.service.ScheduleServiceClock;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClockOpenForBusinessControllerTest {

    @Test
    void TestsIsOpenForBusiness() {
        String instantExpected = "2014-12-22T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));

        ClockOpenForBusinessController controller = new ClockOpenForBusinessController();
        controller.setClock(clock);
        controller.setScheduleService(new ScheduleServiceClock());

        assertTrue(controller.isOpenForBusiness().isOpen());
    }

    @Test
    void TestsIsNotOpenForBusiness() {
        String instantExpected = "2014-12-28T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));

        ClockOpenForBusinessController controller = new ClockOpenForBusinessController();
        controller.setClock(clock);
        controller.setScheduleService(new ScheduleServiceClock());

        assertFalse(controller.isOpenForBusiness().isOpen());
    }
}