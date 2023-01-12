package UserLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class UserDataBase {
    public static HashMap<String, String> userHashMap;

    public UserDataBase(){
        userHashMap = new HashMap<>();
    }

    public static int login(String user, String password){
        if(userHashMap.containsKey(user)){
            if(Objects.equals(password, userHashMap.get(user))) return 1;
            else return 0;
        }
        else return 0;
    }

    public static int register(String user, String password){
        if(!userHashMap.containsKey(user)){
            userHashMap.put(user, password);
            return 1;
        }
        else {
            return 0;
        }
    }


}
