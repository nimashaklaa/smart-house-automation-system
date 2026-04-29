package strategies;

import devices.SmartDevice;

import java.util.List;

public interface HomeModeStrategy {
    void executeMode(List<SmartDevice> devices);
}
