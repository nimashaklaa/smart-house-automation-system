package automation;

public class MotionSensor extends Sensor{
    public void detectMovement() {
        System.out.println(">>> [SENSOR] Motion detected in the hallway!");
        notifyObservers("MOTION_DETECTED");
    }
}
