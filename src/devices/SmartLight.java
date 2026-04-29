package devices;

public class SmartLight extends SmartDevice{
    private int brightness =100;

    public SmartLight(String name){
        super(name);
    }

    @Override
    public void performAction(){
        System.out.print("Light " + getName() + " is shining at " + brightness + "% brightness.");
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public int getBrightness(){
        return this.brightness;
    }


}
