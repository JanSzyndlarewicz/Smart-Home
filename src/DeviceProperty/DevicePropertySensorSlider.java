package DeviceProperty;


public class DevicePropertySensorSlider extends DeviceProperty implements Slider{
    private double value, min, max;


    public DevicePropertySensorSlider(String name) {
        super(name, "SensorSlider");
        value = 0;
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
    }
    public DevicePropertySensorSlider(String name, double value, double min, double max){
        super(name, "Slider");
        this.value=value;
        this.min=min;
        this.max=max;
    }

    public DevicePropertySensorSlider(String name, double value) {
        super(name, "Slider");
        this.value = value;
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
    }

    public double get() {
        return this.value;
    }
    public Double getValue(){
        return this.value;
    }

    public int getPercentage() {
        return (int) (100*(value-min)/(max-min));
    }

    public String getValueString() {
        return String.valueOf(value);
        //String.format("%.2f", value);
    }


    //=======// Debug methods //=======//

    public void debugSetSensor(double d) {
        this.value = d;
    }
}
