package com.time.demo.properties;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@EqualsAndHashCode
@Getter
public class Schedule {
    private int dayOfTheWeek;
    private int from;
    private int to;
}
