package User;

public class ResetPassword {
    public static void newPassword(String login, String password){
        UserLoginBase.getCurrentUser().setPassword(password);
        UserLoginBase.setPassword(login, password);
    }

}
