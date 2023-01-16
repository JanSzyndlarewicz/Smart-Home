package Observer;

import DeviceProperty.DeviceProperty;


public interface Observer {

    void update(String propertyName, String newValueForProperty);
}
