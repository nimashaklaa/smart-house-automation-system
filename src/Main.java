// This is the entry point which use by "user" or "installer"

import hub.DeviceFactory;
import hub.HomeHub;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Smart Home System!");

        HomeHub homeHub = HomeHub.getInstance();

        homeHub.addDevice(DeviceFactory.createDevice("LIGHT","Living Room Light"));
        homeHub.addDevice(DeviceFactory.createDevice("LOCK","Front Door Lock"));
        homeHub.addDevice(DeviceFactory.createDevice("THERMOSTAT","Main Hallway"));

        System.out.println("\n--- Powering Up All Devices ---");

        homeHub.turnOffAllDevices();

    }
}