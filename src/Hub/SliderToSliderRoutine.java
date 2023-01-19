package Hub;

import Observable.Subject;
import Observer.Observer;

public class SliderToSliderRoutine extends Routine{

    private String outputValue;
    private double minValue,maxValue;

    public SliderToSliderRoutine(String alias, Subject input, Observer output, String outputProperty, double minValue, double maxValue, String outputValue) {
        super(alias, input, output, outputProperty);
        this.minValue=minValue;
        this.maxValue=maxValue;
        this.outputValue=outputValue;
    }

    @Override
    public void update(String propertyName, String newValueForProperty){
        double inputValue;
        inputValue=Double.parseDouble(newValueForProperty);

        if(inputValue<maxValue && inputValue>minValue){
            notifyObservers(outputProperty, outputValue);
        }
    }
}
