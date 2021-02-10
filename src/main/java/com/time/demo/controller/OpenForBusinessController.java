package com.time.demo.controller;

import com.time.demo.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("default")
public class OpenForBusinessController {
    private static final Logger log = LoggerFactory.getLogger(OpenForBusinessController.class);

    @GetMapping(path = "/is-open-for-business")
    public Response isOpenForBusiness() {
        log.info("Using log with date");
        return new Response(true);
    }
}
