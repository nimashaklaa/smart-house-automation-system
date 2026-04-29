package devices;

public abstract class SmartDevice {
    private final String name;
    private boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public abstract  void performAction();

    public void togglePower(){
        this.isOn = !this.isOn;
        System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }
}
