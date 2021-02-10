package com.time.demo.service;

import com.time.demo.properties.Schedule;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

@Service("ScheduleService")
@Profile("clock")
@Log4j2
public class ScheduleServiceClock implements ScheduleService {

    @Override
    public Schedule[] getSchedules() {
        log.info("getSchedules|desde ScheduleServiceClock");
        return new Schedule[]{
                Schedule.builder().dayOfTheWeek(MONDAY.getValue()).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(TUESDAY.getValue()).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(WEDNESDAY.getValue()).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(THURSDAY.getValue()).from(9).to(17).build(),
                Schedule.builder().dayOfTheWeek(FRIDAY.getValue()).from(9).to(17).build(),
        };
    }
}
