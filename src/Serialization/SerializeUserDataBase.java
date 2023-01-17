package Serialization;

import User.User;
import User.UserDataBase;

import java.util.HashMap;

public abstract class SerializeUserDataBase extends Serialization{
    private static final String FILE_NAME = "UserSerialization.ser";

    public static void serialize(){
        serialize(UserDataBase.getUserDataBase(), FILE_NAME);
    }

    public static HashMap deserialize(){
        return deserialize(FILE_NAME);
    }

}
