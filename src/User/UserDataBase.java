package User;

import java.io.Serializable;
import java.util.HashMap;

public class UserDataBase implements Serializable {

    private static HashMap<String, User> userDataBase = new HashMap<>();

    public static User findUser(String login){
        System.out.println(userDataBase.getOrDefault(login, null));
        return userDataBase.getOrDefault(login, null);
    }

    public static void addUser(String login, String password, String label){
        userDataBase.put(login, new User(login, password, label));
    }

    public static void addUser(String login, String password, String phoneNumber, String email, String label){
        userDataBase.put(login, new User(login, password, phoneNumber, email, label));
    }

    public static void removeUser(String login){
        userDataBase.remove(login);
    }

    public static HashMap<String, User> getUserDataBase() {
        return userDataBase;
    }

    public static void setUserDataBase(HashMap<String, User> userDataBase) {
        UserDataBase.userDataBase = userDataBase;
    }
}
