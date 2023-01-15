package Hub;

import Observable.Subject;
import Observer.Observer;

public class ToggleToSliderRoutine extends Routine{

    String outputOffValue;

    public ToggleToSliderRoutine(Subject input, Observer output, String outputProperty, String outputValue, String outputOffValue) {
        super(input, output, outputProperty, outputValue);
        this.outputOffValue = outputOffValue;
    }

    @Override
    public void update(String propertyName, String newValueForProperty){
        if(newValueForProperty.equalsIgnoreCase("true") || newValueForProperty.equals("1")){
            notifyObservers(outputProperty, outputValue);
        }else{
            notifyObservers(outputProperty, outputOffValue);
        }
    }


}
