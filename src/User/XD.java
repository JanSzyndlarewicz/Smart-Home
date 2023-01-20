package User;

public class XD {
    public static void newPassword(String login, String password){
        UserLoginBase.getCurrentUser().setPassword(password);
        UserLoginBase.setPassword(login, password);
    }
}
