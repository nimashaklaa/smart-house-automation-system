package commands;

import devices.SmartDevice;

public class TurnOnCommand implements Command {
    private final SmartDevice device;

    public TurnOnCommand(SmartDevice device){
        this.device = device;
    }

    @Override
    public void execute() {
        if(!device.isOn()){
            device.togglePower();
        }
    }
    @Override
    public void undo() {
        if(device.isOn()){
            device.togglePower();
        }
    }
}
