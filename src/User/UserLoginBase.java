package User;

import User.UserDataBase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserLoginBase implements Serializable {
    public static HashMap<String, String> userHashMap;

    public UserLoginBase(){
        userHashMap = new HashMap<>();
        UserDataBase userDataBase = new UserDataBase();
    }

    public static boolean login(String login, String password){
        if(userHashMap.containsKey(login)){
            return Objects.equals(password, userHashMap.get(login));
        }
        else return false;
    }

    public static boolean register(String login, String password){
        if(!userHashMap.containsKey(login)){
            userHashMap.put(login, password);
            UserDataBase.addUser(login, password);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean remove(String login, String password){
        if(userHashMap.containsKey(login)){
            if(Objects.equals(userHashMap.get(login), password)){
                userHashMap.remove(login);
                UserDataBase.removeUser(login);
            }
            return true;
        }
        else return false;
    }


}
