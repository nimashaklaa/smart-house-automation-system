// This is the entry point which use by "user" or "installer"

import commands.Command;
import commands.RemoteControl;
import commands.TurnOnCommand;
import devices.SmartLight;
import hub.DeviceFactory;
import hub.HomeHub;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Smart Home System!");

        HomeHub homeHub = HomeHub.getInstance();
        RemoteControl remote = new RemoteControl();

        homeHub.addDevice(DeviceFactory.createDevice("LIGHT","Bed Room Light"));
        homeHub.addDevice(DeviceFactory.createDevice("LOCK","Front Door Lock"));
        homeHub.addDevice(DeviceFactory.createDevice("THERMOSTAT","Main Hallway"));

        System.out.println("\n--- Powering Up All Devices ---");

        homeHub.turnOffAllDevices();

        SmartLight livingRoomLight = (SmartLight) DeviceFactory.createDevice("LIGHT","Living Room Light");
        homeHub.addDevice(livingRoomLight);

        Command lightOn = new TurnOnCommand(livingRoomLight);

        System.out.println("--- Using the Remote Control ---");
        remote.pressButton(lightOn); // The light turns on!

        System.out.println("--- Testing Undo ---");
        remote.pressUndo(); // The light turns off!
    }
}