package Hub;

import Observable.Subject;
import Observer.Observer;

public class ToggleToToggleRoutine extends Routine{

    private boolean state;

    public ToggleToToggleRoutine(String alias, Subject input, Observer output, String outputProperty, boolean state) {
        super(alias, input, output, outputProperty);
        this.state=state;
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {
        boolean inputValue;
        if(newValueForProperty.equalsIgnoreCase("true") || newValueForProperty.equals("1")){
            inputValue=true;
        }else{
            inputValue=false;
        }

        if(inputValue==state){
            notifyObservers(outputProperty, "true");
        }else{
            notifyObservers(outputProperty, "false");
        }
    }
}
