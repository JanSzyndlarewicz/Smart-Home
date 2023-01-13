package Device;

import DeviceProperty.DeviceProperty;
import Observer.Observer;

public abstract class OutputDevice extends Device implements Observer{
    public OutputDevice(String alias) {
        super(alias);
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {
        getProperies()
    }
}
