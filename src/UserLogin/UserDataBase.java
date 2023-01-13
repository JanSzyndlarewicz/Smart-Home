package UserLogin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class UserDataBase implements Serializable {
    public static HashMap<String, String> userHashMap;

    public UserDataBase(){
        userHashMap = new HashMap<>();
    }

    public static boolean login(String user, String password){
        if(userHashMap.containsKey(user)){
            return Objects.equals(password, userHashMap.get(user));
        }
        else return false;
    }

    public static boolean register(String user, String password){
        if(!userHashMap.containsKey(user)){
            userHashMap.put(user, password);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean remove(String user, String password){
        if(userHashMap.containsKey(user)){
            userHashMap.remove(user);
            return true;
        }
        else return false;
    }


}
