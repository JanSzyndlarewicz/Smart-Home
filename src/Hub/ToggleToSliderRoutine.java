package Hub;

import Observable.Subject;
import Observer.Observer;

public class ToggleToSliderRoutine extends Routine{

    String outputOnValue;
    String outputOffValue;

    public ToggleToSliderRoutine(String alias, Subject input, Observer output, String outputProperty, String outputOnValue, String outputOffValue) {
        super(alias, input, output, outputProperty);
        this.outputOffValue = outputOffValue;
        this.outputOnValue = outputOnValue;
    }

    @Override
    public void update(String propertyName, String newValueForProperty){
        if(newValueForProperty.equalsIgnoreCase("true") || newValueForProperty.equals("1")){
            notifyObservers(outputProperty, outputOnValue);
        }else{
            notifyObservers(outputProperty, outputOffValue);
        }
    }


}
