package User;

public class ResetPassword {
    public static void newPassword(String login, String password){
        if (password==null){
            System.err.println("Nieprawidlowe haslo!");
            return;
        }
        UserLoginBase.getCurrentUser().setPassword(password);
        UserLoginBase.setPassword(login, password);
    }

}
