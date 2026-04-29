package commands;

import devices.SmartLight;

public class TurnOnCommand implements Command {
    private final SmartLight smartLight;

    public TurnOnCommand(SmartLight smartLight){
        this.smartLight = smartLight;
    }

    @Override
    public void execute() {
        if(!smartLight.isOn()){
            smartLight.togglePower();
        }
    }
    @Override
    public void undo() {
        if(smartLight.isOn()){
            smartLight.togglePower();
        }
    }
}
