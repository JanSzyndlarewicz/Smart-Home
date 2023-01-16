package Main;

import TextMenu.UserLogin.UserLoginBase;
import User.User;

public class Test {
    public Test() {
    }

    public static User currentUser(){
        return UserLoginBase.getCurrentUser();
    }
}
