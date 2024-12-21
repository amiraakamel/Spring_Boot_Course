package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //endpoint for 'work out'
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k! ";
    }

    //endpoint fo fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day. ";
    }

}

