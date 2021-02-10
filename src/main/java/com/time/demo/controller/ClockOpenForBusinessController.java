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
        Schedule[] schedules = scheduleService.getSchedules();

        return new Response(true);
    }
}
