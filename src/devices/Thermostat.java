package devices;

public class Thermostat extends SmartDevice{

    private int temperature=22;

    public Thermostat(String name){
        super(name);
    }

    @Override
    public void performAction(){
        System.out.println("Thermostat " + getName() + " is set to " + temperature + "°C.");
    }
}
