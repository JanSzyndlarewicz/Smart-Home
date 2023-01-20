package DeviceProperty;

public class DevicePropertySlider extends DeviceProperty implements Slider {
    private double value, min, max;

    public DevicePropertySlider(String name, double value) {
        super(name, "Slider");
        this.value = value;
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
    }

    public DevicePropertySlider(String name, double value, double min, double max){
        super(name, "Slider");
        this.value=value;
        this.min=min;
        this.max=max;
    }

    public Double getValue(){
        return this.value;
    }

    public double get() {
        return this.value;
    }

    public void set(double value) {
        if(value<min){
            this.value = min;
        } else if (value>max) {
            this.value = max;
        } else {
            this.value = value;
        }

    }

    public String getValueString() {
        return String.valueOf(value);
        //return String.format("%.2f", value);
    }
}
