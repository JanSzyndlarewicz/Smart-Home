package DeviceProperty;

public abstract class DeviceProperty {
    private String name, type;
    
    public DeviceProperty(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public abstract String getValueString();

    public abstract <T> T getValue();


    public String toString() {
        return type + " (\"" + name + "\") = " + getValueString();
    }

}
