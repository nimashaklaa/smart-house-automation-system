// This is the entry point which use by "user" or "installer"

import commands.Command;
import commands.RemoteControl;
import commands.SetTempCommand;
import commands.TurnOnCommand;
import devices.SmartLight;
import devices.Thermostat;
import hub.DeviceFactory;
import hub.HomeHub;
import strategies.EcoMode;
import strategies.SecurityMode;

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

        Thermostat hallwayThermostat = (Thermostat) DeviceFactory.createDevice("THERMOSTAT","Hallway Thermostat");
        homeHub.addDevice(hallwayThermostat);

        Command setTemp = new SetTempCommand(hallwayThermostat, 34);
        System.out.println("--- Using the Remote Control ---");
        remote.pressButton(setTemp); // The light turns on!

        System.out.println("--- Testing Undo ---");
        remote.pressUndo(); // The light turns off!

        // 3. Testing Strategy Pattern (The "Smart Modes")
        // This will automatically adjust the thermostat and lights we added above
        System.out.println("\n--- Activating Smart Modes ---");

        System.out.println("Switching to ECO MODE...");
        homeHub.setMode(new EcoMode());
        homeHub.showStatus();

        System.out.println("\nSwitching to SECURITY MODE...");
        homeHub.setMode(new SecurityMode());
        homeHub.showStatus();

    }
}