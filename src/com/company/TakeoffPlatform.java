package com.company;

import java.util.ArrayList;
import java.util.List;

public class TakeoffPlatform {
    String name;
    List<Rocket> rocketList = new ArrayList<>();
    private static final int NUM_MAX_ROCKET = 4;

    public TakeoffPlatform(String name) {
        this.name = name;
    }
    public int currentFreeSpace(){
        return NUM_MAX_ROCKET - this.rocketList.size();
    }
    public void addRocket(Rocket rocket){
        rocketList.add(rocket);
    }
}
