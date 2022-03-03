package com.company;

public class Rocket {
    private String name;
    private boolean preparedTakeoff=false;
    private boolean takeOff=false;

    public Rocket(String name) throws Exception{
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) throws Exception{
        if(name.isEmpty() || name == null) throw  new Exception("The hangar need a name");
    }

    public String getName() {
        return name;
    }

    public boolean isPreparedTakeoff() {
        return preparedTakeoff;
    }

    public boolean isTakeOff() {
        return takeOff;
    }

    public void setPreparedTakeoff(boolean preparedTakeoff) {
        this.preparedTakeoff = preparedTakeoff;
    }

    public void setTakeOff(boolean takeOff) {
        this.takeOff = takeOff;
    }
}
