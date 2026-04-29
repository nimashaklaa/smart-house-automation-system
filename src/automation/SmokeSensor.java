package automation;

public class SmokeSensor extends Sensor{
    public void triggerAlarm() {
        System.out.println(">>> [SENSOR] SMOKE DETECTED! Sending emergency signal...");
        notifyObservers("SMOKE_DETECTED");
    }
}
