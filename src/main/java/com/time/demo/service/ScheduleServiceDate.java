package com.time.demo.service;

import com.time.demo.properties.Schedule;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;

@Service("ScheduleService")
@Profile("default")
@Log4j2
public class ScheduleServiceDate implements ScheduleService {

    @Override
    public Schedule[] getSchedules() {
        log.info("getSchedules|desde ScheduleServiceDate");
        return new Schedule[]{
                Schedule.builder().dayOfTheWeek(MONDAY).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(TUESDAY).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(WEDNESDAY).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(THURSDAY).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(FRIDAY).from(9).to(17).build(),
        };
    }
}
