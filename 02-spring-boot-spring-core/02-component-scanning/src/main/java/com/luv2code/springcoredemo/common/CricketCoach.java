package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;
//mark the class as Spring bean makes it available for dependency injection

@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes NOW !!!!!!!!!!!";
    }
}
