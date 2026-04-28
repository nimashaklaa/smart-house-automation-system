package hub;

import devices.SmartDevice;
import devices.SmartLight;
import devices.SmartLock;
import devices.Thermostat;

public class DeviceFactory {

    public static SmartDevice createDevice (String type, String name){
        if(type == null || type.isEmpty()){
            return null;
        }

        return switch (type.toUpperCase()) {
            case "LIGHT" -> new SmartLight(name);
            case "LOCK" -> new SmartLock(name);
            case "THERMOSTAT" -> new Thermostat(name);
            default -> {
                System.out.println("Unknown device type: " + type);
                yield null;
            }
        };
    }
}
