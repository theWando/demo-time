package com.time.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Schedule {
    java.util.Date
    private int dayOfTheWeek;
}
