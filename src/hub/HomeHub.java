package hub;

import devices.SmartDevice;

import java.util.ArrayList;
import java.util.List;

// here it uses a singleton pattern

public class HomeHub {

    // static variable to hold single instance of HomeHub
    private static HomeHub instance;

    // Marking as final ensures the list reference never changes
    private final List<SmartDevice> devices;

    // as this is private no one can use new HomeHub()
    private HomeHub() {
        devices = new ArrayList<>();
        System.out.println("Home Hub System Initialized.");
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println("Added SmartDevice: " + device.getName());
    }

    public void showStatus() {
        System.out.println("\n--- Current Home Status ---");
        for (SmartDevice d : devices) {
            System.out.println(d.getName() + " | Status: " + (d.isOn() ? "ON" : "OFF"));
        }
    }

    public void turnOffAllDevices() {
        System.out.println("\n--- Shutting down all systems... ---");
        for (SmartDevice device : devices) {
            if (device.isOn()) {
                device.togglePower();
            }
        }
        System.out.println("All devices are now OFF.");
    }

}
