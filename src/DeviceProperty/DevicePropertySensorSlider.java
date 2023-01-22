package DeviceProperty;


public class DevicePropertySensorSlider extends DeviceProperty implements Slider{
    private double value, min, max;


    public DevicePropertySensorSlider(String name) {
        super(name, "SensorSlider");
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
        this.value = ((max-min)/2)+min;
    }
    public DevicePropertySensorSlider(String name, double min, double max){
        super(name, "Slider");
        this.min=min;
        this.max=max;
        this.value = ((max-min)/2)+min;
    }

    public double get() {
        return this.value;
    }
    public Double getValue(){
        return this.value;
    }

    public int []getSliderInfo() {
        return new int[]{(int) (min*100), (int) (value*100), (int) (max*100)};
    }

    public int getValueToSlider(){
        return (int) (value*100);
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
