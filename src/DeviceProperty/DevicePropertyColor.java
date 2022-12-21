package DeviceProperty;

import Control.Color;

public class DevicePropertyColor extends DeviceProperty {
    private Color value;

    public DevicePropertyColor(String name, Color value) {
        super(name, "Color");
        this.value = value;
    }

    public Color get() {
        return this.value;
    }

    public void set(Color value) {
        this.value = value;
    }    
    
    public String getValueString() {
        return (value.toString());
    }
}
