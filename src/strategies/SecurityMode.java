package strategies;

import devices.SmartDevice;
import devices.SmartLock;

import java.util.List;

public class SecurityMode implements HomeModeStrategy {
    @Override
    public void executeMode(List<SmartDevice> devices) {
        for (SmartDevice device : devices) {
            if (device instanceof SmartLock) {
                if (!device.isOn()) device.togglePower();
            }
        }
    }
}
