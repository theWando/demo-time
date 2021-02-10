package com.time.demo.controller;

import com.time.demo.model.Response;
import com.time.demo.properties.Schedule;
import com.time.demo.service.ScheduleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@Profile("default")
@Log4j2
public class OpenForBusinessController {

    private ScheduleService scheduleService;

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(path = "/is-open-for-business")
    public Response isOpenForBusiness() {
        log.info("Using log with date");
        //No puedes hacer pruebas unitarias
        Calendar currenDate = new GregorianCalendar();
        Schedule[] schedules = scheduleService.getSchedules();

        for (Schedule schedule:
             schedules) {
            //Usa métodos deprecados en la versión 1.1
            if (currenDate.get(Calendar.DAY_OF_WEEK) == schedule.getDayOfTheWeek() &&
                    currenDate.get(Calendar.HOUR) >= schedule.getFrom() &&
                    currenDate.get(Calendar.HOUR) <= schedule.getTo())
                return new Response(true);
        }
        return new Response(false);
    }
}
