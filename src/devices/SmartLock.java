package devices;

import automation.Observer;

public class SmartLock extends SmartDevice implements Observer {

    public SmartLock(String name){
        super(name);
    }

    @Override
    public void performAction(){
        System.out.println("Smart Lock " + getName() + " is now " + (isOn() ? "locked" : "unlocked") + ".");
    }

    @Override
    public void update(String eventType){
        if(eventType.equals("MOTION_DETECTED")){
            System.out.println(getName() + ": Movement sensed! Turning on automatically.");
            if (!isOn()) togglePower();
        }
    }
}
