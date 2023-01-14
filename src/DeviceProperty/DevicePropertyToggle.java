package DeviceProperty;

public class DevicePropertyToggle extends DeviceProperty {
    private boolean value;


    public DevicePropertyToggle(String name, boolean value) {
        super(name, "Toggle");
        this.value = value;
    }

    public boolean isValue() {
        return this.value;
    }

    public Boolean getValue(){
        return this.value;
    }

    public boolean get() {
        return this.value;
    }

    public void set(boolean value) {
        this.value = value;
    }  
    
    public String getValueString() {
        return (value ? "True" : "False");
    }
}
