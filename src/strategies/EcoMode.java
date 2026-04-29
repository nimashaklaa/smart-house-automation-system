package strategies;

import devices.SmartDevice;
import devices.SmartLight;
import devices.Thermostat;

import java.util.List;

public class EcoMode implements HomeModeStrategy{
    @Override
    public void executeMode(List<SmartDevice> devices) {
        System.out.println("Activating Eco Mode: Optimizing energy usage.");
        for (devices.SmartDevice device : devices) {
            if (device instanceof Thermostat) {
                ((Thermostat) device).setTemperature(20);
            } else if (device instanceof SmartLight) {
                System.out.println("Dimming " + device.getName() + " to 50%.");
            }
        }
    }
}
