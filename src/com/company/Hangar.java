package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hangar {
    private String name;
    private static final int numMaxRocket = 24;
    private List<Rocket> rocketList;

    public Hangar(String name) throws Exception{
        checkName(name);
        this.name = name;
        this.rocketList = new ArrayList<>();
    }

    private void checkName(String name) throws  Exception{
        if(name.isEmpty() || name == null) throw  new Exception("The hangar need a name");
    }
    public String showRockets(){
        String result = "";
        int count = 1;
        if(rocketList.isEmpty()){
            result += "We don't have rockets";
        }
        else {
            for (Rocket currentRocket : rocketList) {
                result += "Rocket number " + count + " " + currentRocket.getName() + "\n";
                count++;
            }
        }
        return result;
    }
    public void createRocket(String nameRocket) throws Exception {
        Rocket rocket = new Rocket(nameRocket);
        if(rocketList.size() <= numMaxRocket){
            rocketList.add(rocket);
        }
        else{
            throw new Exception("The hangar is full");
        }

    }



}
