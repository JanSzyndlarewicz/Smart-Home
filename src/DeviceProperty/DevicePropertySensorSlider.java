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

    public int getPercentage() {

        System.out.println( (100*(value-min)/(max-min)));
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
