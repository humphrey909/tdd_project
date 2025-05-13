package com.example.tdd_project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

//    Logger logger = LoggerFactory.getLogger(TestController.class);
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/")
    public String hello_(@RequestParam(value = "name", defaultValue = "World3333") String name) {
        log.trace("trace message0");
        log.debug("debug message0");
        log.info("info message0"); // 0
        log.warn("warn message0");  // 0
        log.error("error message0"); // 0

        return String.format("Hello2222  %s!",name);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message"); // default
        log.warn("warn message");
        log.error("error message");

        return String.format("Hello  %s!",name);
    }


    @GetMapping("/hello2/{owner_id}")
    public String hello2(
            @PathVariable("owner_id") String ownerId
//            @RequestParam(value = "name", defaultValue = "World3333") String name
    ) {
        log.trace("trace message2");
        log.debug("debug message2");
        log.info("info message2"+ownerId); // default
        log.warn("warn message2");
        log.error("error message2");

        return "123123";
    }
}
