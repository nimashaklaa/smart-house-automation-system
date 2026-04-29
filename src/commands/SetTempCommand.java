package commands;

import devices.Thermostat;

public class SetTempCommand implements Command {

    private final Thermostat thermostat;
    private final int newTemp;
    private int previousTemp;

    public SetTempCommand(Thermostat thermostat, int newTemp) {
        this.thermostat = thermostat;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        this.previousTemp = thermostat.getTemperature();
        thermostat.setTemperature(newTemp);
        System.out.println("Thermostat set to " + newTemp + "°C");
    }

    @Override
    public void undo() {
        thermostat.setTemperature(previousTemp);
        System.out.println("Thermostat reverted to " + previousTemp + "°C");
    }
}
