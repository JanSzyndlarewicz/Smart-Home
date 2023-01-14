package User;

import java.io.Serializable;
import java.util.HashMap;

public class UserDataBase implements Serializable {
    private static HashMap<String, User> userDataBase;

    public UserDataBase() {
        userDataBase = new HashMap<>();
    }

    public static User findUser(String login){
        return userDataBase.getOrDefault(login, null);
    }

    public static void addUser(String login, String password){
        userDataBase.put(login, new User(login, password));
    }

    public static void removeUser(String login){
        userDataBase.remove(login);
    }


    public static HashMap<String, User> getUserDataBase() {
        return userDataBase;
    }

}
