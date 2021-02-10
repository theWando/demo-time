package com.time.demo.controller;


import com.time.demo.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;

@RestController
@Profile("clock")
public class ClockOpenForBusinessController {

    private static final Logger log = LoggerFactory.getLogger(ClockOpenForBusinessController.class);

    private Clock clock;

    @Autowired
    public void setClock(Clock clock) {
        this.clock = clock;
    }

    @GetMapping(path = "/is-open-for-business")
    public Response isOpenForBusiness() {
        log.info("Using log with clock");
        return new Response(true);
    }
}
