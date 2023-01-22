package Hub;

import java.io.Serializable;
import java.util.ArrayList;

public class Hub implements Serializable {

    private static ArrayList<Routine> routineList = new ArrayList<Routine>();

    public void addRoutine(Routine routine){
        routineList.add(routine);
    }

    public void removeRoutine(Routine routine){
        routineList.remove(routine);
    }

    public static void removeRoutines(String alias){
    	while(!checkRoutineAliasAvailbility(alias))
        for(int i=0; i<routineList.size(); i++){
            if(routineList.get(i).getAlias().equalsIgnoreCase(alias)){
                routineList.remove(i);
            }
        }
    }

    public void listRoutines(){

    }
    public static ArrayList<Routine> getRoutineList(){
    	return routineList;
    }
    
    public static boolean checkRoutineAliasAvailbility(String alias){
        boolean state = true;
        for(int i=0; i<routineList.size(); i++){
            if(routineList.get(i).getAlias().equalsIgnoreCase(alias)){
                state = false;
            }
        }

        return state;
    }

}
