package devices;

import automation.Observer;

public class SmartLight extends SmartDevice implements Observer {
    private int brightness =100;

    public SmartLight(String name){
        super(name);
    }

    @Override
    public void performAction(){
        System.out.print("Light " + getName() + " is shining at " + brightness + "% brightness.");
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public int getBrightness(){
        return this.brightness;
    }

    @Override
    public void update(String eventType){
        if(eventType.equals("MOTION_DETECTED")){
            System.out.println(getName() + ": Movement sensed! Turning on automatically.");
            if (!isOn()) togglePower();
        }
    }

}
