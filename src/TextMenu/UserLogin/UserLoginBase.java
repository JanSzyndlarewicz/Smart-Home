package TextMenu.UserLogin;

import User.User;
import User.UserDataBase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserLoginBase implements Serializable {
    public static HashMap<String, String> userHashMap = new HashMap<>();

    private static User currentUser = new User("Login", "Haslo", "phone", "email");

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserLoginBase.currentUser = currentUser;
    }

    public static boolean login(String login, String password){
        if(userHashMap.containsKey(login)){
            currentUser.setLogin(login);
            currentUser.setPassword(userHashMap.get(login));
            System.out.println(UserDataBase.findUser(login));
            currentUser = UserDataBase.findUser(login);
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

    public static boolean register(String login, String password, String phoneNumber, String email){
        if(!userHashMap.containsKey(login)){
            userHashMap.put(login, password);
            UserDataBase.addUser(login, password, phoneNumber, email);
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
