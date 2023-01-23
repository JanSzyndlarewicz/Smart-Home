package User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserLoginBase implements Serializable {
    private static HashMap<String, String> userHashMap = new HashMap<>();

    private static User currentUser = new User("Login", "Haslo", "phone", "email", "label");



    public static void setPassword(String login ,String password){
        userHashMap.remove(login);
        userHashMap.put(login, password);
    }

    public static boolean login(String login, String password){
        if(userHashMap.containsKey(login)){
            currentUser = UserDataBase.findUser(login);
            return Objects.equals(password, userHashMap.get(login));

        }
        else return false;
    }

    public static boolean register(String login, String password, String label){
        if(!userHashMap.containsKey(login)){
            userHashMap.put(login, password);
            UserDataBase.addUser(login, password, label);

            currentUser = UserDataBase.findUser(login);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean register(String login, String password, String phoneNumber, String email, String label){
        if(!userHashMap.containsKey(login)){
            userHashMap.put(login, password);
            UserDataBase.addUser(login, password, phoneNumber, email,label);

            currentUser = UserDataBase.findUser(login);
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

    public static HashMap<String, String> getUserHashMap() {
        return userHashMap;
    }

    public static void setUserHashMap(HashMap<String, String> userHashMap) {
        UserLoginBase.userHashMap = userHashMap;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserLoginBase.currentUser = currentUser;
    }


}
