package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //inject properties for coach.name and team.name
    @Value("${coach.name")
    private string coachName;
    @Value("${team.name")
    private string teamName;

    @GetMapping("/teamInfo")
    public string getTeamInfo() {
        return "Coach: "+coachName+"Team: "+teamName;
    }
}
