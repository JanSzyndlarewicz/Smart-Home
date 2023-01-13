package DeviceProperty;

public class DevicePropertySlider extends DeviceProperty {
    private double value;

    public DevicePropertySlider(String name, double value) {
        super(name, "Slider");
        this.value = value;
    }

    public Double getValue(){
        return this.value;
    }

    public double get() {
        return this.value;
    }

    public void set(double value) {
        this.value = value;
    }

    public String getValueString() {
        return String.valueOf(value);
        //return String.format("%.2f", value);
    }
}
