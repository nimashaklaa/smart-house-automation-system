package devices;

public class SmartLock extends SmartDevice{

    public SmartLock(String name){
        super(name);
    }

    @Override
    public void performAction(){
        System.out.println("Smart Lock " + getName() + " is now " + (isOn() ? "locked" : "unlocked") + ".");
    }
}
