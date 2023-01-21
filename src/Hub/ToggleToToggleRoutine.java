package Hub;

import Observable.Subject;
import Observer.Observer;

public class ToggleToToggleRoutine extends Routine{

    private String outputOnValue, outputOffValue;

    public ToggleToToggleRoutine(String alias, Subject input, Observer output, String outputProperty, String outputOnValue, String outputOffValue) {
        super(alias, input, output, outputProperty);
        this.outputOffValue = outputOffValue;
        this.outputOnValue = outputOnValue;
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {

        if(newValueForProperty.equalsIgnoreCase("true") || newValueForProperty.equals("1")){
            notifyObservers(outputProperty, outputOnValue);
        } else if (newValueForProperty.equalsIgnoreCase("false") || newValueForProperty.equals("1")) {
            notifyObservers(outputProperty, outputOffValue);
        }

    }
}
