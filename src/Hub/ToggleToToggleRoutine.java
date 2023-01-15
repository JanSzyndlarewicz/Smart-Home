package Hub;

import Observable.Subject;
import Observer.Observer;

public class ToggleToToggleRoutine extends Routine{

    public ToggleToToggleRoutine(Subject input, Observer output, String outputProperty, String outputValue) {
        super(input, output, outputProperty, outputValue);
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {
        notifyObservers(outputProperty, outputValue);
    }
}
