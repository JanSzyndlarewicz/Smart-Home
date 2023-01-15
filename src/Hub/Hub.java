package Hub;

import java.util.ArrayList;

public class Hub{

    private ArrayList<Routine> routineList = new ArrayList<Routine>();

    public void addRoutine(Routine routine){
        routineList.add(routine);
    }

    public void removeRoutine(Routine routine){
        routineList.remove(routine);
    }

    public void listRoutines(){

    }

}
