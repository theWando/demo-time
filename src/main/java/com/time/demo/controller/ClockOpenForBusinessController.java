package com.time.demo.controller;


import com.time.demo.model.Response;
import com.time.demo.properties.Schedule;
import com.time.demo.service.ScheduleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@RestController
@Profile("clock")
@Log4j2
public class ClockOpenForBusinessController {

    private Clock clock;

    private ScheduleService scheduleService;

    @Autowired
    public void setClock(Clock clock) {
        this.clock = clock;
    }

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(path = "/is-open-for-business")
    public Response isOpenForBusiness() {
        log.info("Using log with clock");
        //permite pruebas
        LocalDateTime currentTime = LocalDateTime.now(clock);
        Schedule[] schedules = scheduleService.getSchedules();

        for (Schedule schedule :
                schedules) {
            //Sin métodos deprecados
            if (currentTime.get(ChronoField.DAY_OF_WEEK) == schedule.getDayOfTheWeek() &&
            currentTime.get(ChronoField.HOUR_OF_DAY) >= schedule.getFrom() &&
            currentTime.get(ChronoField.HOUR_OF_DAY) <= schedule.getTo())
                return new Response(true);
        }
        return new Response(false);
    }
}
