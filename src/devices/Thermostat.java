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

    public int getTemperature(){
        return this.temperature;
    }

    public void setTemperature(int temperature){
        this.temperature=temperature;
    }
}
