package Hub;

import Observable.Subject;
import Observer.Observer;

public class SliderToToggleRoutine extends Routine{

    private boolean outputState;
    private double minValue, maxValue;

    public SliderToToggleRoutine(String alias, Subject input, Observer output, String outputProperty, double minValue, double maxValue, boolean outputState) {
        super(alias, input, output, outputProperty);
        this.outputState = outputState;
        this.minValue=minValue;
        this.maxValue=maxValue;
    }

    @Override
    public void update(String propertyName, String newValueForProperty){
        String outputValue;
        double inputValue;

        if(outputState){
            outputValue="true";
        }else{
            outputValue="false";
        }

        inputValue=Double.parseDouble(newValueForProperty);

        if(inputValue<=maxValue && inputValue>=minValue){
            notifyObservers(outputProperty, outputValue);
        }


    }
}
