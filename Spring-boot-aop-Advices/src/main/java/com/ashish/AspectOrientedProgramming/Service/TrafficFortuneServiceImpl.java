package com.ashish.AspectOrientedProgramming.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception exception){
            throw new RuntimeException();
        }

        //return fortune
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("Major accident road is closed");
        }

        return "Major accident road is closed";
    }
}
